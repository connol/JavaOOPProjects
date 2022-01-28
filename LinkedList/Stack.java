
/**
 * A Stack data tpye structure that uses nodes and a lists
 * to create the functinallity of a stack extends List class
 *
 * @author Connor Lauerman
 * @version 11/14/2019
 */
public class Stack extends List
{
    /**
     * The constructor for the stack which takes 
     * no arguments and calls the paraent constructor
     */
    public Stack()
    {
        super();   
    }
    
    /**
     * Checks to see if the stack is empty by calling
     * the super isEmpty method and checling if the list
     * used to store the stack is empty
     * 
     * @return false or true basesd on the emptines of the 
     * stack
     */
    public boolean isEmpty()
    {
        return super.isEmpty();   
    }
    
    /**
     * Adds an object to the start of the stack by calling the insert
     * method from the base List class at index 0
     * 
     * Input:
     * 
     * @param next the Object that will be added to the top 
     * of the stack
     * 
     * @exception throws LinkedListException
     */
    public void push(Object next) throws LinkedListException
    {
        super.insert(next,0);
    }
    
    /**
     * Removes form the top of the stack and moves every
     * other element up towrads the top
     * 
     * @return The object that was removed from the stack
     * 
     * @exception throws LinkedListExcetion
     */
    public Object pop() throws LinkedListException
    {
        return super.remove(0);
    }
    
    /**
     * Overides the Parent indexOf method so that the stack
     * cannot access it
     */
    public int indexOf(Object target) throws LinkedListException
    {
      throw new LinkedListException("Invalid call for stack");   
    }
    
    /**
     * Overides the append method from the parent class so that
     * the stack object cannot access it instead will work as the
     * push method 
     * 
     * Input:
     * 
     * @param next The object to be added to the list
     */
    public void append(Object next) throws LinkedListException
    {
        super.insert(next,0);
    }
    
    /**
     * Overides the remove method from the list base class and will 
     * instead work as the pop method
     * 
     * Input:
     * 
     * @param index as type int not used
     */
    public Object remove(int index) throws LinkedListException
    {
        return super.remove(0);
    }
    
    /**
     * Overids the insert method from list and instead works
     * like pop method
     * 
     * Input:
     * 
     * @param next The Object to be added 
     * 
     * @param index will not be used
     * 
     * 
     */
    public void insert(Object next, int index) throws LinkedListException
    {
        super.insert(next,0);
    }
    
    
}
