import java.util.Comparator;

public class SortItemsGreedy implements Comparator<Item> {
	@Override
	public int compare(Item a, Item b) {
		if ( a.value > b.value ) return -1;        
		else if ( a.value == b.value ) return 0;        
		else return 1;    
	}
}
