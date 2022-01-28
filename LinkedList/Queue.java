
/**
 * A queue data type structure used by extending the list
 * class which uses nodes to store values
 *
 * @author Connor Lauerman
 * @version 11/14/2019
 */
public class Queue extends List
{
    /**
     * No arg constructor for Queue which will call the 
     * base class constructor
     */
    public Queue()
    {
        super();

    }

    /**
     * Will add an object to the back of the queue 
     * 
     * Adds object to the back of the queue by calling the 
     * super insert and adding the object to the last postion
     * of the list
     * 
     * Input:
     * 
     * @param next an Object that will be added to the queue
     * 
     * @exception LinkedListException throws if input is null
     * 
     */
    public void enqueue(Object next) throws LinkedListException
    {
        if(next == null)
        {
            throw new LinkedListException("Input can't be null");
        }
        else
        {
            super.insert(next,super.size());
        }
    }

    /**
     * Retrives the front of the queue object and pushes the 
     * rest of the objects one up in the queue does so by
     * calling the base method remove at index 0
     * 
     * @return The Object removed from the queue
     * 
     * @exception LinkedListException
     */
    public Object dequeue() throws LinkedListException
    {
        if(isEmpty())
        {
            throw new LinkedListException("Queue is empty");
        }
        else
        {
            return super.remove(0);
        }
    }

    /**
     * Checks to see if the queue is empty by
     * calling the base isEmpty method
     * 
     * @return true or false based on emptiness of queue
     */
    public boolean isEmpty()
    {
        return super.isEmpty();
    }

    /**
     * Overides the insert method in the base class and works the same 
     * as the enqueu method 
     * 
     * Input:
     * 
     * @param next an Object that is added to the queue
     * 
     * @param a as type int not used 
     * 
     * @exception LinkedListException
     */
    public void insert(Object next, int a) throws LinkedListException
    {
        if(next == null)
        {
            throw new LinkedListException("Input can't be null");
        }
        else
        {
            super.insert(next,super.size());
        }
    }

    /**
     * Overrides the remove method from the base class will
     * work as the dequeue method 
     * 
     * Input:
     * 
     * @param a as type int not used
     */
    public Object remove(int a) throws LinkedListException
    {
        if(isEmpty())
        {
            throw new LinkedListException("Queue is empty");
        }
        else
        {
            return super.remove(0);
        }
    }

    /**
     * Overides the indexOf method from the base class and throws 
     * exception if called from a queue object 
     * 
     * @param target the Object to find not used
     * 
     * @exception LinkedListException if called
     */
    public int indexOf(Object target) throws LinkedListException
    {
        throw new LinkedListException("Invalid call for queue");   
    }

    /**
     * Overides the append method from the base class to work 
     * the same as the enqueue class
     * 
     * @param next the Object added to the queue
     * 
     * @exception LinkedListException
     */
    public void append(Object next) throws LinkedListException
    {
        enqueue(next);
    }


}
