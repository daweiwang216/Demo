package theProject;

//Merge sort for string 

public class MergeSort {

	 private ALCollection<String> strList;
		private double start, end; 
	 
	    // Constructor
	    public MergeSort(ALCollection<String> input) {
	        strList = input;
	    }
	     
	    public ALCollection<String> sort() {
	    	start = System.nanoTime();
	        strList = mergeSort(strList);
	    	end = System.nanoTime() - start;
	        System.out.println("\nMerge sort done. \n");
	        System.out.println("Time Spent: "+ end + "ns");
	        return strList;
	    }
	 
	    public ALCollection<String> mergeSort(ALCollection<String> whole) {
	        ALCollection<String> left = new ALCollection<String>();
	        ALCollection<String> right = new ALCollection<String>();
	        int center;
	 
	        if (whole.size() == 1) {    
	            return whole;
	        } else {
	            center = whole.size()/2;
	            // copy the left half of whole into the left.
	            for (int i=0; i<center; i++) {
	                    left.add(whole.get(i));
	            }
	 
	            //copy the right half of whole into the new ALCollection.
	            for (int i=center; i<whole.size(); i++) {
	                    right.add(whole.get(i));
	            }
	 
	            // Sort the left and right halves of the ALCollection.
	            left  = mergeSort(left);
	            right = mergeSort(right);
	 
	            // Merge the results back together.
	            merge(left, right, whole);
	        }
	        return whole;
	    }
	 
	    private void merge(ALCollection<String> left, ALCollection<String> right, ALCollection<String> whole) {
	        int leftIndex = 0;
	        int rightIndex = 0;
	        int wholeIndex = 1;
	 
	        // As long as neither the left nor the right ALCollection has
	        // been used up, keep taking the smaller of left.get(leftIndex)
	        // or right.get(rightIndex) and adding it at both.get(bothIndex).
	        while (leftIndex < left.size() && rightIndex < right.size()) {
	            if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
	                whole.reset(wholeIndex, left.get(leftIndex));
	                leftIndex++;
	            } else {
	                whole.reset(wholeIndex, right.get(rightIndex));
	                rightIndex++;
	            }
	            wholeIndex++;
	        }
	 
	        ALCollection<String> rest;
	        int restIndex;
	        if (leftIndex >= left.size()) {
	            // The left ALCollection has been use up...
	            rest = right;
	            restIndex = rightIndex;
	        } else {
	            // The right ALCollection has been used up...
	            rest = left;
	            restIndex = leftIndex;
	        }
	 
	        // Copy the rest of whichever ALCollection (left or right) was not used up.
	        for (int i=restIndex; i<rest.size(); i++) {
	            whole.reset(wholeIndex, rest.get(i));
	            wholeIndex++;
	        }
	    }
	 
	    public void show() {
	        System.out.println("Data After Sorting:");
	        for (int i=0; i< strList.size();i++) {
	            System.out.println("No."+(i+1)+" Element: "+strList.get(i));
	        }
	    }

}
	    
