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

double** push(double* array[], double x);
double** pop(double* array[]);
double top(double* array[]);
int size(double* array[]);
void print(double* array[]);
void reset(double* array[]);
int more();
void eval();


int main() 
{
	eval();
	return 0;
}

double** push(double* array[], double x)
{
	if (array[9] != NULL) {
		cout << "Error: Too Many Values in the Stack." << endl;
		more();
	
	}
	int marker = 0;
	for (int i = 0; i <= 9; i++) {
		if (array[i] == NULL)
			marker = i;
			break;
	}
	array[marker] = &x;
	return array;
}

double** pop(double* array[])
{
	int marker = 0;
	for (int i = 0; i <= 9; i++) {
		if (array[i] == NULL)
			marker = i - 1;
			break;
	}
	array[marker] = NULL;
	return array;
}

double top(double* array[])
{
	for (int i = 0; i <= 9; i++) {
		if (array[i] == NULL)
			return *array[(i - 1)];
	}
	return *array[9];
}

int size(double* array[])
{
	for (int i = 0; i <= 9; i++) {
		if (array[i] == NULL) {
			return i;
		}
	}
	return 0;
}

void print(double* array[])
{
	for (int i = 0; i <= 9; i++) {
		cout << *array[i] << " ";
	}
	cout << endl;
}

void reset(double* array[])
{
	for (int i = 0; i <= 9; i++) {
		delete array[i];
	}
}

void eval()
{
	string input, part;
	int startOfSubstring = 0;
	int endOfSubstring = 0;
	int lengthOfSubstring = 0;
	
	double* array[10];
	for (int i = 0; i < 10; i++)
	{
		array[i] = NULL;
	}
	
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
			double m = stod (input, 0);
			push(array, m);
		}
		else {
			if (array[0] == NULL && array[1] == NULL) {
				cout << "Error: Not enough expressions in the Stack." << endl;
				more();
			}
			double m1 = top(array);
			pop(array);
			double m2 = top(array);
			pop(array);
			
			if (part == "+") {
				cout << "we are adding " << m1 << " and " << m2 << endl;
				double calcul = (m1 + m2);
				cout << "the calculation is " << calcul << endl;
				push(array, calcul);
			}
			if (part == "-") {
				cout << "we are subtracting " << m1 << " and " << m2 << endl;
				double calcul = (m1 - m2);
				cout << "the calculation is " << calcul << endl;
				push(array, calcul);
			}
			if (part == "*") {
				cout << "we are multiplying " << m1 << " and " << m2 << endl;
				double calcul = (m1 * m2);
				cout << "the calculation is " << calcul << endl;
				push(array, calcul);
			}
			if (part == "/") {
				if (m2 == 0.0) {
					cout << "Error: Division by zero" << endl;
					more();
				}
				push(array, (m1 / m2));
			}
		}
		startOfSubstring = endOfSubstring + 1;
	}
	int endSize = size(array);
	if (endSize > 1) {
		cout << "Error: Too many values in the expression" << endl;
		more();
	}
	else {
		double result = top(array);
		print(array);
		cout << "Result: " << result << endl;
	}
	reset(array);
	more();
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