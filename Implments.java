package csProjectFinal;

public class Implments {

	
	/*
	 *
	 *
	 *make it where it would search from the left and from the right
	 *
	 */
	
	public static int biRecusive(int arr[], int target, int leftSide, int rightSide) {

		if (leftSide > rightSide) 
			return -1;
			
		int middle = leftSide + (rightSide - leftSide) /2;
			
		if (arr[middle] == target)
			return middle;
		
		else if(arr[middle] < target) 
			return biRecusive(arr, target, middle + 1, rightSide);		
		else 
			return biRecusive(arr, target, leftSide, middle - 1);
	
		
	}
	
	/*
	 *  
	 * 
	 */
	
	public static int biIteration(int arr[], int target) {
		int leftSide = 0;
		int rightSide = arr.length -1;
		
		while(leftSide <= rightSide) {
			int middle = leftSide + (rightSide - leftSide) /2;
			
			if (arr[middle] == target) 
				return middle;
			
			else if (arr[middle] < target)
				leftSide = middle + 1;
			
			else 
				rightSide = middle -1;
			
		}
		
		return -1;
		
	}
	
	/*
	 * to sort the array
	 * sorts the array so it doesent get confused Ex:
	 * if its [6. 1. 10. 4, 7] 
	 * the middle is 10 but without it being sorted it will think that 10 is smaller 7 so it will read left
	 * [6, 1]
	 * 
	 */
	
	public static int[] sortArray(int size) {
		int[] arr = new int[size];
		
		for (int i = 0; i < size; i++) {
			arr[i] = i;
		}
		return arr;
	}
	
	
	/*TODO
	 * 
	 * or make a loop to see how much time it takes to find each number 
	 * while adding +1 each time so I dont have to input the numbers everytime 
	 * have it were it ask what number do you wnat to end with
	 * than work with the numbers 
	 */
	
	public static void main(String[] args) {
		int size[] = {200, 300, 400, 500, 1000, 5000, 10000, 30000, 50000, 70000, 74500, 80000, 100000, 1000000};
		int tests = 10;
		
		for (int sizes : size) {
			
			int arr[] = sortArray(sizes);
			int target = arr[sizes - 1];
			
			long recTotal = 0;
			long itTotal = 0;
			
			// rec test
			
			for(int i = 0; i < tests; i++) {
				
				long start = System.nanoTime();
				biRecusive(arr, target, 0, arr.length-1);
				long end = System.nanoTime();
				recTotal += (end - start);
				
			}
			
			//it test
			
			for(int i = 0; i < tests; i++) {
				
				long start = System.nanoTime();
				biIteration(arr, target);
				long end = System.nanoTime();
				itTotal += (end - start);
				
			}
			
			//might need might not---
			long recAvg = recTotal / tests;
			long itAvg = itTotal / tests;
			
			System.out.println("Size is " + sizes);
			System.out.println("Recurive total time: " + recTotal);
			System.out.println("Iteration total time "+ itTotal);
			System.out.println("Recusive avg time " + recAvg);
			System.out.println("iteration avg time " + itAvg);
			
			
			
		}
		
		
	}
	
}
