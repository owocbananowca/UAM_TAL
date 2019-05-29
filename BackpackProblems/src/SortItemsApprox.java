import java.util.Comparator;

public class SortItemsApprox implements Comparator<Item> {
	@Override
	public int compare(Item a, Item b) {
		if ( a.ratio > b.ratio ) return -1;        
		else if ( a.ratio == b.ratio ) return 0;        
		else return 1;    
	}
}
