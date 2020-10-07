import java.util.*;
/**
 * The interface Index is an interface for the implementations of a book index
 *
 * @author Omar Drira
 * @version 05/05/20
 */
public interface Index
{
    
    /**
     * method that adds a word appearance in a certain line to the index
     * @param the word to be added  
     * @param the line number in which it appears
     */
    void add(String w, Integer k);
    
    /**
     * method that prints the contents of the index 
     * to a certain given file name
     * @param the name of the output file
     */
    void print(String fileName);
}
