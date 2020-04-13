import java.io.IOException;

public class Level {
	
	//private Figures[][] level;
	private TileSetReader map;
	private char[][] tiles;
	private Figures[][] level;
	
	public Level(String field) throws IOException  {
		this.map = new TileSetReader(field);
		this.tiles = map.getMapArray(field);
		//this.level = level;
		setFigures();
	}
	
	
	public void setFigures() {
		
		level = new Figures[tiles.length][tiles.length];
		
		for(int i = 0; i < tiles.length; i++){
	    	for(int j = 0; j< tiles[i].length; j++){
	    		if (tiles[i][j] == '@') {
	    			level[i][j] = new Player(new Position(i,j)); 
	    		}
	    		else if (tiles[i][j] == '#') {
	    			level[i][j] = new Wall(new Position(i,j)); 
	    		}
	    		else if (tiles[i][j] == '$') {
	    			level[i][j] = new Box(new Position(i,j)); 
	    		}
	    		else if (tiles[i][j] == '.') {
	    			level[i][j] = new TargetLocation(new Position(i,j)); 
	    		}
	    		else {
	    		level[i][j] = new Field(new Position(i,j)); 
	    		}
	    		
	    	}
	    }
	}
	

	public void drawLevelObjects() {
		//Auf Basis der Figuren mit Koordinaten
		for(int i = 0; i < tiles.length; i++){
	    	for(int j = 0; j< tiles[i].length; j++){
	    		System.out.print(level[i][j].getPosition().getX()+ "." + level[i][j].getPosition().getY()+"=");
	    		System.out.print(level[i][j].getSign() + " ");
	    		if (j == tiles.length-1) {
	    			System.out.println("");
	    		}
	    	}
		}
		
	}

	public void drawLevelTiles() {
		//Auf Basis des Tilesets statisch!!!!!!!!!
		for(int i = 0; i < tiles.length; i++){
	    	for(int j = 0; j< tiles[i].length; j++){
	    		System.out.print(tiles[i][j]);
	    		if (j == tiles.length-1) {
	    			System.out.println("");
	    		}
	    	}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException{
		
	}


 
	
}
