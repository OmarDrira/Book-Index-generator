import java.util.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileReader;
/**
 * The class ListIndex represents a book index by a sorted ArrayList of Entry
 * objects
 *
 * @author Omar Drira
 * @version 05/05/20
 */
public class ListIndex implements Index
{   
    /**
     * ArrayList for Entry objects
     */
    ArrayList<Entry> index;

    /**
     * Constructor for objects of class ListIndex
     */
    public ListIndex()
    {
        index = new ArrayList<Entry>();

    }
    
    /**
     * inner class Entry is a class that represents an Entry of a word and lines numbers
     */
    class Entry implements Comparable<Entry>{
        String word;
        TreeSet<Integer> lineNumbers;
        
        /**
         * Constructor of Entry class
         * @param the word
         * @param the first line
         */
        public Entry(String w, Integer k ){
            word=w;
            lineNumbers = new TreeSet<>();
            lineNumbers.add(k);
        }
        
        /**
         * method that adds a line number to the treeSet of line numbers
         * @param the line number to be added
         */
        public void add(Integer k){
            lineNumbers.add(k);
        }
        
        /**
         * method that returns a string describing the data contained in this
         * @return a string describing the data contained in this
         */
        public String toString(){
            return (word+" "+lineNumbers);
        }
        
        /**
         * method that returns an int describing the result of comparing 
         * this to another Entry
         * @param Entry to be compared to
         * @return int describing the result of comparing this to the Entry
         */
        public int compareTo(Entry e){
            return word.compareTo(e.word);
        }
    }
    /**
     * method that adds a word appearance in a certain line to the index
     * @param the word to be added  
     * @param the line number in which it appears
     */
    public void add(String w, Integer k){

        int pos =  binarySearch(w);
        if(pos<0){
            Entry e= new Entry(w,k);
            index.add(-pos-1,e);
        }else{
            index.get(pos).add(k);
        }

    }

    /**
     * method that returns the position of a given word if it exists in the
     * index or where it should be if it does not exist using a binary search
     * @param the word
     * @return the position
     */
    public int binarySearch(String w){
        int l=0; int r=index.size()-1;
        while (l<=r){
            int m= (l+r)/2; 
            if(w.compareTo(index.get(m).word) < 0) r=m-1;
            else if(w.compareTo(index.get(m).word) > 0) l=m+1;
            else return m ;
        }
        return -l-1;
    }

    /**
     * method that prints the contents of the index 
     * to a certain given file name
     * @param the name of the output file
     */
    public void print(String fileName){
        try{
            PrintWriter p = new PrintWriter(new File(fileName));
            for(Entry entry:index) {
                p.write(""+entry);p.println();
            }
            p.close(); 
        }catch (Exception e){
            System.out.println("Exception occured in ListIndex print method: "+e);
        }
    }
}
