class Lab12a {
	public static void main(String args[]) {
		String j = args[0];
		char a = j.charAt(0);
		char b = j.charAt(1);
		if ((a == 'j' || a == 'J') && (b == 'j' || b == 'J')) {
			System.out.println(j.substring(2));
		}
		else if (a == 'j' || a == 'J') {
			System.out.println(j.substring(0));
		}
		else if (b == 'j' || b == 'J') {
			System.out.println(a + j.substring(2));
		}
		else {
			System.out.println(j);
		}
	}
}