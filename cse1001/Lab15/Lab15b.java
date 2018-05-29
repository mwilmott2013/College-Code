import java.util.Scanner;
class Lab15b {
	public static void main(String args[]) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Are you Bob?(Y/N) ");
		String x = kb.next();
		while (!x.equals("Y"))
		{
			System.out.println("Are you Bob?(Y/N) ");
			x = kb.next();
			if (!x.equals("Y") && !x.equals("N")) {
				System.out.println("Incorrect answer!");
			}
		}
		if (x.equals("Y")) {
			System.out.println("Hello Bob.  Program Terminating.");
		}
	}
}