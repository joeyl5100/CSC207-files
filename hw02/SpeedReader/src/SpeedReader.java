import java.awt.*;
import java.io.IOException;

public class SpeedReader {
	public static final int MILLISEC_PER_MINUTE = 60000;

	/**
	 * Instantiates a word generator and drawing panel to display words 
	 *    focusing on the "focus letter" in red from a file at a specified 
	 *    speed in a customized panel and font size
	 * 
	 * @param args
	 *            takes filename, width, height, font size, and wpm in that
	 *            order
	 * @throws IOException
	 *             if file from command-line cannot be found
	 * @throws InterruptedException
	 * 			   if the thread interrupts the current thread
	 */
	public static void main(String[] args) throws IOException,
			InterruptedException {
		if (args.length != 5) {
			System.out.println("Error, incorrect arguments given");
		} else {
			// Instantiate variables with given command line arguments
			int wpm = Integer.parseInt(args[4]);
			int msecPerWord = MILLISEC_PER_MINUTE / wpm;
			int width = Integer.parseInt(args[1]);
			int height = Integer.parseInt(args[2]);
			String word;
			WordGenerator wordGen = new WordGenerator(args[0]);
			DrawingPanel panel = new DrawingPanel(width, height);
			Graphics g = panel.getGraphics();
			Font f = new Font("Courier", Font.BOLD, Integer.parseInt(args[3]));
			g.setFont(f);
			while (wordGen.hasNext()) {
				word = wordGen.next();
				int stringWidth;
				String letter;
				
				// Center the string around focus letter
				if (word.length() <= 1) {
					stringWidth = (width / 4);
					letter = word;
				} else if (word.length() <= 5) {
					stringWidth = (width / 4)
							- (g.getFontMetrics().stringWidth(word.substring(0,1)));
					letter = word.substring(1,2);
				} else if (word.length() <= 9) {
					stringWidth = (width / 4)
							- (g.getFontMetrics().stringWidth(word.substring(0,2)));
					letter = word.substring(2,3);
				} else if (word.length() <= 13) {
					stringWidth = (width / 4)
							- (g.getFontMetrics().stringWidth(word.substring(0,3)));
					letter = word.substring(3,4);
				} else {
					stringWidth = (width / 4)
							- (g.getFontMetrics().stringWidth(word.substring(0,4)));
					letter = word.substring(4,5);
				}

				int stringHeight = (height / 2) + (f.getSize() / 4);
				g.drawString(word, stringWidth, stringHeight);
				g.setColor(Color.red);
				g.drawString(letter, (width / 4), stringHeight);
				g.setColor(Color.black);
				Thread.sleep(msecPerWord);
				panel.clear();
			}
			System.out.println("Word count: " + wordGen.getWordCount());
			System.out.println("Sentence count: " + wordGen.getSentenceCount());
		}
	}
}
