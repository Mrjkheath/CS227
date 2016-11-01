
public class TestArray
{
	public static int[] reverseArray( int [] list)
	{
	   int[] result = new int[list.length];	
	   
	   for  (int i = 0, j = result.length - 1;
			   i < list.length; i++, j--)
	   {
			result[j] = list[i];   
	   }
	   return result; 
	}

	public static void main(String[] args)
	{
		
		final int SIZE = 10;
		int[] myArray  = new int[SIZE];
		
		for  (int i = 0; i < SIZE; i ++)
			myArray[i] = i;
		
		// print out the array
		
		for (int i = 0; i < SIZE; i++)
			System.out.print( myArray[i] + " ");
		
		System.out.println();
		// create another array that has the reversal of the list
		 
		
		int[] myReversedArray = reverseArray(myArray);
		
		// print out the array
		for (int i = 0; i < SIZE; i++)
			System.out.print( myReversedArray[i] + " ");
		
		System.out.println();
			
	} // main
}
