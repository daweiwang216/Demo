package theProject;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Read file = new Read();
		
		String path = "";
		Scanner sc = null;
		sc = new Scanner (System.in);
		
		//initial user interface
		System.out.println("Please type datafile path: ");
		path = sc.nextLine();
		System.out.println("Please select data type: 1 for String, 2 for Integer, 3 for Float");
		System.out.println("Please type 1 or 2 or 3, hit enter to finish");
		int type = sc.nextInt();
		
		System.out.println("Please type data size: (Any integer number)");
		int size = sc.nextInt();		
		
		//For data type is String
		
		if (type == 1){
			ALCollection<String> store = file.ReadAndStore(size,path);
			
			//allow user to update their dataset
			System.out.println("Do you want to update your data: type 1 for add, type 2 for delete, type 3 for adjust value, type 0 to skip");
			int up = sc.nextInt();
			while (up != 0) {
				if (up == 1) {
					
					//ask for add position
					System.out.println("Where do you want to add: type 1 for Front, 2 for Middle, 3 for Back.");
					int wh = sc.nextInt();
					
					while (wh != 0) {
						
						//add to the front
						if (wh == 1) {
							System.out.println("Please enter your datum (String Format):");
							String added = sc.nextLine();
							store.add(Where.FRONT,added);
							store.show();
						}
						
						//add in the middle
						if (wh == 2) {
							System.out.println("Please enter the position number of element you want to add");
							int num = sc.nextInt()-1;
							System.out.println("Please enter your datum (String Format):");
							String added = sc.nextLine();
							store.add(Where.MIDDLE, num, added);
							store.show();
						}
						
						//add to the end
						if (wh == 3) {
							System.out.println("Please enter your datum (String Format):");
							String added = sc.nextLine();
							store.add(Where.BACK,added);
							store.show();
						}
						System.out.println("Where do you want to add: type 1 for Front, 2 for Middle, 3 for Back. Type 0 to skip");
						wh = sc.nextInt();
					}
				}
				
				//ask for delete operation
				if (up == 2) {
					System.out.println("Please enter the number of element you want to delete:");
					int del = sc.nextInt();
					store.remove(del-1);
					store.show();	
				}
				//ask for adjust operation
				if (up == 3) {
					System.out.println("Please enter the number of element you want to adjust:");
					int adj = sc.nextInt();
					System.out.println("Please enter your datum (String Format):");
					String adjust = sc.nextLine();
					store.reset(adj,adjust);
					store.show();
				}
				//ask for another edit
				System.out.println("Do you want to update your data: type 1 for add, type 2 for delete, type 3 for adjust value, type 0 to skip");
				up = sc.nextInt();
			}
			
			//ask for linear search with unsorted dataset
			System.out.println("Do you want to do linear search? Type 1 for yes, 0 for no.");
			int lin = sc.nextInt();	
			
			while (lin != 0) {
				if (lin == 1) {
					System.out.println("Please type your target (String Format):");
					String tar = sc.nextLine();
					store.contains(tar);
				}
				System.out.println("Do you want to do linear search? Type 1 for yes, 0 for No.");
				lin = sc.nextInt();	
			}
			
			//ask for sort method and sort the dataset
			
			System.out.println("Please select sort method: 1 for Bubble sort, 2 for Heap sort, 3 for Merge sort");
			int sort = sc.nextInt();
			//do bubble sort
			if (sort == 1) {
				BubbleSort bu = new BubbleSort(store); 
				ALCollection<String> sorted = bu.sort();
				bu.show();
					
			}
			//do heap sort
			if (sort == 2) {
				HeapSort he = new HeapSort(store);
				ALCollection<String> sorted = he.sort();
				he.show();
			}
			//do merge sort
			if (sort == 3) {
				MergeSort me = new MergeSort(store);
				ALCollection<String> sorted = me.sort();
				me.show();		
			}
			
			//ask for BST search
			System.out.println("Do you want to do BST search? Type 1 for yes, 0 for no.");
			int bst = sc.nextInt();	
			while (bst != 0) {
				if (bst == 1) {
					System.out.println("\nBinary Search Tree Generating ... ");
					//restore the sorted list to balanced binary search tree
					ReStore restore = new ReStore (store);
					BinarySearchTree <String> balancedTree = restore.transfer();
					System.out.println("\nBinary Search Tree Created, Inorder traversal listed here: ");
					restore.show();
					System.out.println("Please type your target (String Format):");
					String tar = sc.nextLine();
					balancedTree.contains(tar);
				}
				System.out.println("Do you want to do BST search? Type 1 for yes, 0 for no.");//add
				bst = sc.nextInt();
			}
			
			System.out.println("Service Finished, Thanks for Using.");
		}

		//For data type is Integer
		else if (type == 2) {
			ALCollection<Integer> store = file.ReadAndStoreI(size,path);
			
			//allow user to update their dataset
			System.out.println("Do you want to update your data: type 1 for add, type 2 for delete, type 3 for adjust value, type 0 to skip");
			int up = sc.nextInt();
			while (up != 0) {
				if (up == 1) {
					System.out.println("Where do you want to add: type 1 for Front, 2 for Middle, 3 for Back.");
					int wh = sc.nextInt();
					while (wh != 0) {
						if (wh == 1) {
							System.out.println("Please enter your datum (int Format):");
							int added = sc.nextInt();
							store.add(Where.FRONT,added);
							store.show();
						}
						if (wh == 2) {
							System.out.println("Please enter the position number of element you want to add");
							int num = sc.nextInt()-1;
							System.out.println("Please enter your datum (int Format):");
							int added = sc.nextInt();
							store.add(Where.MIDDLE, num, added);
							store.show();
						}
						if (wh == 3) {
							System.out.println("Please enter your datum (int Format):");
							int added = sc.nextInt();
							store.add(Where.BACK,added);
							store.show();
						}
						System.out.println("Where do you want to add: type 1 for Front, 2 for Middle, 3 for Back. Type 0 to skip");
						wh = sc.nextInt();
					}
				}
					
				if (up == 2) {
					System.out.println("Please enter the number of element you want to delete:");
					int del = sc.nextInt();
					store.remove(del-1);
					store.show();	
				}
				
				if (up == 3) {
					System.out.println("Please enter the number of element you want to adjust:");
					int adj = sc.nextInt();
					System.out.println("Please enter your datum (int Format):");
					int adjust = sc.nextInt();
					store.reset(adj,adjust);
					store.show();
				}
				System.out.println("Do you want to update your data: type 1 for add, type 2 for delete, type 3 for adjust value, type 0 to skip");
				up = sc.nextInt();
			}
			
			//ask for linear search with unsorted dataset
			System.out.println("Do you want to do linear search? Type 1 for yes, 0 for no.");
			int lin = sc.nextInt();
			while (lin != 0) {
				if (lin == 1) {
					System.out.println("Please type your target (int Format):");
					int tar = sc.nextInt();
					store.contains(tar);
				}
				System.out.println("Do you want to do linear search? Type 1 for yes, 0 for No.");
				lin = sc.nextInt();	
			}
			
			//ask for sort method and sort the dataset
			
			System.out.println("Please select sort method: 1 for Bubble sort, 2 for Heap sort, 3 for Merge sort");
			int sort = sc.nextInt();
			if (sort == 1) {
				BubbleSortInt bu = new BubbleSortInt(store); 
				ALCollection<Integer> sorted = bu.sort();
				bu.show();	
			}
			
			if (sort == 2) {
				HeapSortInt he = new HeapSortInt(store);
				ALCollection<Integer> sorted = he.sort();
				he.show();
			}
			
			if (sort == 3) {
				MergeSortInt me = new MergeSortInt(store);
				ALCollection<Integer> sorted = me.sort();
				me.show();		
			}
			
			//ask for BST search
			System.out.println("Do you want to do BST search? Type 1 for yes, 0 for no.");
			int bst = sc.nextInt();	
			while (bst != 0) {
				if (bst == 1) {
					System.out.println("\nBinary Search Tree Generating ... ");
					ReStoreInt restore = new ReStoreInt (store);
					BinarySearchTree <Integer> balancedTree = restore.transfer();
					System.out.println("\nBinary Search Tree Created, Inorder traversal listed here: ");
					restore.show();
					System.out.println("Please type your target (int Format):");
					int tar = sc.nextInt();
					balancedTree.contains(tar);
				}
				System.out.println("Do you want to do BST search? Type 1 for yes, 0 for no.");
				bst = sc.nextInt();
			}
		}
			
		

		//For data type is Float
		else if (type == 3) {

			ALCollection<Float> store = file.ReadAndStoreF(size,path);
			
			//allow user to update their dataset
			System.out.println("Do you want to update your data: type 1 for add, type 2 for delete, type 3 for adjust value, type 0 to skip");
			int up = sc.nextInt();
			while (up != 0) {
				if (up == 1) {
					System.out.println("Where do you want to add: type 1 for Front, 2 for Middle, 3 for Back. Type 0 to skip");
					int wh = sc.nextInt();
					
					while (wh != 0) {
						
						if (wh == 1) {
							System.out.println("Please enter your datum (Float Format):");
							float added = sc.nextFloat();
							store.add(Where.FRONT,added);
							store.show();
						}
						
						if (wh == 2) {
							System.out.println("Please enter the position number of element you want to add");
							int num = sc.nextInt()-1;
							System.out.println("Please enter your datum (float Format):");
							float added = sc.nextFloat();
							store.add(Where.MIDDLE, num, added);
							store.show();
						}
					
						if (wh == 3) {
							System.out.println("Please enter your datum (float Format):");
							float added = sc.nextFloat();
							store.add(Where.BACK,added);
							store.show();
						}
						System.out.println("Where do you want to add: type 1 for Front, 2 for Middle, 3 for Back. Type 0 to skip");
						wh = sc.nextInt();
					}

				}	
				if (up == 2) {
					System.out.println("Please enter the number of element you want to delete:");
					int del = sc.nextInt();
					store.remove(del-1);
					store.show();
				
				}
				if (up == 3) {
					System.out.println("Please enter the number of element you want to adjust:");
					int adj = sc.nextInt();
					System.out.println("Please enter your datum (Float Format):");
					float adjust = sc.nextFloat();
					store.reset(adj,adjust);
					store.show();
				}
				System.out.println("Do you want to update your data: type 1 for add, type 2 for delete, type 3 for adjust value, type 0 to skip");
				up = sc.nextInt();
			}
			
			//ask for linear search with unsorted dataset
			System.out.println("Do you want to do linear search? Type 1 for yes, 0 for No.");
			int lin = sc.nextInt();	
			while (lin != 0) {
				if (lin == 1) {
					System.out.println("Please type your target (float Format):");
					float tar = sc.nextFloat();
					store.contains(tar);
				}
				System.out.println("Do you want to do linear search? Type 1 for yes, 0 for No.");
				lin = sc.nextInt();	
			}
			
			//ask for sort method and sort the dataset
			
			System.out.println("Please select sort method: 1 for Bubble sort, 2 for Heap sort, 3 for Merge sort");
			int sort = sc.nextInt();
			if (sort == 1) {
				BubbleSortFloat bu = new BubbleSortFloat(store); 
				ALCollection<Float> sorted = bu.sort();
				bu.show();	
			}
			if (sort == 2) {
				HeapSortFloat he = new HeapSortFloat(store);
				ALCollection<Float> sorted = he.sort();
				he.show();
			}
			if (sort == 3) {
				MergeSortFloat me = new MergeSortFloat(store);
				ALCollection<Float> sorted = me.sort();
				me.show();		
			}
			System.out.println("Do you want to do BST search? Type 1 for yes, 0 for no.");
			int bst = sc.nextInt();	
			while (bst !=0) {
				if (bst == 1) {
					System.out.println("\nBinary Search Tree Generating ... ");
					ReStoreFloat restore = new ReStoreFloat (store);
					BinarySearchTree <Float> balancedTree = restore.transfer();
					System.out.println("\nBinary Search Tree Created, Inorder traversal listed here: ");
					restore.show();
					System.out.println("Please type your target (float Format):");
					float tar = sc.nextFloat();
					balancedTree.contains(tar);
					}
				System.out.println("Do you want to do BST search? Type 1 for yes, 0 for no.");
				bst = sc.nextInt();
			}
		}
			
		System.out.println("Service Finished, Thanks for Using.");
			
		
	}//main end
		
} //class end
