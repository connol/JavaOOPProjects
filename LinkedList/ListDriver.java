
/**
 * A driver to test the code from the list class
 *
 * @author Connor Lauerman
 * @version 11/13/2019
 */
public class ListDriver
{
    /**
     * The method that tests the list class
     * 
     * Output:
     * 
     * Will print to screen results of methods
     */
    public static void main(String[] args)
    {
        try
        {
            List a = new List();

            char b = 'b';
            char c = 'c';
            char d = 'd';
            char e = 'e';
            System.out.println(a.size());
            a.insert(b,0);
            System.out.println(a.size());
            System.out.println(a.toString());
            a.insert(c,1);
            System.out.println(a.size());
            System.out.println(a.toString());
            a.insert(d,0);
            System.out.println(a.size());
            System.out.println(a.toString());
            System.out.println(a.size());
            a.insert(d,1);
            System.out.println(a.size());
            a.insert(e,4);
            System.out.println(a.toString());
            System.out.println(a.remove(3));
            System.out.println(a.toString());
            System.out.println(a.remove(0));
            System.out.println(a.toString());
            System.out.println(a.remove(1));
            System.out.println(a.toString());
            a.append(b);
            System.out.println(a.toString());
            a.append(d);
            System.out.println(a.toString());
            a.append(c);
            System.out.println(a.toString());
            System.out.println(a.indexOf(c));
            System.out.println(a.indexOf(d));
            System.out.println(a.indexOf(e));
            System.out.println(a.indexOf(b));
        }
        catch (LinkedListException e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            List aa = new List();
            aa.remove(0);
            
            
        }
        catch(LinkedListException e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            List aaa = new List();
            char a = 'a';
            aaa.insert(a,10);
        }
        catch(LinkedListException e)
        {
            System.out.println(e.getMessage());
        }
    }
}