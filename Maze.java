/* 
 * Program Created by Kyle Heath
 * Last Modified on the 15th of October 2016
 * Email: jheath5298@g.fmarion.edu
 * 
 * This program is a maze that is traversed through user input. It uses nodes 
 * and sends them through a loop that analyzes the user input. If the user enters
 * a direction that are unable to go to, it stops them and makes them try again.
 * It then moves the user through the maze telling them which room they are in A-L. 
 * It stops them when they reach room L. 
 * 
 */

import java.util.Scanner;
public class Maze{
	
	Node north, south, east, west;
	
	
	
	public static void main(String[] args){
		
		// These are the nodes that represent each room in the maze from A-L
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		Node F = new Node("F");
		Node G = new Node("G");
		Node H = new Node("H");
		Node I = new Node("I");
		Node J = new Node("J");
		Node K = new Node("K");
		Node L = new Node("L");
		
		// These methods designate which way the user is not able to go.
		// null are the directions they can't go
		A.connectors(null, E, null, B);
		B.connectors(null, F, A, null);
		C.connectors(null, G, null, D);
		D.connectors(null, null, C, null);
		E.connectors(A, I, null, null);
		F.connectors(B, null, null, G);
		G.connectors(C, K, F, H);
		H.connectors(null, L, G, null);
		I.connectors(E, null, null, J);
		J.connectors(null, null, I, null);
		K.connectors(G, null, null, null);
		L.connectors(H, null, null, null);
		
		// Tells the user what to enter for the input in order to traverse the maze.
		System.out.println("You have entered a maze.");
		System.out.println("Enterence Key: 'E' = East 'W' = West 'N' = North 'S' = South");
		
		// Creating a temporary node to store the user in.
		Node current = A;
		Scanner input = new Scanner(System.in);
		
		/* 
		 * This loop prompts the user to enter a direction
		 * It validates whether or not the user entered 
		 * a proper input. 
		 */ 
		while (current != L){
			
			// This line tells the user what room they are in as well as where they are able to go in the maze. 
			 System.out.print("You enter " + current.id + " of a maze of twisty little passages, all alike. You can go ");
			 
			 // prints along with the first line only if north position of their location does not equal null.
			 if (current.getNorth() != null){
				 System.out.print("north ");
				 
			 }
			 
			 // This prints out along with the north key word only if there is a value for east in that room.
			 if (current.getEast() != null){
				
				 // Prints along with the east key word if both north and east have values.
				 if(current.getNorth() != null){
					 System.out.print("or ");
				 }
				 
				 System.out.print("east ");
				
			 }
			 
			 
			 // This prints if the south direction has a value in the room.
			 if (current.getSouth() != null){
				 
				 // This prints or if either east or north or both contain values in their rooms.
				 if (current.getNorth() != null || current.getEast() != null){
					 System.out.print("or ");
				 } 
				 
				 System.out.print("south ");
				 
			 }
			 
			 //This is does the same thing as the if statements above. This checks for west in the room.
			 if (current.getWest() != null){
				 
				 // This prints out or if another direction has a room location in the same constructor.
				 if (current.getNorth() != null || current.getSouth() != null || current.getEast() != null){
					 System.out.print("or ");
				 }
			 }
			 
			 System.out.println();
			 
			 String answer = input.nextLine();
			 
			 // a boolean used to keep the loop going unless interrupted by breaks.
			 boolean flag = false;
			 
			 // This loop checks to make sure the person is entering the right direction.
			 while (!flag){
				 if (!answer.equals("N") || current.getNorth() == null){
					 flag = false;
				 } else {
					 flag = true;
					 break;
				 }
				 if (!answer.equals("W") || current.getWest() == null){
					 flag = false;
				 } else {
					 flag = true;
					 break;
				 }
				
				 if (!answer.equals("E") || current.getEast() == null){
					 flag = false;
				 } else {
					 flag = true;
					 break;
				 }
				
				 if (!answer.equals("S") || current.getSouth() == null){
					 flag = false;
				 } else {
					 flag = true;
					 break;
				 }
				 if (!flag){

					 // Prints if the user does not enter proper letters for direction.
					 System.out.println("Not a valid input. Try Again.");
					 System.out.println("Remember: Always check to see where you can go in your room.");
					 System.out.println("You can enter: 'E' for East; 'S' for South;");
					 System.out.println("'N' for North; or 'W' for West.");
					 answer = input.nextLine();
				 }
				
			 }
			 
			 
			 // These if statements process the user input to decide the direction and room they can go.
			 if (answer.equals("N") || answer.equals("n")){
				 current = current.getNorth();
			 } else if (answer.equals("S") || answer.equals("s")){
				 current = current.getSouth();
			 } else if (answer.equals("W") || answer.equals("w")) {
				 current = current.getWest();
			 } else if (answer.equals("E") || answer.equals("e")){
				 current = current.getEast();
			 }
		}
		
		input.close(); // closing the Scanner.
		
		// This tells the user they have reached the end of the maze.
		System.out.println("You have reached room L and found the exit. Congratulations!");
	}
	
	// This is the separate class created for the Nodes.
	public static class Node{
		String id;
		Node north, south, east, west;
		
		// Constructor for creating the nodes and telling which direction they can go. 
		public Node(String id){
			this.id = id;
		}
		
		// This method establishes the nodes for each room. 
		// This will determine which direction works for the user.
		public void connectors(Node north, Node south, Node west, Node east){
			setNorth(north);
			setSouth(south);
			setEast(east);
			setWest(west);
		}
		
		/*
		 * These below methods are the getters and setters
		 * for every possible direction in the maze. 
		 */
		public Node getNorth(){
			return north;
		}
		
		public Node getSouth(){
			return south;
		}
		
		public Node getEast(){
			return east;
		}
		
		public Node getWest(){
			return west;
		}
		
		public void setNorth(Node north){
			this.north = north;
		}
		
		public void setSouth(Node south){
			this.south = south;
		}
		
		public void setEast(Node east){
			this.east = east;
		}
		
		public void setWest(Node west){
			this.west = west;
		}
		
	}
}
