import java.util.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileReader;
/**
 * The class TreeIndex represents a book index by a TreeMap
 *
 * @author Omar Drira
 * @version 05/05/20
 */
public class TreeIndex implements Index
{   
    /**
     * The TreeMap represents the book index
     */
    TreeMap<String, TreeSet<Integer>> index; 
    /**
     * Constructor for objects of class TreeIndex
     */
    public TreeIndex()
    {
        index = new TreeMap<>() ;
    }
    
    /**
     * method that adds a word appearance in a certain line to the index
     * @param the word to be added  
     * @param the line number in which it appears
     */
    public void add(String w, Integer k){

        if (index.containsKey(w)) {
            index.get(w).add(k);
        }
        else {
            TreeSet<Integer> t= new TreeSet<>();
            t.add(k);
            index.put(w,t);
        }

    }
    
    /**
     * method that returns a set of all the words in the index
     * @return a set of all the words in the index
     */
    public Set<String> keySet(){
        return index.keySet();
    }

    /**
     * method that prints the contents of the index 
     * to a certain given file name
     * @param the name of the output file
     */
    public void print(String fileName){
        try{
            PrintWriter p = new PrintWriter(new File(fileName));
            ArrayList<String> keys = new ArrayList<>(index.keySet());
            for(String key:keys) {
                p.write(key+" "+index.get(key));p.println();
            }
            p.close(); 
        }catch (Exception e){
            System.out.println("Exception occured in TreeIndex print method: "+e);
        }

    }

}
