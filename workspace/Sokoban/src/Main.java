import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException{
		Level lvl1 = new Level("sokoban.txt");
		System.out.println("Ausgabe der Zeichen:");
		lvl1.drawLevelTiles();
		System.out.println("");
		System.out.println("Ausgabe der Zeichen mit Koordinaten:");
		lvl1.drawLevelObjects();
	}

}
