import java.util.*;
public class Lab18 {
	public static void main(String[] args) {
		int nameCount, quizScore, testScore, quizSum, testSum;
		double quizAvg, testAvg; 
		String name;
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter number of students (Maximum 30, Minimum 1):");
		nameCount = kb.nextInt();
		if (nameCount <= 0 || nameCount > 30) {
			System.out.println("Error: Not within specified parameters.");
		}
		else {
		}
		for (int i = 1; i <= nameCount; i++) {
			quizScore = 0;
			System.out.print("Enter name:");
			name = kb.next();
			System.out.print("Enter quiz scores (-1 terminates):");
			quizSum = 0;
			int m = 0;
			while (quizScore != -1) {
			
				quizSum = quizSum + quizScore;
				m++;
				quizScore = kb.nextInt();
			}
			quizAvg = quizSum/(double)m;
			System.out.print("Enter test scores (-1 terminates):");
			testScore = 0;
			testSum = 0;
			int k = 0;
			testScore = kb.nextInt();
			while (testScore != -1) {
				
				testSum = testSum + testScore;
				k++;
				testScore = kb.nextInt();
			}
			testAvg = testSum/(double)k;
			System.out.println("Quiz Average:" + quizAvg);
			System.out.println("Test Average:" + testAvg);
			System.out.println();
		}
	}
}

