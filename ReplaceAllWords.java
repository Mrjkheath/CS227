/****************************************************************************************************************
 * Created by Jonathan Kyle Heath
 * 
 * E-mail: jheath5298@g.fmarion.edu
 * 
 * Last modified on the 7th of September 2016
 * 
 * This program accesses a directory and changes a word in files within that directory recursively.   
 * It can also change a word in files within nested directories. This can change a file name on it's own as well.
 * This program notifies the user if they enter a directory or file name that does not exist.
 * 
 ****************************************************************************************************************/

import java.util.Scanner;
import java.io.*;

public class ReplaceAllWords {

	public static void main(String[] args)
	{
		// This is used to determine whether or not the user is properly using commands.
		if (args.length != 3) {
			System.out.println("Usage: directoryName oldWord newWord");
			System.exit(0);
		}
		
		// Checks to determine whether or not the file or directory exists
		File file = new File(args[0]);
		if (!file.isFile() && !file.isDirectory()) {
			System.out.println(file.getAbsoluteFile() + " is not a file nor a directory.");
			System.exit(0);
		}
		wordReplacement(file, args[1], args[2]);
		
		// Lets the user know the program worked and the files have been replaced.
		System.out.println("The Words have been changed.");
	}
	
	public static void wordReplacement(File file, String oldWord, String newWord)
	{
		// This if statement reads what is in the file, if and only if the file exists, and replaces the word.
		if (file.isFile())
		{
			String s = "";
			
			// Scans the Strings within the files of a directory.
			try (Scanner input = new Scanner(file)) 
			{
				while (input.hasNext())
				{
					s += input.nextLine();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
			// This if statement switches the word within the directory.
			if (s.length() > 0)
			{
				s = s.replaceAll(oldWord, newWord);
				
			
				try (FileOutputStream output = new FileOutputStream(file, false)){
					
					// This will write the new word into the document.
					output.write(s.getBytes());
				} catch (IOException ex){
					ex.printStackTrace();
				}
			}
			
		} else {
			
			// This array pulls all the files and directories in a directory.
			File[] files = file.listFiles();
			
			// If the file is not empty, then the program will continue.
			if (files != null) 
			{
				// For each file within the array of files collected.
				for (File f : files) 
				{
					
				// A recursive call to the method is implemented until each file has been modified.	
				wordReplacement(f, oldWord, newWord);
				}
			}
		}
	}

}
