package simplilearn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileHandling {

	final File f = new File("/Users/thanhle/simplilearn/phase1/selfLearning/section6/src/simplilearn/_test4.txt");
	static Scanner input = new Scanner(System.in);
	
	boolean exit;

	public static void main(String[] args) throws IOException {
		FileHandling menu = new FileHandling();
		menu.runMenu();
	}//main()

	public void runMenu() throws IOException {  		// looping thru the file operations
		printHeader();
		while (!exit) {
			printMenu();
			int choice = getMenuChoice();
			performAction(choice);
		}
		input.close();
	}

	private void printHeader() {								//print the header
		System.out.println("+---------------------------+");
		System.out.println("|  Menu: File Handling      |");
		System.out.println("+---------------------------+");
	}

	private void printMenu() {									//print the menu options
		System.out.println();
		System.out.println("1) Create a new File");
		System.out.println("2) Read to File");
		System.out.println("3) Write to File");
		System.out.println("4) Append to File");
		System.out.println("0) Exit");
	}

	private int getMenuChoice() {								// return user's choice
		int choice = -1;
		do {
			System.out.print("\nEnter your choice: ");
			try {
				choice = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid selection. Numbers only please.");
			}
			if (choice < 0 || choice > 4) {
				System.out.println("Choice outside of range. Please chose again.");
			}
		} while (choice < 0 || choice > 4);
		return choice;
	}
	
	private static void createFile(File file) throws IOException {		// create a file
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
	
	private static void readFile(File file) throws IOException {		// read from the file
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str;
		while ((str = br.readLine()) != null) 
			System.out.println(str);
		br.close();
	}
	
	private static void writeFile(File file) throws IOException {		// write to the file
	    try {
	        FileWriter myWriter = new FileWriter(file);
	        System.out.println("Enter your text to write to file: ");
	        myWriter.write(input.nextLine());
	        myWriter.close();
	        System.out.println("Successfully wrote to the file.");
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	}
	
	private static void appendFile(File file) throws IOException {		//append to the file
		FileWriter writer = new FileWriter(file, true);
		System.out.print("append your text here: ");
		writer.write(input.nextLine());
		writer.close();		
	}

	private void performAction(int choice) throws IOException {			// perform the choices
		switch (choice) {
		case 0:
			System.out.println("Good Bye.");
			System.exit(0);
			break;
		case 1: createFile(f); break;
		case 2: readFile(f); break;
		case 3: writeFile(f); break;
		case 4: appendFile(f); break;
		default: System.out.println("\nUnknown error has occured.\n");
		}
	}

}//FileHandling