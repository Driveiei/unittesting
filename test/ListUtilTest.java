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
	 * */
	private List<?> makeList(Object ... elements){
		return java.util.Arrays.asList(elements);
	}
	
	@Test
	public void testEmptyList() {
		List<?> list = new ArrayList<>();
		assertEquals(0, ListUtil.countUnique(list),TOL);
	}
	
	@Test
	public void testListSizeOne() {
		assertEquals(1, ListUtil.countUnique(makeList("one")),TOL);
	}
	
	@Test
	public void testListSizeOneManyOrders() {
		assertEquals(1, ListUtil.countUnique(makeList("one","one","one","one","one","one")),TOL);
	}
	
	@Test
	public void testListOfTwoItemsManyOrders() {
		List<?> list = makeList(1,2);
		assertEquals(2, ListUtil.countUnique(list),TOL);
		list = makeList(1,2,1,2,1,2,1,2,1,2,2,2,2,2,1,1,1);
		assertEquals(2,ListUtil.countUnique(list),TOL);
	}
	
	@Test(expected=java.lang.NullPointerException.class)
	public void testNullList() {
		ListUtil.countUnique(makeList(null));
	}
	
	@Test
	public void testListOfMultipleSize() {
		List<?> list = makeList(1,2,3,4,5,5,5,3,2,1,1,2,6);
		assertEquals(6,ListUtil.countUnique(list),TOL);
		
	}
	
	@Test
	public void testListOfMultipleType() {
		List<?> list = makeList('1',"Hello",222,222,"Hello","Hello",222,4);
		assertEquals(4,ListUtil.countUnique(list),TOL);
	}

}