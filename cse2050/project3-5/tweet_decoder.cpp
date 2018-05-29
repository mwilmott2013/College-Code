// Name: Matthew Wilmott
// Email: mwilmott2013@my.fit.edu
// Purpose: 
//    Interpret the meaning of an abbreviation from a tweet
//    given by the user. 
// Algorithm:
//    Prompt user for tweet abbreviation
//    Get tweet abbreviation
//    Compare abbreviation given with known abbreviations
//    If the given abbreviation matches a known one,
//    Display the interpretation of the abbreviation
//    Otherwise,
//    Display apology message

#include <iostream>
using namespace std;
int main ()
{
	string origTweet;
	
	cout << "Enter abbreviation from tweet: " << endl;
	cin >> origTweet;
	
	if (origTweet == "LOL")
	    cout << "LOL = laughing out loud" << endl;
	else if (origTweet == "BFN")
		cout << "BFN = bye for now" << endl;
	else if (origTweet == "FTW")
		cout << "FTW = for the win" << endl;
	else if (origTweet == "IRL")
		cout << "IRL = in real life" << endl;
	else if (origTweet == "F2F")
		cout << "F2F = face to face" << endl;
	else if (origTweet == "BGD")
		cout << "BGD = background" << endl;
	else if (origTweet == "FAB")
		cout << "FAB = fabulous" << endl;
	else if (origTweet == "IDK")
		cout << "IDK = I don't know" << endl;
	else if (origTweet == "B4")
		cout << "B4 = before" << endl;
	else if (origTweet == "TBH")
		cout << "TBH = to be honest" << endl;
	else
		cout << "Sorry, don't know that one." << endl;
	
	return 0;
}
