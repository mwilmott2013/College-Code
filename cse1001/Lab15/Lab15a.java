class Lab15a {
	public static void main(String args[]) {
		int x = 0;
		int y = Integer.parseInt(args[0]);
		while (x != y)
		{
			x = x + 1;
			System.out.println("Loop iteration " + x);
		}
	}
}