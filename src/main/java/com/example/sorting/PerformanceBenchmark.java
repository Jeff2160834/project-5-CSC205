package com.example.sorting;

import java.util.*;

public class PerformanceBenchmark {

	// Simple benchmarking harness to compare Gnome, Cocktail Shaker, and Shell sorts
	// across different input patterns (random, sorted, reverse) and sizes.
	public static void main(String[] args) {

		int[] sizes = new int[]{1000, 5000, 10000}; // sizes to test
		int warmupRuns = 2; // JVM warm-up runs (ignored)
		int measuredRuns = 5; // measured runs per configuration

		String[] patterns = new String[]{"random", "sorted", "reverse"};

		System.out.println("Performance benchmark: Gnome vs Cocktail Shaker vs Shell\n");

		for (int size : sizes) {
			System.out.println("Input size: " + size);
			for (String pattern : patterns) {
				System.out.println("  Pattern: " + pattern);

				// generate base input once per (size, pattern)
				Integer[] base = generateInput(size, pattern);

				// algorithms to test
				Map<String, List<Long>> allTimes = new LinkedHashMap<>();
				allTimes.put("Gnome", new ArrayList<>());
				allTimes.put("CocktailShaker", new ArrayList<>());
				allTimes.put("Shell", new ArrayList<>());

				// Warm up: run each algorithm a couple times to let the JIT compile
				for (int w = 0; w < warmupRuns; w++) {
					SortingUtility.gnomeSort(Arrays.copyOf(base, base.length));
					SortingUtility.cocktailShakerSort(Arrays.copyOf(base, base.length));
					SortingUtility.shellSort(Arrays.copyOf(base, base.length));
				}

				// Measured runs
				for (int r = 0; r < measuredRuns; r++) {
					// Gnome
					Integer[] inputG = Arrays.copyOf(base, base.length);
					long t0 = System.nanoTime();
					SortingUtility.gnomeSort(inputG);
					long t1 = System.nanoTime();
					allTimes.get("Gnome").add(t1 - t0);

					// Cocktail Shaker
					Integer[] inputC = Arrays.copyOf(base, base.length);
					t0 = System.nanoTime();
					SortingUtility.cocktailShakerSort(inputC);
					t1 = System.nanoTime();
					allTimes.get("CocktailShaker").add(t1 - t0);

					// Shell
					Integer[] inputS = Arrays.copyOf(base, base.length);
					t0 = System.nanoTime();
					SortingUtility.shellSort(inputS);
					t1 = System.nanoTime();
					allTimes.get("Shell").add(t1 - t0);
				}

				// Print summary: median times in milliseconds
				for (Map.Entry<String, List<Long>> e : allTimes.entrySet()) {
					List<Long> times = e.getValue();
					Collections.sort(times);
					long median = times.get(times.size() / 2);
					System.out.printf("    %-16s median = %8.3f ms (runs=%d)\n",
							e.getKey(), median / 1_000_000.0, times.size());
				}

				System.out.println();
			}
			System.out.println();
		}
		System.out.println("Benchmark complete.");
	}

	private static Integer[] generateInput(int size, String pattern) {
		Integer[] a = new Integer[size];
		Random rnd = new Random(12345); // fixed seed for reproducibility
		switch (pattern) {
			case "random":
				for (int i = 0; i < size; i++) a[i] = rnd.nextInt(size * 10);
				break;
			case "sorted":
				for (int i = 0; i < size; i++) a[i] = i;
				break;
			case "reverse":
				for (int i = 0; i < size; i++) a[i] = size - i;
				break;
			default:
				for (int i = 0; i < size; i++) a[i] = rnd.nextInt(size * 10);
		}
		return a;
	}

}

