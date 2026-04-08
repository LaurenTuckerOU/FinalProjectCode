
public class Factorial {

	public static int recursionFactorial(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		else {
			return n * recursionFactorial(n - 1);
		}
	}
	
	
	
	
	public static int iterationFactorial(int num) {
	int result = 1;
	
	for(int i = 2; i <= num; i++) {
		result *= i;
	}
	return result;	
	}
	
	
	// Recursion System.nanoTime
	public static long recursionNanoTime(int a) {
		
		long recursionTime = 0;
		for(int i = 0; i <= 10; i++) {
		
		long startTime; 
		long endTime;
		
		startTime = System.nanoTime();
		
		try {
			recursionFactorial(a);
		}
		
		catch (StackOverflowError e){
			return -1;
			
		}
	
		endTime = System.nanoTime();
		recursionTime += endTime - startTime;
		
		}
		return recursionTime / 10;
		
		
	}
	
	// Iteration System.nanoTime
	public static long iterationNanoTime(int a) {

		long iterationTime = 0;
		for(int i = 0; i <= 10; i++) {
		
		long startTime; 
		long endTime;
		
		startTime = System.nanoTime();
		iterationFactorial(a); 
		endTime = System.nanoTime();
		iterationTime += endTime - startTime; 
		
		
			}
		
		return iterationTime / 10;
		
		}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		int[] numbers = {5000, 10000, 30000, 50000, 70000, 100000};
		
		for(int a : numbers) {
		
		long recursionTime = recursionNanoTime(a);
		long iterationTime = iterationNanoTime(a);
		
		if( recursionTime == -1) {
			System.out.println("Recursion Cliff");
		}
		else {
			System.out.println("Time results for Recursion: " + recursionTime );
		}
		
		System.out.println("Time results for Iteration: " + iterationTime + '\n');

		}
		
	}

}
