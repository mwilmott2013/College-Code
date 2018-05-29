import java.util.Scanner;
public class Lab20
{
	public static void main (String [] args)
	{
		Scanner cin = new Scanner (System.in);
		int i, j, cordX = 0, cordY = 0; //cord = coordinate
		i = Integer.parseInt (args [0]); //this is the x-axis
		j = Integer.parseInt (args [1]); //this is the y-axis
		
		String [][] names = new String [i][j]; //declares and allocates the string array
		for (int count = 0; count < i; count++) //fills the array with "nothing" values
		{
			for (int countTwo = 0; countTwo < j; countTwo++)
			{
				names [count][countTwo] = "nothing";
			}
		}
		
		while ((cordX != -1) || (cordY != -1)) //loop for user entry for names
		{
			System.out.println ("Enter a coordinate (-1 terminates): ");
			cordX = cin.nextInt ();
			if (cordX == -1) //the -1 error check is only for the x coordinate. For the y coordinate, it is just out of bounds
			{
				break;
				
			}
			cordY = cin.nextInt ();
			
			if ((cordX >= i) || (cordY >= j) || (cordX < -1) || (cordY <= -1)) //checks if entered coordinates are within the array's bounds
			{
				System.out.println ("Out of bounds!");
			}
			else if (!names [cordX][cordY].equals("nothing")) //if the entered coordinates already has a name, it will not allow user to re-enter another name
			{
				System.out.println ("Already has a name!");
				
			}
			else
			{
				System.out.println ("Enter a name: ");
				names [cordX][cordY] = cin.next ();
				
			}
			
		}
		
		System.out.println ("Printing results:");
		for (int count = 0; count < i; count++) //same loop as the first, just prints out names instead of filling each array with nothing
		{
			for (int countTwo = 0; countTwo < j; countTwo++)
			{
				System.out.println (count + ", " + countTwo + " has " + names [count][countTwo]);
			}
		}
		
		
		
	}
}
