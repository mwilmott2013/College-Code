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

int decode();

int moreTweets();
	
int main()
{
	decode();
	return 0;
}

int decode()
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
			cout << "laughing out loud ";
		else if (singleWord == "BFN")
			cout << "bye for now ";
		else if (singleWord == "FTW")
			cout << "for the win ";
		else if (singleWord == "IRL")
			cout << "in real life ";
		else if (singleWord == "F2F")
			cout << "face to face ";
		else if (singleWord == "BGD")
			cout << "background ";
		else if (singleWord == "FAB")
			cout << "fabulous ";
		else if (singleWord == "IDK")
			cout << "I don't know ";
		else if (singleWord == "B4")
			cout << "before ";
		else if (singleWord == "TBH")
			cout << "to be honest ";
		else
			cout << singleWord << " ";
			
		startOfSubstring = endOfSubstring + 1;
	}
	moreTweets();
	return 0;
}

int moreTweets()
{
	string confirm;
	cout << endl;
	cout << "Do you want to keep going?  Enter 'yes' if yes, or 'no' if no." << endl;
	getline(cin, confirm);
	
	if (confirm == "yes")
		decode();
	return 0;
}