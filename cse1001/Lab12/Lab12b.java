import java.util.Scanner;
class Lab12b {
	public static void main(String args[]) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the value for x (must be either 1 or 2): ");
		int x = kb.nextInt();
		System.out.println("Enter the value for a (must be 1, 2, 3, 4, or 5): ");
		int a = kb.nextInt();
		switch (x) {
			case 1: if (a == 1) {
					System.out.println("YES");
					}
					else if (a == 2) {
					System.out.println("NO");
					}
					else if (a == 3) {
					System.out.println("NO");
					}
					else if (a == 4) {
					System.out.println("YES");
					}
					else if (a == 5) {
					System.out.println("YES");
					}
					else {
					System.out.println("ERROR");
					}
					break;
			case 2: if (a == 1) {
					System.out.println("NO");
					}
					else if (a == 2) {
					System.out.println("YES");
					}
					else if (a == 3) {
					System.out.println("NO");
					}
					else if (a == 4) {
					System.out.println("NO");
					}
					else if (a == 5) {
					System.out.println("YES");
					}
					else {
					System.out.println("ERROR");
					}
					break;
			default : System.out.println("ERROR");
			}
		}
	}