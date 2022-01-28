import java.util.*;
/**
 *  An Exception to throw for the Link queue and Stack
 *
 * @author Connor Lauerman
 * @version 11/14/2019
 */
public class LinkedListException extends Exception
{
    /**
     * No arg constructor for LinkedListException
     */
   public LinkedListException()
   {
       super();
   }
   
   /**
    * Constructor for LinkedListException which brings in a message
    * to type to screen when thrown
    * 
    * Input:
    * 
    * @param message a String for the message to send when the
    * exception is thrown
    */
   public LinkedListException(String message)
   {
       super(message);
    }
}
