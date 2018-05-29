import java.util.Scanner;
public class Lab24a {
	public static String getName() {
		System.out.println("Enter name: ");
		Scanner keyboard = new Scanner (System.in);
		String name = keyboard.next();
		return name;
	}
	public static int getAge() {
		System.out.println("Enter age: ");
		Scanner keyboard = new Scanner (System.in);
		int age = keyboard.nextInt();
		return age;
	}
	public static int compareAge(int ageM, int ageF) {
		int x;
		if (ageM >= ageF) {
			x = 0;
		}
		else {
			x = 1;
		}
		return x;
	}
	public static void main(String[] args) {
		String[] names = new String[2];
		int[] ages = new int[2];
		for (int i = 0; i != 2; i++) {
			names[i] = getName();
			ages[i] = getAge();
		}
		int ageM = ages[0];
		int ageF = ages[1];
		int x = compareAge(ageM, ageF);
		int y;
		String bravo;
		if (x == 0) {
			y = ageM - ageF;
			if (y > 1) {
				bravo = "years.";
			}
			else {
				bravo = "year.";
			}
			System.out.println(names[0] + " is older than " + names[1] + " by " + y + " " + bravo);
		}
		else {
			y = ageF - ageM;
			if (y > 1) {
				bravo = "years.";
			}
			else {
				bravo = "year.";
			}
			System.out.println(names[1] + " is older than " + names[0] + " by " + y + "  " + bravo);
		}
	}
}