import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordGenerator {
	private int wordCount;
	private int sentenceCount;
	Scanner text;
	
	/**
	 * Constructor of WordGenerator, initializing values and Scanner
	 * to read file parameter
	 * 
	 * @param filename (with extensions) of the new input of Scanner 
	 * @throws IOException if Scanner cannot connect to file
	 */
	public WordGenerator(String filename) throws IOException{
		text = new Scanner(new File(filename));
		this.wordCount = 0;
		this.sentenceCount = 0;
	}
	/**
	 * Check to see if Scanner has another token to read
	 * 
	 * @return true if there is another token, otherwise returns false
	 */
	public boolean hasNext(){
		return text.hasNext();
	}
	/**
	 * Returns next token and updates word count and sentence count
	 * 
	 * @return the next String token from Scanner
	 */
	public String next(){
		this.wordCount ++;
		String str = text.next();
		if (str.contains(".") || str.contains("!") || str.contains("?")){
			sentenceCount++;
		}
		return str;
	}
	
	/**
	 * Returns word count
	 * 
	 * @return number of words read
	 */
	public int getWordCount(){
		return wordCount;
	}

	/**
	 * Returns sentence count
	 * 
	 * @return number of sentences (that end in '.', '?', or '!')
	 */
	public int getSentenceCount(){
		return sentenceCount;
	}
}