import java.io.IOException;

public class Level {
	
	
	private TileSetReader map;
	private char[][] tiles;
	private Figures[][] level;
	private int steps;
	private boolean playerOnGoal = false;
	private Figures goalContainer;
	private int goals;
	private int achievedGoals = 0;
	
	public Level(String field) throws IOException  {
		this.map = new TileSetReader(field);
		this.tiles = map.getMapArray(field);
		this.setSteps(0);
		setFigures();
		this.getGoals();
	}
	
	public void setFigures() {
		
		level = new Figures[tiles.length][tiles[0].length];
		
		for(int i = 0; i < tiles.length; i++){
			
			//Erste Spalte mit Wall auffüllen
			for (int a = 0; a< tiles.length; a++) {
				if (tiles [a][0] == ' ') {
					tiles[a][0] = '#';
				}
			}
			
		
			//Letzte Reihe mit Wall auffüllen
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
	public Figures[][] getFigures() {
		return level;
	}
	public Player getPlayer() {
		Player player = null;
		for(int i = 0; i < level.length; i++){
			for(int j = 0; j< level[i].length; j++){
				if(level[i][j].getSign() == '@'){
					player = (Player) level[i][j];
				}
			}
		}
		return player;
		
	}
	
	public void drawLevel() {
		
		for (int i = 0; i<30; i++) {
		       System.out.print('\n');
		    }
		
		System.out.println("Steps: " + steps);

		//Auf Basis der Figuren mit Koordinaten
		for(int i = 0; i < tiles.length; i++){
	    	for(int j = 0; j< tiles[i].length; j++){
	    		System.out.print(level[i][j].getSign());
	    		if (j == tiles[i].length-1) {
	    			System.out.println();
	    		}
	    	}
		}
		
		System.out.println("Targets: "+ this.achievedGoals + "/"  + this.goals);
		
		
	}
	
	public boolean checkWin() {
		if (this.goals == this.achievedGoals) {
			return true;
		}
		return false;
	}
	
	
	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = this.steps + steps;
	}

	public boolean isPlayerOnGoal() {
		return playerOnGoal;
	}

	public void setPlayerOnGoal(boolean playerOnGoal) {
		this.playerOnGoal = playerOnGoal;
	}

	public Figures getGoalContainer() {
		return goalContainer;
	}

	public void setGoalContainer(Figures goalContainer) {
		this.goalContainer = goalContainer;
	}

	public int getAchievedGoals() {
		return achievedGoals;
	}

	public void setAchievedGoals() {
		this.achievedGoals = this.achievedGoals + 1;
	}
	
	

	public void getGoals() {
		int goals = 0;
		for(int i = 0; i < tiles.length; i++){
	    	for(int j = 0; j< tiles[i].length; j++){
	    		if (level[i][j].getSign() == '.') {
	    			goals = goals + 1;
	    		}
	    	}
		}
		this.goals = goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}
	
    /*
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
	
	*/
}
