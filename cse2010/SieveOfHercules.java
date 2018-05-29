import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfHercules extends PrimeOptimized {
	ArrayList<Integer> primes = new ArrayList<Integer>();
	@Override
	
	public void findAllPrimes(int upTo) {
		// if are_primes returns true, i is prime
		boolean[] are_primes = new boolean[upTo - 2];
		// right now, all values in array are false
		Arrays.fill(are_primes; true)
		// now all elements of are_primes are true
		for (int i = 2; i < upTo; i++) {
		// select multiples of ...
			for (int j = i*2; j < upTo; j+=i) {
				// unless j == i, j is not a prime
				are_primes[j] = false;
			}
		}
		
		
		
		
		
	}
	
	
    public boolean isPrime (int p) {
    	if (p < 2) {
    		
    	}
}