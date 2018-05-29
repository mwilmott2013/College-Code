/*
 * Author:  Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course:  CSE 2010, Section 02, Fall 2015
 * Project: Lab 6
 */

public class Pair<F, S> { 
    private F first;
    private S second;


    public Pair(F first_, S second_){ 
        first=first_; 
        second=second_; 
    }
    public String toString(){ 
        return first.toString() + " " + second.toString();
    }
    public F getFirst(){ 
        return first; 
    }
    public S getSecond(){ 
        return second; 
    }
    @Override
    public boolean equals(Object obj) { 
        if (obj == this) {
            return true; 
        } 
        if (obj == null || obj.getClass() != this.getClass()) { 
            return false;
        }
        @SuppressWarnings("unchecked")


        Pair<F,S> guest = (Pair<F,S>) obj;


        return (guest.first == this.first) && (guest.second == this.second); 
    } 
}