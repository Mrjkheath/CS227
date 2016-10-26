import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Linked_List
{

	public static void main(String[] args)
	{
		List<Integer> newList = new LinkedList<>();
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an integer value of the list size you want: ");
		
		int size = input.nextInt();
		
		for (int i = 0; i <= size; i++){
			newList.add(i);
		}
		
		System.out.println(newList);
		System.out.println();
		
		while (!(size == 0)){
			newList.remove(2);
		}
		size--;
		
		System.out.println("The List after the removal");
		
		System.out.println(newList);
		
		
		/*
		newList.add(1);
		newList.add(2);
		newList.add(3);
		newList.add(4);
		newList.add(5);
		
		System.out.println(newList);
		
		newList.remove(0);
		
		System.out.println(newList);
		
		
		
		newList.remove(2);
		
		System.out.println(newList); */
	}
	
	public static void remove(int size, List<Integer> tempList){
		int count = size;
		
		while(!(count == 0)){
			tempList.remove(2);
		}
		count--;
	}

}
