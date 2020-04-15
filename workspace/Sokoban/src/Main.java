import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader tastaturInput = new BufferedReader(new InputStreamReader(System.in));
		Level lvl = new Level("lvl2.txt");
		Player player = lvl.getPlayer();
		lvl.drawLevel();
		
		
		while(true) {
			
			player.move((char)tastaturInput.read(),lvl);
			lvl.drawLevel();
			if (lvl.checkWin() == true) {
				System.out.println("Gewonnen mit " + lvl.getSteps() + " Steps!");
				break;
			}
			
		}
	}
}
