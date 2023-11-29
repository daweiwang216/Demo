package theProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class HeapSortInt {
	
	 private ALCollection<Integer> intList;
	 private double start, end;
	    // Constructor
	    public HeapSortInt(ALCollection<Integer> input) {
	        intList = input;
	    }
	     
	    public ALCollection<Integer> sort() {
	    	start = System.nanoTime();
	        intList = heapSortInt(intList);
	    	end = System.nanoTime() - start;
	        System.out.println("\nHeap sort done. \n");
	        System.out.println("Time Spent: "+ end + "ns");
	        return intList;
	    }
	
	//Heap sort main function for int
	public ALCollection<Integer> heapSortInt(ALCollection<Integer> unsortedList)
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
	public void heapify(ALCollection<Integer> unsortedList, int count)
	{
		int start = count/2 - 1;
		while(start >= 0)
		{
			siftDown(unsortedList, start, count - 1);
			start -= 1;
		}
	}
	public void siftDown(ALCollection<Integer> unsortedList, int start, int end)
	{
		int root = start;
		while(root*2+1 <= end)
		{
			int child = root*2+1;
			int swap = root;
			if(unsortedList.get(swap) < unsortedList.get(child))
			{
				swap = child;
			}
			if(child+1 <= end && unsortedList.get(swap) < unsortedList.get(child+1))
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
	public void swap(ALCollection<Integer> unsortedList, int swapOne, int swapTwo)
	{
		int holder = unsortedList.get(swapOne);
		unsortedList.reset(swapOne+1, unsortedList.get(swapTwo));
		unsortedList.reset(swapTwo+1, holder);
	}
	
    public void show() {
        System.out.println("Data After Sorting:");
        for (int i=0; i< intList.size();i++) {
            System.out.println("No."+(i+1)+" Element: " + intList.get(i));
        }
    }
    

	
}
