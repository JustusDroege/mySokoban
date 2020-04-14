import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader tastaturInput = new BufferedReader(new InputStreamReader(System.in));
		Level lvl1 = new Level("lvl1.txt");
		Player player = lvl1.getPlayer();
		lvl1.drawLevel();
		Figures[][] map = lvl1.getFigures();
		
		while(true) {
			
			player.move((char)tastaturInput.read(),map);
			lvl1.drawLevel();
			
		}
	}
}
