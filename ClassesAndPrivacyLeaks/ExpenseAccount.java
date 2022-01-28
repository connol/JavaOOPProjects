
/**
 * A list to hold bills for a company
 *
 * @author Connor Lauerman
 * @version 11/21/2019
 */
public class ExpenseAccount extends ArrayList
{
    /**
     * Constructor for expense account that creates an 
     * Expense account arrayList by calling the super constructor
     * 
     */
    public ExpenseAccount()
    {
        super();
    }

    /**
     * Returns the amount as a double for the total number of
     * money unpaid in the expense account
     * 
     * @return double for the amount left to be paid
     */
    public double getBalance()
    {
        double total = 0;
        for(int i = 0; i < getNumElements();i++)
        {
            Bill temp = (Bill) get(i);
            if(temp.isPaid() != true)
            {
                total += temp.getAmount().getMoney();
            }
        }
        return total;
    }

    /**
     * Adds a bill to the Expense account by calling the
     * base class add method
     * 
     * @param b a Bill to be added to the Expense account
     */
    public void debited(Bill b)
    {
        super.add(b);
    }

    /**
     * Pays off a bill in the expense account by taking in a bill
     * finding in the expense account and setting to the date paid
     * 
     * @param b Bill that is getting paid off
     * 
     * @param paid tpye Date the date the bill will be paid off
     * 
     * @exception IllegalArgumentException if the Bill inputed is
     * not in the expense account
     */
    public void credited(Bill b, Date paid)
    {
        if(indexOf(b) == -1)
        {
            throw new IllegalArgumentException("Bill not in account");
        }
        else
        {
            Object s = get(indexOf(b));
            Bill temp = (Bill) s;
            System.out.println("Amount paid: " + temp.getAmount().getMoney());
            temp.setPaid(paid);
            insert(temp,indexOf(b));

        }
    }

    /**
     * Finds the bill that will need to be paid next by
     * the lowest date if that bill is not already paid
     * 
     * @return type Bill the bill that needs to be paid next
     * 
     * @exception IllegalArgumentException if the expesne account
     * is empty
     */
    public Bill nextDue()
    {
        Object t = get(0);
        if(t == null)
        {
            throw new IllegalArgumentException("Empty expense list");
        }
        Bill next = (Bill)t;

        for(int i = 0; i < getNumElements();i++)
        {
            Bill temp = (Bill) get(i);
            if(next.getPaidDate() != null)
            {
                next = temp;
            }
            if(next.getDueDate().compareTo(temp.getDueDate()) > 0)
            {
                next = temp;
            }

        }
        if(next.getPaidDate() != null)
        {
            System.out.println("All bills are Paid");
            return null;
        }
        else
        {
            System.out.println("Next Bill due: " + next.toString());
            return next;
        }
    }

    /**
     * Pays the whole Expense Account then closes it by
     * setting the paid date and setting index to null
     * 
     * @param paidDate type date the date to set the pay 
     * date of the bill
     * 
     * @return the amount of bills paid off as type
     * double
     */
    public double close(Date paidDate)
    {
        double paid = getBalance();
        int k = getNumElements();
        for(int i = 0; i <k;i++)
        {
            Bill temp = (Bill)get(0);
            if(temp.getPaidDate() == null)
            {

                temp.setPaid(paidDate);
                
                remove(0);
            }
            else
            {
                remove(0);
            }
        }
        System.out.println("Amount paid when closing: " + paid);
        return paid;
    }

}
