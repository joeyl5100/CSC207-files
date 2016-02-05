import java.awt.*;
import java.io.IOException;

public class SpeedReader {

	public static void main(String[] args) throws IOException, InterruptedException{
		if(args.length != 5){
			System.out.println("Error, incorrect arguments given");
		}
		else{
			int wpm = Integer.parseInt(args[4]);
			int MsecPerWord = 60000 / wpm;
			int width = Integer.parseInt(args[1]);
			int height = Integer.parseInt(args[2]);
			int stringWidth;
			int stringHeight;
			String word;
			WordGenerator wordGen = new WordGenerator(args[0]);
		    DrawingPanel panel = new DrawingPanel(width, height);
		    Graphics g = panel.getGraphics();
		    Font f = new Font("Courier", Font.BOLD, Integer.parseInt(args[3]));
		    g.setFont(f);
		    while(wordGen.hasNext()){
		    	word = wordGen.next();
			    stringWidth = (width / 2) - (g.getFontMetrics().stringWidth(word) / 2);
			    stringHeight = (height / 2) + 10;
			    g.drawString(word, stringWidth, stringHeight);
			    Thread.sleep(MsecPerWord);
		    	panel.clear();
		    }
			System.out.println("Word count: " + wordGen.getWordCount());
			System.out.println("Sentence count: " + wordGen.getSentenceCount());
		}
	}
}
