
public class BackpackProblems {

	public static void main(String[] args) {
	    Item[] items = {new Item("Item1", 4, 12), 
                new Item("Item2", 2, 1), 
				new Item("Item3", 2, 2), 
				new Item("Item4", 1, 1),
                new Item("Item5", 10, 4)
               };
	    
	    int capacity = 16;
	    
		DynamicProgramming.launchDynamicProg(items, capacity);
		System.out.println("************************************************************************************************");
		Approximation.launchApproximation(items, capacity);
		System.out.println("************************************************************************************************");
		Greedy.launchGreed(items, capacity);
	}

}
