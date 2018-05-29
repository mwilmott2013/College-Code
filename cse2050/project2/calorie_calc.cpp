// Name: Matthew Wilmott
// Email: mwilmott2013@my.fit.edu
// Purpose: 
//    Calculate the user's total consumption of pizza slices
//    given the user's age in years. 
// Algorithm:
//    Prompt user for age in years
//    Get age in years
//    Calculate user's total calorie expenditure
//    total calories = (calories spent daily * 365) * age in years
//    calories spent daily = 2000
//    Calculate total pizza slices consumed
//    total pizza slices = total calories / pizza calories
//    pizza calories = 253
//    Display user's total user lifetime calories
//    Display user's total pizza slice consumption

#include <iostream>
using namespace std;
int main ()
{
	int userAgeYears = 0;
	int caloriesSpentDaily = 2000;
	int userLifetimeCalories = 0;
	int pizzaCalories = 253;
	int totalPizzaSlices = 0;
	
	cout << "Enter your age in years: " << endl;
	cin >> userAgeYears;
	
	userLifetimeCalories = (caloriesSpentDaily * 365) * userAgeYears;
	totalPizzaSlices = userLifetimeCalories / pizzaCalories;
	
	cout << "A man generally spends 2000 calories per day." << endl;
	cout << "A 4.4 ounce slice of pizza at Pizza Hut has 253 calories." << endl;
	cout << "In your lifetime, you have spent approximately " << endl;
	cout << userLifetimeCalories << " calories.  Given that, you would need" << endl;
	cout << "to eat " << totalPizzaSlices << " pizza slices to satisfy your" << endl;
	cout << "lifetime expenditure." << endl;
	
	return 0;
}
