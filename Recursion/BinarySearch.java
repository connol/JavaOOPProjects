
/**
 * A program that can find the index of 
 * a word from an array of words
 *
 * @author Connor Lauerman
 * @version 10/7/2019
 */
public class BinarySearch extends SearchAlgorithm
{
    public int LI;
    public int HI;
    public int MI;
    /**
     * Finds a word certain word form an array of 
     * words and returns the index does so with
     * a while loop
     * 
     * Input:
     * 
     * @param words[], an array of strings that is the 
     * list of words to search through
     * 
     * @param wordToFind, a String for the word to be
     * found in the array
     */
    public int search(String[] words, String wordToFind)
    throws ItemNotFoundException
    {
        int LowIndex = 0;
        int HighIndex = words.length-1;
        int MidIndex = HighIndex / 2;
        while(LowIndex <= HighIndex)
        {
            incrementCount();
            MidIndex = (HighIndex + LowIndex) / 2;
            if(words[MidIndex].equals(wordToFind))
            {
                return MidIndex;
            }
            else if(words[MidIndex].compareTo(wordToFind) < 0)
            {
                LowIndex = MidIndex +1;
            }
            else if(words[MidIndex].compareTo(wordToFind) > 0)
            {
                HighIndex = MidIndex -1;
            }

        }
        throw new ItemNotFoundException("Word not in list");
    }

      /**
     * Finds a word certain word form an array of 
     * words and returns the index does so with
     * reccursion
     * 
     * Input:
     * 
     * @param words[], an array of strings that is the 
     * list of words to search through
     * 
     * @param wordToFind, a String for the word to be
     * found in the array
     */
    public int recSearch(String[] words, String wordToFind) 
    throws ItemNotFoundException
    {
        if(getCount() == 0)
        {
            HI = words.length -1;
            LI=0;

        }
        
        MI = (HI + LI) / 2;
        
        incrementCount();
        if(words[LI].equals(wordToFind))
        {
            return LI;
        }
        else if(words[HI].equals(wordToFind))
        {
            return HI;
        }
        if(HI <= LI)
        {
            throw new ItemNotFoundException("Word not in list");
        }
        if(words[MI].equals(wordToFind))
        {
            return MI;
        }
        else if(words[MI].compareTo(wordToFind) < 0)
        {
            LI = MI + 1;
            return recSearch(words,wordToFind);
        }
        else
        {
            HI = MI - 1;
            return recSearch(words,wordToFind);
        }
        
        

        
    }
}
