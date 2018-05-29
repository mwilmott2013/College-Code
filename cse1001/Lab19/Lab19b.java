import java.util.Scanner;
public class Lab19b {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner (System.in);
		int sum, length, average, arraylength;
		sum = 0;
		arraylength = Integer.parseInt(args[0]);
		int[] thearray = new int[arraylength];
		for (int i = 0; i <= thearray.length-1; i++) {
			System.out.println("Enter " + i + " array element:");
			thearray[i] = keyboard.nextInt();
		}
		for (int j = 0; j <= thearray.length-1; j++) {
			sum = sum + thearray[j];
		}
		length = thearray.length;
		average = sum / length;
		System.out.println("Average of array elements: " + average);
	}
}