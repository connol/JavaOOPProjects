
/**
 * This program is a data structure creation
 * of a stack which is capable of storing object
 * elements. The stack follows a LIFO structure
 *
 * @author Connor Lauerman
 * @version 10/16/2019
 */
public class Stack
{
    private Object[] stack;
    private int numElements = 0;

    /**
     * Default constructor for Stack 
     * will set Object array to 100
     */
    public Stack()
    {
        this.stack = new Object[100];
    }
    
    /**
     * Will push every object in the list down
     * one postion and will add a new object to 
     * the front of the list
     * 
     * Input:
     * 
     * newObject: The Object to be added to the
     * front of the stack
     */
    public void push(Object newObject)
    {
        if(this.stack[this.stack.length -2] != null)
        {
            reSize();
        }
        if(newObject != null)
        {
            if (numElements == 0)
            {
                this.stack[0] = newObject;
            }
            else
            {
                Object temp1;
                Object temp2 = newObject;
                for(int i = 0; i <numElements+1; i++)
                {
                    temp1= this.stack[i];
                    this.stack[i]=temp2;
                    temp2=temp1;

                }

            }
            numElements++;
        }
    }

    /**
     * Will bring every object up one postion in 
     * the list and return the previous first object
     * 
     * output:
     * 
     * The Object that was at the front of the stack
     */
    public  Object pop()
    {
        if(this.stack[this.stack.length -2] != null)
        {
            reSize();
        }
        Object carrier = null;
        if(this.stack[0] != null)
        {

            Object temp;
            carrier=this.stack[0];
            for (int i = 0; i < numElements+1;i++)
            {
                temp = this.stack[i+1];
                this.stack[i]=temp;
            }
            numElements--;
        }
        return carrier;
    }

    /**
     * Will create a string containg the elements of
     * of the array
     * 
     * Output:
     * 
     * Returns a string with the elements of the array
     * printed
     */
    public String toString()
    {
        String retVal = "";
        for (int i = 0; i < numElements;i++)
        {
            
            retVal = retVal + stack[i] + "\n";
        }
        return retVal;
    }

    /**
     * Will check list to see if empty or not
     * 
     * Output:
     * 
     * True or false based on if the list is empty
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
     * Checks if to stack lists are equal by
     * checking the number of elements and value
     * or memeory address of each element
     * 
     * Input:
     * 
     * other: Type Obejct that will be compared to the
     * stack list
     * 
     * Output:
     * 
     * true or false based on the equality of the two Stack lists
     */
    
    public boolean equals(Object other)
    {
        if(other == null)
        {
            return false;
        }
        else if(!( other instanceof Stack))
        {
            return false;
        }
        
        Stack that = (Stack)other;
        if(this.numElements != that.getNumElements())
        {
            return false;
        }
        boolean isEqual = true;
        for (int i = 0; i< this.stack.length;i++)
        {
            if (this.stack[i] != that.getStackArray()[i])
            {
                isEqual = false;
            }
        }
        return isEqual;
    }
    
    /**
     * Getter for the stack array
     * 
     * output:
     * 
     * returns the instace of the array used in
     * stack
     */
    private Object[] getStackArray()
    {
        return this.stack;
    }
    
    /**
     * Getter for the number of elements in the stack
     * list
     * 
     * Output:
     * 
     * Will return the number of elements in the stack
     */
    public int getNumElements()
    {
        return this.numElements;
    }
    
    /**
     * Will resize the stack array used
     * method is called at start of any additive
     * method to resize if there is an element in the 
     * second to last index
     */
    public void reSize()
    {
        Object temp[] = new Object[this.stack.length + 50];
        for(int i = 0; i < this.stack.length;i++)
        {
            temp[i]=this.stack[i];
        }
        this.stack=temp;
    }
    public int size()
    {
        return this.numElements;
    }

}
