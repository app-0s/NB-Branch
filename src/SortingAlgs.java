
public class SortingAlgs {
	// From Sedgewick, Algorithms
	// Shellsort is an extension of insertion sort that exchanges array entries that are 
	// far apart, to produce partially sorted arrays that can be effeciently sorted
	public static void shellSort(Comparable[] a) {
		// Sort a[] into increasing order
		int n = a.length;
		int h = 1;
		
		while (h < n/3)
			h = 3*h + 1;
			
		while (h >= 1) {
			// h-sort the array
			for (int i = h; i < n; i++) {
				// Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]...
				for (int j = i; j >= h && SortingOps.less(a[j], a[j-h]); j -= h)
					SortingOps.exchange(a, j, j-h);
			}
			h = h/3;
		}
	}
	
	// From Sedgewick, Algorithms; modified to take int array argument
	public static int[] insertionSort(int[] a) {
		for(int i = 0; i < a.length; i++) {
			// Insert smallest element into a[i-1], a[i-2],...
			for(int j = i; j > 0 && SortingOps.less(a[j], a[j-1]); j--) {
				SortingOps.exchange(a, j, j-1);
			}
		}
		return a;
	}
	
	// From Sedgewick, Algorithms
	// In-place Merge: Copies into auxiliary array, and then back into original array. 
	public static int[] merge(int[] a, int lo, int mid, int hi) {
		int i = lo;			// Index
		int j = mid + 1;	// Index
		
		int[] aux = new int[a.length];
		
		for (int k = lo; k <= hi; k++)	// Copy a[lo...hi] to aux[lo...hi]
			aux[k] = a[k];
		
		for(int k = lo; k <= hi; k++) {		// Merge back to a[lo...hi]
			if	(i > mid)					// Left hand is exhausted
				a[k] = aux[j++];	// Take from right hand
			else if (j > hi)				// Right hand exhausted
				a[k] = aux[i++];	// Take from left hand
			else if (SortingOps.less(aux[j], aux[i]))		// Element at index on right is less than element at indx on left
			a[k] = aux[j++];		// Take from right
			else
				a[k] = aux[i++];
		}
			
		return a;
	}
	
	
	// Top-down Mergesort: Uses divide-and-conquer paradigm to sort the subarray. Array is divided into 2 parts a[lo..mid] and a[mid+1..hi],
	// Sorted independently, then merged
	public static void tdMergeSort(int[] a) {
		tdMergeSort(a, 0, a.length - 1);
	}
	
	private static void tdMergeSort(int[] a, int lo, int hi) {
		// Sort a[lo..hi]
		if (hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		tdMergeSort(a, lo, mid);			// Sort left half
		tdMergeSort(a, mid+1, hi);			// Sort right half
		merge(a, lo, mid, hi);				// Merge Results
	}
	
	
}
