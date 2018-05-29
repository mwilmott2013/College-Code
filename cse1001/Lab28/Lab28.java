public class Lab28 {
	public static void sort (String[] alpha) {
			int minPos;
			String temp;
			for (int i = 0; i <= alpha.length-2; i++) {
				minPos = i;
				for (int j = i+1; j <= alpha.length-1; j++) {
					if (alpha[j].hashCode() < alpha[minPos].hashCode()){
						minPos = j;
					}
				}
				temp = alpha[i];
				alpha[i] = alpha[minPos];
				alpha[minPos] = temp;
			}
		System.out.println("Sorted list:");
		for (int q = 0; q <= alpha.length-1; q++) {
			System.out.print(alpha[q] + " ");
		}
	}
	public static void main (String[] args) {
		String[] alpha = new String[10];
		for (int i = 0; i <= alpha.length-1; i++) {
			alpha[i] = args[i];
		}
		System.out.println("Presorted list:");
		for (int z = 0; z <= alpha.length-1; z++) {
			System.out.print(alpha[z] + " ");
		}
		System.out.println();
		sort (alpha);
	}
}