import java.util.Scanner;
class Lab5b {
	public static void main(String args[]) {
		double g1 = Double.parseDouble(args[0]);
		double g2 = Double.parseDouble(args[1]);
		double g3 = Double.parseDouble(args[2]);
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter weight of first grade: ");
		double w1 = kb.nextDouble();
		System.out.println("Enter weight of second grade: ");
		double w2 = kb.nextDouble();
		System.out.println("Enter weight of third grade: ");
		double w3 = kb.nextDouble();
		double avg = (w1 * g1 + w2 * g2 + w3 *g3) / (w1 + w2 + w3);
		System.out.println("The average of the grades is: " + avg);
	}
}