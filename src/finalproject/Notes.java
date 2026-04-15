/*
 * PLAN & NOTES 3/25
 * 
 * RECURSION VS ITERATION baseed on research findings:
 * 
 Recursion:
 	uses jvm call stack
 	each recursive call has overhead of multiple method invocations
 	too many recursive calls leads to StackOverflowError (note exactly what point this is!)
 	recursion sometimes easier to read/comprehend, eg for binary search
 	java DOES NOT do tail call optimization, 
 	therefore eventually results in StackOverflowError and uses more memory, and can only make limited # of calls
 	most used for tree problems, divided smaller tasks, etc.
 	
 Iteration
 	uses loops
 	does NOT grow call stack
 	usually faster bc no call overhead
 	better for very large input sizes
 * 
 * RECURSIVE FACTORIAL
 * 
 *  public static long factorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1; // base case
        }
        return n * factorialRecursive(n - 1); // recursive case
    }


 * 
 * ITERATIVE FACTORIAL
 * 
 * public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i; // multiply step by step
        }
        return result;
    }


 * RECURSIVE BINARY SEARCH
 * 
 * public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // not found
        }

        int mid = (left + right) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            return binarySearchRecursive(arr, target, left, mid - 1);
        } else {
            return binarySearchRecursive(arr, target, mid + 1, right);
        }
    }


 * 
 * ITERATIVE BINARY SEARCH
 * 
 *  public static int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1; // not found
    }


 * WHERE RECURSION CLIFF IS
 * plan
 * 1. start w small #, eg n=100, call factorialRecursive(n)
 * 2. if works, increase n by 100 or smaller/larger # (test first) in a loop using try cathc:
 * 
 * try
 * {
 * 	factorialRecursive(n);
   } catch (StackOverflowError e)   // indic. recursion broke @ this n
           {
           }

 * 3. when StackOVerflow occurs, test in smaller searches by 10s 0r 30s, etc. using binary/linear search
 * 4. stay within limit of calls (bc no tail recursion) and print output for tests:
 * 
  	System.out.println("Test n = " + n);
  
 * 5. note failing n as recursion cliff for factorial 
 * 
 * 
 * 
 * ITERATIVE & RECURSIVE FAST EXPONENTIATION (X^n)
 * also must handle neg exponents
 * if n even, x^n = (x^(n/2))^2
 * if n odd, x^n = x * x^(n-1)
 * reduces number of multiplications; faster
 * 
 * 
 * 
 */

package finalproject;

public class Notes {
	
	// Recursive Fast Exponentiation
	 public static long fastExRecursive(long x, long n) 
	 {

	        if (n == 0) 
	        {
	            return 1;
	        }
	        if (n == 1) 
	        {
	            return x;
	        }

	        // even exp
	        if (n % 2 == 0) {
	            long half = fastExRecursive(x, n / 2);
	            return half * half;
	        }

	        // odd exp
	        return x * fastExRecursive(x, n - 1);
	    }



	
	
// iterative fast exp	
	  public static long fastExIterative(long x, long n) 
	  {

	        long result = 1;
	        long base = x;
	        long exponent = n;

	        while (exponent > 0) {

	            if (exponent % 2 == 1) 
	            {
	                result *= base;
	            }

	            base = base * base;
	            exponent = exponent / 2;
	        }

	        return result;
	    }
	  
// Recursive Timing w System.nanoTime, output in nanoseconds
	  
	  public static long recursionNanoTime(long x, long n) 
	  {

	        long totalTime = 0;

	        for (int i = 0; i < 10; i++) 
	        {

	            long startTime;
	            long endTime;

	            startTime = System.nanoTime();

	            try {
	                fastExRecursive(x, n);
	            }
	            catch (StackOverflowError e) 
	            {
	                return -1;   // recursion cliff
	            }

	            endTime = System.nanoTime();
	            totalTime += (endTime - startTime);
	        }

	        return totalTime / 10;
	    }

// Iterative Timing w System.nanoTime
	  
	  public static long iterationNanoTime(long x, long n) {

	        long totalTime = 0;

	        for (int i = 0; i < 10; i++) {

	            long startTime = System.nanoTime();
	            fastExIterative(x, n);
	            long endTime = System.nanoTime();

	            totalTime += (endTime - startTime);
	        }

	        return totalTime / 10;
	    }

// MAIN testing
	  public static void main(String[] args)
	  {

	        long base = 2;  // x value for x^n

	        long[] numbers = {5000, 10000, 30000, 50000, 70000, 100000};

	        for (long n : numbers) 
	        {

	            long recursionTime = recursionNanoTime(base, n);
	            long iterationTime = iterationNanoTime(base, n);

	            System.out.println("Testing n = " + n);

	            if (recursionTime == -1) 
	            {
	                System.out.println("Recursion Cliff Reached!");
	            } else {
	                System.out.println("Recursive Time: " + recursionTime);
	            }

	            System.out.println("Iterative Time: " + iterationTime);
	            System.out.println();
	        }
	    }
	  
} // end notes class
