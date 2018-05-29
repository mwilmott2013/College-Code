import java.util.Scanner;
public class Lab27a {
	public static int Loops (int n) {
		int a = 0;
		int b = 1;
		int c = 0;
		int j = 0;
		if (n == 1) {
			j = 0;
		}
		if (n == 2) {
			j = 1;
		}
		else {
			for (int i = 2; i < n; i++) {
				c = a + b;
				a = b;
				b = c;
			}
		j = c;
		}
	return j;
	}
	public static int fib (int n) {
		if (n == 1) {
			return 0;
		}
		else if (n == 2) {
			return 1;
		}
		else {
			return fib (n-1) + fib (n-2);
		}
	}
	public static void main (String []args) {
		Scanner keyboard = new Scanner (System.in);
		int t = 0;
		System.out.println("Enter your choice [ 1(loops) or 2 (recursion)] ");
		int a = keyboard.nextInt();
		System.out.println("Enter a number: ");
		int n = keyboard.nextInt();
		if (a == 1) {
			t = Loops(n);
			System.out.println("Fibonacci number at " + n + " is: " + t);
		}
		if (a == 2) {
			t = fib(n);
			System.out.println("Fibonacci number at " + n + " is: " + t);
		}
	}
}