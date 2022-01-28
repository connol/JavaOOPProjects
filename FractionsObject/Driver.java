import java.util.*;
import java.io.*;
/**
 * This program brings together Fraction class FractionCounter Class
 * and ObjectList class to read from a file how many iteration of unique
 * fractions are on the file and prints the number of iterations
 *
 * @author Connor Lauerman
 * @version 10/10/2019
 */
public class Driver
{
    /**
     * Pulls in fractions from file then uses the numerator and denominator
     * to create a fraction obeject. Once all fraction objects are created 
     * and stored an a array it checks for multiple iterations of each 
     * fraction and prints out the how many time each fraction appears.
     */
    public static void main(String[] args)
    {
        ObjectList list = new ObjectList();
        Scanner sc = null;
        try
        {
            sc = new Scanner(new FileInputStream("fractions.txt"));
        }
        catch(IOException e)
        {
            System.out.println("File not Found");
            System.exit(0);
        }

        String [] split = new String[2];
        double numerator = 0;
        double denominator = 0;
        String Line;
        boolean a = true;
        while(sc.hasNextLine())

        {   

            Line = sc.nextLine();            
            if(!(Line.equals("")))
            {
                split=Line.split("/",2);
                try
                {
                    
                    numerator = Double.parseDouble(split[0]);
                    
                }
                catch(NumberFormatException b)
                {
                    System.out.println("Your file is corrupt, program will close. GoodBye");
                    System.exit(0);
                }
                try
                {
                 denominator = Double.parseDouble(split[1]);   
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Your file is corrupt, program will close. GoodBye");
                    System.exit(0);
                }
                catch(ArrayIndexOutOfBoundsException b)
                {
                    System.out.println("Your file is corrupt, program will close. GoodBye");
                    System.exit(0);
                }
                    
                    if((numerator < 0 && denominator > 0) ||
                    (numerator > 0 && denominator < 0))         
                    {

                    }
                    else if(numerator == 0 || denominator == 0)
                    {

                    }

                    else
                    {
                        while (numerator % 1 != 0 || denominator % 1 != 0)
                        {
                            numerator = numerator * 10;
                            denominator = denominator * 10;

                        }
                        if (numerator < 0 && denominator < 0)
                        {
                            numerator = numerator * -1;
                            denominator = denominator * -1;
                        }
                        Fraction frac = new Fraction(numerator,denominator);
                        FractionCounter fc = new FractionCounter(frac);
                        list.addFractionCounter(fc);
                    }

                }
        }
        for (int i = 0; i < list.getFractionCounter().length; i++)
        {

            for (int k = i+1; k < list.getFractionCounter().length; k++)
            {
                if (!(list.getFractionCounter()[i] == null) && list.getFractionCounter()[k] != null)
                {
                    if(list.getFractionCounter()[i].compareAndIncrement(list.getFractionCounter()[k].getFraction()))
                    {
                        list.getFractionCounter()[k] = null;

                    }
                }

            }
            if(!(list.getFractionCounter()[i] == null))
            {
                System.out.println(list.getFractionCounter()[i].toString() + " has " + list.getFractionCounter()[i].getCounter());
            }
        }

        sc.close();
    }

}