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
			if ( weight + i.weight <= capacity) {
				weight += i.weight;
				its.add(i);
			}
		}
		
		return new Backpack(its, capacity);  
	}

	public static void launchApproximation(Item[] items, int cap) {
	    Approximation knapsack = new Approximation(items, cap);
	    Backpack solution = knapsack.solve();
	    solution.display();
	}
}

