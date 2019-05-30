import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Greedy {
	public Item[] items;
	public int capacity;
	
	public Greedy( Item[] its, int cap ) {
		this.capacity = cap;
		items = its;
		
		Arrays.sort(items, new SortItemsGreedy());
		for (Item i : items) {
			System.out.println("- " + i.str());
		}
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

	public static void launchGreed(Item[] items, int cap) {
	    Greedy knapsack = new Greedy(items, cap);
	    Backpack solution = knapsack.solve();
	    solution.display();
	}
}
