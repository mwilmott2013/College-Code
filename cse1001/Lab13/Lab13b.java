class Lab13b {
	public static void main(String args[]) {
		int x = Integer.parseInt(args[0]);
			switch (x) {
				case 1: 
					System.out.println("Red");
					break;
				case 2: 
					System.out.println("Blue");
					break;
				case 3: 
					System.out.println("Green");
					break;
				case 4: 
					System.out.println("Yellow");
					break;
				case 5: 
					System.out.println("White");
					break;
				default: 
					System.out.println("ERROR");
					break;
			}
		}
	}