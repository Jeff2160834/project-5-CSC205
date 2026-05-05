package com.example.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SortingUtilityTest {

	// ------------------------- Gnome Sort Tests ------------------------- //

	@Test
	@DisplayName("GnomeSort - empty array returns empty array (Integer & String)")
	public void testGnomeSort_emptyArray_returnsEmptyArray() {
		// Integer empty array
		Integer[] intInput = new Integer[]{};
		Integer[] intExpected = new Integer[]{};
		SortingUtility.gnomeSort(intInput);
		assertArrayEquals(intExpected, intInput, "Integer empty array should remain empty after gnomeSort");

		// String empty array
		String[] strInput = new String[]{};
		String[] strExpected = new String[]{};
		SortingUtility.gnomeSort(strInput);
		assertArrayEquals(strExpected, strInput, "String empty array should remain empty after gnomeSort");
	}

	@Test
	@DisplayName("GnomeSort - single element returns same array (Integer & String)")
	public void testGnomeSort_singleElement_returnsSameArray() {
		// Integer single element
		Integer[] intInput = new Integer[]{5};
		Integer[] intExpected = new Integer[]{5};
		SortingUtility.gnomeSort(intInput);
		assertArrayEquals(intExpected, intInput);

		// String single element
		String[] strInput = new String[]{"apple"};
		String[] strExpected = new String[]{"apple"};
		SortingUtility.gnomeSort(strInput);
		assertArrayEquals(strExpected, strInput);
	}

	@Test
	@DisplayName("GnomeSort - two elements sorted keeps order")
	public void testGnomeSort_twoElementsSorted_keepsOrder() {
		Integer[] intInput = new Integer[]{1, 2};
		Integer[] intExpected = new Integer[]{1, 2};
		SortingUtility.gnomeSort(intInput);
		assertArrayEquals(intExpected, intInput);

		String[] strInput = new String[]{"apple", "banana"};
		String[] strExpected = new String[]{"apple", "banana"};
		SortingUtility.gnomeSort(strInput);
		assertArrayEquals(strExpected, strInput);
	}

	@Test
	@DisplayName("GnomeSort - two elements unsorted sorts array")
	public void testGnomeSort_twoElementsUnsorted_sortsArray() {
		Integer[] intInput = new Integer[]{2, 1};
		Integer[] intExpected = new Integer[]{2, 1};
		Arrays.sort(intExpected);
		SortingUtility.gnomeSort(intInput);
		assertArrayEquals(intExpected, intInput);

		String[] strInput = new String[]{"banana", "apple"};
		String[] strExpected = new String[]{"banana", "apple"};
		Arrays.sort(strExpected);
		SortingUtility.gnomeSort(strInput);
		assertArrayEquals(strExpected, strInput);
	}

	@Test
	@DisplayName("GnomeSort - already sorted array remains sorted")
	public void testGnomeSort_alreadySorted_keepsOrder() {
		Integer[] input = new Integer[]{1, 2, 3, 4, 5};
		Integer[] expected = Arrays.copyOf(input, input.length);
		SortingUtility.gnomeSort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	@DisplayName("GnomeSort - reverse sorted array becomes sorted")
	public void testGnomeSort_reverseSorted_sortsArray() {
		Integer[] input = new Integer[]{5, 4, 3, 2, 1};
		Integer[] expected = Arrays.copyOf(input, input.length);
		Arrays.sort(expected);
		SortingUtility.gnomeSort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	@DisplayName("GnomeSort - array with all duplicates remains unchanged ordering")
	public void testGnomeSort_allDuplicates_keepsOrder() {
		Integer[] input = new Integer[]{7, 7, 7, 7};
		Integer[] expected = Arrays.copyOf(input, input.length);
		SortingUtility.gnomeSort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	@DisplayName("GnomeSort - array with some duplicates sorts correctly")
	public void testGnomeSort_someDuplicates_sortsArray() {
		Integer[] input = new Integer[]{3, 1, 4, 1, 5, 9, 2};
		Integer[] expected = Arrays.copyOf(input, input.length);
		Arrays.sort(expected);
		SortingUtility.gnomeSort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	@DisplayName("GnomeSort - random unsorted array sorts correctly")
	public void testGnomeSort_randomUnsorted_sortsArray() {
		Integer[] input = new Integer[]{64, 34, 25, 12, 22, 11, 90};
		Integer[] expected = Arrays.copyOf(input, input.length);
		Arrays.sort(expected);
		SortingUtility.gnomeSort(input);
		assertArrayEquals(expected, input);
	}

	// ---------------------- Cocktail Shaker Sort Tests ------------------- //

	@Test
	@DisplayName("CocktailShakerSort - empty array returns empty array (Integer & String)")
	public void testCocktailShakerSort_emptyArray_returnsEmptyArray() {
		Integer[] intInput = new Integer[]{};
		Integer[] intExpected = new Integer[]{};
		SortingUtility.cocktailShakerSort(intInput);
		assertArrayEquals(intExpected, intInput);

		String[] strInput = new String[]{};
		String[] strExpected = new String[]{};
		SortingUtility.cocktailShakerSort(strInput);
		assertArrayEquals(strExpected, strInput);
	}

	@Test
	@DisplayName("CocktailShakerSort - single element returns same array")
	public void testCocktailShakerSort_singleElement_returnsSameArray() {
		Integer[] intInput = new Integer[]{5};
		Integer[] intExpected = new Integer[]{5};
		SortingUtility.cocktailShakerSort(intInput);
		assertArrayEquals(intExpected, intInput);

		String[] strInput = new String[]{"apple"};
		String[] strExpected = new String[]{"apple"};
		SortingUtility.cocktailShakerSort(strInput);
		assertArrayEquals(strExpected, strInput);
	}

	@Test
	@DisplayName("CocktailShakerSort - two elements sorted keeps order")
	public void testCocktailShakerSort_twoElementsSorted_keepsOrder() {
		Integer[] intInput = new Integer[]{1, 2};
		Integer[] intExpected = new Integer[]{1, 2};
		SortingUtility.cocktailShakerSort(intInput);
		assertArrayEquals(intExpected, intInput);
	}

	@Test
	@DisplayName("CocktailShakerSort - two elements unsorted sorts array")
	public void testCocktailShakerSort_twoElementsUnsorted_sortsArray() {
		Integer[] intInput = new Integer[]{2, 1};
		Integer[] intExpected = new Integer[]{2, 1};
		Arrays.sort(intExpected);
		SortingUtility.cocktailShakerSort(intInput);
		assertArrayEquals(intExpected, intInput);
	}

	@Test
	@DisplayName("CocktailShakerSort - already sorted array remains sorted")
	public void testCocktailShakerSort_alreadySorted_keepsOrder() {
		Integer[] input = new Integer[]{1, 2, 3, 4, 5};
		Integer[] expected = Arrays.copyOf(input, input.length);
		SortingUtility.cocktailShakerSort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	@DisplayName("CocktailShakerSort - reverse sorted array becomes sorted")
	public void testCocktailShakerSort_reverseSorted_sortsArray() {
		Integer[] input = new Integer[]{9, 7, 5, 3, 1};
		Integer[] expected = Arrays.copyOf(input, input.length);
		Arrays.sort(expected);
		SortingUtility.cocktailShakerSort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	@DisplayName("CocktailShakerSort - array with all duplicates remains unchanged ordering")
	public void testCocktailShakerSort_allDuplicates_keepsOrder() {
		Integer[] input = new Integer[]{7, 7, 7, 7};
		Integer[] expected = Arrays.copyOf(input, input.length);
		SortingUtility.cocktailShakerSort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	@DisplayName("CocktailShakerSort - array with some duplicates sorts correctly")
	public void testCocktailShakerSort_someDuplicates_sortsArray() {
		Integer[] input = new Integer[]{3, 1, 4, 1, 5, 9, 2};
		Integer[] expected = Arrays.copyOf(input, input.length);
		Arrays.sort(expected);
		SortingUtility.cocktailShakerSort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	@DisplayName("CocktailShakerSort - random unsorted array sorts correctly")
	public void testCocktailShakerSort_randomUnsorted_sortsArray() {
		Integer[] input = new Integer[]{64, 34, 25, 12, 22, 11, 90};
		Integer[] expected = Arrays.copyOf(input, input.length);
		Arrays.sort(expected);
		SortingUtility.cocktailShakerSort(input);
		assertArrayEquals(expected, input);
	}

	// ------------------------- Shell Sort Tests ------------------------- //

	@Test
	@DisplayName("ShellSort - empty array returns empty array (Integer & String)")
	public void testShellSort_emptyArray_returnsEmptyArray() {
		Integer[] intInput = new Integer[]{};
		Integer[] intExpected = new Integer[]{};
		SortingUtility.shellSort(intInput);
		assertArrayEquals(intExpected, intInput);

		String[] strInput = new String[]{};
		String[] strExpected = new String[]{};
		SortingUtility.shellSort(strInput);
		assertArrayEquals(strExpected, strInput);
	}

	@Test
	@DisplayName("ShellSort - single element returns same array")
	public void testShellSort_singleElement_returnsSameArray() {
		Integer[] intInput = new Integer[]{5};
		Integer[] intExpected = new Integer[]{5};
		SortingUtility.shellSort(intInput);
		assertArrayEquals(intExpected, intInput);
	}

	@Test
	@DisplayName("ShellSort - two elements sorted keeps order")
	public void testShellSort_twoElementsSorted_keepsOrder() {
		Integer[] intInput = new Integer[]{1, 2};
		Integer[] intExpected = new Integer[]{1, 2};
		SortingUtility.shellSort(intInput);
		assertArrayEquals(intExpected, intInput);
	}

	@Test
	@DisplayName("ShellSort - two elements unsorted sorts array")
	public void testShellSort_twoElementsUnsorted_sortsArray() {
		Integer[] intInput = new Integer[]{2, 1};
		Integer[] intExpected = new Integer[]{2, 1};
		Arrays.sort(intExpected);
		SortingUtility.shellSort(intInput);
		assertArrayEquals(intExpected, intInput);
	}

	@Test
	@DisplayName("ShellSort - already sorted array remains sorted")
	public void testShellSort_alreadySorted_keepsOrder() {
		Integer[] input = new Integer[]{1, 2, 3, 4, 5};
		Integer[] expected = Arrays.copyOf(input, input.length);
		SortingUtility.shellSort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	@DisplayName("ShellSort - reverse sorted array becomes sorted")
	public void testShellSort_reverseSorted_sortsArray() {
		Integer[] input = new Integer[]{9, 7, 5, 3, 1};
		Integer[] expected = Arrays.copyOf(input, input.length);
		Arrays.sort(expected);
		SortingUtility.shellSort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	@DisplayName("ShellSort - array with all duplicates remains unchanged ordering")
	public void testShellSort_allDuplicates_keepsOrder() {
		Integer[] input = new Integer[]{7, 7, 7, 7};
		Integer[] expected = Arrays.copyOf(input, input.length);
		SortingUtility.shellSort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	@DisplayName("ShellSort - array with some duplicates sorts correctly")
	public void testShellSort_someDuplicates_sortsArray() {
		Integer[] input = new Integer[]{3, 1, 4, 1, 5, 9, 2};
		Integer[] expected = Arrays.copyOf(input, input.length);
		Arrays.sort(expected);
		SortingUtility.shellSort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	@DisplayName("ShellSort - random unsorted array sorts correctly")
	public void testShellSort_randomUnsorted_sortsArray() {
		Integer[] input = new Integer[]{64, 34, 25, 12, 22, 11, 90};
		Integer[] expected = Arrays.copyOf(input, input.length);
		Arrays.sort(expected);
		SortingUtility.shellSort(input);
		assertArrayEquals(expected, input);
	}

	// ------------------------- Additional Edge Case Tests ------------------------- //

	@Test
	@DisplayName("All sorts - null input throws NullPointerException")
	public void testAllSorts_nullInput_throwsNullPointer() {
		// Expect NPE when null array is passed (current implementations do not handle null)
		assertThrows(NullPointerException.class, () -> SortingUtility.gnomeSort(null));
		assertThrows(NullPointerException.class, () -> SortingUtility.cocktailShakerSort(null));
		assertThrows(NullPointerException.class, () -> SortingUtility.shellSort(null));
	}

	@Test
	@DisplayName("All sorts - array containing null elements throws NullPointerException")
	public void testAllSorts_arrayWithNullElements_throwsNullPointer() {
		Integer[] withNull = new Integer[]{1, null, 2};
		assertThrows(NullPointerException.class, () -> SortingUtility.gnomeSort(withNull));
		assertThrows(NullPointerException.class, () -> SortingUtility.cocktailShakerSort(withNull));
		assertThrows(NullPointerException.class, () -> SortingUtility.shellSort(withNull));
	}

	@Test
	@DisplayName("Custom Comparable objects sort correctly (ShellSort)")
	public void testShellSort_customComparable_sortsCorrectly() {
		// Local Comparable implementation
		class MyComp implements Comparable<MyComp> {
			final int v;
			MyComp(int v) { this.v = v; }
			@Override
			public int compareTo(MyComp o) { return Integer.compare(this.v, o.v); }
			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (!(o instanceof MyComp)) return false;
				return v == ((MyComp) o).v;
			}
			@Override
			public int hashCode() { return Integer.hashCode(v); }
			@Override
			public String toString() { return Integer.toString(v); }
		}

		MyComp[] input = new MyComp[]{new MyComp(3), new MyComp(1), new MyComp(2), new MyComp(1)};
		MyComp[] expected = Arrays.copyOf(input, input.length);
		Arrays.sort(expected);
		SortingUtility.shellSort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	@DisplayName("GnomeSort - negative numbers and zeros sort correctly")
	public void testGnomeSort_negativeNumbers_sortsCorrectly() {
		Integer[] input = new Integer[]{0, -1, 5, -3, 2};
		Integer[] expected = Arrays.copyOf(input, input.length);
		Arrays.sort(expected);
		SortingUtility.gnomeSort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	@DisplayName("CocktailShakerSort - alternating high/low sequence sorts correctly")
	public void testCocktailShakerSort_alternatingHighLow_sortsCorrectly() {
		Integer[] input = new Integer[]{5, 1, 4, 2, 3};
		Integer[] expected = Arrays.copyOf(input, input.length);
		Arrays.sort(expected);
		SortingUtility.cocktailShakerSort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	@DisplayName("ShellSort - many duplicates sorts correctly")
	public void testShellSort_manyDuplicates_sortsCorrectly() {
		Integer[] input = new Integer[]{1,1,1,1,2,1,1};
		Integer[] expected = Arrays.copyOf(input, input.length);
		Arrays.sort(expected);
		SortingUtility.shellSort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	@DisplayName("All sorts - case-sensitive string ordering (String arrays)")
	public void testAllSorts_stringCaseSensitivity_sortsConsistently() {
		String[] input = new String[]{"Zebra", "apple", "Mango", "banana"};
		String[] expected = Arrays.copyOf(input, input.length);
		Arrays.sort(expected);

		String[] a1 = Arrays.copyOf(input, input.length);
		SortingUtility.gnomeSort(a1);
		assertArrayEquals(expected, a1);

		String[] a2 = Arrays.copyOf(input, input.length);
		SortingUtility.cocktailShakerSort(a2);
		assertArrayEquals(expected, a2);

		String[] a3 = Arrays.copyOf(input, input.length);
		SortingUtility.shellSort(a3);
		assertArrayEquals(expected, a3);
	}

}
