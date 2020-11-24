package simplilearn;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

	public static void main(String[] args) {
		
		String searchId = "username@yahoo.corporate.in";		//user's search email defined
		
		ArrayList<String> inArr = new ArrayList<>(); 	//create a list of email
		inArr.add("user@domain.com");
		inArr.add("user@domain.co.in");
		inArr.add("user.name@domain.com");
		inArr.add("user_name@domain.com");
		inArr.add("username@yahoo.corporate.in");
			
		for (String str: inArr)							//print out email list
			System.out.println(str);		
		System.out.println("-------");
		
		if (searchEmail(inArr, searchId) != null) { 		//search and validate email
			System.out.print("found: " + searchId);
			if (validate(searchId)) 
				System.out.println(", valid");
			else
				System.out.println("not valid");
		}	
	}//main()	

	public static String searchEmail(ArrayList<String> strArr, String id) {
		for (String s: strArr) {
			System.out.println(s);
			if (s.equals(id)) 
				return id;
		}	
		return null;
	}
	
    public static boolean validate (String email) {
    	String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"; 	//java email validation permitted by
    																			//  RFC 5322
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(email);
    	return matcher.matches();
    }	
    
}//Email