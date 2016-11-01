/****************************************************************************************************************** 
 * Program Created by Jonathan Kyle Heath on the 31st of August, 2016
 * 
 * Email: jheath5298@g.fmarion.edu
 * File Name: Exponential_Recursion
 * 
 * This program uses a recursive method from user input to calculate exponents on a single base number.
 * Ex: If the user enters 2 for the base and 4 for the exponent, then the program calculates 2^4, 2^3, 2^2,
 * 2^1, and 2^0.  
 * The program is designed to use only non-negative numbers for both the base, and the exponent.
 * 
 *******************************************************************************************************************/

import java.util.Scanner;

public class Exponential_Recursion 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int baseInput;
		
		//Using a do-while loop for input validation of a positive number base.
		do {
			System.out.println("Enter a non-negative base integer:");
			baseInput = input.nextInt();
			if (baseInput < 0) {
				System.out.println("You Must Enter a Positive base number!");
			}

		} while (baseInput < 0);

		int exponentInput;
		
		//Using a Second do-while loop for input validation of a positive exponent.
		do {
			System.out.println("Enter a non-negative exponent");
			exponentInput = input.nextInt();
			if (exponentInput < 0) {
				System.out.println("You must enter a positive exponent!");
			}
		} while (exponentInput < 0);

		power(baseInput, exponentInput); // Calling the recursive "power" method using user input.

		input.close(); // Closing user input.
	}
	
	// This recursive method calculates every exponent from user input until zero.
	public static void power(int base, int exponent) {
		if (exponent == 0) {
			System.out.println(base + "^" + 0 + " = " + 1);
		} else if (exponent >= 1) {
			System.out.println(base + "^" + exponent + " = " + (int) Math.pow(base, exponent));
			power(base, exponent - 1);
		}

	}

}