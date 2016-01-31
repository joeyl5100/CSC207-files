import java.util.Scanner;

public class VigenereCipher {

	// Encrypts string parameter using key	
	public static void encrypt(String str, String key){
		char[] charArray = str.toCharArray();
		int base = (int) 'a';
		int keyAddTo, charToInt;
			for(int i = 0; i < charArray.length; i++){
				keyAddTo = (int)(key.charAt(i % key.length())) - base;
				charToInt = ((int)str.charAt(i) - base);
				charArray[i] = (char)(((charToInt + keyAddTo) % 26) + base);
			}
			System.out.println("Encoded string: " + new String(charArray));
	}

	// Decrypts string parameter using key
	public static void decrypt(String str, String key){
		char[] charArray = str.toCharArray();
		int base = (int) 'a';
		int keySubtractBy, charToInt;
			for(int i = 0; i < charArray.length; i++){
				keySubtractBy = (int)(key.charAt(i % key.length())) - base;
				charToInt = ((int)str.charAt(i) - base);
				charArray[i] = (char)((((charToInt - keySubtractBy) + 26) % 26) + base);
			}
			System.out.println("Encoded string: " + new String(charArray));
	}
	
	//Encode or Decode strings using Vigenere Cipher
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//User prompt
		System.out.println("This program encrypts and decrypts messages using " +
				"the Vigenere Cipher.");
		System.out.println("Would you like to encode or decode a message?");
		String response = scan.nextLine();
		
		while(!(response.equals("encode") || response.equals("decode"))){
			System.out.println("Valid options are \"encode\" or \"decode\"");
			response = scan.nextLine();
		}
		
		if(response.equals("encode")){
			System.out.println("Enter the string to encode:");
			response = scan.nextLine();
			System.out.println("Enter the key:");
			encrypt(response, scan.nextLine());
		}
		else{
			System.out.println("Enter the string to decode:");
			response = scan.nextLine();
			System.out.println("Enter the key:");
			decrypt(response, scan.nextLine());
		}
			
		scan.close();
	}

}