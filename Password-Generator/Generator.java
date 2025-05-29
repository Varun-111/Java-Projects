package com.varun2pwd;

import java.util.Scanner;
public class Generator {
	Alphabet alphabet;
	public static Scanner keyboard;
	
	public Generator(Scanner sc) {
		keyboard = sc;
	}
	
	public Generator(boolean Includeupper, boolean Includelower, boolean Includenum, boolean Includesym) {
		alphabet = new Alphabet(Includeupper, Includelower, Includenum, Includesym);
	}
	
	public void mainloop() {
		System.out.println("Welcome to Varun password services. ");
		printMenu();
		
		String userOption = "-1";
		
		while (!userOption.equals("4")) {
			userOption = keyboard.next();
			
			switch(userOption) {
				case "1" -> {
					requestPassword();
					printMenu();
				}
			
				case "2" -> {
					checkPassword();
					printMenu();
				}
				case "3" -> {
					printUsefulInfo();
					printMenu();
				}
				case "4" -> printQuitMessage();
				default -> {
					System.out.println();
					System.out.println("Kindly select one of the available commands: ");
					printMenu();
				}
			}
		}
	}
	
	private Password GeneratePassword(int length) {
		final StringBuilder pass = new StringBuilder("");
		
		final int alphabetlength = alphabet.getAlphabet().length();
		
		int max = alphabetlength - 1;
		int min = 0;
		
		int range = max - min + 1;
		
		for(int i=0;i< length;i++) {
			int index = (int)(Math.random() * range) + min;
			pass.append(alphabet.getAlphabet().charAt(index));
		}
		
		return new Password(pass.toString());
	}
	
	private void printUsefulInfo() {
		System.out.println();
		System.out.println("Use a minimum password length of 8 or more characters if permitted");
		System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
		System.out.println("Generate passwords randomly	where feasible");
		System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems.");
		System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," + "\n usernames, "
				+ "relative or pet names, romantic links(current or past) " + "and biological information (e.g., IDnumbers, ancestors names or dates.");
		System.out.println("Avoid using information that the user's colleagues and/or "+ "acquiantances might know to be associated with the user");
		System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
		
	}
	
	private void requestPassword() {
		boolean Includeupper = false;
		boolean Includelower = false;
		boolean Includenum = false;
		boolean Includesym = false;
		
		boolean correctParams;
		System.out.println();
		System.out.println("Hello , welcome to the Password Generator :) answer " + "the following questions by Yes or No \n");
		
		do {
			String input;
			correctParams = false;
			
			do {
				System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
				input = keyboard.next();
				PasswordRequestError(input);
			}while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
			
			if (isInclude(input)) Includelower = true;
			
			do {
				System.out.println("Do you want Uppercase letter \"ABCD...\" to be used? ");
				input = keyboard.next();
				PasswordRequestError(input);
			} while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
			
			if(isInclude(input)) Includeupper = true;
			
			do {
				System.out.println("Do you want numbers \"1234....\" to be used?");
				input = keyboard.next();
				PasswordRequestError(input);

			} while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
			
			if(isInclude(input)) Includenum = true;
			
			do {
				System.out.println("Do you want symbols \"!@#$...\" to be used? ");
				input = keyboard.next();
				PasswordRequestError(input);
			}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
			
			if (isInclude(input)) Includesym = true;
			
			//No pool selected.
			
			if(!Includeupper && !Includelower && !Includenum && !Includesym) {
				System.out.println("You have selected no characters to generate your "+ "password, atleast one of your answers should be Yes\n");
				correctParams = true;
			}
		} while(correctParams);
		
		System.out.println("Great! Now enter the length of the password");
		int length = keyboard.nextInt();
		
		final Generator generator = new Generator(Includeupper, Includelower, Includenum, Includesym);
		final Password password = generator.GeneratePassword(length);
		
		System.err.println("Your Generated password -> "+password);
	}
	private boolean isInclude(String input) {
		if (input.equalsIgnoreCase("yes")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private void PasswordRequestError(String i) {
		if(!i.equalsIgnoreCase("yes") && !i.equalsIgnoreCase("no")) {
			System.out.println("You have entered something incorrect let's go over it again.");
		}
	}
	
	private void checkPassword() {
		String input;
		System.out.println("\n Enter your password:");
		input = keyboard.next();
		final Password p = new Password(input);
		
		System.out.println(p.calculateScore());
	}
	
	private void printMenu() {
		System.out.println();
		System.out.println("Enter 1 - Password Generator");
		System.out.println("Enter 2 - Password Strength Check");
		System.out.println("Enter 3 - Useful Information");
		System.out.println("Enter 4 - quit");
		System.out.println("Choice:");
	}
	
	private void printQuitMessage() {
		System.out.println("Closing the program bye ....");
	}
}
