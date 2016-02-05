import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordGenerator {
	public int wordCount;
	public int sentenceCount;
	Scanner text;
	public WordGenerator(String filename) throws IOException{
		text = new Scanner(new File(filename));
		this.wordCount = 0;
		this.sentenceCount = 0;
	}
	
	public boolean hasNext(){
		return text.hasNext();
	}
	
	public String next(){
		this.wordCount ++;
		String str = text.next();
		if (str.contains(".") || str.contains("!") || str.contains("?")){
			sentenceCount++;
		}
		return str;
	}
	
	public int getWordCount(){
		return wordCount;
	}

	public int getSentenceCount(){
		return sentenceCount;
	}
}