/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		// test adding null to the list
		try {
			shortList.add(null);
			fail("Invalid input null");
		}
		catch (NullPointerException e){
			
		}
		// test adding other elements to the list
		// add C to the end of the list
		assertEquals("AddEnd: check the return type", true, shortList.add("C"));
		assertEquals("Check the last element of the list", "C", shortList.get(2));
		assertEquals("Check the size of the list", 3,shortList.size());
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		// test if the element being added is null
		try {
			shortList.add(null);
			fail("Invaid input : null");
			
		}
		catch (NullPointerException e) {
		
		}
		// test on corner cases on shortList
		// test out of bound error for the tail side
		try {
			longerList.add(11, 100);
			fail("Out of bounds");
			
			
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
		// on the long list
		// test of the out of bound error for the head side
		try {
			longerList.add(-1, 0);
			fail("Out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// check other cases
		shortList.add(1, "C");
		assertEquals("check value ", "C", shortList.get(1));
		assertEquals("check size ", 3, shortList.size());	
		longerList.add(2, 10);
		assertEquals("check value  ", (Integer)10, longerList.get(2));
		assertEquals("check size", 11, longerList.size());
		
		
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		// check adding null element
	    try {
	    	longerList.add(0, null);
	    	fail("Should not add null element");
	    	
	    }
	    catch(NullPointerException e) {
	    	
	    }
	    // check index out of bound
	    try {
	    	longerList.add(11, 100);
	    	fail("Index out of bound");
	    	
	    }
	    catch(IndexOutOfBoundsException e) {
	    
	    }
	    assertEquals("check return is correct ", (Integer)100, longerList.set(2, 100));
		assertEquals("check value is correct ", (Integer)100, longerList.get(2));
		assertEquals("check size is correct", 10, longerList.size());
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
