/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Fall 2012
 * Project: web
 */


public class Newton {
    
	static Complex first;
	static Complex second;
	static Complex third;
	static Complex fourth;
	
	public static void setXscale(double min, double max) {
		StdDraw.setXscale(min, max);
	}
	
	public static void setYscale(double min, double max) {
		StdDraw.setYscale(min, max);
	}
	
    public static void main (final String[] args) {
    	StdDraw.show(0);
    	final int size = Integer.parseInt(args[0]);
    	
        first = new Complex (1.0, 0.0);
   	    second = new Complex (-1.0, 0.0);
   	    third = new Complex (0.0, 1.0);
   	    fourth = new Complex (0.0, -1.0);
   	    double min = -1.0;
   	    double max = 1.0;
    	for (double i = -1.0; i < 1.0; i = i + 2 / size) {
    		for (double j = -1.0; j < 1.0; j = j + 2 / size) {
    			Complex z = new Complex (i, j);
    			newton(z, 0);
    		}
    	
        }
    }
    
    public static Complex newton (final Complex z, final int iterations) {
        Complex real = z.minus((z.power(4).minus(first)).divides
    			(z.power(3).times(new Complex(4.0, 0.0))));
        if (real.minus(first).abs() < .001) {
        	return new Complex (1.0, 0.0);
        }
        
        if (real.minus(second).abs() < .001) {
        	return new Complex (-1.0, 0.0);
        }
        
        if (real.minus(third).abs() < .001) {
        	return new Complex (0.0, 1.0);
        }
        
        if (real.minus(fourth).abs() < .001) {
        	return new Complex (0.0, -1.0);
        }
        if (iterations == 100) {
        	return new Complex (0,0);
        }
        return newton(real, iterations + 1);
    }
}        
        