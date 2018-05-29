import java.util.Scanner;
class Lab11a {
	public static void main(String args[]) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the students grade: ");
		int x = kb.nextInt();
		if (x >= 90) {
			System.out.println("Student's grade for " + x + " is A");
			}
		else {
			if (x >= 85) {
				System.out.println("Student's grade for " + x + " is B");
			}
			else {
				if (x >= 75) {
					System.out.println("Student's grade for " + x + " is C");
				}
				else {
					if (x >= 50) {
						System.out.println("Student's grade for " + x + " is D");
					}
					else {
						System.out.println("Student's grade for " + x + " is F");
					}
				}
			}
		}
	}
}
//This was a very simple lab today.