
/************************************************************************************************************************* 
 * Created by Jonathan Kyle Heath
 * Email: jheath5298@g.fmarion.edu
 * String_Permutation was last modified on the 7th of September, 2016
 * This program takes a string from user input and creates every possible permutation of that string through recursion.
 * If the user doesn't enter anything it prompts them to enter a string again.
 **************************************************************************************************************************/

import java.util.Scanner;

public class StringPermutation
{

	public static void main(String[] args) throws NotAStringException
	{
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		// This loop repeats if the user does not enter anything.
		do
		{
			// This try catch body is meant to check weather or not the user
			// enters a String.
			try
			{
				System.out.print("Enter a string to be permutated: ");
				String s = input.nextLine();

				// This if statement throws the exception to the catch block.
				if (s.isEmpty() == true)
				{
					throw new NotAStringException();
				} 
				displayPermutation(s);

				repeat = false;
				// This catch block contains a custom exception that tells
				// whether or not a String was entered by the user.
			} catch (NotAStringException ex)
			{
				System.out.println("You must enter a String. Try Again.");
			}

		} while (repeat);// end of do-while loop.

		input.close(); // closes the input Scanner established at the top of the
						// main method.
	}

	// This method is used to display only one literal, if that what the user
	// enters.
	public static void displayPermutation(String s)
	{
		displayPermutation(" ", s);
	}

	// This method is used to display the users input, if the input is more than
	// one literal.
	public static void displayPermutation(String s1, String s2)
	{
		// This if statement prints what the user enters as the first string in
		// the list.
		if (s2.length() == 0)
		{
			System.out.println(s1);
		} else
		{
			// This for loop scans the String letter by letter
			for (int i = 0; i < s2.length(); i++)
			{
				// This statement recursively calls the method and shifts each
				// character throughout the different indices.
				displayPermutation(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1));
			}
		}
	}

}
