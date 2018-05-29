/*
 * Author:  Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course:  CSE 2010, Section 02, Fall 2015
 * Project: Lab 1
 */

import java.util.ArrayList;

public class PrimeOptimized extends Prime {
  private final ArrayList<Integer> primes = new ArrayList<Integer>();
  @Override
    public boolean isPrime (int p) {
    boolean skip = false;
      boolean result = false;
      if (p <= 0) {
        throw new OutOfRangeException("p must be positive and non-zero");
      }
      if (p < 2) {
        return true;
      }
        else {
          primes.add(1);
          primes.add(2);
          for (int n = 2; n != p; n++) {
            for (int i = n; i <= primes.size(); i++) {
              if ((p % primes[i]) == 0) {
                skip = true;
                break;
              }
            }
            if (skip) {
              skip = false;
              continue;
            }
            result = isDivisible(p, n);
            if (result == true) {
              return result;
            }
          }
          return result;
        }
    }
}