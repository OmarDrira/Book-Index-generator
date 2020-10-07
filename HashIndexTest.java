

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HashIndexTest tests the add and print methods of the HashIndex class
 *
 * @author Omar Drira
 * @version 05/10/20
 */
public class HashIndexTest
{
    private HashIndex hash1;
    private HashIndex hash2;
    private HashIndex hash3;
    private HashIndex hash4;
    
    /**
     * Default constructor for test class HashIndexTest
     */
    public HashIndexTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        hash1 = new HashIndex();
        hash2 = new HashIndex();
        hash3 = new HashIndex();
        hash4 = new HashIndex();
        hash2.add("nice", 111);
        hash3.add("nice", 111);
        hash3.add("Good", 222);
        hash4.add("nice", 111);
        hash4.add("good", 222);
        hash4.add("welcome", 333);
        hash4.add("home", 444);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testAdd()
    {
        hash1.add("nice", 1234);
        hash4.add("alpha", 431);
        hash3.add("wiiiw", 56);
        hash2.add("good", 98);
        hash2.add("nice", 908);
        testPrint();
    }
    
    @Test
    public void testPrint()
    {
        hash1.print("unittestoutput/hash1.txt");
        hash2.print("unittestoutput/hash2.txt");
        hash3.print("unittestoutput/hash3.txt");
        hash4.print("unittestoutput/hash4.txt");
    }
}
