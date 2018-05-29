import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Buggy {
	// Run through our tests
	public static void main(String args[]) {
		breakpointDemo();
		
		ohnulls();
		sillymath();
		sillystrings();
	}
	
	
	public static void breakpointDemo() {
		// set a breakpoint here...
		int x = 5;
		int y = 42;
		System.out.println("Put a breakpoint on this line");
		System.out.println("Step over");
		System.out.println("Step over");
		x++;
		System.out.println("Step over");
		stepInto();
		System.out.println("Step over");
		System.out.println("Step over");
		x += 700;
		y++;
		System.out.println("Step over");
		System.out.println("Step over");
		
		
		System.out.println("Add a watch for i");
		for (int i=0;i<1000;i++) {
			System.out.println("boring calculations");
			System.out.println("Set a conditional breakpoint to examine when i==225");
			if(i%50==26) {
				System.out.println("i=" + i);
				// While debugging change the i%50==25 to i%50=26 and press save
			}
			System.out.println("Set breakpoint here, press continue");
		}
		
		System.out.println("Can right click->run to line here to skip the boring loop");
		System.out.println("Step over");
		System.out.println("Step over");
		System.out.println("Step over");
		System.out.println("Step over");
		System.out.println("Try drop to frame(restarts method invocation)");
		return;
	}
	
	public static void stepInto() {
		System.out.println("In the function");
		System.out.println("...");
		System.out.println("...");
		System.out.println("...");
		System.out.println("...");
		System.out.println("...");
		System.out.println("...");
		return; //can step out/step return to skip this boring stuff
	}
	

	// Should print out an amusing grid of x's and spaces
	static void ohnulls() {
		String strs[][] = new String[10][15];
		for(int i=0; i<strs.length; i++) {
			for(int j=0; j<strs[i].length; j++) {
				if (i%2==0 || j%3==0) {
					strs[i][j] = new String("x");
			} else {
				strs[i][j] = new String(" ");
			}
		}
		}
		for (String[] row: strs) {
			for (String str: row) {
				System.out.print(str);
			}
			System.out.println();
		}
	}

	// Shouldn't crash/result in zero.  The correct value is 4.0, and the message should be correct.
	static void sillymath() {

		double z = 1000;
		double x = 500;

		while (x > 10) {
			double t = x / z;
			x = x/5;
			z = t;
		}
		System.out.println(x);

		double i = 250;
		if (i / 500 == 0.5) {
			System.out.println("All is right in the world");
		} else {
			System.out.println("Your debugging skills still need some work");
		}

	}

	// Expect to get the right message about proper capitalization
	static void sillystrings() {
		String s = "hello world!";
		System.out.println(s);

		s = s.replace("hello","Hello");
		if (s.equals("Hello world!")) {
			System.out.println("Proper capitalization");
		} else {
			System.out.println("Still not quite there yet");
		}
	}
}
