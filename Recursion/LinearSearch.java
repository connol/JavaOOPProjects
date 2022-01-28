
/**
 * A program that inherits from search algorithm whose main
 * function is to search a list of arrays for a
 * paticular word lineraly
 *
 * @author Connor Lauerman
 * @version 11/7/2019
 */
public class LinearSearch extends SearchAlgorithm
{
    /**
     * Will lineraly search throough a array of words to 
     * find a desired word 
     * 
     * Input:
     * 
     * @param words[], string array that takes the words
     * in to search for a word
     * 
     * @param wordToFind, String of the word to find in 
     * the array
     * 
     * Output:
     * 
     * returns index at which the word is found
     * 
     * @exception Throws ItemNotFoundException if
     * the word cannot be found in the list
     */
    public int search(String[] words, String wordToFind) 
    throws ItemNotFoundException
    {
        boolean found = false;
        for(int i = 0;i < words.length;i++)
        {
            incrementCount();
            if(wordToFind.equals(words[i]))
            {
                found = true;
                return i;
                
            }
        }
        if(!found)
        {
            throw new ItemNotFoundException("Word to find not in list");  
        }
        return getCount();
    }

    /**
     * Attempts to find the word lineraly
     * using reccursion
     * 
     * !Is unable to find the word becasue the method gives
     * a sack overflow propably becasue there are so many
     * words to search through and the stack can't hold
     * that many iterations!
     * 
     * Input:
     * 
     * @param words[], string array that takes the words
     * in to search for a word
     * 
     * @param wordToFind, String of the word to find in 
     * the array
     * 
     * Output:
     * 
     * returns index at which the word is found
     * 
     * @exception Throws ItemNotFoundException if
     * the word cannot be found in the list
     */
    public int recSearch(String[] words, String wordToFind)
    throws ItemNotFoundException
    {
        if(getCount() >= words.length)
        {
            
            
                throw new ItemNotFoundException("Word to find not in list");
           
            
            
        }
        else if(words[getCount()].equals(wordToFind))
        {
            return 0;
        }
        else
        {
            incrementCount();
            return recSearch(words,wordToFind) +1;
            
        }
    }
}
