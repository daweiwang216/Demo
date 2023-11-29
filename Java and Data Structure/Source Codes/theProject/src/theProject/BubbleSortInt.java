package theProject;

public class BubbleSortInt {
	
	private ALCollection<Integer> intList;
	private double start, end; 
	
	//constructor
	public BubbleSortInt (ALCollection<Integer> input) {
		intList = input;
	}
	
	public ALCollection<Integer> sort() {     
		start = System.nanoTime(); 
		intList = bubbleSort(intList);
		end = System.nanoTime() - start;
		System.out.println("\nBubble sort done. \n");
		System.out.println("Time Spent: "+ end + "ns");
		return intList;
	}

	//Bubble sort main function for int
	public ALCollection<Integer> bubbleSort (ALCollection<Integer> storageInteger) {

		for (int i = storageInteger.size()+1; i>0;i-- ) {
			for (int j = 1; j < i && (j+1) < i; j++) {
				if (storageInteger.get(j-1) > storageInteger.get(j)) {
					int temp2 = storageInteger.get(j-1);
					int temp3 = storageInteger.get(j);
					storageInteger.reset(j, temp3);
					storageInteger.reset(j+1, temp2);
				}
			}
		}

		return storageInteger;
	}
	
    public void show() {
        System.out.println("Data After Sorting:");
        for (int i=0; i< intList.size();i++) {
            System.out.println("No."+(i+1)+" Element: " + intList.get(i));
        }
    }
	
}
