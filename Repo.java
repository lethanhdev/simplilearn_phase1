package simplilearn;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Repo {
	
	static final String dirPath = "/Users/thanhle/simplilearn/phase1/selfLearning/section6/src/simplilearn/repoDir";
	final File   f = new File(dirPath + "file1.txt");
	static Scanner input = new Scanner(System.in);	
	boolean exit;

	public static void main(String[] args) throws IOException {
		Repo menu = new Repo();
		menu.runMenu();
	}//main()

	public void runMenu() throws IOException {  		// looping thru the main file operations
		printWelcome();
		while (!exit) {			
			printMainMenu();
			int choice = getMainMenuChoice();
			
			performMainAction(choice);					// for  Main choice #1, #2, #3
		}//while()
		
		input.close();
	}

	private void printWelcome() {											//print the header
		System.out.println("+------------------------------------- +");
		System.out.println("|     WELCOME To Your Repositories     |");
		System.out.println("|You can perform operations on files by|");
		System.out.println("| choosing options from the Menu below |");
		System.out.println("+--------------------------------------+");
	}
	
	private void printMainMenu() {												//print the menu options
		System.out.println();
		System.out.println("   Main Menu:");
		System.out.println("1) List files");
		System.out.println("2) To Add, Delete and Search a file");
		System.out.println("3) Exit");
	}
	
	private void printSubMenu() {
		System.out.println();
		System.out.println("   Sub Menu:");
		System.out.println("1) Add a file");
		System.out.println("2) Delete a file");
		System.out.println("3) Search a file");
		System.out.println("4) Back to Main Menu");
	}

	private int getMainMenuChoice() {											// return user's choice
		int choice = -1;
		do {
			System.out.print("\nEnter your choice: ");
			try {
				choice = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid selection. Numbers only please.");
			}
			if (choice < 1 || choice > 3) {
				System.out.println("Choice outside of range. Please chose again.");
			}
		} while (choice < 1 || choice > 3);
		return choice;
	}
	
	private int getSubMenuChoice() {											// return user's choice
		int choice = -1;
		do {
			printSubMenu();
			
			System.out.print("\nEnter your sub choice: ");
			try {
				choice = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid selection. Numbers only please.");
			}
			if (choice < 1 || choice > 4) {
				System.out.println("Choice outside of range. Please chose again.");
			}
		} while (choice < 1 || choice > 4);
		return choice;
	}
	
	private static void listFiles(String directory) throws IOException {			// list files in directory
		File dir = new File(directory);
		File[] filesList = dir.listFiles();
	
		if (dir.exists()) {
			System.out.println("> Current files in directory: ");
			Arrays.sort(filesList);													// files in ascending order
			for(File f: filesList) 
				if (f.getName().charAt(0) != '.')									// don't list ".*" files
					System.out.println(f.getName());
		} else
			System.out.println("> dir Does Not exist.");
	}
	
	private static void addFile(String directory) throws IOException {				// add a file
		File dir = new File(directory);												
		
		System.out.println("> Please enter a file name: " );
		File file = new File(dir, input.nextLine());
		
		try {
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName() + "\n");
			} else {
				System.out.println("File already exists.\n");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.\n");
			e.printStackTrace();
		}
	}
	
	private static void deleteFile(String directory) throws IOException {			// delete a file
		File dir = new File(directory);													
		
		System.out.println("> Please enter file name to be deleted: " );
		File file = new File(dir, input.nextLine());
		
		if(file.delete()) 
			System.out.println("  >> file deleted successfully!");
		else
			System.out.println("  >> delete fail, file not found.");
	}
	
	private static void searchFile(String directory) throws IOException {			// search a file
		File dir = new File(directory);													
		
		System.out.println("> Please enter file name to be searched: " );
		String name = input.nextLine();
		
		File[] list = dir.listFiles();
		if (list != null) {
			for (int i=0; i < list.length; i++) {
				if (name.equals(list[i].getName())) {
					System.out.println("> found file: " + name);
					break;
				} else if (!name.equals(list[i].getName()) && i == list.length-1) 
							System.out.println("> file " + name + " is not found.");
			}
		}
	}
	
	private void performMainAction(int choice) throws IOException {						// perform the choices
		switch (choice) {
			case 1: listFiles(dirPath)    ; break;
			case 2: performSubAction()    ; break;
			case 3: System.out.println("Thank you and good bye.");
				    System.exit(0);
				    break;
			default: System.out.println("\nUnknown error has occured.\n");
		}
	}
	
	private void performSubAction() throws IOException {						// perform the choices
										
		boolean done = false;
		
		while (!done) {			
			switch (getSubMenuChoice()) {										// subChoices are from 1-4
				case 1: addFile(dirPath); break;
				case 2: deleteFile(dirPath); break;
				case 3: searchFile(dirPath); break;
				case 4: { System.out.println("> Back to Main Menu");
					      done = true; 
					      break;
						}
				default: System.out.println("\nUnknown error has occured.\n");
			}
		}//while
	}

}//Repo