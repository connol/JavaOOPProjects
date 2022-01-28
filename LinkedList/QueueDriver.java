
/**
 * A driver to test the queue methods 
 *
 * @author Connor Lauerman
 * @version 11/14/2019
 */
public class QueueDriver
{
    /**
     * Tests the methods of the queue class
     */
    public static void main(String[] args)
    {
        try
        {
            Queue a = new Queue();

            char b = 'b';
            char c = 'c';
            a.enqueue(b);
            System.out.println(a.toString());
            a.enqueue(c);
            System.out.println(a.toString());
            a.insert(c,100);
            a.append('z');
            a.remove(3);
            System.out.println();
            
            System.out.println("\nWill print \nc\nc\nz\n");
            while(!a.isEmpty())
            {
                System.out.println(a.dequeue());
            }
        }
        catch(LinkedListException e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            Queue aa = new Queue();
            aa.dequeue();
        }
        catch(LinkedListException e)
        {
            System.out.println(e.getMessage());
        }

    }   

}
