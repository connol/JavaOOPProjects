
/**
 * This program is a data structure arrayList which is
 * capable of adding elements to the list and resizing 
 * as necessary
 *
 * @author Connor Lauerman
 * @version 10/13/2019
 */
public class ArrayList
{
    private Object[] arrayList;
    private int numElements=0;

    /**
     * Constructor that sets array at desired size
     * 
     * input:
     * 
     * size: How many indices the arrayList will have
     */
    public ArrayList()
    {
        this.arrayList = new Object[100];
    }

    /**
     * Will add object to the next available spot in
     * the array list
     * 
     * intput:
     * 
     * newObject: The object that will be added to the 
     * 
     */
    public void add(Object newObject)
    {
        if(this.arrayList[this.arrayList.length -2] != null)
        {
            reSize();
        }
        if(newObject != null)
        {           
            for(int i = 0; i < this.arrayList.length; i++)
            {

                if(this.arrayList[i] == null)
                {
                    this.arrayList[i]=newObject;

                    numElements++;
                    break;
                }

            }
        }
    }

    /**
     * Will insert an object into the specified index 
     * and push every index after to the right. 
     * 
     * Invariants:
     * 
     * Index must be positve or error msg will show and
     * object will not be added
     * 
     * Index is not allowed to be added past the number of
     * elements in the list, error msg is shown and added to
     * last element of the list
     *
     * input:
     * 
     * newObject: The objecte to be inserted into the List
     * 
     * index: At what index the new object will be added;
     * 
     **/
    public void insert(Object newObject, int index)
    {
        if(this.arrayList[this.arrayList.length -2] != null)
        {
            reSize();
        }
        Object temp1;
        Object temp2;
        if(index < 0 )
        {
            System.out.println("Index cannot be negative object not added");
            System.out.println("Program will end");
            System.exit(0);
        }
        else if(index > numElements)
        {
            System.out.print("Object added past end of list");
            System.out.println(" program will end");
            System.exit(0);
        }
        else
        {
            temp2=newObject;
            for (int i = index; i < this.numElements+1;i++)
            {
                temp1 = this.arrayList[i];
                this.arrayList[i]=temp2;
                temp2=temp1;

            }
            this.numElements++;
        }

    }

    /**
     * Removes the object in the list at specific
     * index then collapses the rest of the list
     * to fill the empty index
     * 
     * Cases:
     * 
     * At desired index no element exsists will return a null
     *
     * input: 
     * 
     * index: At what index the object will be removed
     * 
     * Output:
     * 
     * Returns the object removed for list
     * 
     * 
     */
    public Object remove(int index)
    {
        if(this.arrayList[this.arrayList.length -2] != null)
        {
            reSize();
        }
        if(index > this.numElements)
        {
            System.out.println("OutOfBounds");
            return null;
        }
        else
        {
            Object temp1;           
            Object temp2=this.arrayList[index];
            this.arrayList[index] = null;

            for (int i = index; i< this.numElements+1;i++)
            {
                temp1 = this.arrayList[i+1];
                this.arrayList[i]= temp1;
            }
            numElements--;
            return temp2;
        }
    }

    /**
     * Returns how many Elements are currently in the 
     * list
     * 
     * output:
     * 
     *Returns number of elements in the list as int
     */
    public int size()
    {
        return this.numElements;
    }

    /**
     * Returns a string representation of the 
     * list with empty lines inbetween
     * 
     * output:
     * 
     * Returns a String with all element memory locations
     * printed
     */
    public String toString()
    {
        String retVal = "";
        for (int i = 0; i < this.numElements+1;i++)
        {
            if(this.arrayList[i] != null)
            {
                retVal = retVal + this.arrayList[i] + "\n";
            }
        }
        return retVal;
    }

    /**
     * Checks to see if the arrayList is empty
     * 
     * output:
     * 
     * Returns true if the array list is empty and false
     * if the array list contains elements
     */
    public boolean isEmpty()
    {
        if (this.numElements==0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
     * Finds the index of a desired object
     * 
     * intput:
     * 
     * toFind: the object to be found within the list
     * type object
     */
    public int indexOf(Object toFind)
    {
        for (int i =0; i<this.numElements+1;i++)
        {
            if(this.arrayList[i]==toFind)
            {
                return i;
            }

        }
        return -1;
    }

    /**
     * Checks to see if two arrayLists are equal by 
     * checking the size and elements of the two lists
     * 
     * input:
     * 
     * other: The object to be compared to the arrayList
     * 
     * output:
     * 
     * true or false based on the equality of the 
     * array lists
     */
    public boolean equals(Object other)
    {
        if(other == null)
        {
            return false;
        }
        else if(!(other instanceof ArrayList))
        {
            return false;
        }
        ArrayList check = (ArrayList)other;
        if(this.arrayList.length !=check.getArrayList().length
        || this.numElements != check.numElements)
        {
            return false;
        }
        boolean isEqual = true;
        for (int i = 0; i< this.arrayList.length;i++)
        {
            if (this.arrayList[i] != check.getArrayList()[i])
            {
                isEqual = false;
            }
        }
        return isEqual;
    }

    /**
     * Getter for arrayList
     * 
     * output:
     * 
     * returns the array for the arrayList
     */
    private Object[] getArrayList()
    {
        return this.arrayList;
    }

    /**
     * Getter for the number of elemetns in the arrayList
     * 
     * output:
     * 
     * returns an int for the number of elements in the list
     */
    public int getNumElements()
    {
        return this.numElements;
    }

    /**
     * Gets the object at a specific index in the
     * array list will not remove object
     * 
     * input:
     * 
     * index: the index at which the object will be grabbed
     * type int
     * 
     * output:
     * 
     * returns the object from the array list
     * 
     * 
     */
    public Object get(int index)
    {
        if (!(index > this.arrayList.length) && index > -1)
        {
            return this.arrayList[index];
        }
        else
        {
            System.out.print("OutOfBounds");
             System.out.println(" returning null");
         return null;   
        }
        
    }

    /**
     * Will resize the stack array used
     * method is called at start of any additive
     * method to resize if there is an element in the 
     * second to last index
     */
    public void reSize()
    {
        Object temp[] = new Object[this.arrayList.length + 50];
        for(int i = 0; i < this.arrayList.length;i++)
        {
            temp[i]=this.arrayList[i];
        }
        this.arrayList=temp;
    }
}