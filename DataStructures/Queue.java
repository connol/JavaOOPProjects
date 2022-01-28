
/**
 * This program is a creation of the data
 * structure queue in which elements are
 * stored and accesed with a FIFO order
 *
 * @author Connor Lauerman
 * @version 10/13/2019
 */
public class Queue
{
    private Object[] queue;
    private int numElements;
    
    /**
     * Default constructor for Queue
     * will set queue array to 100
     */
    public Queue()
    {
        queue= new Object[100];
    }
    
    /**
     * Will add an Object to the end of the queue
     * 
     * Input:
     * 
     * newObject: Type Object, the object that will be 
     * added to the end of the queue
     */
    public void enqueue(Object newObject)
    {
         if(this.queue[this.queue.length -2] != null)
        {
            reSize();
        }
        if(newObject != null);
        {
           
           
            for(int i = 0; i < numElements+1;i++)
            {
                if(this.queue[i]==null)
                {
                    this.queue[i]=newObject;
                    numElements++;
                    break;
                }
            }
        }
    }
    
    /**
     * Will return the object at the front of the queue
     * 
     * Output:
     * 
     * retruns object at fornt of queue
     */
    public Object dequeue()
    {
        Object carrier = null;
        if(isEmpty() == false)
        {
            carrier = this.queue[0]; 
            Object temp;
            this.queue[0]=null;
            for(int i = 0; i< numElements +2;i++)
            {
                temp = this.queue[i+1];
                this.queue[i]=temp;
                
            }
          numElements--;  
        }
        return carrier;
    }
    
    /**
     * Checks to see if queue list is empty
     * 
     * Output:
     * 
     * True or false based off the empetiness of the list
     */
    public boolean isEmpty()
    {
        if(numElements == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * Will return the number of elements in the list
     * 
     * Output:
     * 
     * returns an int for the number
     * of elements in the list
     */
    public int size()
    {
        return this.numElements;
    }
    
    /**
     * Creates a string for every element of the queue
     * 
     * Output;
     * 
     * returns a String for all elements of the queue
     */
    public String toString()
    {
        String retVal = "";
        for(int i = 0; i < numElements;i++)
        {
            retVal = retVal + this.queue[i] + "\n";
        }
        return retVal;
    }
    
    /**
     * Will check if an object is equal to the queue
     * based on the number of elements and each element
     * value/memory address
     * 
     * Input:
     * 
     * other: Type object, will be used to 
     * compare to the current instance of queue
     * 
     * output:
     * 
     * true or false based on the equality of the two
     * queue objects
     * 
     */
    public boolean equals(Object other)
    {
        if(other == null)
        {
            return false;
        }
        else if(!( other instanceof Queue))
        {
            return false;
        }
        
        Queue that = (Queue)other;
        if(this.numElements != that.getNumElements())
        {
            return false;
        }
        boolean isEqual = true;
        for (int i = 0; i< this.queue.length;i++)
        {
            if (this.queue[i] != that.getQueueArray()[i])
            {
                isEqual = false;
            }
        }
        return isEqual;
    }
    
    /**
     * Getter for the queue's array
     * 
     * Output:
     * 
     * Returns an Object array that is used
     * for the current instance of queue
     */
    private Object[] getQueueArray()
    {
        return this.queue;
    }
    
    /**
     * Getter for the number of elemetns for the queue
     * 
     * Output:
     * 
     * Reutrns 
     */
    public int getNumElements()
    {
        return this.numElements;
    }
    
    public void reSize()
    {
        Object temp[] = new Object[this.queue.length + 50];
        for(int i = 0; i < this.queue.length;i++)
        {
            temp[i]=this.queue[i];
        }
        this.queue=temp;
    }
    
}
