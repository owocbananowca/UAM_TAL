
public class BackpackProblems {

	public static void main(String[] args) {
	    /*Item[] items = {new Item("Item1", 4, 12), 
                new Item("Item2", 2, 1), 
				new Item("Item3", 2, 2), 
				new Item("Item4", 1, 1),
                new Item("Item5", 10, 4)
               };*/
		Item[] items = Item.randomList();
	    
	    int capacity = 100;
	    
	    long tStart;
	    long tEnd;
	    
	    tStart = System.nanoTime();
		DynamicProgramming.launchDynamicProg(items, capacity);
		tEnd = System.nanoTime();
		System.out.println("Time: " + (tEnd - tStart));
		System.out.println("************************************************************************************************");
		tStart = System.nanoTime();
		Approximation.launchApproximation(items, capacity);
		tEnd = System.nanoTime();
		System.out.println("Time: " + (tEnd - tStart));
		System.out.println("************************************************************************************************");
		tStart = System.nanoTime();
		Greedy.launchGreed(items, capacity);
		tEnd = System.nanoTime();
		System.out.println("Time: " + (tEnd - tStart));
	}

}
