import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class SpeedReader {
	public static final int MILLISEC_PER_MINUTE = 60000;

	/**
	 * Instantiates a word generator and drawing panel to display words from file 
	 * at a specified speed in a customized panel and font size
	 * 
	 * @param args takes filename, width, height, font size, and wpm in that order
	 * @throws IOException if file from command-line cannot be found
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException{
		if(args.length != 5){
			System.out.println("Error, incorrect arguments given");
		}
		else{
			int wpm = Integer.parseInt(args[4]);
			int msecPerWord =  MILLISEC_PER_MINUTE / wpm;
			int width = Integer.parseInt(args[1]);
			int height = Integer.parseInt(args[2]);
			String word;
			WordGenerator wordGen = new WordGenerator(args[0]);
		    DrawingPanel panel = new DrawingPanel(width, height);
		    Graphics g = panel.getGraphics();
		    Font f = new Font("Courier", Font.BOLD, Integer.parseInt(args[3]));
		    g.setFont(f);
		    while(wordGen.hasNext()){
		    	word = wordGen.next();
			    int stringWidth = (width / 2) - (g.getFontMetrics().stringWidth(word) / 2); //Center text to window
			    int stringHeight = (height / 2) + (f.getSize() / 4);			    
			    g.drawString(word, stringWidth, stringHeight);
			    Thread.sleep(msecPerWord);
		    	panel.clear();
		    }
			System.out.println("Word count: " + wordGen.getWordCount());
			System.out.println("Sentence count: " + wordGen.getSentenceCount());
		}
	}
}
