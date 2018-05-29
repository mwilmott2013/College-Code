public class Sort {

	private int K_CONST; // constant which decides whether insertion sort is
	// used or radix sort


	public Sort(){
		
	}
	
	public void radixSort(int[] a, int digit){
		this.radixSort(a, digit, 0, a.length);
	}

	public void radixSort(int[] a, int digit, int from, int to) {
		if (to-from <= K_CONST) {
			// perform insertion sort 
			insertionSort(a, from, to); 
			return;
		}
		// otherwise perform radix sort on the digit ’digit’ 
		// on indices starting from ’from’ all the way to ’to’-1
		int r = 0;
		int[] bucket = new int[a.length()];
		int bucketIndex = 0;
		for (int k = from; k < to; k++) {
			if (a[k] > r) {
				r = a[k];
			}
		}
		while (r / digit > 0) {
			
		}
	}
	public static void insertionSort(int[] a, int from, int to){ 
		// perform insertion sort on the array a[from] - a[to]
		int x = 0;
		int j = i;
		for (int i = from; i < to; i++) {
			x = a[i];
			while (j > from && a[j-i] > x) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = x;
		}
	}
	public static void insertionSort(int[] a){
		insertionSort(a, 0, a.length);
}

}