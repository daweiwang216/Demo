package theProject;

public class BubbleSort {
	
	private ALCollection<String> strList;
	private double start, end;
	//constructor
	public BubbleSort (ALCollection<String> input) {
		strList = input;
	}
	
	public ALCollection<String> sort() { 		
		start = System.nanoTime();    
		strList = bubbleSort(strList);		
		end = System.nanoTime() - start;
		System.out.println("\nBubble sort done. \n");
		System.out.println("Time Spent: "+ end + "ns");
		return strList;
	}
	
	//Bubble sort main function for string
	public ALCollection<String> bubbleSort (ALCollection<String> storage) {

		for (int i = storage.size()+1; i>0;i-- ) {
			for (int j = 1; j < i && (j+1) < i; j++) {
				if (((storage.get(j-1)).compareTo(storage.get(j)) > 0)) {
					String temp = storage.get(j-1);
					String temp1 = storage.get(j);
					storage.reset(j, temp1);
					storage.reset(j+1, temp);
				}
			}
		}

		return storage;
	}
	
    public void show() {
        System.out.println("Data After Sorting:");
        for (int i=0; i< strList.size();i++) {
            System.out.println("No."+(i+1)+" Element: " + strList.get(i));
        }
    }
	
}
