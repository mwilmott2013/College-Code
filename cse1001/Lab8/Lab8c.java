import java.util.Scanner;
class Lab8c {
	public static void main(String args[]) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = new String(kb.nextLine());
		String frst = name.substring(0, name.indexOf(" "));
		String lst = name.substring(name.indexOf(" ")+1, name.length());
		System.out.println(lst.toUpperCase() + ", " + frst.toLowerCase() + " is a student at Florida Tech.");
	}
}