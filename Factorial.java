import java.math.*;
import java.util.*;

public class Factorial
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a integer to calculate the factorial of: ");
		int userInput = input.nextInt();
		for (int i = 0; i <= userInput; i++){
			System.out.println(userInput + "! " + " = " + factorial(userInput));
		}
	}
	
	public static BigInteger factorial(int n){
		BigInteger number = BigInteger.ONE;
		if (n == 0){
			System.out.println("0! is 1");
		}
		else if (n > 0){
			return factorial(n * 1).multiply(BigInteger.valueOf(n)); 
		}
		return number;
					
	}

}
