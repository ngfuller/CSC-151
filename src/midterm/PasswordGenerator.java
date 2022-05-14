package midterm;

import java.util.Scanner;
import java.util.Random;

/**
 * CSC-151 Spring 2022 Midterm Part II.
 * 
 * @version 2.1
 */
public class PasswordGenerator {
	/**
	 * Special Characters
	 * 
	 * @return Returns an array of chars containing all valid special characters
	 */
	public static char[] getSpecialCharacters() {
		final char[] SPECIAL_CHARS = {'!', '@', '#', '_', '.', '*'};
		return SPECIAL_CHARS;
	}
	
	/**
	 * Valid password characters
	 * 
	 * @return Returns String containing all valid password characters
	 */
	public static final String getValidPasswordCharacters() {
		final String PASSWORD_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		return PASSWORD_CHARS;
	}
	
	/**
	 * @return Returns a single String of 140 four-letter words that can be used in a password.
	 */
	public static final String getAllFourLetterWords() {
		final String FOUR_LETTER_WORDS = 
			"able bane barn bile blip boat bolt bran brat brim bulb "+
			"bull burn cane card cart clan clip cold cone core dart "+
			"deny dial dang dirk dolt door dote drip drop dupe each "+
			"earn easy fast fest file five flap flip flop foal folk "+
			"fort four full gave give gone grin hard hurt idle isle "+
			"join king knit knob land lane lard link list live long "+
			"lung made main many mile mine moat mole mote mule nine "+
			"norm note paid part pick pile ping pipe plan pole pong "+
			"port prim pull quid quip quit rain rang redo ring ripe "+
			"role root rote rung sand sang silk sing sink slam slow "+
			"song sort spam sulk take tame tang tide tile time tint "+
			"toll tone took tote trap trip turn undo vile volt vote "+
			"wart wing woke wool wore writ zero zoom";
		return FOUR_LETTER_WORDS;
	}
	
	/**
	 * Create a password
	 * 
	 * @return Returns a password meeting all of the specifications
	 */
	public static String createPassword() {
		//**********MY CODE START**********//
		String password = "";
		
		Random r = new Random();
		
		// Bounds of substring
		int wordMin = r.nextInt(139 - 5) * 5;
		int wordMax = wordMin + 4;
		
		int specialChar = r.nextInt(5);
		int twoNum = r.nextInt(99);
		int validChar = 0;
		
		// Add random four letter word
		password += getAllFourLetterWords().substring(wordMin, wordMax);
		
		// Add random special character
		password += getSpecialCharacters()[specialChar];
		
		// Add leading zero to single digit twoNum values
		if (twoNum < 10)
			password += "0" + twoNum;
		else
			password += twoNum;
		
		// Select five random characters from getValidPasswordCharacters()
		for (int i = 0; i < 5; i++) {
			validChar = r.nextInt(getValidPasswordCharacters().length());
			password += getValidPasswordCharacters().charAt(validChar);
		}
		
		return password;
		//**********MY CODE END**********//
	}
	
	/**
	 * @return Returns true if this password is unique to the list of generated passwords.
	 */
	//**********MY CODE START**********//
	public static boolean isPasswordUnique(String password, String uniquePasswords) {
		return !uniquePasswords.contains(password);
	}
	//**********MY CODE END**********//
	
	/**
	 * Add aPassword to the list of unique passwords
	 * 
	 * @param aPassword: The password to add
	 * @param passwordList: A string containing all unique passwords, separated by spaces
	 * @return Returns updated passwordList with the new password
	 */
	public static String addUniquePassword(String aPassword, String passwordList) {
		//**********MY CODE START**********//
		return passwordList + aPassword + " ";
		//**********MY CODE END**********//
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("How many passwords do you want to generate? ");
		int numPasswords = scanner.nextInt();
		scanner.close();
		
		String uniquePasswords = "";
		
		//**********MY CODE START**********//
		String temp = "";
		
		for (int i = 0; i < numPasswords; i++) {
			temp = createPassword();
			
			if (isPasswordUnique(temp, uniquePasswords))
				uniquePasswords = addUniquePassword(temp, uniquePasswords);
			else
				i--;
		}
		
		// Print one password per line
		for (int n = 0, j = 1; n < uniquePasswords.length(); n += 13, j++) {
			if (j < 10)
				System.out.print("0");
			
			System.out.println(j + ": " + uniquePasswords.substring(n, n + 12));
		}
		//**********MY CODE END**********//
	}
}
