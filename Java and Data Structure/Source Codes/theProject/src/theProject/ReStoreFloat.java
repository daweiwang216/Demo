package theProject;

import java.util.Iterator;

//convert sorted ALCollection to a balanced binary search tree for float data

public class ReStoreFloat {

	private BinarySearchTree <Float> my = new BinarySearchTree();

	private ALCollection<Float> floatList;

	//Contractor
	public ReStoreFloat (ALCollection<Float> input) {
		floatList = input;
	}



	public BinarySearchTree <Float> transfer() {
		insertTree(0, floatList.size()-1);
		return my;
	}

	public void insertTree (int low, int high) {

		//base case 1
		if (low == high) {
			my.add(floatList.get(low));
			return;
		}
		//base case 2
		else if ((low+1) ==high ) {
			my.add(floatList.get(low));
			my.add(floatList.get(high));
			return;
		}
		else {
			int mid = (high+low)/2;
			my.add(floatList.get(mid));
			insertTree (low, mid-1);
			insertTree (mid+1,high);
			return;
		}
	
	}
	
	public void show() {
		Iterator<Float> iter;
		iter = my.getIterator(BSTInterface.Traversal.Inorder);
		System.out.println();
		while (iter.hasNext())
			System.out.print(iter.next() + "\n");
		System.out.println();
	}
	
	
}
