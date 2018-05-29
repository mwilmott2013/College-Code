import java.util.Scanner;
public class Lab27b {
	public static int Loops (int n) {
		int x, fact = 1;
		for (x = n; x > 1; x--){
			fact *= x;
		}
		return fact;
	}
	public static int fact (int n) {
		if (n == 1) {
			return 1;
		}
		else {
			return n*fact (n-1);
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
			System.out.println("Factorial of " + n + " using loops is: " + t);
		}
		if (a == 2) {
			t = fact(n);
			System.out.println("Factorial of " + n + " using recursion is: " + t);
		}
	}
}