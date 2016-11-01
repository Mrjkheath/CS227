/*************************************************************************************
 * 
 * PriorityQueue program created by Kyle Heath
 * Last Modified on 9/19/16
 * Email: jheath5298@g.fmarion.edu
 * 
 * This program creates a queue that outputs strings in a specific priority.
 * This queue has a method to remove items in the queue, and adds items to the 
 * queue.
 * 
 *************************************************************************************/

import java.util.ArrayList;

public class PriorityQueue<E>
{
	// This Array sorts the priority of the items in the queue.
	ArrayList<Integer> priority;
	
	// Array list for the Items in the queue.
	ArrayList<E> queue;

	// Creating a method for the main method to create ArrayLists.
	public PriorityQueue()
	{
		queue = new ArrayList<E>();
		priority = new ArrayList<Integer>();
	}

	// This method adds the items to the queue from calls in the main method.
	public void add(E item, int priority)
	{
		queue.add(item);
		this.priority.add(priority);
	}

	// used to eliminate warnings on the Comparable interface. 
	@SuppressWarnings(
	{ "rawtypes", "hiding" })
	
	// This method removes items in the queue from main method calls.
	public <E extends Comparable> E remove()
	{
		int index = 0;
		
		//used Min_Value to determine the highest priority in the ArrayList.
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < priority.size(); i++)
		{
			// This if statement assigns the highest number to the queue with the highest priority.
			if (priority.get(i) > max)
			{
				max = priority.get(i);
				index = i;
			}
		}
		@SuppressWarnings("unchecked")
		
		// Giving the method a return to pass to the main method call.
		E temp = (E) queue.get(index);
		priority.remove(priority.get(index));
		queue.remove(queue.get(index));
		return temp;
	}

	public static void main(String[] args){
		PriorityQueue<String> priorityQueue = new PriorityQueue<String>();
		
		// Prints the queue in mixed order.
		System.out.println("a, b, c with mixed priority: ");
		
		priorityQueue.add("a", 2);
		priorityQueue.add("b", 1);
		priorityQueue.add("c", 3);
		
		System.out.println(priorityQueue.remove());
		System.out.println(priorityQueue.remove());
		System.out.println(priorityQueue.remove());
		System.out.println(); // Prints a blank line between the orders.
		
		// Prints the queue in Ascending ordering.
		System.out.println("a, b, c with ascending priority: ");
		
		priorityQueue.add("a", 1);
		priorityQueue.add("b", 2);
		priorityQueue.add("c", 3);
		
		System.out.println(priorityQueue.remove());
		System.out.println(priorityQueue.remove());
		System.out.println(priorityQueue.remove());
		System.out.println();
		
		// Prints the queue in descending order.
		System.out.println("a, b, c with descending priority: ");
		
		priorityQueue.add("a", 3);
		priorityQueue.add("b", 2);
		priorityQueue.add("c", 2);
		priorityQueue.add("d", 2);
		priorityQueue.add("e", 4);

		
		System.out.println(priorityQueue.remove());
		System.out.println(priorityQueue.remove());
		System.out.println(priorityQueue.remove());
		System.out.println(priorityQueue.remove());
		System.out.println(priorityQueue.remove());

		
	}
}
