/*
 * Author:  Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course:  CSE 2010, Section 02, Fall 2015
 * Project: Lab 1
 */


public class Prime {

    public boolean isPrime (int p) {
    	boolean result = false;
    	if (p <= 0) {
    		throw new OutOfRangeException("p must be positive and non-zero");
    	}
        if (p == 1) {
        	return true;
        }
        else if (p == 2) {
        	return true;
        }
        else {
        	for (int n = 2; n != p; n++) {
        		result = isDivisible(p, n);
        		if (result == true) {
        			return result;
        		}
        	}
        	return result;
        }
    }
    
    public boolean isDivisible (int p, int n) {
    	int check = (p % n);
    	if (check !== 0) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }

}

