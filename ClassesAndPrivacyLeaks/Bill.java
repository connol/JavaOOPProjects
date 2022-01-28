import java.io.*;
/**
 * This program is a bill that has an amount to
 * be paid a due date a paid date and an 
 * originator of the bill
 *
 * @author Connor Lauerman
 * @version 10/19/20
 */
public class Bill implements Comparable, Cloneable,Serializable
{
    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String originator;
    private static final long serialVersionUID = 55L;

    /**
     * Constructor for Bill that will set
     * amount due date and originator not 
     * the paid date
     * 
     * input:
     * 
     * amount: Money object for the amount of
     * the bill
     * 
     * dueDate: Date object for the date the
     * object is due
     * 
     * originator: The name of the creator of the 
     * bill, as string
     */
    public Bill(Money amount, Date dueDate, String originator)
    {
        this.paidDate=null;
        Money tempa = amount.clone();
        this.amount = tempa;
        setDueDate(dueDate);
        setOriginator(originator);

    }

    /**
     * Copy Constructor for bill class
     * 
     * Will take the arguments of another
     * bill object and create a new memory
     * location for a new bill with the 
     * same arguments
     * 
     * Input:
     * 
     * b: Bill object to be copied
     *
     */
    private Bill(Bill b)
    {
        if(b.paidDate != null)
        {
            setAmount(b.amount);
            setDueDate(b.dueDate);
            setPaid(b.paidDate);
            setOriginator(b.originator);
        }
        else
        {
            setAmount(b.amount);
            setDueDate(b.dueDate); 
            setOriginator(b.originator);
        }
    }

    /**
     * Gets the due date object from the
     * bill object 
     * 
     * Creates new memory location for due date
     * and returns that mermory location
     * 
     * Output:
     * 
     * Returns the due date for the bill as
     * a date object
     * 
     */
    public Date getDueDate()
    {
        return this.dueDate.clone();
    }

    /**
     * Will get the date the bill was paid on
     * 
     * @return Date Object that the bill was paid on or null
     * if date is not paid
     * 
     * 
     */
    public Date getPaidDate()
    {
        if(paidDate == null)
        {
           return null;

        }
        else
        {
            return this.paidDate.clone();
        }
    }

    /**
     * Gets the originator for the bill 
     * obejct 
     * 
     * Output:
     * 
     * Returns a string of the orginator name
     */
    public String getOriginator()
    {
        return new String(this.originator);
    }

    /**
     * Checks whether the bill is currently paid
     * 
     * Output:
     * 
     * Returns true or false based off
     * the payment status of the bill
     */
    public boolean isPaid()
    {
        if(this.paidDate != null)
        {
            return true;
        }
        else
        {
            return false;   
        }
    }

    /**
     * Sets the paid date for the bill if 
     * the date is before the due date
     * 
     * Input:
     * 
     * onDay: The Date object the bill will
     * be set on
     * 
     * @exception if paid date is after due date or if date null
     */
    public void setPaid(Date onDay)
    {
        if(onDay != null)
        {
            if(onDay.isLessThan(this.dueDate))
            {
                Date temp = onDay.clone();
                this.paidDate = temp;
            }

            else 
            {
                String msg = ("Paid Date conflicts with due date");
                throw new IllegalArgumentException(msg);
            }

        }
        else
        {
            String msg = ("Null paid date given");
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Makes the bill unpaid by 
     * setting the paid date to null
     */
    public void unPaid()
    {
        this.paidDate = null;
    }

    /**
     * Will set the due dateif the bill has 
     * not already been paid
     * 
     * Input:
     * 
     * nextDate: The date the due date is to be
     * set
     * 
     * @exception IllegalArgumentException is thrown if due date of
     * bill is attempted to be set when already paid
     */
    public void setDueDate(Date nextDate)
    {
        if(this.paidDate != null)
        {
            String msg = ("Bill must not be paid to set due date");

            throw new IllegalArgumentException(msg);

        }
        else
        {
            Date temp = nextDate.clone();
            this.dueDate = temp;
        }

    }

    /**
     * Sets the amount of the bill using a money
     * object
     * 
     * Input:
     * 
     * amount: A money object to set the amount
     */
    public void setAmount(Money amount)
    {
        Money temp = amount.clone();
        this.amount = temp;
    }

    /**
     * Gets the price of the bill
     * 
     * Output:
     * 
     * Returns a new money object with the
     * value of the bill
     */
    public Money getAmount()
    {
        return this.amount.clone();   
    }

    /**
     * Sets the originator of the bill must not be null
     * or an empty string
     * 
     * Input:
     * 
     * A String for the originator for the bill
     * 
     * @exception IllegalArgumentException is thrown if the Orginator
     * has no name
     */
    public void setOriginator(String originator)
    {
        if (originator != null)
        {
            if(originator.isEmpty() || originator.length() == 0)
            {
                String msg = ("Originator must have a name");
                throw new IllegalArgumentException(msg);
            }
            else
            {
                String temp = new String(originator);
                this.originator = temp;
            }   
        }
        else
        {
            String msg = ("Originator must have a name");
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Creates a String representation of the bill
     * by writing the amount, duedate, paid date
     * and originator of the bill
     * 
     * Output:
     * 
     * Returns a String representation of the bill
     */
    public String toString()
    {
        String retVal = "";
        if(this.paidDate == null)
        {
            retVal= "Amount: " + this.amount + " Due by: " + this.dueDate;
            retVal= retVal + " pay to: " + this.originator + " Status: unpaid";
            return retVal;
        }
        else
        {
            retVal= "Amount: " + this.amount + " Due by: " + this.dueDate;
            retVal= retVal + " pay to: " + this.originator + " Status: paid ";
            retVal = retVal + "Date paid: " + this.paidDate;
            return retVal;
        }
    }

    /**
     * Checks if two bill objects are equal
     * by checking the due date paid date
     * amount and originator
     * 
     * Input:
     * 
     * That: the bill to be compared 
     * 
     * Output:
     * 
     * True or false based off the comparison
     * of the two bills
     */
    public boolean equals(Bill that)
    {
        if(that == null)
        {
            return false;
        }
        else if(this.paidDate != null && that.paidDate != null)
        {
            if(this.amount.equals(that.amount) &&
            this.dueDate.equals(that.dueDate) &&
            this.originator.equals(that.originator) &&
            this.paidDate.equals(that.paidDate))

            {
                return true;
            }
            else
            {

                return false;
            }
        }
        else if(this.paidDate == null && that.paidDate == null)
        {
            if(this.amount.equals(that.amount) &&
            this.dueDate.equals(that.dueDate) &&
            this.originator.equals(that.originator))
            {
                return true;   
            }
            else
            {
                return false;
            }
        }

        else
        {
            return false;
        }
    }

    /**
     * Compares two Bill object two and returns 0 if they are equal a
     * positve number if the calling objects amount is larger and a
     * negative number if the calling object has a less amount
     * 
     * @param other Object type that will be compared to the bill
     * 
     * @return int value positve or negative based on the comparison
     * 
     * @excetpion IllegalArgumentException is thrown if other is not
     * a Bill or is null
     */
    public int compareTo(Object other)
    {
        int same = 0;
        if(other == null)
        {
            throw new IllegalArgumentException("Compared object cannot be null");
        }
        else if(!(other instanceof Bill))
        {
            throw new IllegalArgumentException("Not instance of Bill");
        }
        Bill that =(Bill) other;
        if(this.equals(that))
        {
            return 0;
        }
        if(this.getAmount().compareTo(that.getAmount()) > 0)
        {
            return 7;
        }
        else
        {
            return -7;
        }
     
    }

    /**
     * Creates a deep copy of the calling bill object
     * 
     * @return the deep copy of the calling bill
     */
    public Bill clone()
    {
        if(this.paidDate == null)
        {
            Bill temp = 
                new Bill(this.amount.clone(),this.dueDate.clone(),this.getOriginator());
            return temp;
        }
        else
        {
            Bill temp = 
                new Bill(this);
            return temp;
        }
    }
}
