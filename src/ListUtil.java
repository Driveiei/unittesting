import java.util.ArrayList;
import java.util.List;

/**
 * ListUtil count the number of distinct elements in a list and use a binary
 * search to find index in.
 * 
 * @author Kornphon Noiprasert
 */
public class ListUtil {
	/**
	 * Count the number of distinct elements in a list. The list may be empty but
	 * not null.
	 *
	 * @param list a list of elements
	 * @return the number of distinct elements in list
	 * @throws if the value in list is null.
	 */
	public static int countUnique(List<?> list) {
		if (list == null)
			throw new NullPointerException();
		int number = 0;
		List<Object> copyList = new ArrayList<>();
		copyList.addAll(list);
		while (copyList.size() != 0) {
			Object element = copyList.get(0);
			copyList.remove(0);
			if (copyList.indexOf(element) == -1)
				number++;
		}
		return number;
	}

	/**
	 * Searches for an element in an array, where the array contents
	 * are already sorted.
	 * 
	 * @param array - contents are already sorted.
	 * @param element - the value to be searched for.
	 * @return index of the matching element or -1 if the search element is not in
	 *         the array.
	 * @throws if the value to find (element) is null.
	 */
	public static <T extends Comparable<? super T>> int binarySearch(T[] array, T element) {
		if (element == null)
			throw new IllegalArgumentException("Search element cannot be null.");
		if (array.length == 0)
			return -1;
		int lowerBound = 0;
		int upperBound = array.length - 1;
		int medium;
		do {
			medium = (lowerBound + upperBound) / 2;
			int numberStatus = element.compareTo(array[medium]);
			if (numberStatus == 0)
				return medium;
			if (numberStatus >= 1)
				lowerBound = medium + 1;
			else
				upperBound = medium - 1;
		} while (lowerBound <= upperBound);
		return -1;
	}
}
