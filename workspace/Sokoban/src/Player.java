public class Player extends Figures {

	Player(Position position) {
		super(position, '@');
	}
	
	public void move(char direction,Level level) {
		
		switch(direction) {
		
			case('w'):
				this.checkCollision(level, -1, 0);
				break;
			case('a'):
				this.checkCollision(level, 0, -1);
				break;
			case('s'):
				this.checkCollision(level, 1 , 0);
				break;
			case('d'):
				this.checkCollision(level, 0 , 1);
				break;
			default:
				break;
		}
	}
	
	public void checkCollision(Level level,int x, int y) {
		
		Figures[][] map = level.getFigures();
		
		if (map[this.getPosition().getX()+x][this.getPosition().getY()+y].getSign() == '.' & level.isPlayerOnGoal() == true ) {
			level.setGoalContainer(map[this.getPosition().getX()+x][this.getPosition().getY()+y]);
			map[this.getPosition().getX()+x][this.getPosition().getY()+y] =  map[this.getPosition().getX()][this.getPosition().getY()];
			map[this.getPosition().getX()][this.getPosition().getY()] = level.getGoalContainer();
			this.getPosition().setX(+x);
			this.getPosition().setY(+y);
			level.setPlayerOnGoal(true);
			level.setSteps(1);
			
		}
		else if (map[this.getPosition().getX()+x][this.getPosition().getY()+y].getSign() == ' ' & level.isPlayerOnGoal() == true ) {
			map[this.getPosition().getX()+x][this.getPosition().getY()+y] =  map[this.getPosition().getX()][this.getPosition().getY()];
			map[this.getPosition().getX()][this.getPosition().getY()] = level.getGoalContainer();
			this.getPosition().setX(+x);
			this.getPosition().setY(+y);
			level.setPlayerOnGoal(false);
			level.setSteps(1);
			
		}
		else if (map[this.getPosition().getX()+x][this.getPosition().getY()+y].getSign() == ' ' & level.isPlayerOnGoal() == false) {
			Figures placeholderField = map[this.getPosition().getX()+x][this.getPosition().getY()+y];
			map[this.getPosition().getX()+x][this.getPosition().getY()+y] =  map[this.getPosition().getX()][this.getPosition().getY()];
			map[this.getPosition().getX()][this.getPosition().getY()] = placeholderField;
			this.getPosition().setX(+x);
			this.getPosition().setY(+y);
			map[this.getPosition().getX()+x][this.getPosition().getY()+y].getPosition().setX(-x);
			map[this.getPosition().getX()+x][this.getPosition().getY()+y].getPosition().setY(-y);
			level.setSteps(1);
			
		}
		else if (map[this.getPosition().getX()+x][this.getPosition().getY()+y].getSign() == '.') {
			 level.setGoalContainer(map[this.getPosition().getX()+x][this.getPosition().getY()+y]);
			 map[this.getPosition().getX()+x][this.getPosition().getY()+y] =  map[this.getPosition().getX()][this.getPosition().getY()];
			 map[this.getPosition().getX()][this.getPosition().getY()] = new Field(new Position(this.getPosition().getX(),this.getPosition().getY()));
			 this.getPosition().setX(+x);
			 this.getPosition().setY(+y);
			 level.setPlayerOnGoal(true);
			 level.setSteps(1);
			
		}
		else if (map[this.getPosition().getX()+x][this.getPosition().getY()+y].getSign() == '$' && map[this.getPosition().getX()+2*x][this.getPosition().getY()+2*y].getSign() == '.' ) {
			Figures placeholderBox = map[this.getPosition().getX()+x][this.getPosition().getY()+y];
			//Figures placeholderGoal = map[this.getPosition().getX()+2*x][this.getPosition().getY()+2*y];
			map[this.getPosition().getX()+x][this.getPosition().getY()+y] =  map[this.getPosition().getX()][this.getPosition().getY()];
			map[this.getPosition().getX()+2*x][this.getPosition().getY()+2*y] = placeholderBox;
			map[this.getPosition().getX()+2*x][this.getPosition().getY()+2*y].setSign('+');
			level.setAchievedGoals();
			map[this.getPosition().getX()][this.getPosition().getY()] = new Field(new Position(this.getPosition().getX(),this.getPosition().getY()));
			this.getPosition().setX(+x);
			this.getPosition().setY(+y);
			map[this.getPosition().getX()+x][this.getPosition().getY()+y].getPosition().setX(+x);
			map[this.getPosition().getX()+2*x][this.getPosition().getY()+2*y].getPosition().setX(-2*x);
			map[this.getPosition().getX()+x][this.getPosition().getY()+y].getPosition().setY(+y);
			map[this.getPosition().getX()+2*x][this.getPosition().getY()+2*y].getPosition().setY(-2*y);
			level.setSteps(1);
	    }	
		else if (map[this.getPosition().getX()+x][this.getPosition().getY()+y].getSign() == '$' && map[this.getPosition().getX()+2*x][this.getPosition().getY()+2*y].getSign() == ' ' ) {
			Figures placeholderBox = map[this.getPosition().getX()+x][this.getPosition().getY()+y];
			Figures placeholderField = map[this.getPosition().getX()+2*x][this.getPosition().getY()+2*y];
			map[this.getPosition().getX()+x][this.getPosition().getY()+y] =  map[this.getPosition().getX()][this.getPosition().getY()];
			map[this.getPosition().getX()+2*x][this.getPosition().getY()+2*y] = placeholderBox;
			map[this.getPosition().getX()][this.getPosition().getY()] = placeholderField;
			this.getPosition().setX(+x);
			this.getPosition().setY(+y);
			map[this.getPosition().getX()+x][this.getPosition().getY()+y].getPosition().setX(+x);
			map[this.getPosition().getX()+2*x][this.getPosition().getY()+2*y].getPosition().setX(-2*x);
			map[this.getPosition().getX()+x][this.getPosition().getY()+y].getPosition().setY(+y);
			map[this.getPosition().getX()+2*x][this.getPosition().getY()+2*y].getPosition().setY(-2*y);
			level.setSteps(1);
	    }	
	}
}

