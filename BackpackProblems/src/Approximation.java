import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Approximation {
	public Item[] items;
	public int capacity;
	
	public Approximation( Item[] its, int cap ) {
		this.capacity = cap;
		items = its;
		
		Arrays.sort(items, new SortItemsApprox());
	}
	
	public Backpack solve() {
		List<Item> its = new ArrayList<>();
		int weight = 0;
		
		for (Item i : items) {
			if ( weight + i.weight < capacity) {
				weight += i.weight;
				its.add(i);
			}
		}
		
		return new Backpack(its, capacity);  
	}

	public static void launchApproximation() {
		//Input items
	    Item[] items = {new Item("Item1", 4, 12), 
		                new Item("Item2", 2, 1), 
						new Item("Item3", 2, 2), 
						new Item("Item4", 1, 1),
	                    new Item("Item5", 10, 4)
	                   };

	    Approximation knapsack = new Approximation(items, 15);
	    Backpack solution = knapsack.solve();
	    solution.display();
	}
}

