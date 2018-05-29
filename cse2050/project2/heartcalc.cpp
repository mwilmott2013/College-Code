// Name: Matthew Wilmott
// Email: mwilmott2013@my.fit.edu
// Purpose: 
//    Calculate the user's total heartbeats in their life
//    given the user's age in years. 
// Algorithm:
//    Prompt user for age in years
//    Get age in years
//    Calculate user's total heartbeats
//    total heartbeats = age in years * heartbeats per year
//    heartbeats per year = (72 * 60) * (24 * 365)
//    Display user's total heartbeats

#include <iostream>
using namespace std;
int main ()
{
	int userAgeYears = 0;
	int userTotalHeartbeats = 0;
	int heartbeatPerYear = (72 * 60) * (24 * 365);
	
	// 72 beats per minute, 60 minutes per hour,
	// 24 hours per day, 365 days per year.
	
	cout << "Enter your age in years: " << endl;
	cin >> userAgeYears;
	
	userTotalHeartbeats = heartbeatPerYear * userAgeYears;
	
	cout << "If there are 72 heartbeats per minute, then" << endl;
	cout << "your have had " << userTotalHeartbeats << " heartbeats" << endl;
	cout << "in your life." << endl;
	
	return 0;
}
