import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Test methods in the ListUtil class.
 * 
 * @author Kornphon Noiprasert
 */
public class ListUtilTest {
	/** A small tolerance for floating point round-off (precision) error. */
	static final double TOL = 1.0E-6;

	/**
	 * Make any attributes into a list.
	 * 
	 * @param elements - many elements to be in list.
	 * @return a list with many elements in.
	 */
	private List<?> makeList(Object... elements) {
		return java.util.Arrays.asList(elements);
	}

	@Test
	public void testEmptyList() {
		List<?> list = new ArrayList<>();
		assertEquals(0, ListUtil.countUnique(list), TOL);
	}

	@Test
	public void testListSizeOne() {
		assertEquals(1, ListUtil.countUnique(makeList("one")), TOL);
	}

	@Test
	public void testListSizeOneManyOrders() {
		assertEquals(1, ListUtil.countUnique(makeList("one", "one", "one", "one", "one", "one")), TOL);
	}

	@Test
	public void testListOfTwoItemsManyOrders() {
		List<?> list = makeList(1, 2);
		assertEquals(2, ListUtil.countUnique(list), TOL);
		list = makeList(1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 1, 1, 1);
		assertEquals(2, ListUtil.countUnique(list), TOL);
	}

	@Test(expected = java.lang.NullPointerException.class)
	public void testNullList() {
		ListUtil.countUnique(makeList(null));
	}

	@Test
	public void testListOfMultipleSize() {
		List<?> list = makeList(1, 2, 3, 4, 5, 5, 5, 3, 2, 1, 1, 2, 6);
		assertEquals(6, ListUtil.countUnique(list), TOL);

	}

	@Test
	public void testListOfMultipleType() {
		List<?> list = makeList('1', "Hello", 222, 222, "Hello", "Hello", 222, 4);
		assertEquals(4, ListUtil.countUnique(list), TOL);
	}

	@Test
	public void testBinarySearchOneElement() {
		Integer[] testInt = new Integer[] { 1 };
		assertEquals(0, ListUtil.binarySearch(testInt, 1),TOL);
		assertEquals(-1, ListUtil.binarySearch(testInt, 5),TOL);
		String[] testString = new String[] { "Hello" };
		assertEquals(0, ListUtil.binarySearch(testString, "Hello"),TOL);
		assertEquals(-1, ListUtil.binarySearch(testString, "Hi"),TOL);
	}

	@Test
	public void testBinarySearchEvenSize() {
		Integer[] testInt = new Integer[] { 1, 2, 3, 4, 5, 6 };
		assertEquals(0, ListUtil.binarySearch(testInt, 1),TOL);
		assertEquals(1, ListUtil.binarySearch(testInt, 2),TOL);
		assertEquals(2, ListUtil.binarySearch(testInt, 3),TOL);
		assertEquals(3, ListUtil.binarySearch(testInt, 4),TOL);
		assertEquals(4, ListUtil.binarySearch(testInt, 5),TOL);
		assertEquals(5, ListUtil.binarySearch(testInt, 6),TOL);
		assertEquals(-1, ListUtil.binarySearch(testInt, 7),TOL);
		String[] testString = new String[] { "Ant", "Banana", "Coconut", "Octopus", "Peanut", "Zebra" };
		assertEquals(0, ListUtil.binarySearch(testString, "Ant"),TOL);
		assertEquals(1, ListUtil.binarySearch(testString, "Banana"),TOL);
		assertEquals(2, ListUtil.binarySearch(testString, "Coconut"),TOL);
		assertEquals(3, ListUtil.binarySearch(testString, "Octopus"),TOL);
		assertEquals(4, ListUtil.binarySearch(testString, "Peanut"),TOL);
		assertEquals(5, ListUtil.binarySearch(testString, "Zebra"),TOL);
		assertEquals(-1, ListUtil.binarySearch(testString, "zebra"),TOL);
	}

	@Test
	public void testBinarySearchOddSize() {
		Integer[] testInt = new Integer[] { 1, 2, 3, 4, 5 };
		assertEquals(0, ListUtil.binarySearch(testInt, 1),TOL);
		assertEquals(1, ListUtil.binarySearch(testInt, 2),TOL);
		assertEquals(2, ListUtil.binarySearch(testInt, 3),TOL);
		assertEquals(3, ListUtil.binarySearch(testInt, 4),TOL);
		assertEquals(4, ListUtil.binarySearch(testInt, 5),TOL);
		assertEquals(-1, ListUtil.binarySearch(testInt, 7),TOL);
		String[] testString = new String[] { "Ant", "Banana", "Coconut", "Octopus", "Zebra" };
		assertEquals(0, ListUtil.binarySearch(testString, "Ant"),TOL);
		assertEquals(1, ListUtil.binarySearch(testString, "Banana"),TOL);
		assertEquals(2, ListUtil.binarySearch(testString, "Coconut"),TOL);
		assertEquals(3, ListUtil.binarySearch(testString, "Octopus"),TOL);
		assertEquals(4, ListUtil.binarySearch(testString, "Zebra"),TOL);
		assertEquals(-1, ListUtil.binarySearch(testString, "zebra"),TOL);
	}

	@Test
	public void testBinarySearchDuplicate() {
		Integer[] testInt = new Integer[] { 1, 3, 3, 4, 4, 4, 5 };
		assertEquals(1, ListUtil.binarySearch(testInt, 3),TOL);
		assertEquals(3, ListUtil.binarySearch(testInt, 4),TOL);
		Integer[] testIntTwo = new Integer[] { 1, 2, 2, 2, 2, 5, 5, 5};
		assertEquals(5, ListUtil.binarySearch(testIntTwo, 5),TOL);
		assertEquals(3, ListUtil.binarySearch(testIntTwo, 2),TOL);
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testBinarySearchNullElement() {
		ListUtil.binarySearch(new Integer[] {0}, null);
	}
	
	@Test
	public void testBinarySearchEmptyArray() {
		Integer[] testEmpty = new Integer[]{  };
		assertEquals(-1, ListUtil.binarySearch(testEmpty, 5),TOL);
	}
	
}