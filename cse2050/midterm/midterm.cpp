// Name: Matthew Wilmott
// Email: mwilmott2013@my.fit.edu
// Purpose: 
//    Calculate an equation in Reverse Polish Notation.
// Algorithm:
//    Prompt user for expression
//    Get expression
//    Split expression into multiple abbreviations
//    While there are still tokens in the expression,
//    Compare token given with known abbreviations
//    If the given token  does not match a known abbreviation,
//    Push the number on the stack
//    Otherwise,
//    Pop two numbers from the stack
//    Calculate equation with operator and values
//    Push result onto the stack
//    When finished,
//    Pop and display result
//    Ask if the user wants to continue
//    Get response
//    If yes, get new expression and evaluate
//    Otherwise, end program


#include <iostream>
#include <string>
#include <cstring>
#include <stdlib.h>
using namespace std;

void push(double array[], int &size, double x);
void pop(double array[], int &size);
double top(double array[], int size);
int size(double array[], int size);
void print(double array[], int size);
void reset(double array[], int &size);
int more();
int eval();


int main() 
{
	eval();
	return 0;
}

void push(double array[], int &size, double x)
{
	array[size] = x;
	size++;
}

void pop(double array[], int &size)
{
	array[size] = -9999.9;
	size--;
}

double top(double array[], int size)
{
	return array[size - 1];
}

int size(double array[], int size)
{
	return size;
}

void print(double array[])
{
	for (int i = 0; i <= 9; i++) {
		cout << array[i] << " ";
	}
	cout << endl;
}

void reset(double array[])
{
	for (int i = 0; i <= 9; i++) {
		array[i] = -9999.9;
	}
}

int eval()
{
	string input, part;
	int startOfSubstring, endOfSubstring, lengthOfSubstring, thesize = 0;
	double calcul = 0.0;
	
	double array[10] = {-9999.9, -9999.9, -9999.9, -9999.9, -9999.9, -9999.9, -9999.9, -9999.9, -9999.9, -9999.9};
	
	cout << "Enter expression: " << endl;
	getline(cin, input);
	
	while (startOfSubstring <= input.size())
	{
		endOfSubstring = input.find(" ", startOfSubstring);
		if (endOfSubstring == string::npos)
			endOfSubstring = input.size();
		lengthOfSubstring = (endOfSubstring - startOfSubstring); 
		part = input.substr(startOfSubstring, lengthOfSubstring);
		
		if (part != "+" && part != "-" && part != "*" && part != "/") {
			double m = stod (part, 0);
			if (array[9] != -9999.9) {
				cout << "Error: Too Many Values in the Stack." << endl;
				more();
				return 0;
			}
			else {
				push(array, thesize, m);
			}
		}
		else {
			if (array[0] == -9999.9 || array[1] == -9999.9) {
				cout << "Error: Not enough expressions in the Stack." << endl;
				more();
				return 0;
			}
			double m1 = top(array, thesize);
			pop(array, thesize);
			double m2 = top(array, thesize);
			pop(array, thesize);
			
			if (part == "+") {
				calcul = (m2 + m1);
				push(array, thesize, calcul);
			}
			if (part == "-") {
				calcul = (m2 - m1);
				push(array, thesize, calcul);
			}
			if (part == "*") {
				calcul = (m2 * m1);
				push(array, thesize, calcul);
			}
			if (part == "/") {
				if (m1 == 0.0) {
					cout << "Error: Division by zero" << endl;
					more();
					return 0;
				}
				calcul = (m2 / m1);
				push(array, thesize, calcul);
			}
		}
		startOfSubstring = endOfSubstring + 1;
	}
	if (thesize > 1) {
		cout << "Error: Too many values in the expression" << endl;
		more();
		return 0;
	}
	else {
		double result = top(array, thesize);
		cout << "Result: " << result << endl;
		reset(array);
		more();
		return 0;
	}
}

int more()
{
	string confirm;
	cout << endl;
	cout << "Do you want to keep going?  Enter 'yes' if yes, or 'no' if no." << endl;
	getline(cin, confirm);
	
	if (confirm != "yes")
		return 0;
	else {
		eval();
		return 0;
	}
}