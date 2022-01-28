
/**
 * This Class will store the Fraction objects within the array and
 * will resize array when neccessary, specifically when a new
 * Fraction object is added. 
 * 
 * Attributes:
 * 
 * fractionsCs: An array of FractionCounter objects
 * 
 * sizeCounter:Counts how many FractionCounter objects
 * have been added used to resized array.
 *
 * @author Connor Lauerman
 * @version 10/10/2019
 */
public class ObjectList
{
    private FractionCounter[] fractionCs;
    private int sizeCounter;

    /**
     * Constructor for ObjectList, sets the FractionCounter array to 0
     */
    public ObjectList()
    {
        fractionCs=new FractionCounter[0];
    }

    /**
     * Will resize array if a new FractionCounter object is added to the 
     * array
     * 
     * input:
     * 
     * f: The FractionCounter object to be added to the array
     */
    public void addFractionCounter(FractionCounter f)
    {
        this.sizeCounter++;
        FractionCounter[] temp = new FractionCounter[fractionCs.length];
        for (int i = 0; i < fractionCs.length;i++)
        {
            temp[i]=fractionCs[i];
        }
        fractionCs=new FractionCounter[sizeCounter];
        for (int k =0; k < temp.length; k++)
        {
            fractionCs[k]=temp[k];
        }
        fractionCs[fractionCs.length-1]= f;

    }

    /**
     * Getter for the FractionCounter array
     * 
     * output:
     * 
     * Returns the FractionCounter array
     */
    public FractionCounter[] getFractionCounter()
    {
        return fractionCs; 
    }
}
