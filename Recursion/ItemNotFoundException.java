
/**
 * An exception that is used when some item
 * is not found in a list
 *
 * @author Connor Lauerman
 * @version 11/7/2019
 */
public class ItemNotFoundException extends Exception
{
    /**
     * Constructor for the exception 
     * calls the super to write message
     */
    public ItemNotFoundException(String message)
    {
        super(message);
    }
}
