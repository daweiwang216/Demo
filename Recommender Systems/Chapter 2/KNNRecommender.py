import numpy as np
import pandas as pd
from scipy.spatial.distance import cosine, correlation

#--------------------------------------------------------------------------------------------------

def pearsonSim(inA,inB):
	### This function converts the Pearson correlation between two vectors
	### into a similarity function returning  value in range [0,1]
    from scipy.spatial.distance import correlation
    if len(inA) < 3 : return 1.0
	# Note that scipy function is a distance function, 1-correlation will give the standard Pearson similarity
    return 0.5+0.5*(1-correlation(inA, inB))

def cosineSim(inA,inB):
	### Coverts the scipy Cosine distance into a similarity function
    from scipy.spatial.distance import cosine
    return (1 - cosine(inA,inB))

#--------------------------------------------------------------------------------------------------

def knn_search(x, D, metric=pearsonSim):
    """ find indices of most similar neighbors of an instance x among the instances in D """
    """ D assumed to be a 2d Numpy Array of ratings (Rows: users; Cols: items)           """
    """ x is a 1d Numpy Array representing the test instance (e.g., a user) with same    """
    """ dims as instances in D  """

    sims = np.array([])
    num_instances = np.shape(D)[0]
    for i in range(num_instances):
        d = D[i,:]
        overlap = np.nonzero(np.logical_and(x>0, d>0))[0] # find indices of the overlapping (co-rated) items
        if len(overlap) == 0:
            sim = 0
        else:
            sim = metric(x[overlap], d[overlap]) # we only want to compute similarities on overlapping items

        if not np.isnan(sim): # depending on the number of overlapping items, correlation maybe undefined
            sims = np.append(sims, [sim])
        else:
            sims = np.append(sims, 0)

    idx = np.argsort(sims) # find indices of most similar neighbors to x
    idx = idx[::-1] # order in terms of decreasing similarity
    # return the indexes of neighbors in decreasing order of similarity and array of all similarities
    return idx, sims

#--------------------------------------------------------------------------------------------------

def knn_predict(user, item, RatingsMat, K, metric=pearsonSim):

    """ Given user (a Numpy array with same dimensions as RatingsMat columns      """
    """ item (a column index in RatingsMat) and RatingsMat, the ratings matrix    """
    """ (a 2d Numpy array), find the K nearest neighbors of user and use weighted """
    """ average of their ratings on item as predicted rating for (user, item).    """

    neigh_idx, sims = knn_search(user, RatingsMat, metric)

    # Ratings of the neighbors on item
    neigh_ratings = RatingsMat[neigh_idx][:,item]
    neigh_sims = sims[neigh_idx]
    wr = 0
    sum_sim = 0
    # compute the weighted average rating of the neighbors on item
    for i in range(K):
        if (neigh_ratings[i] > 0) & (neigh_sims[i] > 0):
            wr += neigh_ratings[i] * neigh_sims[i]
            sum_sim += neigh_sims[i]
    if sum_sim > 0:
        predicted_rating = wr/sum_sim
    else:
        item_vec = RatingsMat[:,item]  # if there are no neighbors with ratings for item,then use
                                       # the item's average rating across all users as the prediction
        predicted_rating = (RatingsMat[:,item][item_vec > 0]).mean()
    return predicted_rating

#--------------------------------------------------------------------------------------------------

def cross_validate_user(dataMat, user, test_ratio, K, metric=pearsonSim):

    """ For a given test user, this function randomly selects test_ratio percent of the  """
    """ already rated items and computes the prediction errors for these test items      """

    number_of_items = np.shape(dataMat)[1]
    rated_items_by_user = np.array([i for i in range(number_of_items) if dataMat[user,i]>0])
    test_size = int(test_ratio * len(rated_items_by_user))
    test_indices = np.random.randint(0, len(rated_items_by_user), test_size)
    withheld_items = rated_items_by_user[test_indices]
    original_user_profile = np.copy(dataMat[user]) # maintain the original ratings to be restored later
    dataMat[user, withheld_items] = 0 # So that the withheld test items is not used in the rating prediction below
    error_u = 0.0
    count_u = len(withheld_items)

    # Compute absolute error for user u over all test items
    for item in withheld_items:
        # Estimate rating on the withheld item
        u = dataMat[user]
        # print("user: ", u, "Item: ", i)
        predicted_rating = knn_predict(u, item, dataMat, K, metric)
        error_u = error_u + abs(predicted_rating - original_user_profile[item])

    # Now restore ratings of the withheld items to the user profile
    for item in withheld_items:
        dataMat[user, item] = original_user_profile[item]

    # Return sum of absolute errors and the count of test cases for this user
    # Note that these will have to be accumulated for each user to compute MAE
    return error_u, count_u

#--------------------------------------------------------------------------------------------------

def test(dataMat, num_test_users, test_ratio, K, metric=pearsonSim):

    """ This function performs cross_validate_user on the first num_test_users in the training data """
    """ It returns the Mean Absolute Error (MAE) across all test cases. """

    total_error=0.0;
    total_test_cases=0.0
    for u in range(num_test_users):
        error_u, count = cross_validate_user(dataMat, u , test_ratio, K, metric)
        # print('Evaluating user', u, ' out of', num_test_users, 'MAE: ', error_u/count)
        total_error=total_error+error_u
        total_test_cases=total_test_cases+count
    print('Mean Absoloute Error for K =',K,' : ', total_error/total_test_cases)
    return(total_error/total_test_cases)

#--------------------------------------------------------------------------------------------------

def recommend(user, Ratings, K, N=3, metric=pearsonSim):

    """ Given user (integer row index) and Ratings (a Pandas DataFrame), find the top N """
    """ recommended items for user (unrated items with highest predicted rating)        """

    u = np.array(Ratings.iloc[user])
    RatingsMat = np.array(Ratings)
    predictions = np.zeros(len(u))
    unrated = 0

    for j in range(len(u)):
        if u[j] == 0:
            unrated += 1
            j_pred = knn_predict(u, j, RatingsMat, K, metric)
            # print(j, j_pred)
            predictions[j] = j_pred

    recs = np.argsort(predictions)
    recs = recs[::-1]
    if unrated < N: N = unrated
    preds = predictions[recs[:N]]
    items = Ratings.columns[recs[:N]]

    return preds, items

#--------------------------------------------------------------------------------------------------
