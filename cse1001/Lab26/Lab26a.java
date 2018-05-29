import java.util.Scanner;
public class Lab26a {
	public static void main (String[] args) {
		Scanner kb = new Scanner (System.in);
		System.out.println("How long will the array be? ");
		int x = kb.nextInt();
		int[] a = new int[x];
		for (int i = 0; i <= a.length-1; i++) {
			System.out.println("Enter " + i + " array element:");
			a[i] = kb.nextInt();
			}
		System.out.println("Please define the search term for this array of strings: ");
		int y = kb.nextInt();
		seqSearch(a, y);
		}
	public static int seqSearch(int [] a, int y) {
		int z = 0;
		for (int j = 0; j <= a.length-1; j++) {
			if (a[j] == y) {
				System.out.println("Value appears in position " + j);
				z = j;
			}
		}
		return z;
	}
}