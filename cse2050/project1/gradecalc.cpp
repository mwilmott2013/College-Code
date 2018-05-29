// Name: Matthew Wilmott
// Email: mwilmott2013@my.fit.edu
// Purpose: 
//    Calculate the user's course percentage for the course
//    given scores for assignments given during the 
//    semester.
// Algorithm:
//    Prompt user for homework score
//    Get homework score
//    Prompt user for quiz score
//    Get quiz score
//    Prompt user for midterm exam score
//    Get midterm exam score
//    Prompt user for final exam score
//    Get final exam score
//    Calculate course percentage
//    percentage = sum of all assignment calculations
//    calculation = (score * max score) / weight
//    Convert percentage from fraction to percent
//    conversion = percentage * 100 
//    Display course percentage

#include <iostream>
using namespace std;
int main ()
{
	const double HOMEWORK_MAX = 80.0;
	const double QUIZ_MAX     = 20.0;
	const double MIDTERM_MAX  = 40.0;
	const double FINAL_MAX    = 70.0;
	const double HOMEWORK_WEIGHT = 0.10;
	const double QUIZ_WEIGHT     = 0.15;
	const double MIDTERM_WEIGHT  = 0.30;
	const double FINAL_WEIGHT    = 0.45;
	
	double homeworkScore    = 0.0;
	double quizScore        = 0.0;
	double midtermScore     = 0.0;
	double finalScore       = 0.0;
	double homeworkPart     = 0.0;
	double quizPart         = 0.0;
	double midtermPart      = 0.0;
	double finalPart        = 0.0;
	double coursePercentage = 0.0;
	
	cout << "Enter homework score:" << endl;
	cin >> homeworkScore;
	
	cout << "Enter quiz score:" << endl;
	cin >> quizScore;
	
	cout << "Enter midterm exam score:" << endl;
	cin >> midtermScore;
	
	cout << "Enter final exam score:" << endl;
	cin >> finalScore;
	
	homeworkPart = ((homeworkScore / HOMEWORK_MAX) * HOMEWORK_WEIGHT);
	quizPart     = ((quizScore / QUIZ_MAX) * QUIZ_WEIGHT);
	midtermPart  = ((midtermScore / MIDTERM_MAX) * MIDTERM_WEIGHT);
	finalPart    = ((finalScore / FINAL_MAX) * FINAL_WEIGHT);
	
	coursePercentage = homeworkPart + quizPart + midtermPart + finalPart;
	coursePercentage = coursePercentage * 100; // Convert fraction to %
	
	cout << endl << "Your course percentage: ";
	cout << coursePercentage << endl;
	
	return 0;
}
