package theProject;

import java.util.Iterator;

//convert sorted ALCollection to a balanced binary search tree for string data

public class ReStore {

	private BinarySearchTree <String> my = new BinarySearchTree();

	private ALCollection<String> strList;

	//Contractor
	public ReStore (ALCollection<String> input) {
		strList = input;
	}



	public BinarySearchTree <String> transfer() {
		insertTree(0, strList.size()-1);
		return my;
	}

	public void insertTree (int low, int high) {

		//base case 1
		if (low == high) {
			my.add(strList.get(low));
			return;
		}
		//base case 2
		else if ((low+1) ==high ) {
			my.add(strList.get(low));
			my.add(strList.get(high));
			return;
		}
		else {
			int mid = (high+low)/2;
			my.add(strList.get(mid));
			insertTree (low, mid-1);
			insertTree (mid+1,high);
			return;
		}
	
	}
	
	public void show() {
		Iterator<String> iter;
		iter = my.getIterator(BSTInterface.Traversal.Inorder);
		System.out.println();
		while (iter.hasNext())
			System.out.print(iter.next() + "\n");
		System.out.println();
	}
	
	
}
