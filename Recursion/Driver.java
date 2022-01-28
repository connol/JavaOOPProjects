
/**
 * A tester for the FindFile class which catches all
 * posible exceptions that can be thrown
 *
 * @author Connor Lauerman
 * @version 11/7/2019
 */
public class Driver
{
    /**
     * Tests the FindFile by finding a different cases to
     * find a file and different amount of times
     */
    public static void main(String[] args)
    {
        FindFile a = new FindFile(6);
        FindFile b = new FindFile(3);
        FindFile c = new FindFile (2);
        FindFile d= new FindFile(1);
        try
        {
            a.directorySearch("longwords.txt","c:\\//AAA");//Multiple
            b.directorySearch("HW3.zip","c:\\//AAA");//One exsists
            c.directorySearch("a","c:\\//AAA");//None exsists
            a.directorySearch("longwords.txt","c:\\//AAA");
            d.directorySearch("longwords.txt","c:\\//AAA");//Max reached
        }
        catch(IllegalArgumentException e)
        {

            System.out.println(e.getMessage());
            //System.exit(0); //Can exit if excpetion is thrown

        }
        catch(ItemNotFoundException e)
        {
            System.out.println(e.getMessage());

        }
        finally
        {
            for(String m : a.getFiles())
            {
                if(m != null)
                {
                    System.out.println(m);
                }
            }
            for(String m : b.getFiles())
            {
                if(m != null)
                {
                    System.out.println(m);
                }
            }
            for(String m : c.getFiles())
            {
                if(m != null)
                {
                    System.out.println(m);
                }
            }
            for(String m : d.getFiles())
            {
                if(m != null)
                {
                    System.out.println(m);
                }
            }
        }
        //Tests for invalid directory
        try
        {
            b.directorySearch("HW3.zip","Wrong directory");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
