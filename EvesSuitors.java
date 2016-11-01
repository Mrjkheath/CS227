/*
 * Program Created by Kyle Heath
 * Last Modified on October 15th 2016
 * Email: jheath5298@g.fmarion.edu
 * 
 * This program takes user input of an integer to create a list and
 * remove every third index in the list. It doesn't allow the user 
 * to enter anything other than an integer. The integer must also
 * be a positive integer. It continues to prompt until they enter
 * a positive integer. The list stops when there is only one node
 * left in the list. 
 * 
 */
import java.util.*;

public class EvesSuitors<E>
{
	private Suitor<E> head, tail;

	private int size = 0;
	
	
	// An empty constructor to make the list.
	public static void EvesSuitors()
	{
		
	}

	// This method adds an element to the beginning of the list.
	public void addFirst(E e)
	{
		Suitor<E> newSuitor = new Suitor<>(e);
		newSuitor.next = head;
		head = newSuitor;
		size++;

		if (tail == null)
		{
			tail = head;
			tail.next = head; // makes the list circular.
		}
	}

	// This method adds to the end of the list.
	public void addLast(E e)
	{

		if (tail == null)
		{
			head = tail = new Suitor<>(e);
		}

		else
		{
			Suitor<E> tempSuitor = new Suitor<>(e);
			tail.next = tempSuitor;
			tail = tempSuitor;
			tail.next = head; // Makes the list circular.
		}
		size++;
	}

	
	// This video adds to a specified index anywhere in the list.
	public void add(int i, E e)
	{
		if (i == 1)
		{
			addFirst(e);
		} else if (i >= size)
		{
			addLast(e);
		} else
		{
			Suitor<E> current = head;

			for (int j = 1; j < i; j++)
			{
				current = current.next;
			}
			Suitor<E> tempSuitor = current.next;
			current.next = new Suitor<>(e);
			(current.next).next = tempSuitor;
			size++;
		}

	}

	
	// This method removes the start of the list.
	public E removeFirst()
	{
		if (size == 0)
		{
			return null;
		} else
		{
			Suitor<E> tempSuitor = head;
			head = head.next;
			size--;
			if (head == null)
			{
				return tempSuitor.suitor;
			}
			return null;
		}
	}

	
	// This method removes from the end of the list.
	public E removeLast()
	{
		if (size == 0)
		{
			return null;
		} else if (size == 1)
		{
			Suitor<E> tempSuitor = head;
			head = tail = null;
			size = 0;
			return tempSuitor.suitor;
		} else
		{
			Suitor<E> current = head;

			for (int i = 0; i < size - 2; i++)
			{
				current = current.next;
			}

			Suitor<E> tempSuitor = tail;
			tail = current;
			tail.next = head; // makes the list circular
			size--;
			return tempSuitor.suitor;
		}
	}

	
	// This method removes from a specified index in the array.
	public E remove(int index)
	{
		if (index < 1 || index > size)
		{
			return null;
		} else if (index == 1)
		{
			return removeFirst();
		} else if (index == size)
		{
			return removeLast();
		} else
		{
			Suitor<E> previous = head;

			for (int i = 2; i < index; i++)
			{
				previous = previous.next;
			}

			Suitor<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.suitor;
		}
	}

	
	// This method retrieves a node within the list.
	public E getSuitor(int index)
	{
		if (index == 1)
		{
			return head.suitor;
		} else
		{
			Suitor<E> current = head;
			for (int i = 1; i < index; i++)
			{
				current = current.next;
			}
			return current.suitor;
		}
	}

	
	// This method prints an integer representation of the nodes inside the list.
	public int getSize()
	{
		return size;
	}

	// Method for creating the list from user input.
	public static void createSuitors(int size, EvesSuitors<Integer> list)
	{
		for (int i = 1; i <= size; i++)
		{
			list.add(i, i);
		}
	}

	
	// This method displays the list element by element.
	public static void displaySuitors(EvesSuitors<Integer> list)
	{
		for (int i = 1; i <= list.getSize(); i++)
		{
			System.out.print(list.getSuitor(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		EvesSuitors<Integer> man = new EvesSuitors<>();

		Scanner input = new Scanner(System.in);

		
		// This boolean input is only used to keep the loop going until a break.
		boolean validate = true;
		int suitor;
		System.out.println("Enter an amount of suitors: ");
		
		// this do-while loop checks for 
		do
		{
			// Checks the scanner to see if it reads an integer value from user input.
			while (!input.hasNextInt())
			{
				System.out.println("You must enter an integer! Try Again.");
				input.next(); // clears the input and allows the user to re-enter a value.
			}
			suitor = input.nextInt();
			
			// this loops checks to see the user input is positive.
			if (suitor > 0)
			{
				// exits the do-while because the user input is a positive integer.
				break;
			} else
			{
				// This statement prints the line if the user input is negative (and not 0).
				System.out.println("You must enter an integer greater than 0! Try Again.");
			}

		} while (validate);

		System.out.println("Your list contains " + suitor + " suitors.");

		createSuitors(suitor, man);
		displaySuitors(man);

		int count = 1;
		int i = 1;
		int num = 1;

		// This loop removes every third item in the list until there is only one item left.
		while (man.getSize() != 1)
		{

			// Calculates which index is a third through division remainders.
			if (count % 3 * num == 0)
			{
				man.remove(i);
				displaySuitors(man);
				num++;
				i--;
				
			// prints one if the size of the list entered is one.	
			} else if (i >= man.getSize())
			{
				i = 1;
				
			// increments the list to remove the next third node.	
			} else
			{
				i++;
			}
			count++;
		}
	}

}
