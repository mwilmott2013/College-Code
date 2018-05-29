import java.util.Scanner;
public class Lab19c {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner (System.in);
		int largest, arraylength;
		arraylength = Integer.parseInt(args[0]);
		int[] thearray = new int[arraylength];
		for (int i = 0; i <= thearray.length-1; i++) {
			System.out.println("Enter " + i + " array element:");
			thearray[i] = keyboard.nextInt();
		}
		largest = thearray[0];
		for (int j = 1; j <= thearray.length-1; j++) {
			if (thearray[j] > largest) {
				largest = thearray[j];
			}
		}
		System.out.println("Largest array element: " + largest);
	}
}