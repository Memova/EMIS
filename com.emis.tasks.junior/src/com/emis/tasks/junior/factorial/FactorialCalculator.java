package com.emis.tasks.junior.factoriel;

public class FactorialCalculator {

	public static void main(String[] args) {

		long startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j <= 10; j++) {
				System.out.printf("%d! = %d\n", j, calculateFactorial(j));
			}
		}
		long stopTime = System.nanoTime();

		System.out.printf("The factorial calculation took : %s nanoseconds.\n", (stopTime - startTime));
	}

	private static long calculateFactorial(int n) {
		long factorial = 1;

		if (n > 1) {
			for (int i = 2; i <= n; i++) {
				factorial = factorial * i;
			}
		}
		return factorial;
	}
}