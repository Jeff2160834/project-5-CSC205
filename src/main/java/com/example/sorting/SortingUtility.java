package com.example.sorting;

public class SortingUtility {


    public static <T extends Comparable<T>> void gnomeSort(T[] a) {
        // Initialize position to the start of the array
        int pos = 0;

        // Continue until we reach the end of the array
        while (pos < a.length) {
            // If at the beginning or current element is >= previous element, move forward
            if (pos == 0 || a[pos].compareTo(a[pos - 1]) >= 0) {
                pos = pos + 1;
            } else {
                // Otherwise, swap current and previous elements, then move backward
                swap(a, pos, pos - 1);
                pos = pos - 1;
            }
        }
    }


         public static <T extends Comparable<T>> void cocktailShakerSort(T[] a) {
             // Initialize swapped flag to control the do-while loop
             boolean swapped;
             
             // Perform bidirectional passes until no swaps occur
             do {
                 swapped = false;
                 
                 // Forward pass: iterate from left to right (0 to length-2)
                 for (int i = 0; i < a.length - 1; i++) {
                     // If current element is greater than next, swap them
                     if (a[i].compareTo(a[i + 1]) > 0) {
                         swap(a, i, i + 1);
                         swapped = true;
                     }
                 }
                 
                 // If no swaps occurred in forward pass, array is sorted
                 if (!swapped) {
                     break;
                 }
                 
                 // Reset swapped flag for backward pass
                 swapped = false;
                 
                 // Backward pass: iterate from right to left (length-2 down to 0)
                 for (int i = a.length - 2; i >= 0; i--) {
                     // If current element is greater than next, swap them
                     if (a[i].compareTo(a[i + 1]) > 0) {
                         swap(a, i, i + 1);
                         swapped = true;
                     }
                 }
             } while (swapped);
         }


    public static <T extends Comparable<T>> void shellSort(T[] a) {
        // Initialize the Ciura gap sequence for optimal performance
        // Time Complexity: average depends on gap sequence; shifting still dominates moves.
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};

        // Get the array length
        int n = a.length;

        // Start with the largest gap and work down to a gap of 1
        // We optimize the inner work by using binary search to find the insertion
        // point within each gapped subsequence (reduces comparisons) and using
        // System.arraycopy for the final gap==1 pass to move contiguous blocks.
        for (int gap : gaps) {
            // Skip gaps larger than the array length for efficiency
            if (gap >= n) {
                continue;
            }

            // For each element in the array starting at index 'gap', insert it into
            // the already gap-sorted subsequence to its left. We keep variable names
            // from the pseudocode: gaps, n, gap, i, j, temp.
            for (int i = gap; i < n; i += 1) {
                // save a[i] in temp and make a hole at position i
                T temp = a[i];

                // If gap == 1 we can treat the subsequence as contiguous which allows
                // a faster block move using System.arraycopy after finding the insert position.
                if (gap == 1) {
                    // perform binary search over a[0..i-1] to find insertion index
                    int insertPos = binarySearchInsert(a, 0, i - 1, temp);
                    // shift the block [insertPos..i-1] one to the right
                    if (insertPos < i) {
                        System.arraycopy(a, insertPos, a, insertPos + 1, i - insertPos);
                        a[insertPos] = temp;
                    }
                    // otherwise already in place
                } else {
                    // For gap > 1 we operate on the gapped subsequence with the same offset
                    int offset = i % gap; // starting index for this subsequence
                    int highIndex = i - gap; // last element in subsequence before i

                    // Find insertion position (index) within the gapped subsequence using binary search
                    int insertPos = findGappedInsertIndex(a, offset, highIndex, gap, temp);

                    // Shift elements up by gap until we reach insertPos
                    int j = i;
                    while (j > insertPos) {
                        a[j] = a[j - gap];
                        j -= gap;
                    }
                    a[insertPos] = temp;
                }
            }
        }
    }

    /**
     * Binary search for insertion position in a contiguous range a[lo..hi].
     * Returns the index where key should be inserted (between lo..hi+1).
     */
    private static <T extends Comparable<T>> int binarySearchInsert(T[] a, int lo, int hi, T key) {
        int left = lo;
        int right = hi;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (a[mid].compareTo(key) <= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left; // insertion index
    }

    /**
     * Find insertion index within a gapped subsequence defined by offset and gap.
     * The subsequence elements are at indices: offset, offset+gap, offset+2*gap, ..., highIndex.
     * Returns the absolute array index where key should be placed.
     */
    private static <T extends Comparable<T>> int findGappedInsertIndex(T[] a, int offset, int highIndex, int gap, T key) {
        if (highIndex < offset) {
            // no elements in subsequence before i -> place at offset
            return offset;
        }

        int lo = 0;
        int hi = (highIndex - offset) / gap; // number of elements - 1
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int midPos = offset + mid * gap;
            if (a[midPos].compareTo(key) <= 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return offset + lo * gap;
    }


     private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }

    public static void main(String[] args) {

        // --- Integer array ---
        Integer[] intArray = {5, 1, 4, 2, 8, 0, 2};
        System.out.print("Before (Integer): ");
        printArray(intArray);
        shellSort(intArray);
        System.out.print("After  (Integer): ");
        printArray(intArray);
        System.out.println();

        // --- String array ---
        String[] strArray = {"mango", "apple", "cherry", "banana", "date"};
        System.out.print("Before (String):  ");
        printArray(strArray);
        shellSort(strArray);
        System.out.print("After  (String):  ");
        printArray(strArray);
        System.out.println();

        // --- Double array ---
        Double[] dblArray = {9.9, 1.1, 5.5, 3.3, 7.7, 2.2};
        System.out.print("Before (Double):  ");
        printArray(dblArray);
        shellSort(dblArray);
        System.out.print("After  (Double):  ");
        printArray(dblArray);
        System.out.println();

        // --- Already sorted (best-case termination test) ---
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        System.out.print("Before (Sorted):  ");
        printArray(sortedArray);
        shellSort(sortedArray);
        System.out.print("After  (Sorted):  ");
        printArray(sortedArray);
        System.out.println();

        // --- Reverse sorted (worst-case) ---
        Integer[] reversedArray = {9, 7, 5, 3, 1};
        System.out.print("Before (Reverse): ");
        printArray(reversedArray);
        shellSort(reversedArray);
        System.out.print("After  (Reverse): ");
        printArray(reversedArray);
    }

    private static <T> void printArray(T[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }



}

