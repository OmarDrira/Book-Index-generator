

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListIndexTest tests the add and print methods of the ListIndex class
 *
 * @author Omar Drira
 * @version 05/10/20
 */
public class ListIndexTest
{
    private ListIndex list1;
    private ListIndex list2;
    private ListIndex list3;
    private ListIndex list4;

    /**
     * Default constructor for test class ListIndexTest
     */
    public ListIndexTest()
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
        list1 = new ListIndex();
        list2 = new ListIndex();
        list3 = new ListIndex();
        list4 = new ListIndex();
        list2.add("nice", 111);
        list3.add("nice", 111);
        list3.add("Good", 222);
        list4.add("nice", 111);
        list4.add("good", 222);
        list4.add("welcome", 333);
        list4.add("home", 444);
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
        assertEquals(-1, list1.binarySearch("nice"));
        assertEquals(2, list4.binarySearch("nice"));
        assertEquals(-1, list4.binarySearch("Good"));
        assertEquals(0, list4.binarySearch("good"));
        assertEquals(1, list4.binarySearch("home"));
        assertEquals(-1, list2.binarySearch("good"));
        assertEquals(0, list2.binarySearch("nice"));
        assertEquals(-2, list3.binarySearch("good"));
        list3.add("welcome", 123);
        assertEquals(2, list3.binarySearch("welcome"));
        list4.add("wow", 189);
        assertEquals(4, list4.binarySearch("wow"));
        list1.add("body", 98);
        assertEquals(0, list1.binarySearch("body"));
        list1.add("body", 876);
        assertEquals(0, list1.binarySearch("body"));
    }

    @Test
    public void testPrint()
    {
        list1.print("unittestoutput/list1.txt");
        list2.print("unittestoutput/list2.txt");
        list3.print("unittestoutput/list3.txt");
        list4.print("unittestoutput/list4.txt");
    }
}


