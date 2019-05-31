
public class TrotterJohnson {
	
	public static void main(String[] args) {
		int[] input = { 3, 4, 2, 1 };
		
		//Czy zwracaj¹ odp wyniki? - Tak
		//int[] output = unrank(rank(input,4),4);
		//for (int i : output) System.out.print(i + " ");
		
		//Wszystkie
		/*
		for (int i = 0; i < 24; i++) {
			System.out.print("\n" + i + ": " );
			for(int j : unrank(i,4)) {
				System.out.print(j + " ");
			}
		}
		*/
		//Previous
		/*
		int[] idx1 = {1,2,4,3}; //idx0 -> prev element should be {1,2,3,4}
		for (int i : prev(idx1,4)) {
			System.out.print(i + " ");
		}
		*/
		//Next
		/*
		int[] idx0 = {1,2,3,4};
		for	(int i : next(idx0, 4)) {
			System.out.print(i + " ");
		}
		*/
	}
	
	//L - ci¹g
	//n - d³ugoœæ ci¹gu
	public static int rank(int[] L, int n) {
		int r = 0;
		int k = 0;
		int i = 0;
		
		for (int j = 2; j <= n; j++) {
			k = 1;
			i = 0;
			while (L[i] != j) {
				if (L[i] < j) {
					k++;
				}
				i++;
				if ( i == n ) { 
					//k = 1; 
					//i = 1; 
					break; 
				}
			}
			if (r%2 == 0) {
				r = j * r + j - k;
			} else {
				r = j * r + k - 1;
			}
			//System.out.println("j: " + j + " i: " + i + " k: " + k + " r: " + r);
		}
		
		return r;
	}
	
	public static int[] unrank(int r, int n) {
		int[] L = new int[n];
		
		int r2 = 0;
		int r1 = 0;
		int k = 0;
		
		L[0] = 1;
		
		for (int j = 2 ; j <= n; j++) {
			r1 = (int) Math.floor( (r * factorial(j)) / factorial(n) );
			k = r1 - j * r2;
			if (r2%2 == 0) {
				for (int i = j-1; i >= j-k; i-- ) {
					L[i+1-1] = L[i-1];
				}
				L[j-k-1] = j;
			} else {
				for (int i = j-1; i >= k+1; i--) {
					L[i+1-1] = L[i-1];
				}
				L[k+1-1] = j;
			}
			r2 = r1;
		}
		
		return L;
	}
	
	private static int factorial(int n) {
		int value = 1;
		for (int i = 1; i <= n; i++) {
			value = value * i;
		}
		return value;
	}
	
	private static int[] prev(int[] L, int n) {
		int[] out = unrank(rank(L,n)-1,n);
		
		return out;
	}
	
	
	private static int[] next(int[] L, int n) {
		return unrank(rank(L,n)+1,n);
	}
}
