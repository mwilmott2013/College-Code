// Name: Matthew Wilmott
// Email: mwilmott2013@my.fit.edu
// Purpose: 
//    Calculate the user's age in months and days given the user's
//    age in years. 
// Algorithm:
//    Prompt user for age in years
//    Get age in years
//    Calculate age in days
//    age in days = age in years * 365
//    Calculate age in months and days
//    age in months = age in days / 30
//    age in days (remainder) = age in days % 30
//    Display age in months and days

#include <iostream>
using namespace std;
int main ()
{
	int userAgeYears = 0;
	int userAgeDays = 0;
	int userAgeMonths = 0;
	int userAgeRemainder = 0;
	
	cout << "Enter your age in years: " << endl;
	cin >> userAgeYears;
	
	userAgeDays = userAgeYears * 365;
	userAgeMonths = userAgeDays / 30;
	userAgeRemainder = userAgeDays % 30;
	
	cout << "You are " << userAgeMonths << " months and " 
	            << userAgeRemainder << " days old." << endl;
	
	return 0;
}
