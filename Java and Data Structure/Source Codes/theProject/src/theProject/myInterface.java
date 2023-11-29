package theProject;


public interface myInterface<E>
{
   /**
    * Determines if this data structure is at its capacity.
    * 
    * @return true - if this data structure is at its capacity; false otherwise.
    */
    
   public boolean is_full();

   /**
    * Determines if this data structure is empty.
    * 
    * @return true - if this data structure is empty; false otherwise.
    */
    
   public boolean is_empty();

   /**
    * Determines the number of elements in this data structure.
    * 
    * @return the number of elements currently resident in this
    *         data structure.
    */
    
   public int size();

   /**
    * Add a new element.
    *
    * @param e the element to be added.  
    *
    * It is expected that classes that extend this interface will
    * provide an order on how the element is added to the collection. 
    */
    
   public boolean add(E e);

   /**
    * Remove the specified element.
    *
    * @param i - Index of the element to be removed.
    *
    * @return the element removed, if the element exists on the collection,
    *         null otherwise.
    */
    
   public E remove(int i);

   /**
    * Determine if the element is contained in this list.
    *
    * @param e the element to be searched for.
    *
    * @return true - if e was in the list, false otherwise.
    */
    
   public boolean contains(E e);
   
   //reset the element with index 
   
   public E reset(int i, E e);
   
   //traversal of the collection
   public void show() ;
   
  
   
}
