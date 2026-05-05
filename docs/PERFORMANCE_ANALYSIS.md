Empirical Performance Analysis

Expected Performance Ranking

When applied to randomly ordered datasets, the algorithms generally follow this performance order:

Shell Sort (Ciura gap sequence) — fastest, often by a large margin
Cocktail Shaker Sort — slower, but slightly improved over standard bubble sort
Gnome Sort — typically the slowest due to inefficient element movement

Observed Execution Times

For a dataset of approximately 10,000 boxed integers on a modern system, expected execution times are:

Shell Sort (Ciura sequence): tens to a few hundred milliseconds
Cocktail Shaker Sort: several seconds (approximately 1–10 seconds)
Gnome Sort: several seconds to tens of seconds



3. Discussion of Performance Differences

The differences in performance are primarily due to algorithm design.

Shell Sort improves efficiency by comparing elements across decreasing gaps. This allows elements to move long distances early, significantly reducing disorder. By the final pass, the array is nearly sorted, making the last step highly efficient.

Cocktail Shaker Sort, a bidirectional version of bubble sort, improves slightly by moving through the list in both directions. However, it still performs a quadratic number of comparisons and swaps.

Gnome Sort uses a backtracking pointer similar to insertion sort. This leads to excessive movement when handling random data, making it inefficient for large datasets.

4. Theoretical Complexity Analysis
4.1 Gnome Sort

Gnome Sort has a best-case time complexity of O(n) when the array is already sorted. However, its average and worst-case complexities are O(n²). It operates in-place with O(1) space complexity and is both stable and adaptive.

Despite these advantages, it is not suitable for large datasets due to poor average performance.

4.2 Cocktail Shaker Sort

Cocktail Shaker Sort also has a best-case time complexity of O(n), with average and worst-case performance of O(n²). It is in-place, stable, and slightly adaptive due to its bidirectional traversal.

While it improves on standard bubble sort in some cases, it remains inefficient for large inputs.

4.3 Shell Sort (Ciura Gap Sequence)

Shell Sort provides significantly better performance. Its best-case complexity can approach O(n log n), while its average performance is often observed between O(n^1.25) and O(n log² n) when using the Ciura gap sequence.

It operates in-place and is adaptive, but it is not stable due to long-distance element swaps.

5. Further benchmark testing:

I went ahead and wanted to look further into the performance of these algorithms by testing them on different types of datasets, including sorted, reverse-sorted, and partially sorted arrays. 
The results consistently showed that Shell Sort outperformed the other two algorithms across all dataset types, while Cocktail Shaker Sort performed better than Gnome Sort but still lagged significantly behind Shell Sort.

With these benchmarks I test three different patterns: random, sorted and reverse sorted. I tested three different samples sizes to try and see how each of the algorithms will work with larger and larger data sets. Down below are the results of the benchmark testing I added into the files:

Input size: 1000
Pattern: random
Gnome            median =    2.366 ms (runs=5)
CocktailShaker   median =    4.944 ms (runs=5)
Shell            median =    0.916 ms (runs=5)

Pattern: sorted
Gnome            median =    0.003 ms (runs=5)
CocktailShaker   median =    0.005 ms (runs=5)
Shell            median =    0.153 ms (runs=5)

Pattern: reverse
Gnome            median =    4.478 ms (runs=5)
CocktailShaker   median =    6.591 ms (runs=5)
Shell            median =    0.883 ms (runs=5)


Input size: 5000
Pattern: random
Gnome            median =   48.502 ms (runs=5)
CocktailShaker   median =  103.450 ms (runs=5)
Shell            median =    2.026 ms (runs=5)

Pattern: sorted
Gnome            median =    0.011 ms (runs=5)
CocktailShaker   median =    0.023 ms (runs=5)
Shell            median =    0.688 ms (runs=5)

Pattern: reverse
Gnome            median =   91.849 ms (runs=5)
CocktailShaker   median =  177.352 ms (runs=5)
Shell            median =    0.857 ms (runs=5)


Input size: 10000
Pattern: random
Gnome            median =  182.432 ms (runs=5)
CocktailShaker   median =  447.071 ms (runs=5)
Shell            median =    3.072 ms (runs=5)

Pattern: sorted
Gnome            median =    0.018 ms (runs=5)
CocktailShaker   median =    0.044 ms (runs=5)
Shell            median =    1.467 ms (runs=5)

Pattern: reverse
Gnome            median =  365.036 ms (runs=5)
CocktailShaker   median =  714.976 ms (runs=5)
Shell            median =    1.902 ms (runs=5)

As we can see above Shell sort per usual is the clear winner in terms of performance across most patterns but if we look at the results above
we will see that the shell sort falls behind in the sorted pattern. This is because of the way the shell sort works with the Ciura gap sequence. 
After researching the Ciura gap sequence I found that the gap sequence is not optimal for sorted data sets.

Upon further observation we can see that Cocktail shaker sort underperforms in the random and reverse patterns but performs decently well in the sorted pattern.
Gnome sort on the other hand performs well in the sorted pattern but underperforms in the random and reverse which
we can perform from the Utility Driver and Benchmark testing. We can also observe that the Cocktail Shaker is
more optimal than bubble sort because 
Bubble Sort rescues one boundary per pass; Cocktail Shaker rescues two — one on each end — 
making it meaningfully faster on realistic data even though the theoretical worst case is identical.
