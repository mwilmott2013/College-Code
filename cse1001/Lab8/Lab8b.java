import java.util.Scanner;
class Lab8b {
	public static void main(String args[]) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a String: ");
		String entry = new String(kb.next());
		System.out.println("String without first, last character: " + entry.substring(1, entry.length()-1));
		}
	}