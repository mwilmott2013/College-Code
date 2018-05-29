import java.util.Scanner;
class Lab13a {
	public static void main(String args[]) {
		Scanner kb = new Scanner(System.in);
		String username1 = args[0];
		String password1 = args[1];
		String squestion = args[2];
		String sanswer1 = args[3];
		System.out.println("Enter username: ");
		String username2 = kb.next();
		if (username2.equals(username1)) {
			System.out.println("Username recognized.  Enter password: ");
			String password2 = kb.next();
			if (password2.equals(password1)) {
				System.out.println("Password accepted.  Answer the following security question: ");
				System.out.println(squestion);
				String sanswer2 = kb.next();
				if (sanswer2.equals(sanswer1)) {
					System.out.println("Correct Answer.  Authentication Succesful.");
				}
				else {
					System.out.println("Incorrect Answer.  Authentication Failed.");
				}
			}
			else {
				System.out.println("Password denied.  Authentication Failed.");
			}
		}
		else {
			System.out.println("Username not recognized.  Authentication Failed.");
		}
	}
}