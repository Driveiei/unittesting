import java.util.ArrayList;
import java.util.List;

/**
 * ListUtil count the number of distinct elements in a list.
 * 
 * @author Kornphon Noiprasert
 */
public class ListUtil {
	/**
     * Count the number of distinct elements in a list.
     * The list may be empty but not null.
     *
     * @param list a list of elements
     * @return the number of distinct elements in list
     */
	public static int countUnique(List<?> list) {
		if (list == null) throw new NullPointerException();
		int number = 0;
		List<Object> copyList = new ArrayList<>();
		copyList.addAll(list);
		while(copyList.size() != 0) {
			Object element = copyList.get(0);
			copyList.remove(0);
			if(copyList.indexOf(element) == -1) 
				number++;
		}
		return number;
	}
}
