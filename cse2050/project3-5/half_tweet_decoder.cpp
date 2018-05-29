// Name: Matthew Wilmott
// Email: mwilmott2013@my.fit.edu
// Purpose: 
//    Interpret the meaning of an abbreviation from a tweet
//    given by the user. 
// Algorithm:
//    Prompt user for tweet
//    Get tweet
//    Split tweet into multiple abbreviations
//    While there are still words in the tweet,
//    Compare word given with known abbreviations
//    If the given word matches a known abbreviation,
//    Display the interpretation of the abbreviation
//    Otherwise,
//    Display apology message

#include <iostream>
using namespace std;
int main ()
{
	string origTweet, singleWord;
	int startOfSubstring, endOfSubstring, lengthOfSubstring = 0;
	
	cout << "Enter a tweet: " << endl;
	getline(cin, origTweet);
	
	while (startOfSubstring <= origTweet.size())
	{
		endOfSubstring = origTweet.find(" ", startOfSubstring);
		if (endOfSubstring == string::npos)
			endOfSubstring = origTweet.size();
		lengthOfSubstring = (endOfSubstring - startOfSubstring); 
		singleWord = origTweet.substr(startOfSubstring, lengthOfSubstring);
	
		if (singleWord == "LOL")
			cout << "LOL = laughing out loud" << endl;
		else if (singleWord == "BFN")
			cout << "BFN = bye for now" << endl;
		else if (singleWord == "FTW")
			cout << "FTW = for the win" << endl;
		else if (singleWord == "IRL")
			cout << "IRL = in real life" << endl;
		else if (singleWord == "F2F")
			cout << "F2F = face to face" << endl;
		else if (singleWord == "BGD")
			cout << "BGD = background" << endl;
		else if (singleWord == "FAB")
			cout << "FAB = fabulous" << endl;
		else if (singleWord == "IDK")
			cout << "IDK = I don't know" << endl;
		else if (singleWord == "B4")
			cout << "B4 = before" << endl;
		else if (singleWord == "TBH")
			cout << "TBH = to be honest" << endl;
		else
			cout << "Sorry, don't know that one." << endl;
			
		startOfSubstring = endOfSubstring + 1;
	}
	return 0;
}
