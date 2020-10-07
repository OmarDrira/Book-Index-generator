import java.io.File;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;
/**
 * The class IndexTester conducts experiments on the 3 different index classes
 *
 * @author Omar Drira
 * @version 05/05/20
 */
public class IndexTester 
{
    /**
     * ArrayList that represents a dictionary
     */
    ArrayList<String> dictionary;
    
    /**
     * Constructor for objects of class IndexTester, creates a dictionary
     */
    public IndexTester()
    {
        dictionary= new ArrayList<>();
        try {
            BufferedReader br1 = new BufferedReader(new FileReader("English.txt"));
            while (br1.ready()) dictionary.add(br1.readLine());
        } catch (Exception e) {
            System.out.println("Exception occured in the constructor: "+e);
        }
    }
    
    /**
     * Main method of the IndexTester class that performs the experiments
     * gives a result for 14 different books for a chosen data structure
     * @param an array of string arguments
     */
    public static void main(String[] args){
        IndexTester tester = new IndexTester();
        String[] files= {"Alice","Candide","Nietzsche","Frankenstein","JaneAusten","DavidCopperfield","BleakHouse","Maupassant","WarAndPeace","LesMiserables","WilliamCowper","RobertBrowning","Shakespeare","WinstonChurchill"};
        try {
            for (String file:files){
                long average= 0; long average1= 0; 
                for(int j=0; j<10;j++){
                    BufferedReader br = new BufferedReader(new FileReader(file+".txt"));
                    Index l= new HashIndex(); // data structure can be changed here
                    String line =br.readLine();

                    long startTime = System.currentTimeMillis(); 
                    int i=1;
                    while (line!=null){
                        String[] words= line.toLowerCase().split(("[^a-zA-Z]+"));
                        for(String w:words){
                            if(tester.isWord(w)){l.add(w,i);}
                        }
                        line =br.readLine();
                        i++;
                    }
                    long stopTime= System.currentTimeMillis();
                    long startTime1 = System.currentTimeMillis();
                    l.print("output/"+j+file+"output.txt");
                    long stopTime1= System.currentTimeMillis();
                    average+=(stopTime - startTime);
                    average1+=(stopTime1 - startTime1);
                }
                
                average= (long) ((float)average/(float)10);
                average1= (long) ((float)average/(float)10);
                System.out.println(average+" | "+average1);
            }
        } catch (Exception e) {
            System.out.println("Exception occured in the main method: "+e);
        }

    }
    
    /**
     * method that determines if a string is an english word or not
     * @param input string to be determined
     * @return boolean describing if the string is an english word or not
     */
    public boolean isWord(String w){
        int l=0; int r= dictionary.size();
        while (l<=r){
            int m= (l+r)/2; 
            if(w.compareTo(dictionary.get(m)) > 0) l=m+1;
            else if(w.compareTo(dictionary.get(m)) < 0) r=m-1;
            else return true ;
        }
        return false;
    }
}
