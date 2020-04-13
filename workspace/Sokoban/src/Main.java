import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException{
		Level lvl1 = new Level("lvl2.txt");
		System.out.println("Input");
		lvl1.drawLevelTiles();
		System.out.println("");
		System.out.println("Output");
		lvl1.drawLevelObjects();
	}
}
