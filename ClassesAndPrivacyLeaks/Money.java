import java.io.*;
/**
 * This program is a representation of money to which value
 * can be added through dollars and cents
 *
 * @author Connor Lauerman
 * @version 10/19/19
 */
public class Money implements Comparable,Cloneable,Serializable
{
    private int dollars;
    private int cents;
    private static final long serialVersionUID = 89L;

    /**
     * Constructor for Money which takes in dollars 
     * and no cents to create the object
     * 
     * input:
     * 
     * dol: the dollar amount to be used for money
     * as type int
     */
    public Money(int dol)
    {
        setDollars(dol);
    }

    /**
     * Constructor for money which takes the
     * dollars and cents to create the object
     * 
     * input:
     * 
     * dol: the dollar amount to be used for money
     * as type int
     * 
     * cent: the amount of cents to add to the money
     * as type int
     * 
     * 
     */
    public Money(int dol, int cent)
    {
        setDollars(dol);
        setCents(cent);
    }

    /**
     * Copy constructor for Money object will
     * take a money object and create a copy using
     * new memory location
     * 
     * input: 
     * 
     * other: the money object to be copied
     */
    private Money(Money other)
    {
        this.dollars = other.dollars;
        this.cents= other.cents;
    }

    /**
     * Sets the dollars for the money account
     * if dollars is 0 or greater
     * 
     * input:
     * 
     * dol: The dollars to be set, type int
     * 
     * @exception IllegalArgumentException is thrown if input is 
     * negative
     */
    public void setDollars(int dol)
    {
        if(dol >= 0)
        {
            this.dollars = dol;
        }
        else
        {
            String msg= ("Dollars can't be negative");
            throw new IllegalArgumentException(msg); 
        }
    }

    /**
     * Will set the cents for the money if cents
     * is 0 or greater and less than 100
     * 
     * input:
     * 
     * cent: the amount of cents to be set as type
     * int
     * 
     * @exception IllegalArgumentException is thrown if cents is
     * is not between 0 - 99
     */
    public void setCents(int cent)
    {
        if (cent >= 0 && cent < 100)
        {
            this.cents = cent;
        }
        else
        {
            String msg = ("Cents must be inbetween 0 and 99");
            throw new IllegalArgumentException(msg); 
        }
    }

    /**
     * Will get the value of dollars 
     * and return it as int
     * 
     * output:
     * 
     * returns value of dollars as int
     */
    public int getDollars()
    {
        return this.dollars;
    }

    /**
     * Will get the value of cents
     * and return it as int
     * 
     * output:
     * 
     * returns value of cents as int
     */
    public int getCents()
    {
        return this.cents;
    }

    /**
     * Will get the total amount of cents and
     * dollars for the money object and return 
     * the value as a double
     * 
     * Output:
     * 
     * Returns a double for the value of the money
     */
    public double getMoney()
    {
        Double dol = new Double(this.dollars);
        Double cents= new Double(this.cents);
        cents = cents/100;
        return (dol + cents);
    }

    /**
     * Will set the cents and dollars for the
     * money object
     * 
     * input:
     * 
     * dol: The amount of dollars to be set as int
     * 
     * cent: The amount of cents to be set as int
     */
    public void setMoney(int dol, int cent)
    {
        Money temp = new Money(dol,cent);
        setDollars(temp.dollars);
        setCents(temp.cents);
    }

    /**
     * Will add dollars to the current dollar 
     * value if the new value of dollars added
     * is still 0 or above
     * 
     * input:
     * 
     * dol: The dollars to be added 
     * to the current value as int
     * 
     * @exception IllegalArgumentException is thrown if dollars 
     * is negative
     */
    public void add(int dol)
    {
        if(this.dollars + dol < 0)
        {
            String msg = ("Can't have negative dollars");
            throw new IllegalArgumentException(msg);
        }
        else
        {
            setDollars(this.dollars + dol);
        }
    }

    /**
     * Will add dollars and cents to the current
     * value of dollar and cents if the addition of cents 
     * goes above or below the current dollar value will
     * convert dollars to cents to properley add the new 
     * value, will end program if at any point the total 
     * value is less than zero after addition
     * 
     * input: 
     * 
     * dol: The dollar amount to be added as int
     * 
     * cent: the cents amount to be added as int
     * 
     * @excption IllegalArgumentException is thrown if at any point
     * the total amount of dollars is negative
     */
    public void add(int dol, int cents)
    {
        if(dol <= 0 && cents <= 0 )
        {
            if(this.cents + cents < 0)
            {
                int total = (this.cents + cents)/100  * -1;
                if(this.cents + cents <=0 && this.cents + cents >= -99)
                {

                    if(this.dollars < 0 || this.dollars + dol < 0)
                    {
                        String msg =("Can't have negative dollars, exiting");
                        throw new IllegalArgumentException(msg); 
                    }
                    else 
                    {
                        this.dollars = this.dollars - 1;
                        this.cents = ((this.cents + 100 + cents));
                        this.dollars = this.dollars + dol;
                    }
                }            
                else if(this.dollars - total < 0 || this.dollars - total + dol < 0)
                {
                    String msg = ("Can't have negative dollars");
                    throw new IllegalArgumentException(msg); 
                }
                else
                {

                    this.dollars = this.dollars - total;
                    this.cents = ((this.cents + ((100 * total) + cents)));
                    this.dollars = this.dollars + dol;

                }
            }
            else if (this.dollars + dol < 0)
            {
                String msg = ("Can't have negative dollars");
                throw new IllegalArgumentException(msg); 
            }

        }
        else if(dol >= 0 && cents >= 0)
        {

            if(this.cents + cents > 99)
            {
                int total = (this.cents+cents)/100; 
                this.dollars = this.dollars + total;
                this.cents = ((this.cents - (total*100) + cents));
                this.dollars = this.dollars + dol;
            }
            else
            {
                this.dollars = this.dollars + dol;
                this.cents = this.cents + cents;
            }
        }
        else
        {
            String msg = ("Dollars and cents amount must be");
            msg = " both positive or negative";
            throw new IllegalArgumentException(msg); 
        }

    }

    /**
     * Will add dollars and cents that is recived
     * from another money object
     * 
     * input:
     * 
     * other: Money object to get values
     */
    public void add(Money other)
    {
        add(other.getDollars(),other.getCents());

    }

    /**
     * Checks if two money objects are 
     * equal by checking the value of dollars
     * and the value of cents 
     * 
     * input:
     * 
     * Object: The object to be compared to
     * 
     * Output:
     * 
     * True or false based off equality of two
     * the obejcts
     */
    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }
        else if(!(o instanceof Money))
        {
            return false;
        }

        Money that = (Money)o;
        if(this.dollars == that.dollars && this.cents == that.cents)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Creates a string reprsentation of a dollar 
     * printing out the value
     * 
     * Output:
     * 
     * Returns the String for the dollar 
     */
    public String toString()
    {
        String retVal = "";
        if(cents >= 10)
        {
            retVal = retVal + dollars + "." + cents;
            return retVal;
        }   
        else
        {
            retVal = retVal + dollars + ".0" + cents;
            return retVal;
        }
    }

    /**
     * Compares two money objects if they are equal it returns 0 
     * if the calling object is greater it returns a positive value 
     * and if smaller it retuns a negative value
     * 
     * @param other Object type that will be compared
     * 
     * @return an int positive or negative base on the comparison
     * 
     * @exception IllegalArgumentException if other is null
     * or not an instance of money 
     */
    public int compareTo(Object other)
    {
        if(other == null)
        {
            throw new IllegalArgumentException("Inout cannpt be null");
        }
        else if(!(other instanceof Money))
        {
            throw new IllegalArgumentException("Input must be money object");
        }
        Money that = (Money) other;
        if(this.equals(that))
        {
            return 0;
        }
        else if(this.getDollars() > that.getDollars())
        {
            return 1;
        }
        else if(this.getCents() > that.getCents() &&
        this.getDollars() == that.getDollars())
        {
            return 1;
        }
        else 
        {
            return -1;
        }

    }

    /**
     * Creates a deep copy of the calling object
     * 
     * @return Money object that is the copy of the calling
     * object
     */
    public Money clone()
    {
        Money temp = new Money(this);
        return temp;
    }

}

