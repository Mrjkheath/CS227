/***********************************************************************************
 * Program PostfixNotation Created by Kyle Heath 
 * Last Modified on October 24th, 2016
 * Email: jheath5298@g.fmarion.edu
 * This program takes user input of an equation in post fix notation and solves it.
 * It accomplishes this by taking a string and splitting it into to different stacks,
 * one of characters and the other of integer values through generics. It tells the 
 * user when the input they try to use either empty, or not a number, and makes them
 * enter new input.
 ***********************************************************************************/
import java.util.*;

public class PostfixNotation
{
	
	// Removes the warning on line 38
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		// variable to keep the do-while loop working.
		boolean outside = true;
		
	// loop to evaluate the user input.	
	do {	
		
	try {
		String expression;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter an expression to evaluate: ");
		expression = input.nextLine();
		
		// Throws the NumberFormatException if the user does not input anything.
		if (expression.isEmpty() == true){
			throw new NumberFormatException();
		} 
		
		System.out.println(postEvaluation(expression));
		input.close(); // close the scanner.
		
		// This break prevents the loop from scanning for input after correct input is found.
		break;
	} catch (NumberFormatException ex){
		System.out.println("You must enter a mathematical equation in postfix notation. E.g. 1 2 + 3 * ");
		System.out.println("Try again.");
	} catch (EmptyStackException ex){
		System.out.println("You must start your equation with two numbers to be evaluated. Try again. ");
	}
	
	} while (outside); // end of the do-while.
	
	} // end of main method
	
	
	public static int postEvaluation(String problem){
		
		// Stack used to store the numbers in the user's equation
		Stack<Integer> numbers = new Stack<>();
		
		// Stack used to store the symbols, or operators.
		Stack<Character> symbols = new Stack<>();
		
		
		// Creating a String Array to store the user input into.
		String[] evaluation = problem.split(" ");
		
		// for loop evaluates what the expression entered by the user.
		for (int i = 0; i < evaluation.length; i++){
			
			String newString = evaluation[i];
			
			// Process the numbers until it finds a plus or minus.
			if (newString.charAt(0) == '-' || newString.charAt(0) == '+'){
				while (!symbols.isEmpty() &&
					  (symbols.peek() == '-' || 
					   symbols.peek() == '+' || 
					   symbols.peek() == '*' || 
					   symbols.peek() == '/' )){
					
					processOperators(numbers, symbols);
					
				} // closes the while loop
				
				symbols.push(newString.charAt(0));
				
			} else if (newString.charAt(0) == '*' || newString.charAt(0) == '/'){
				while(!symbols.isEmpty() && (symbols.peek() == '*' || symbols.peek() == '/')){
					processOperators(numbers, symbols);
				}
				
				symbols.push(newString.charAt(0));
			} else {
				// pushes the numbers the loop finds in the string and converts it too an integer.
				numbers.push(new Integer(newString));
			}
			
			// processes the arithmetic while the stack is not empty.
			while (!symbols.isEmpty()){
				processOperators(numbers, symbols);
			} // closes the while loop
		} // closes the for loop
		
		
		// gives the user the answer.
		return numbers.pop();
	} // end of postEvaluation method
	
	
	// Method evaluates the operator when called.
	public static void processOperators(Stack <Integer> number, Stack <Character> operation){
		char op = operation.pop();
		int first = number.pop();
		int second = number.pop();
		
		// executes depending on the which character the loop finds within the original character stack.
		switch(op){
		case '+': number.push(first + second);
		break;
		case '-': number.push(first - second);
		break;
		case '*': number.push(first * second);
		break;
		case '/': number.push(first / second);
		break;
		} // closes the switch 
		
		
	} // end of the main method

}// end of program
