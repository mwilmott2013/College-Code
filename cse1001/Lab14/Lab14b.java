import java.util.Scanner;
class Lab14b {
	public static void main(String args[]) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = kb.nextInt();
		int y = 0;
		for (int x = 1; x != n+1; x++) {
			y = y + x;
		}
		System.out.println("Sum: " + y);
	}
}