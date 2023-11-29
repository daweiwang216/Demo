package theProject;

public class ALCollection<E> implements myInterface <E> {

	
	   private E[] elements;
	   private int num_elements;
	   private int capacity;
	   private double start, end;

	   @SuppressWarnings("unchecked")
	   public ALCollection(int size)
	   {
	      elements = (E[]) new Object[size];
	      num_elements = 0;
	      capacity = size;
	   }

	   @SuppressWarnings("unchecked")
	   public ALCollection()
	   {
	      /**
	       * Call the c'tor that takes the 'size' parameter.  **/
	      this(50);
	   }

	   /**
	    * Methods inherited from CS401CollectionInterface
	    */
	    
	   public boolean is_full()
	   {
	      if (num_elements == capacity)
	          return true;
	      return false;
	   }

	   public boolean is_empty()
	   {
	      if (num_elements == 0) 
	          return true;
	      return false;
	   }

	   public int size() { return num_elements; }

	   public boolean add(E e)  {
	      add(Where.BACK, e);  // Add at the end
	      return true;
	   }

	   /*
	    * Remove element at index i.  If the element exists in the collection, 
	    * return that element back to the user.  If the index is out of bounds,
	    * return null.
	    */
	    
	   public E remove(int i) {
	      /*
	       * Remember to compact the array so there are no spaces in between
	       * if an element from the middle is removed or an element at the
	       * beginning of the array is removed.
	       */
		   int size = elements.length;
		   if (i>=size) {
			  System.out.println("Input-Index is bigger than highest index");
		  }
		  else {
			  //get element-to-be-deleted 
			  int numMoved = size - i -1;
			  //move all elements forward one site
			  if (numMoved > 0) {
		            System.arraycopy(elements, i+1, elements, i, numMoved);
			  }
		      elements[--size] = null;
		      num_elements --; 
		  }
		  return null;
	   }

	   /*
	    * Return true if e is in the collection class, false otherwise.
	    */
	    
	   public boolean contains(E e) {
		   start = System.nanoTime();
		   //element is null and there is null element in arraylist
		   if (e == null) {
			   for (int i=0; i< elements.length; i++) {
				   if (elements[i] == null)
					   end = System.nanoTime() - start;
					   System.out.println("\nTarget Found\nLinear Search Time Spent: "+ end + "ns");
					   return true;
			   }
		   }
			  
			//find the non-null element
			else 
				for (int i=0; i< elements.length; i++) {
				   if (e.equals(elements[i])){
					    end = System.nanoTime() - start;
						System.out.println("\nTarget Found\nLinear Search Time Spent: "+ end + "ns");
					   return true;
				   }
			   }
		    end = System.nanoTime() - start;
			System.out.println("\nTarget Not Found\nLinear Search Time Spent: "+ end + "ns");
			return false;

	      // return true;
	   }

	    
	   public boolean add(Where where, int index, E e) { 
	  
	      /* 
	       * If there is no space to add the new element, grow the array. */
	      if (is_full())  {
	          grow();
	      }
	      //adding
	      if (where == where.MIDDLE) {
	    	  System.out.println("Inserting element at index " + index);
	    	  //move all elements backwards for one site
	    	  for (int i=num_elements;i > index; i--) {
	        	  elements[i]=elements[i-1];
	    	  }
	    	  elements[index] = e;
	    	  num_elements++;
	      }
	      /**
	       * Add code here 
	       */
	      return true; 
	   }

	   /**
	    * Add element in front or at the end, as dictated by where.
	    * Preconditions: where != MIDDLE
	    */
	    
	   public boolean add(Where where, E e) { 
	   
	      /* 
	       * If there is no space to add the new element, grow the array. */
	      if (is_full())  {
	          grow();
	      }

	      if (where == Where.BACK)  {
	          //System.out.println("Inserting element at index " + num_elements);
	          elements[num_elements] = e;
	          num_elements++;
	      } 
	      else if (where == Where.FRONT)  {
	          System.out.println("Inserting element at index 0");
	          System.out.println("Compacting storage");
	          //move all elements back for one site
	          for (int i=num_elements;i > 0; i--) {
	        	  elements[i]=elements[i-1];
	          }
	          //add element in the front 
	          elements[0] = e;
	          num_elements++;
	          /*
	           * Add code here.
	           * You will add the new element at index 0, and shift all the
	           * elements down by one. */
	      }

	      return true; 
	   }

	   /*
	    * Gets the element at index i (0 <= i <= num_elements-1)
	    */
	    
	   public E get(int i)  {

	      if (i < 0 && i+1 > num_elements)
	          return null;

	      return(elements[i]);
	   }

	   /**
	    * ----------- Private methods
	    */
	   /*  
	    * Grows elements array to hold more elements.  Copies old (existing)
	    * elements in the new array.
	    * 
	    * Postcondition: (a) elements must contain the contents of the old array
	    *                (b) elements must now have twice as much capacity as
	    *                    before
	    */
	   
	   //reset the number of element [Not index] [Number of element start with 1]
	   public E reset(int i, E e) {
		   
		   //System.out.print("\nNo."+(i)+" Element "+elements [i-1]);
		   elements [i-1]= e;
		   //System.out.println(" has been reset to: "+ elements [i-1]);
		   return (elements[i-1]);
	   }
	    
	   @SuppressWarnings("unchecked")
	   private boolean grow()  {

	      /* 
	       * Expand capacity (double it) and copy old array contents to the
	       * new one. 
	       */

	      System.out.println("Capacity reached.  Increasing storage...");
	         //create a larger array
	      capacity = capacity * 2;
		  E[] larger = (E[]) new Object[capacity];
		   //copy contents from smaller array to larger one
		  int currSmaller = 0;
		  for (int currLarger = 0; currLarger < num_elements; currLarger++) {
			  larger[currLarger] = elements[currSmaller];
			  currSmaller = (currSmaller +1 )% elements.length;
		  }
		   
		   elements = larger;
		   
	      System.out.println("New capacity is " + capacity + " elements");

	      return true;
	   }
	   
	   //traversal the collection
	   public void show() {
	        System.out.println("Current Data:");
	        for (int i=0; i< num_elements;i++) {
	            System.out.println("No."+(i+1)+" Element: "+ elements[i] );
	        }
	   }
	}

