import java.util.List;

public class Backpack {
	public List<Item> items;
	public int capacity;
	public int value;
	public int weight;
	
	public Backpack(List<Item> its, int cap) {
		capacity = cap;
		items = its;
		for (Item i : items) {
			value += i.value;
			weight += i.weight;
		}
	}
	
	public void display() {
		float valwei = (float) value / weight;
		if (items != null && !items.isEmpty()) {
			System.out.println("\nBackpack content");
			System.out.println("Value = " + value);
			System.out.println("Weight = " + weight);
			System.out.println("Value/Weigth = " + valwei);
			
		    for (Item item : items) {
		    	System.out.println("- " + item.str());
			}
		}
	}
}
