package wongandrew_hangman;

import java.util.Scanner;

public class Main {
	
	// Global Scanner
	private static Scanner scanner = new Scanner(System.in);
	
	// Main
	public static void main(String[] args) {
		boolean endGame = false;
		while (endGame == false) {
			String word;
			int pathway = initializeStartup();
			if (pathway == 1) {
				boolean validWord = false;
				while (validWord == false) {
					System.out.print("Enter a word for someone to guess: ");
					word = scanner.nextLine();
					System.out.println();
					if (validateString(word))
						validWord = true;
					else
						System.out.println("Invalid word, please only use alphabetical characters.\n");
				}
			}
		}
	}
	
	// Set up how the game will choose a word
	private static int initializeStartup() {
		// Introduce the Game and the purpose
		System.out.println("Welcome to Hangman!");
		System.out.println("Coded in Java in a 60 minute challenge by Andrew Wong.\n");
		
		// Prompt for a word or to read a word bank
		System.out.println("Would you like to");
		System.out.println("\t1) Suggest a word");
		System.out.println("\t2) Be assigned a random word from our word bank");
		System.out.println("\t3) Be assigned a random word from a word bank you supply");
		
		// Retrieve the user's option and validate it
		boolean validChoice = false;
		
		// Ask for a valid choice until they give one
		while (validChoice == false) {
			System.out.print("My choice is to: ");
			String choice = scanner.nextLine();
			System.out.println();
			
			if (isNumber(choice)) {
				int choiceInt = Integer.parseInt(choice);
				if (choiceInt > 0 && choiceInt < 4) {
					validChoice = true;
					return choiceInt;
				}
				else {
					System.out.println(choice + " is an invalid choice! Please enter a valid one.\n");
				}
			}
			else {
				System.out.println(choice + " is an invalid choice! Please enter a valid one.\n");
			}
		}
		
		return -1;
	}
	
	// Function that checks if a String is an integer
    private static boolean isNumber(String s) 
    { 
        for (int i = 0; i < s.length(); ++i) 
        	if (Character.isDigit(s.charAt(i)) == false) 
        		return false; 
        return true; 
    }

    // Function that checks if a String only contains alphabetical characters
    private static boolean validateString(String str) {
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
           char ch = charArray[i];
           if (!(ch >= 'a' && ch <= 'z')) {
              return false;
           }
        }
        return true;
     }
}
