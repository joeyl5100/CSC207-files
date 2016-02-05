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
			WordGenerator wordGen = new WordGenerator(args[0]);
		    DrawingPanel panel = new DrawingPanel(width, height);
		    Graphics g = panel.getGraphics();
		    Font f = new Font("Courier", Font.BOLD, Integer.parseInt(args[3]));
		    g.setFont(f);
		    g.setColor(Color.blue);
		    while(wordGen.hasNext()){
			    g.clearRect(0,0,width,height);
			    g.drawString(wordGen.next(), 50, 50);
			    Thread.sleep(MsecPerWord);
		    }
			System.out.println("Word count: " + wordGen.getWordCount());
			System.out.println("Word count: " + wordGen.getSentenceCount());
		}
	}

}
