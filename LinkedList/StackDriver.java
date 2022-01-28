
/**
 * A driver for the stack class too test if all the methods of
 * the stack is working correctly
 *
 * @author Connor Lauerman
 * @version 11/14/2019
 */
public class StackDriver
{
    /**
     * Tests the methods of the Stack class
     */
    public static void main(String[] args)
    {
        try
        {
            Stack a = new Stack();
            char b = 'b';
            char c = 'c';
            char d = 'd';
            System.out.println("Add order b c d");
            a.push(b);
            a.insert(c,5);
            a.append(d);
            System.out.println(a.toString());
            a.push('z');
            a.remove(10);
            while(!a.isEmpty())
            {
                System.out.println(a.pop());
            }
            a.pop();

        }
        catch(LinkedListException e)
        {
            System.out.println(e.getMessage());
        }
        
       
        
        
    }
}
