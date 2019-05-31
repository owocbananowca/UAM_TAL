import java.util.Random;

public class Item { // implements Comparable<Item> {
	
	public String name;
	public int value;
	public int weight;
	public float ratio;
	
	public Item(String name, int val, int wei) {
		this.name = name;
		this.value = val;
		this.weight = wei;
		ratio = (float) val/wei;
	}
	
	public String str() {
		return name + " [value = " + value + ", weight = " + weight + "]";
	}

	public static Item[] randomList() {
		Item[] items = new Item[20];
		Random gen = new Random();
		int val;
		int wei;
		String name;
		
		for (int i = 0; i < 20; i++) {
			name = "Item" + i;
			val = gen.nextInt(21) + 1;
			wei = gen.nextInt(21) + 1;
			items[i] = new Item(name, val, wei);
		}
		
		return items;
	}
}
