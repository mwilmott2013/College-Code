import java.util.Scanner;
public class Lab24b {
	public static int numberA(String str) {
		int y = 0;
		for (int i = 0; i != str.length(); i++) {
			char x = str.charAt(i);
			if (x == 'a') {
				y++;
			}
		}
		return y;
	}
		
	public static void main(String[] args) {
		Scanner keyboard = new Scanner (System.in);
		System.out.println("Enter a string:");
		String str = keyboard.nextLine();
		int y = numberA(str);
		System.out.println("Number of a(s): " + y);
	}
}