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

}
