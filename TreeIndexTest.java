
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TreeIndexTest tests the add and print methods of the TreeIndex class
 *
 * @author Omar Drira
 * @version 05/10/20
 */
public class TreeIndexTest
{
    private TreeIndex tree1;
    private TreeIndex tree2;
    private TreeIndex tree3;
    private TreeIndex tree4;

    /**
     * Default constructor for test class TreeIndexTest
     */
    public TreeIndexTest()
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
        tree1 = new TreeIndex();
        tree2 = new TreeIndex();
        tree3 = new TreeIndex();
        tree4 = new TreeIndex();
        tree2.add("nice", 111);
        tree3.add("nice", 111);
        tree3.add("Good", 222);
        tree4.add("nice", 111);
        tree4.add("good", 222);
        tree4.add("welcome", 333);
        tree4.add("home", 444);
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
        tree1.add("nice", 1234);
        tree4.add("alpha", 431);
        tree3.add("wiiiw", 56);
        tree2.add("good", 98);
        tree2.add("nice", 908);
        testPrint();
    }

    @Test
    public void testPrint()
    {
        tree1.print("unittestoutput/tree1.txt");
        tree2.print("unittestoutput/tree2.txt");
        tree3.print("unittestoutput/tree3.txt");
        tree4.print("unittestoutput/tree4.txt");
    }
}
