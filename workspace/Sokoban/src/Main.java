import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException{
		Level lvl1 = new Level("sokoban.txt");
		System.out.println("Ausgabe des char Arrays:");
		lvl1.drawLevelTiles();
		System.out.println("Ausgabe der chars der Figuren Objekte:");
		lvl1.drawLevelObjects();
	}

}
