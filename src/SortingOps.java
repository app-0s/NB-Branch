
public class SortingOps {
	// Operation method
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	public static boolean less(int v, int w) {
		return (v < w ? true : false);
	}
	
	public static void exchange(Comparable[] a, int i, int j) {
		Comparable t = a[i]; 
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void exchange(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void show(Comparable[] a) {
		// Print the array, on a single line
		for(int i = 1; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) 
			if (less(a[i], a[i-1])) return false;
		return true;
	}
}
