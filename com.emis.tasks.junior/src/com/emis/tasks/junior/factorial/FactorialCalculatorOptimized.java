package com.emis.tasks.junior.factoriel;

import java.util.HashMap;
import java.util.Map;

public class FactorialCalculatorOptimized {
	private static Map<Integer, Long> foundedFactorials = new HashMap<Integer, Long>();

	public static void main(String[] args) {

		long startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j <= 10; j++) {
				System.out.printf("%d! = %d\n", j, calculateFactorial(j));
			}
		}

		long stopTime = System.nanoTime();

		System.out.printf("The factorial optimized calculation took : %s nanoseconds.\n", (stopTime - startTime));
	}

	private static long calculateFactorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		else if(foundedFactorials.get(n) != null) {
				return foundedFactorials.get(n);
			} else {
			long factorial = n * calculateFactorial(n - 1);
			foundedFactorials.put(n, factorial);
			return factorial;
		}
	}

}
