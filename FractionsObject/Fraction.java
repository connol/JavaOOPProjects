
/**
 * This class creates instances of fractions when called. The fraction object
 * has properties of numerator and denominator both of which are double for
 * the upper and lower parts of the fraction object
 *
 * @author Connor Lauerman
 * @version 10/10/2019
 */
public class Fraction
{
    private double numerator;
    private double denominator;

    /**
     * Defualt constructor for Fraction class
     */
    public Fraction()
    {

    }

    /**
     * Constructor for fraction class to create fraction 
     * with numerator or denominator
     * 
     * Input
     * 
     * num: The numerator for the fraction, of type int
     * 
     * dem: The denominator for the fraction, of type int
     */
    public Fraction(int num, int dem)
    {
        setFraction(num,dem);
    }

    /**
     * Constructor for the fraction class to create a fraction
     * with a numerator and denominator
     * 
     * Input:
     * 
     * num: The numerator for the fraction, of type double
     * 
     * dem:The denominator for the fraction, of type double
     */
    public Fraction(double num, double dem)
    {
        setFraction(num,dem);
    }

    /**
     * Getter for the numerator of the fraction
     * 
     * output:
     * 
     * returns the numerator, type double
     */
    public double getNumerator()
    {
        return this.numerator;
    }

    /**
     * Getter for the denominator of the fraction
     * 
     * output:
     * 
     * returns the denominator, type double
     */
    public double getDenominator()
    {
        return this.denominator;
    }

    /**
     * Setter for the fraction which reduces the numerator
     * and denominator then sets the numerator and denominator
     * 
     * input:
     * 
     * num: The numerator for the fraction, of type int
     * 
     * dem: The denominator for the fraction, of type int
     */
    public void setFraction(int num, int dem)
    {
        if(num > dem)
        {
            for (int i = num; i >1;i--)
            {
                if (num % i ==0 && dem % i ==0)
                {
                    num = num/i;
                    dem = dem/i;
                }
            }
        }
        else if(dem > num)
        {
            for (int i=dem; i >1; i--)
            {
                if(num % i==0 && dem % i==0)
                {
                    num = num/i;
                    dem = dem/i;
                }
            }
        }
        else if(dem == num)
        {
            dem =1;
            num=1;
        }
        this.numerator = num;
        this.denominator =dem;
    }

    /**
     * Checks if this instance of the fraction is equal
     * another instance of Fraction by checking the numerator
     * and denominator
     * 
     * input: 
     * 
     * other: An instance of the Fraction object that will
     * be compared to
     * 
     * output:
     * 
     * true or false based of equality of the two fraction objects
     */
    public boolean equals(Fraction other)
    {
        if(this.numerator == other.getNumerator() && this.denominator == other.getDenominator())
        {
            return true;  
        }
        else
        {
            return false;   
        }
    }

    /**
     * Setter for the fraction which reduces the numerator
     * and denominator then sets the numerator and denominator
     * 
     * input:
     * 
     * num: The numerator for the fraction, of type double
     * 
     * dem: The denominator for the fraction, of type double
     */
    public void setFraction(double num, double dem)
    {
        if(num > dem)
        {
            for (double i = num; i >1;i--)
            {
                if (num % i ==0 && dem % i ==0)
                {
                    num = num/i;
                    dem = dem/i;
                }
            }
        }
        else if(dem > num)
        {
            for (double i=dem; i >1; i--)
            {
                if(num % i==0 && dem % i==0)
                {
                    num = num/i;
                    dem = dem/i;
                }
            }
        } 
        else if(dem == num)
        {
            dem =1;
            num=1;
        }
        this.numerator = num;
        this.denominator =dem;
    }

    /**
     * Prints to screen the visual reprsentation of the fraction
     * with the numerator and denominator split by an "/"
     *
     * output:
     * 
     * String representation of the Fraction
     */
    public String toString()
    {
        int n = (int)this.numerator;
        int d = (int)this.denominator;

        return (n + "/" + d);
    }

}
