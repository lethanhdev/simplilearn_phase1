package selfLearning;

import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

public class Email {

	public static void main(String[] args) {
		
		System.out.print("Please Enter a string: ");
		Scanner scanner = new Scanner(System.in);
		String email = "";
		
		String[] strArr = scanner.nextLine().split(" "); //get input from user
		scanner.close();
				
		for (String str: strArr) {		//get the string with email address
           if (str.contains("@")) {
        	   email = str;
        	   break;
           }
		}
		
        System.out.println(email);
           
		//validate email address
/*		String regex = "^(.+)@(.+)$";
		Pattern patter = Pattern.compile(regex);
		Matcher matcher = Pattern.matcher(email);*/
		
	}
}
