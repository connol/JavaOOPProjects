import java.io.*;
/**
 * A program that will search through a tree of
 * directories to find a certain file
 *
 * @author Connor Lauerman
 * @version 11/7/2019
 */
public class FindFile
{
    private int Count = 0;
    private int maxFiles;
    private String[] Files;
    /**
     * Constructor for Find File 
     * intializes the String array length and max
     * files 
     * 
     * input:
     * 
     * @param maxFiles as integer which will
     * initialzie the max files to find for one 
     * search iteration
     */
    FindFile(int maxFiles)
    {
        this.maxFiles = maxFiles;
        setFiles(maxFiles);

    }

    /**
     * Gets a file name and directory to find the address of
     * the file location by calling a reccursive method that 
     * seraches through directories for files
     * 
     * Input:
     * 
     * @param target, string, which is the file name 
     * that is to be found
     * 
     * @param dirName, Stirng, Which is the directory
     * name to begin the search
     * 
     * Output:
     * 
     * @exception IllegalArgumen which gets thrown if 
     * dirName is null
     * 
     * @exception Exception which gets thrown if 
     * max files is found 
     * 
     * stroes files location into an array
     */

    public void directorySearch(String target, String dirName)
    throws IllegalArgumentException, ItemNotFoundException
    {
        String temp;
        if(dirName == null)
        {
            throw new IllegalArgumentException("Invalid Directory");
        }
        File start = new File(dirName);
        if(!start.isDirectory())
        {
            throw new IllegalArgumentException("Not a valid Directory");
        }
        else
        {
            this.Count = 0;
            setFiles(this.Files.length);
            recursiveSearch(start,target);//Starts reccursive method
            if(Files[0]==null)
            {
                System.out.println(target + " file not Found");
            }
        }

    }

    /**
     * Method which reccursivley searchs through a 
     * directory tree to find a certain file name
     * and store that name into an array
     * 
     * Input
     * 
     * @param path, type File, The directory to start searched
     * in the tree
     * 
     * @param target, type String, Which is the name of the file
     * to be found
     * 
     * Output:
     * 
     * If file is found Adds file address to String array 
     */
    private void recursiveSearch(File path, String target)
    throws IllegalArgumentException, ItemNotFoundException
    {

        if(Count == maxFiles)
        {
            throw new ItemNotFoundException("Max files found");
        }
        if(!path.isDirectory())
        {
           if(target.equals(path.getName()))
                        {
                            if(Files[maxFiles-1]  != null)
                            {
                                throw new ItemNotFoundException("Max files found");
                            }
                            Files[Count] = path.getPath();
                            Count++;

                        } 
        }
        else
        {
            if(path.listFiles() != null)
            {
                for(File a : path.listFiles())
                {
                    if(!a.isDirectory())
                    {
                        if(target.equals(a.getName()))
                        {
                            if(Files[maxFiles-1]  != null)
                            {
                                throw new ItemNotFoundException("Max files found");
                            }
                            Files[Count] = a.getPath();
                            Count++;

                        }

                    }
                    else
                    {
                        recursiveSearch(a, target);
                    }
                }
            }

        }
    }

    /**
     * Gets the stirng which holds the 
     * file addresses avoids privacy leak
     * when retirving array
     * 
     * Output:
     * 
     * String array with file addresses
     */
    public String[] getFiles()
    {
        String [] temp = this.Files;
        return temp;
    }

    /**
     * gets the Count of how many files have been returned
     * 
     * Output:
     * 
     * Retunrs an int for the amount of Files
     * found of the correct name given
     * 
     */
    public int getCount()
    {
        return Count;
    }

    /**
     * Sets the Files array length 
     * to max files avoids privacy leak
     * 
     * Input:
     * 
     * @param maxfiles the max files for the
     * search to find 
     */
    public void setFiles(int maxFiles)
    {
        String[] temp = new String[maxFiles];
        this.Files = temp;
    }
}
