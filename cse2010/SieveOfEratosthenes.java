/*
 * Author:  Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course:  CSE 2010, Section 02, Fall 2015
 * Project: Lab 1
 */

import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfEratosthenes extends PrimeOptimized {
  ArrayList<Integer> primes = new ArrayList<Integer>();
  
  public SieveOfEratosthenes(int upTo) {
    this.findAllPrimes(upTo);
  }
  
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
    
      for (int whatever = 0; whatever < are_primes.length(); whatever++) {
        if (are_primes[whatever] == true) {
          primes.add(are_primes[whatever]);
        }
      }
    
    
    
  }
  
    @Override
    public boolean isPrime (int p) {
      for (int z = 0; z != primes.length; z++) {
        if (primes[z] == p) {
          return true;
        }
      }
      return false;
}
}
