package theProject;

public interface QueueInterface<T>
{
  void enqueue(T element) throws QueueOverflowException;
  // Throws QueueOverflowException if this queue is full;
  // otherwise, adds element to the rear of this queue.

  T dequeue() throws QueueUnderflowException;
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.

  boolean isFull();
  // Returns true if this queue is full; otherwise, returns false.

  boolean isEmpty();
  // Returns true if this queue is empty; otherwise, returns false.
  
  int size();
  // Returns the number of elements in this queue.
}




