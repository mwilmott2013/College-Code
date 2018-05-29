/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Spring 2015
 * Project: Complex
 */

import java.util.Scanner;

public class Complex {
    private static final int THREE = 3;
    private final double re;   // the real part
    private final double im;   // the imaginary part

    public Complex (final double real, final double imag) {
        re = real;
        im = imag;
    }

    public final double theta () {
        return Math.atan2(im, re);
    }

    public final String toString () {
        return String.format ("%.2f%c%.2fi",
            re, im >= 0 ? '+' : '-', Math.abs (im));
    }

    public final double abs () { // Math.sqrt(re*re + im*im)
        return Math.hypot (re, im);
    }

    public final Complex conjugate () {
        return new Complex (re, -im);
    }

    public final Complex plus (final Complex b) {
        final double real = re + b.re;
        final double imag = im + b.im;
        return new Complex (real, imag);
    }

    public final Complex minus (final Complex b) {
        final double real = re - b.re;
        final double imag = im - b.im;
        return new Complex (real, imag);
    }

    public final Complex times (final Complex b) {
        final double real = re * b.re - im * b.im;
        final double imag = re * b.im + im * b.re;
        return new Complex (real, imag);
    }

    public final Complex divides (final Complex b) {
        final double real = ((re * b.re) + (im * b.im))
                / ((b.re * b.re) + (b.im * b.im));
        final double imag = ((im * b.re) - (re * b.im))
                / ((b.re * b.re) + (b.im * b.im));
        return new Complex (real, imag);
    }

    public final Complex power (final int b) {
        final Complex original = new Complex (re, im);
        Complex res = new Complex (re, im);
        for (int i = 1; i < b; i++) {
            res = res.times(original);
        }
        return res;
    }

    public final Complex squareRoot () {
        final double real = Math.sqrt(((re + Math.sqrt
                ((re * re) + (im * im))) / 2));
        final double imag = Math.signum(im) * Math.sqrt
                (((-re + Math.sqrt((re * re) + (im * im))) / 2));
        return new Complex (real, imag);
    }

    public static void main (final String[] args) {
        final Scanner sc = new Scanner (System.in);
        final double real1 = sc.nextDouble();
        final double imag1 = sc.nextDouble();
        final double real2 = sc.nextDouble();
        final double imag2 = sc.nextDouble();

        final Complex complex1 = new Complex (real1, imag1);
        final Complex complex2 = new Complex (real2, imag2);
        final double theta1 = complex1.theta();
        final double theta2 = complex2.theta();
        System.out.printf("angle(a) = %.2f%n", theta1);
        System.out.printf("angle(b) = %.2f%n", theta2);
        System.out.println("minus = " + complex1.minus(complex2).toString());
        System.out.println("conjugate = " + complex1.conjugate().toString());
        System.out.println("division = " + complex1.divides(complex2).toString());
        System.out.println("power2 = " + complex1.power(2).toString());
        System.out.println("power3 = " + complex1.power(THREE).toString());
        System.out.println("squareRoot(a) = " + complex1.squareRoot().toString());
        sc.close();
    }
}

