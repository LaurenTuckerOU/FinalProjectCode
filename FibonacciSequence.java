package GroupProject;

import java.util.*;

public class FibonacciSequence {
	
	public static int recursiveFibonacci(int n) {

		if(n <= 1) {
			return n;
		}

		return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
	}

	public static long iterativeFibonacci(int n) {
		long result;

		long first = 0;
		long second = 1;
		
		if(n == 0 || n == 1) {
			return n;
		}

		for(int i = 2; i <= n; ++i) {
			result = first + second;
			first = second;
			second = result;
		}

		return second;
	}

	// gets a start and end time for the tests and subtracts them for total time
	public static void main(String[] args) {
		long startTime;
		long endTime;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Give an input value");
		int choice = input.nextInt();
		
		startTime = System.nanoTime();
		System.out.println("Fibonacci for " + choice + ": " + iterativeFibonacci(choice));
		endTime = System.nanoTime();
		long iterativeTime = endTime - startTime;
		
		// iterative results
		System.out.println("Time for iteration: " + iterativeTime + " nanosec");
		
		startTime = System.nanoTime();
		System.out.println("Fibonacci for " + choice + ": " + recursiveFibonacci(choice));
		endTime = System.nanoTime();
		long recursiveTime = endTime - startTime;
		
		// here are your results for recursion
		System.out.println("Time for recursion: " + recursiveTime + " nanosec");
		
	}

}
