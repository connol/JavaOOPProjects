
/**
 * This class has the attributes of a Fraction object and a Counter 
 * in which it will use the fraction stored to check if other 
 * instances of FractioCounter store the same Fraction object
 * and if so will increase the value of theCounter
 * accordingly
 *
 * @author Connor Lauerman
 * @version 10/10/2019
 */
public class FractionCounter
{
    private Fraction theFraction;
    private int theCounter;

    /**
     * The Constructor for  FractionCounter class 
     * will set the Fraction and the counter
     * 
     * input:
     * 
     * theFraction: An instance of the Fraction object
     */
    public FractionCounter(Fraction theFraction)
    {
        this.theFraction = theFraction;
        this.theCounter=1;
    }

    /**
     * Will compare the one fraction with another fraction 
     * and if both fractions are equals will increase the 
     * value of theCounter by 1
     * 
     * input:
     * 
     * newFraction: The fraction to be compared
     * 
     * output:
     * 
     * true or false based on the equality of the two Fraction
     * objects
     */
    public boolean compareAndIncrement(Fraction newFraction)
    {
        if(this.theFraction.equals(newFraction))
        {
            theCounter++;
            return true;
        }
        return false;
    }

    /**
     * Will print a visual reprsentation of the fraction object
     * with the numerator and denominator seperated by a "/"
     * 
     * output:
     * 
     * String representation of the Fraction
     */
    public String toString()
    {
        return theFraction.toString();   
    }

    /**
     * Getter for the fraction 
     * 
     * output:
     * 
     * returns the fraction object stored within the class
     **/
     
    public Fraction getFraction()
    {
        return theFraction;   
    }

    /**
     * Getter for the counter
     * 
     * output:
     * 
     * returns the number of iterations this fraction 
     * object has
     */
    public int getCounter()
    {
        return theCounter;  
    }
}

