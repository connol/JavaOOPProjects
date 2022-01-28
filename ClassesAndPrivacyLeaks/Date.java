import java.io.*;
/**
 * A class that represents a date with month
 * day and year
 *
 * @author Connor Lauerman
 * @version 10/18/2019
 */
public class Date implements Comparable,Cloneable,Serializable
{
    private int day;
    private int year;
    private int month;
    private static final long serialVersionUID = 22L;
    /**
     * This method sets the date
     * 
     * input 
     * 
     * d=day
     * 
     * m=month
     * 
     * y=year
     * 
     * 
     */
    public Date(int m, int d,int y) 
    {
        setDay(d);
        setYear(y);
        setMonth(m);

    }   

    /**
     * Default contructor for Date object
     */
    public Date()
    {

    }

    /**
     * Copy constructor for Date
     */
    private Date(Date d)
    {
        
        setDate(d.getMonth(),d.getDay(),d.getYear());
        

    }

    /**
     * Sets month day and year of the date
     * 
     * input:
     * 
     * m: the moneth to be set type int
     * 
     * d: the day to be set, type int
     * 
     * y: the year to be set, type int
     */
    public void setDate(int m, int d,int y) 
    {
        
        Date n = new Date(m,d,y);
        setDay(n.day);
        setYear(n.year);
        setMonth(n.month);
        
    }   
    /**
     * This method sets the day given the
     * day is between 1 and 32
     * 
     * input:
     * 
     * d:The new day for the date
     * 
     * @exception IllegalArgumentException if the day is not
     *  1-31
     */
    public void setDay(int d)
    {
        if(d > 0 && d < 32)
        {
            this.day = d;
        }
        else
        {
            String msg = ("The day must be inbetween 1 and 32");
            throw new IllegalArgumentException(msg);
            
        }
    }

    /**
     * This method sets the month given that
     * the month is between 1 and 12 if not 
     * defualt value of 1 will be set
     * 
     * input:
     * 
     * m:The month taht the date will be set
     * 
     * @exception IllegalArgumentException if the month is 
     * not 1-12
     */
    public void setMonth(int m)
    {
        if(m > 0 && m < 13)
        {
            this.month =m;
        }
        else
        {
            String msg= ("month must be 1 to 12 setting");
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * This method sets the year if the year
     * is greater than 0 
     * 
     * input:
     * 
     * y:The year that the date will be set at
     * 
     * @exception IllegalArgumentException if year is not 
     * between 2001 and 2024
     */
    public void setYear(int y)
    {
        if(y>2000 && y< 2025)
        {
            this.year=y;
        }
        else
        {
            String msg=("Year must be positive between 2001 and 2024");
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Getter for the day of the date
     * 
     * output:
     * 
     * The day as a int
     */
    public int getDay()
    {
        return this.day; 
    }

    /**
     * getter for the month of the date
     * 
     * output:
     * 
     * The month as a int
     */
    public int getMonth()
    {
        return this.month;
    }

    /**
     * getter for the Year of the date
     * 
     * output:
     * 
     * the year as a int
     */
    public int getYear()
    {
        return this.year;   
    }
    
    /**
     * Returns a String reprsentaion of the Date
     */
    public String toString()
    {
        return getDay() + "." + getMonth() + "." + getYear();
    }
    
    /**
     * Checks if one date object is equal to another date object
     * by checking the day month and year
     * 
     * Input:
     * 
     * other: Some object to be compared to a Date object
     * 
     * output:
     * 
     * True or false basseed on the comparison of the two objects
     */
    public boolean equals(Object other)
    {
        if (other == null)
        {
         return false;   
        }
        else if(!(other instanceof Date))
        {
            return false;
        }
        Date o = (Date)other;
        if(this.day == o.getDay() && this.year == o.getYear()
        && this.month == o.getMonth())
        {
             return true;
        }
        else
        {
          return false;   
        }
    }
    /**
     * Checks if one date is less than anohter date 
     * by checking first the year then the month then 
     * the day
     * 
     * input:
     * 
     * d: Date object to be compared to
     */
    public boolean isLessThan(Date d)
    {
        if(d == null)
        {
            return false;
        }
        else if(this.year > d.year)
        {
            return false;
        }
        else if(this.month > d.month)
        {
            return false;
        }
        else if(this.day > d.day)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    /**
     * Compares two date objects by checking year, month, and day
     * and returns 0 if equal positve if the calling object has a
     * larger date and a negative value of the calling object has a
     * smaller date
     * 
     * Input:
     * 
     * @param that the Object to be compared to the date object
     * 
     * @exception IllegalArgumentException if the object compared
     * is not a date 
     */
    public int compareTo(Object that)
    {
        if(that== null)
        {
            throw new NullPointerException();
        }
        else if(!(that instanceof Date))
        {
            throw new IllegalArgumentException("Object not a Date");
        }
        Date d = (Date) that;
        if(this.equals(that))
        {
            return 0;
        }
        else if(this.year > d.year)
        {
            return 1;
        }
        else if(this.month > d.month)
        {
            return 3;
        }
        else if(this.day > d.day)
        {
            return 5;
        }
        else
        {
            return -1;
        }
    }
    
    /**
     * Creates a deep copy of the calling Date object
     * 
     * @return the deep copy of the Date object
     */
    public Date clone()
    {
        Date temp = new Date(this);
        return temp;
    }
    
}
