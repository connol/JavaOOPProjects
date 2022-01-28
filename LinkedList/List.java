
/**
 * A List data structure that works like an arrayList
 * by using nodes to stroe value
 *
 * @author Connor Lauerman
 * @version 11/14/2019
 */
public class List
{
    private Node head = null;
    private class Node
    {
        private Object value;
        private Node link;
        

        /**
         * Constructor for node inner class
         * 
         * When called creates a new node with the value 
         * as an object and a new link of type Node
         * 
         * Input:
         * 
         * @param inValue value the node will hold 
         * of type object
         * 
         * @param inLink the link the node will refer to
         * as type node
         */
        public Node(Object inValue, Node inLink)
        {
            value = inValue;
            link = inLink;
        }

        /**
         * Getter for the value of the node
         * 
         * Output:
         * 
         * @return value the object the node returns
         */
        public Object getValue()
        {
            return value;
        }

        /**
         * Getter for the link
         * 
         * Output:
         * 
         * @return link the Node linked to this Node
         */
        public Node getLink()
        {
            return link;   
        }

        /**
         * Setter for link which takes in a node
         * to set the link with
         * 
         * Input:
         * 
         * @param in the Node type that the link will be 
         * set at
         */
        public void setLink(Node in)
        {
            this.link = in;
        }

        /**
         * Will traverse the nodes of the list 
         * and return the last 
         * 
         * @return the last node of the list
         * 
         * @exception LinkedListException
         */
        private Node traverse() throws LinkedListException
        {
            Node temp =head;

            while(temp.getLink() != null)
            {
                temp = temp.getLink();
            }

            return temp;
        }

    }

    /**
     * Inserts an object at a specific index in the list by
     * checking the index given and once found switches the 
     * current node with a new node containing the value and
     * adds the next link to the new node will append to the
     * end of the list and add a node to an empty list
     * 
     * Input:
     * 
     * @param next the object to be added to the list
     * 
     * @param index the index the object will be added at 
     * as type int
     * 
     * @exception can throw a LinkedListException if the call to
     * insert breaks any invariants 
     */
    public void insert(Object next, int index) throws LinkedListException
    {
        if(index > size())
        {
            throw new LinkedListException("index out of range");
        }
        if(index == 0)
        {
            if(head == null)
            {
                head = new Node(next,null);
            }
            else
            {
                head = new Node(next,head);
            }

        }
        else if(index == 1)
        {
            if(size() == 1)
            {
                head.link = new Node(next, null);
            }
            else
            {
                head.link = new Node(next, head.getLink());

            }
        }
        else if(index == size())
        {
            head.traverse().setLink(new Node(next, null));
        }
        else 
        {
            int currentIndex = 0;
            Node temp = head;
            Node temp2 = head;
            while(temp.getLink() != null)
            {
                currentIndex++;
                if(currentIndex == index)
                {

                    temp2.link = new Node(next,temp);

                }
                temp2 =temp;
                temp = temp.link;
            }

        }
    }

    /**
     * Creates a string from the list by prinint each element
     * of the list
     * 
     * @return return a string of every element of the list
     */
    public String toString()
    {
        int index = 0;
        if(head != null)
        {
            String retVal=head.getValue() + "\n";
            Node temp = head;

            while(temp.getLink() != null)
            {
                index++;
                temp = temp.getLink();
                retVal=retVal+temp.getValue() + "\n";

            }
            return retVal;
        }
        else
        {
            return null;
        }
    }

    /**
     * Finds the size of the list by going through
     * the list and counting each element
     * 
     * @exception throws LinkedListException
     */
    public int size() throws LinkedListException
    {
        Node temp = head;

        if(head == null)
        {
            return 0;
        }
        else if(head.link == null)
        {
            return 1;
        }
        else
        {
            int size = 1;
            while(temp.link != null)
            {

                temp=temp.getLink();
                size++;
            }

            return size;
        }
    }

    /**
     * Removes the Element at the specified index by 
     * going through the list until the element is reached
     * then pinching the previous link and the next link together
     * 
     * Input:
     * 
     * @param the index the object will be removed from
     * 
     * @return returns the object that was stored at the certain 
     * index
     */
    public Object remove(int index) throws LinkedListException
    {
        if(index < 0)
        {
            throw new LinkedListException("Index must be positve or");
        }
        else if(index == 0)
        {
            if(head == null)
            {
                throw new LinkedListException("Empty index");
            }
            else 
            {
                Object temp = head.value;
                head = head.link;
                return temp;
            }
        }
        else if(index == 1)
        {
            Object temp = head.link.value;
            head.link = head.link.link;
            return temp;
        }
        else if(index == size())
        {
            Object temp = head.traverse().value;
            Node t = head;
            while(t.link != null)
            {
                if(t.link.link == null)
                {
                    t.link = null;
                    break;
                }
            }
            return temp;
        }
        else
        {
            Object t = null;
            int currentIndex = 0;
            Node temp = head;
            Node temp2 = head;
            while(temp.getLink() != null)
            {
                currentIndex++;
                if(currentIndex == index)
                {
                    t = temp.value;
                    temp2.link=temp.link;
                    temp.link = null;
                    break;
                }
                temp2 =temp;
                temp = temp.link;
            }
            return t;
        }
    }
    /**
     * Adds an element to the end of the list
     * 
     * Input:
     * 
     * @param next the object to be added to the 
     * end of the list
     * 
     * @Exception throws LinkedListException
     */
    public void append(Object next) throws LinkedListException
    {
        insert(next,size());
    }
    
    /**
     * Checks if the list is empty by checking if the 
     * head node is null
     * 
     * @return true or false based on if the
     * list is empty
     */
    public boolean isEmpty()
    {
        if(head == null)
        {
            return true;
        }
        else
        {
             return false;
        }
    }
    
    /**
     * Takes an object and searches through the list to find
     * the index of the specific object
     * 
     * Input:
     * 
     * @param target the Object to be found in the list
     * 
     * @return retunrs the index the object was found at or
     * -1 if the object was not found
     * 
     * @exception throws LinkedListExcetption
     */
    public int indexOf(Object target) throws LinkedListException
    {
        if(target == null)
        {
            throw new LinkedListException("Input can't be null");
        }
        else
        {
            if(head.value.equals(target))
            {
                return 0;
            }
            else if(head.link.value.equals(target))
            {
                return 1;
            }
            else
            {
                int index = 0;
                Node temp = head;
                while(head.link != null)
                {
                    index++;
                    if(temp.link.value.equals(target))
                    {
                        return index;
                    }
                    temp=temp.link;
                    
                }
                return -1;
            }
        }
    }
}
