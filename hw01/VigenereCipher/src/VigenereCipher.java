import java.util.Scanner;

public class VigenereCipher {

	
	public static void encrypt(String str, String key){
		char[] charArray = str.toCharArray();
		int base = (int) 'a';
			for(int i = 0; i < charArray.length; i++){
				int addTo = (int)(key.charAt(i % key.length())) - base;
				charArray[i] = (char)(((((int)str.charAt(i) - base) + addTo) % 26) + base);
			}
			System.out.println("Encoded string: " + new String(charArray));
	}
	
	public static void decrypt(String str, String key){
		char[] charArray = str.toCharArray();
		int base = (int) 'a';
			for(int i = 0; i < charArray.length; i++){
				int subtractBy = (int)(key.charAt(i % key.length())) - base;
				charArray[i] = (char)((((((int)str.charAt(i) - base) - subtractBy) + 26) % 26) + base);
			}
			System.out.println("Encoded string: " + new String(charArray));
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("This program encrypts and decrypts messages using " +
				"the Caesar Cipher.");
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