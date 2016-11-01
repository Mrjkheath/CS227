/**********************************************************************************
 * 
 * ArrayListShuffle program created by Kyle Heath
 * Last Modified on 9/19/16
 * Email: jheath5298@g.fmarion.edu
 * 
 * This program takes user input of items and puts them into a String ArrayList.
 * It takes this list and shuffles the items in the list randomly. The input ends 
 * when the user enters a null string.
 * 
 **********************************************************************************/

import java.util.*;

public class ArrayListShuffle
{

	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		// Creating a String ArrayList to store user input.
		ArrayList<String> userInput = new ArrayList<String>();
		boolean repeat = true;

		System.out.println("Enter a list of items you would like to suffle (Enter nothing to end the list): ");

		// A do while loop that checks whether or not the user has entered a
		// null string to end the ArrayList.
		do
		{

			String listItem = input.nextLine();

			if (listItem.isEmpty())
			{

				// This break is used to exit the do loop if the user enters a
				// null string.
				break;
			}

			// Adds the user input to the List.
			userInput.add(listItem);

		} while (repeat);

		// The List before printed prior to shuffling.
		System.out.println("Your list before it is shuffled: ");
		System.out.println(userInput);

		// The shuffle method is called on the user input list.
		shuffle(userInput);

		// The List after it is passed to the shuffle method.
		System.out.println("Your shuffled list: ");
		System.out.println(userInput);

		input.close();
	}

	// Used to control the warning thrown from the Generic string.
	@SuppressWarnings("hiding")

	// This Method accesses the suffle method within the Collections class in
	// the util Package.
	public static <String> void shuffle(ArrayList<String> list)
	{
		// Randomly shuffles the ArrayList Strings the generic random
		// algorithms.
		Collections.shuffle(list);
	}

}
