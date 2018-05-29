public class Lab22a {
	public static void replicate(int rows) {
		for (int i = 1; i <= rows; i++) {
			System.out.println("**********");
		}
	}
	public static void main(String[] args) {
		int rows = Integer.parseInt(args[0]);
			replicate(rows);
	}
}