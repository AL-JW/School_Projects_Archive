//---------------------------------------------------------------------------
// LinkedUnbndQueue.java         by Dale/Joyce/Weems                Chapter 5
//
// Implements UnboundedQueueInterface using a linked list
//---------------------------------------------------------------------------

package queuePackage;

public class LinkedUnbndQueue<T> implements UnboundedQueueInterface<T>
{
  protected LLNode<T> front;   // reference to the front of this queue
  protected LLNode<T> rear;    // reference to the rear of this queue

  public LinkedUnbndQueue()
  {
    front = null;
    rear = null;
  }

  public void enqueue(T element)
  // Adds element to the rear of this queue.
  { 
    LLNode<T> newNode = new LLNode<T>(element);
    if (rear == null)
      front = newNode;
    else
      rear.setLink(newNode);
    rear = newNode;
  }     

  public T dequeue()
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.
  {
    if (isEmpty())
      throw new QueueUnderflowException("Dequeue attempted on empty queue.");
    else
    {
      T element;
      element = front.getInfo();
      front = front.getLink();
      if (front == null)
        rear = null;

      return element;
    }
  }

  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {              
    if (front == null) 
      return true;
    else
      return false;
  }
  
  public static int count(LinkedUnbndQueue<String> origQ) {
		
		//count the values in the origQ, storing them in tempQ
		LinkedUnbndQueue<String> tempQ = new LinkedUnbndQueue<String>();
		int count = 0;
		String s = "";
		
		if(origQ == null)
			return 0;
		else
		{
		while (!tempQ.isEmpty()) 
		{
			s = tempQ.dequeue();
			origQ.enqueue(s);
			count++;
		}
		// count code goes here
		return count;
	    }
	}
  
  
  public static LinkedUnbndQueue<String> copyQueue(LinkedUnbndQueue<String> origQ) {
		
		LinkedUnbndQueue<String> copyQ = new LinkedUnbndQueue<String>();
		String copyStore = "";
		
		while(!origQ.isEmpty()) {
		
		//for(int i = 0; i <= origQ.length()-1; i++)
		
			copyStore = origQ.dequeue();
			copyQ.enqueue(copyStore);
		}
		
		// copyQueue code goes here
		
		return copyQ;
	}
  
  
}

