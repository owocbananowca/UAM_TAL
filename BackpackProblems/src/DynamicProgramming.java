import java.util.ArrayList;
import java.util.List;

public class DynamicProgramming {
	  private Item[] items;
	  private int capacity;

	  public DynamicProgramming(Item[] items, int capacity) {
	    this.items = items;
	    this.capacity = capacity;
	  }

	  public void display() {
	    if (items != null  &&  items.length > 0) {
	      System.out.println("Knapsack problem");
	      System.out.println("Capacity : " + capacity);
	      System.out.println("Items :");

	      for (Item item : items) {
	        System.out.println("- " + item.str());
	      }
	    }
	  }


	  public Backpack solve() {
	    int noOfItems = items.length;
	    //temp - max value nth item
	    int[][] temp = new int[noOfItems + 1][capacity + 1];

	    //init
	    for (int i = 0; i <= capacity; i++)
	      temp[0][i] = 0;

	    // we iterate on items
	    for (int i = 1; i <= noOfItems; i++) {
	      // we iterate on each capacity
	      for (int j = 0; j <= capacity; j++) {
	        if (items[i - 1].weight > j)
	          temp[i][j] = temp[i-1][j];
	        else
	          // we maximize value at this rank in the temp
	          temp[i][j] = Math.max(temp[i-1][j], temp[i-1][j - items[i-1].weight] + items[i-1].value);
	      }
	    }

	    int res = temp[noOfItems][capacity];
	    int w = capacity;
	    List<Item> itemsSolution = new ArrayList<>();

	    for (int i = noOfItems; i > 0  &&  res > 0; i--) {
	      if (res != temp[i-1][w]) {
	        itemsSolution.add(items[i-1]);
	        // we remove items value and weight
	        res -= items[i-1].value;
	        w -= items[i-1].weight;
	      }
	    }

	    return new Backpack(itemsSolution, temp[noOfItems][capacity]);
	  }

	  public static void launchDynamicProg(Item[] items, int cap) {
	    DynamicProgramming knapsack = new DynamicProgramming(items, cap);
	    knapsack.display();
	    Backpack solution = knapsack.solve();
	    solution.display();
	  }
	}