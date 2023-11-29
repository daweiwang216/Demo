package theProject;


public class HeapSort {
	
	 public ALCollection<String> strList;
	 private double start, end;
	 
	    // Constructor
	    public HeapSort(ALCollection<String> input) {
	        strList = input;
	    }
	     
	    public ALCollection<String>  sort() {
	    	start = System.nanoTime(); 
	        strList = heapSort(strList);
	        end = System.nanoTime() - start;
	        System.out.println("\nHeap sort done. \n");
	        System.out.println("Time Spent: "+ end + "ns");
	        return strList;
	    }

	//Heap sort main function for string
	public ALCollection<String> heapSort(ALCollection<String> unsortedList)
	{
		int count = unsortedList.size();
		heapify(unsortedList, count);
		int end = count-1;
		while(end > 0)
		{
			swap(unsortedList, end, 0);
			end = end - 1;
			siftDown(unsortedList, 0, end);
		}
		return unsortedList;
		
	}
	public void heapify(ALCollection<String> unsortedList, int count)
	{
		int start = count/2 - 1;
		while(start >= 0)
		{
			siftDown(unsortedList, start, count - 1);
			start -= 1;
		}
	}
	public void siftDown(ALCollection<String> unsortedList, int start, int end)
	{
		int root = start;
		while(root*2+1 <= end)
		{
			int child = root*2+1;
			int swap = root;
			if(unsortedList.get(swap).compareTo(unsortedList.get(child)) <0 )
			{
				swap = child;
			}
			if(child+1 <= end && unsortedList.get(swap).compareTo(unsortedList.get(child+1)) <0)
			{
				swap = child+1;
			}
			if(swap != root)
			{
				swap(unsortedList, root, swap);
				root = swap;
			}
			else
			{
				return;
			}
		}
	}
	public void swap(ALCollection<String> unsortedList, int swapOne, int swapTwo)
	{
		String holder = unsortedList.get(swapOne);
		unsortedList.reset(swapOne+1, unsortedList.get(swapTwo));
		unsortedList.reset(swapTwo+1, holder);
	}
	
    public void show() {
        System.out.println("Data After Sorting:");
        for (int i=0; i< strList.size();i++) {
            System.out.println("No."+(i+1)+" Element: " + strList.get(i));
        }
    }
    
    
    

}
