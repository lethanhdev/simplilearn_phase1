package selfLearning;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		int num1, num2, result = 0;
		String op;

		Scanner s = new Scanner(System.in);
		
		System.out.print("please enter your first number: ");	
		num1 = s.nextInt();		
		System.out.print("Please enter your second number: ");
		num2 = s.nextInt();
		System.out.print("Please enter your operator: ");
		op = s.next();		
		s.close();
		
		switch (op) {
			case ("+"): result = num1 + num2; break;
			case ("-"): result = num1 - num2; break;
			case ("*"): result = num1 * num2; break;
			case ("/"): result = num1 / num2; break;
			default: ;
		}		
		//System.out.println("The result = " + result);
		System.out.print("calculation: " + num1 + " " + op + " " + num2 + " = " + (double) result);
	}
}