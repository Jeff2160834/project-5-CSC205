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


         /*public static <T extends Comparable<T>> void shellSort(T[] a) {

        // TODO implement Shell Sort here
         }*/


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
        cocktailShakerSort(intArray);
        System.out.print("After  (Integer): ");
        printArray(intArray);
        System.out.println();

        // --- String array ---
        String[] strArray = {"mango", "apple", "cherry", "banana", "date"};
        System.out.print("Before (String):  ");
        printArray(strArray);
        cocktailShakerSort(strArray);
        System.out.print("After  (String):  ");
        printArray(strArray);
        System.out.println();

        // --- Double array ---
        Double[] dblArray = {9.9, 1.1, 5.5, 3.3, 7.7, 2.2};
        System.out.print("Before (Double):  ");
        printArray(dblArray);
        cocktailShakerSort(dblArray);
        System.out.print("After  (Double):  ");
        printArray(dblArray);
        System.out.println();

        // --- Already sorted (best-case termination test) ---
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        System.out.print("Before (Sorted):  ");
        printArray(sortedArray);
        cocktailShakerSort(sortedArray);
        System.out.print("After  (Sorted):  ");
        printArray(sortedArray);
        System.out.println();

        // --- Reverse sorted (worst-case) ---
        Integer[] reversedArray = {9, 7, 5, 3, 1};
        System.out.print("Before (Reverse): ");
        printArray(reversedArray);
        cocktailShakerSort(reversedArray);
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

