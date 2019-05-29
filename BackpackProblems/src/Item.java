
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

	//@Override
    //public int compareTo(Item i) {
    //    return ratio.compareTo(i.ratio);
    //}
}
