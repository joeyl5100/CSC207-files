import java.util.Scanner;

public class CaesarCipher {

	
	public static void encrypt(String str){

	}
	
	public static void decrypt(String str){
	
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
			encrypt(response);
		}
		else{
			System.out.println("Enter the string to decode:");
			response = scan.nextLine();
			decrypt(response);
		}
			
		scan.close();
	}

}
