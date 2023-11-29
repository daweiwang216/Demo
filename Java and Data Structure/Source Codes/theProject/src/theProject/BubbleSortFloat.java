package theProject;

public class BubbleSortFloat {
	
	private ALCollection<Float> floatList;
	private double start, end; 
	
	//constructor
	public BubbleSortFloat (ALCollection<Float> input) {
		floatList = input;
	}
	
	public ALCollection<Float> sort() {  		
		start = System.nanoTime();    
		floatList = bubbleSort(floatList);
		end = System.nanoTime() - start;
		System.out.println("\nBubble sort done. \n");
		System.out.println("Time Spent: "+ end + "ns");
		return floatList;
	}

	//Bubble sort main function for float
	public ALCollection<Float> bubbleSort (ALCollection<Float> storageFloat) {

		for (int i = storageFloat.size()+1; i>0;i-- ) {
			for (int j = 1; j < i && (j+1) < i; j++) {
				if (storageFloat.get(j-1) > storageFloat.get(j)) {
					float temp2 = storageFloat.get(j-1);
					float temp3 = storageFloat.get(j);
					storageFloat.reset(j, temp3);
					storageFloat.reset(j+1, temp2);
				}
			}
		}

		return storageFloat;
	}
	
    public void show() {
        System.out.println("Data After Sorting:");
        for (int i=0; i< floatList.size();i++) {
            System.out.println("No."+(i+1)+" Element: " + floatList.get(i));
        }
    }
}
