import java.util.Scanner;

public class MyLinkedList<E>
{
	private Node<E> head, tail;

	private int size;

	public static void MyLinkedList()
	{
		
	}

	public void addFirst(E e)
	{
		Node<E> newNode = new Node<>(e);
		newNode.next = newNode;
		head = newNode;
		size++;

		if (tail == null)
		{
			tail = head;
			tail.next = head;
		}

	}

	public void addlast(E e)
	{
		Node<E> newNode = new Node<>(e);

		if (tail == null)
		{
			head = tail = newNode;
		} else
		{
			tail.next = newNode;
			tail = tail.next;
			tail.next = head;
		}

		size++;
	}

	public void add(int index, E e)
	{
		if (index == 0)
		{
			addFirst(e);
		} else if (index >= size)
		{
			addlast(e);
		} else
		{
			Node<E> current = head;
			for (int i = 0; i <= index; i++)
			{
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<>(e);
			(current.next).next = temp;
			size++;
		}
	}

	public E removeLast()
	{
		if (size == 0)
		{
			return null;
		} else if (size == 1)
		{
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			size--;
			return temp.element;
		} else
		{
			Node<E> current = head;

			for (int i = 0; i < size; i++)
			{
				current = current.next;
			}

			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;

		}
		

	}
	
	public E removeFirst(){
		if (size == 0){
			return null;
		}
		else {
			Node<E> temp = head;
			head = tail = null;
			size--;
			if (head == null){
				return temp.element;
			}
		}
		return null;
	}
	
	public E remove(int index){
		if (index < 1 || index > size){
			return null;
		}
		else if (index == 1){
			return removeFirst();
		}
		else if (index == size){
			return removeLast();
		}
		else{
			Node<E> previous = head;
			for (int i = 2; i < index; i++){
				previous = previous.next;
			}
			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}
	public int getSize(){
		return size;
	}
	public E getElement(int index){
		if (index == 1){
			return head.element;
		}
		else{
			Node<E> current = head;
			for (int i = 1; i < index; i++){
				current.next = current;
			}
			return current.element;
		}
	}
	
	public static void displayList(int size, MyLinkedList<Integer> list){
		for (int i = 1; i <= list.getSize(); i++){
			System.out.print(list.getElement(i) + " ");
		}
	}
	
	public static void createList(int size, MyLinkedList<Integer> list){
		for (int i = 1; i <= size; i++){
			list.add(i, i);
		}
	}
	
	public static void main(String[] args){
		MyLinkedList<Integer> man = new MyLinkedList<>();
		
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a suitor amount(int): ");
		int suitor = input.nextInt();
		
		createList(suitor, man);
		
		System.out.println("The List is: ");
		displayList(suitor, man);
		
	}
}
