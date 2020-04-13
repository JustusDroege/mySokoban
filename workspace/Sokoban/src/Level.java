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
		
		level = new Figures[tiles.length][tiles[0].length];
		
		for(int i = 0; i < tiles.length; i++){
			
			//Erste Spalte mit Wall auff�llen
			for (int a = 0; a< tiles.length; a++) {
				if (tiles [a][0] == ' ') {
					tiles[a][0] = '#';
				}
			}
			
		
			//Letzte Reihe mit Wall auff�llen
			for (int b = 0; b< tiles[0].length; b++) {
				if (tiles [tiles.length-1][b] == ' ') {
				tiles[tiles.length-1][b] = '#';
				}
			}
			
	    	for(int j = 0; j< tiles[i].length; j++){
	    		switch(tiles[i][j]) {
	    		case ('@'):
	    			level[i][j] = new Player(new Position(i,j)); 
	    			break;
	    		case('#'):
	    			level[i][j] = new Wall(new Position(i,j)); 
	    			break;
	    		case('$'):
	    			level[i][j] = new Box(new Position(i,j)); 
	    			break;
	    		case('.'):
	    			level[i][j] = new TargetLocation(new Position(i,j)); 
	    			break;
	    		case(' '):
	    			level[i][j] = new Field(new Position(i,j)); 
	    			break;
	    		default:
	    			level[i][j] = new Wall(new Position(i,j)); 
	    		}
	    	}
	    }
		
	}
	

	public void drawLevelObjects() {
		//Auf Basis der Figuren mit Koordinaten
		for(int i = 0; i < tiles.length; i++){
	    	for(int j = 0; j< tiles[i].length; j++){
	    		System.out.print(level[i][j].getSign());
	    		if (j == tiles[i].length-1) {
	    			System.out.println();
	    		}
	    	}
		}
		
	}

	public void drawLevelTiles() {
		//Auf Basis des Tilesets statisch!!!!!!!!!
		for(int i = 0; i < tiles.length; i++){
	    	for(int j = 0; j< tiles[i].length; j++){
	    		System.out.print(tiles[i][j]);
	    		if (j == tiles[i].length-1) {
	    			System.out.println();
	    		}
	    	}
		}
	}
}
