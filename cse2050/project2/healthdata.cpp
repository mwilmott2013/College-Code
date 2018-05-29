// Name: Matthew Wilmott
// Email: mwilmott2013@my.fit.edu
// Purpose: 
//    Calculate the user's age in days given the user's
//    age in years. 
// Algorithm:
//    Prompt user for age in years
//    Get age in years
//    Calculate age in days
//    age in days = age in years * 365 
//    Display age in days

#include <iostream>
using namespace std;
int main ()
{
	int userAgeYears = 0;
	int userAgeDays = 0;
	
	cout << "Enter your age in years: " << endl;
	cin >> userAgeYears;
	
	userAgeDays = userAgeYears * 365;
	
	cout << "You are " << userAgeDays << " days old." << endl;
	
	return 0;
}
