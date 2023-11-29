package theProject;

import java.util.Iterator;

//convert sorted ALCollection to a balanced binary search tree for int data

public class ReStoreInt {

	private BinarySearchTree <Integer> my = new BinarySearchTree();

	private ALCollection<Integer> intList;

	//Contractor
	public ReStoreInt (ALCollection<Integer> input) {
		intList = input;
	}



	public BinarySearchTree <Integer> transfer() {
		insertTree(0, intList.size()-1);
		return my;
	}

	public void insertTree (int low, int high) {

		//base case 1
		if (low == high) {
			my.add(intList.get(low));
			return;
		}
		//base case 2
		else if ((low+1) ==high ) {
			my.add(intList.get(low));
			my.add(intList.get(high));
			return;
		}
		else {
			int mid = (high+low)/2;
			my.add(intList.get(mid));
			insertTree (low, mid-1);
			insertTree (mid+1,high);
			return;
		}
	
	}
	
	public void show() {
		Iterator<Integer> iter;
		iter = my.getIterator(BSTInterface.Traversal.Inorder);
		System.out.println();
		while (iter.hasNext())
			System.out.print(iter.next() + "\n");
		System.out.println();
	}
}
