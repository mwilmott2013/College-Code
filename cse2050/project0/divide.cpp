// Name: Matthew Wilmott
// Email: mwilmott2013@my.fit.edu
// Purpose: 
//    Calculate the total amount of peas, given the 
//    number of peas in a pod and the number of pods.
// Algorithm:
//    Say hello
//    Prompt user for number of pods
//    Get number of pods
//    Prompt user for number of peas per pod
//    Get number of peas per pod
//    Calculate total peas
//    total = number of pods / peas per pod
//    Display number of pods
//    Display number of peas per pod
//    Display total number of peas
//    Say goodbye

#include <iostream>
using namespace std;
int main( )
{
	cout << "Hello\n";
	int number_of_pods, peas_per_pod, total_peas;
	cout << "Press return after entering a number.\n";
	cout << "Enter the number of pods:\n";
	cin >> number_of_pods;
	cout << "Enter the number of peas in a pod:\n";
	cin >> peas_per_pod;
	
	total_peas = number_of_pods / peas_per_pod;
	
	cout << "If you have ";
	cout << number_of_pods;
	cout << " pea pods\n";
	cout << "and ";
	cout << peas_per_pod;
	cout << " peas in each pod, then\n";
	cout << "you have ";
	cout << total_peas;
	cout << " peas in all the pods.\n";
	cout << "Good-bye\n";
	
	return 0;
}
