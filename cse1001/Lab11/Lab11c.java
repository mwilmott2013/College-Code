import java.util.Scanner;
class Lab11c {
	public static void main(String args[]) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String theinput = new String(kb.nextLine());
		String theoutput = theinput.toUpperCase();
		int finale = theinput.compareTo(theoutput);
		if (finale == 0) {
			System.out.println("The string is the same in Upper Case form.");
		}
		else {
			System.out.println("The string is not the same in Upper Case form.");
		}
	}
}