import java.util.Scanner;
class Lab14a {
	public static void main(String args[]) {
		Scanner kb = new Scanner(System.in);
		int x = 1;
		System.out.println("Enter score:");
		int y = kb.nextInt();
		int z = y;
		while (y != -1)
		{
			System.out.println("Enter score:");
			y = kb.nextInt();
			if (y >= 0) {
				z = z + y;
				x = x + 1;
			}
			else {
				System.out.println("ERROR: Grade must be positive.");
			}
		}
		System.out.println("Number of grades: " + x);
		System.out.println("Class average: ");
		System.out.print(z / x);
	}
}