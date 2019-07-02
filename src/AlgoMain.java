

public class AlgoMain {

	public static void main(String[] args) {
		int[] arr = {1, 5, 7, 0, 4, 15, 9, 3, 19, 20, 14, 12, 10, 13, 11};
		// TODO Auto-generated method stub
		//SortingAlgs.shellSort(arr);
		//System.out.print(RomanNumConvert.romanToInt("XIX"));
		//String[] sgs = {"flower","flow","flight"};
		//String[] sgs = {"catd","racecar","car"};
		//System.out.print(LongestCommonPrefx.longestCommonPrefix(sgs));
		//printSortedArray(arr);
		
		System.out.print(ValidParenthesis.isValid("()"));
		//System.out.print(PermutationMethods.isPerm("abbab", "bdbaa"));
	}
	
	public static void printSortedArray(int[] array) {
		array = SortingAlgs.insertionSort(array);
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
