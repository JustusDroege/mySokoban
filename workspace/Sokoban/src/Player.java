public class Player extends Figures {

	Player(Position position) {
		super(position, '@');
	}
	
	public void move(char direction,Figures[][] map) {
		switch(direction) {
		
			case('w'):
				if (map[this.getPosition().getX()-1][this.getPosition().getY()].getSign() == ' ') {
					Figures placeholderField = map[this.getPosition().getX()-1][this.getPosition().getY()];
					map[this.getPosition().getX()-1][this.getPosition().getY()] =  map[this.getPosition().getX()][this.getPosition().getY()];
					map[this.getPosition().getX()][this.getPosition().getY()] = placeholderField;
					this.getPosition().setX(-1);
					map[this.getPosition().getX()-1][this.getPosition().getY()].getPosition().setX(+1);
				}
				else if (map[this.getPosition().getX()-1][this.getPosition().getY()].getSign() == '$' && map[this.getPosition().getX()-2][this.getPosition().getY()].getSign() == ' ' ) {
					Figures placeholderBox = map[this.getPosition().getX()-1][this.getPosition().getY()];
					Figures placeholderField = map[this.getPosition().getX()-2][this.getPosition().getY()];
					map[this.getPosition().getX()-1][this.getPosition().getY()] =  map[this.getPosition().getX()][this.getPosition().getY()];
					map[this.getPosition().getX()-2][this.getPosition().getY()] = placeholderBox;
					map[this.getPosition().getX()][this.getPosition().getY()] = placeholderField;
					this.getPosition().setX(-1);
					map[this.getPosition().getX()-1][this.getPosition().getY()].getPosition().setX(-1);
					map[this.getPosition().getX()-2][this.getPosition().getY()].getPosition().setX(+2);
			    }	
			
				break;
			case('a'):
				if (map[this.getPosition().getX()][this.getPosition().getY()-1].getSign() == ' ') {
					Figures placeholder = map[this.getPosition().getX()][this.getPosition().getY()-1];
					map[this.getPosition().getX()][this.getPosition().getY()-1] =  map[this.getPosition().getX()][this.getPosition().getY()];
					map[this.getPosition().getX()][this.getPosition().getY()] = placeholder;
					this.getPosition().setY(-1);
					map[this.getPosition().getX()][this.getPosition().getY()-1].getPosition().setX(+1);
				}
				else if (map[this.getPosition().getX()][this.getPosition().getY()-1].getSign() == '$' && map[this.getPosition().getX()][this.getPosition().getY()-2].getSign() == ' ' ) {
					Figures placeholderBox = map[this.getPosition().getX()][this.getPosition().getY()-1];
					Figures placeholderField = map[this.getPosition().getX()][this.getPosition().getY()-2];
					map[this.getPosition().getX()][this.getPosition().getY()-1] =  map[this.getPosition().getX()][this.getPosition().getY()];
					map[this.getPosition().getX()][this.getPosition().getY()-2] = placeholderBox;
					map[this.getPosition().getX()][this.getPosition().getY()] = placeholderField;
					this.getPosition().setY(-1);
					map[this.getPosition().getX()][this.getPosition().getY()-1].getPosition().setY(-1);
					map[this.getPosition().getX()][this.getPosition().getY()-2].getPosition().setY(+2);
			    }	
				break;
			case('s'):
				if (map[this.getPosition().getX()+1][this.getPosition().getY()].getSign() == ' ') {
					Figures placeholder = map[this.getPosition().getX()+1][this.getPosition().getY()];
					map[this.getPosition().getX()+1][this.getPosition().getY()] =  map[this.getPosition().getX()][this.getPosition().getY()];
					map[this.getPosition().getX()][this.getPosition().getY()] = placeholder;
					this.getPosition().setX(+1);;
					map[this.getPosition().getX()+1][this.getPosition().getY()].getPosition().setX(-1);
				}
				else if (map[this.getPosition().getX()+1][this.getPosition().getY()].getSign() == '$' && map[this.getPosition().getX()+2][this.getPosition().getY()].getSign() == ' ' ) {
					Figures placeholderBox = map[this.getPosition().getX()+1][this.getPosition().getY()];
					Figures placeholderField = map[this.getPosition().getX()+2][this.getPosition().getY()];
					map[this.getPosition().getX()+1][this.getPosition().getY()] =  map[this.getPosition().getX()][this.getPosition().getY()];
					map[this.getPosition().getX()+2][this.getPosition().getY()] = placeholderBox;
					map[this.getPosition().getX()][this.getPosition().getY()] = placeholderField;
					this.getPosition().setX(+1);
					map[this.getPosition().getX()+1][this.getPosition().getY()].getPosition().setX(+1);
					map[this.getPosition().getX()+2][this.getPosition().getY()].getPosition().setX(-2);
			    }	
				break;
			case('d'):
				if (map[this.getPosition().getX()][this.getPosition().getY()+1].getSign() == ' ') {
					Figures placeholder = map[this.getPosition().getX()][this.getPosition().getY()+1];
					map[this.getPosition().getX()][this.getPosition().getY()+1] =  map[this.getPosition().getX()][this.getPosition().getY()];
					map[this.getPosition().getX()][this.getPosition().getY()] = placeholder;
					this.getPosition().setY(1);
					map[this.getPosition().getX()][this.getPosition().getY()+1].getPosition().setX(+1);
				}
				else if (map[this.getPosition().getX()][this.getPosition().getY()+1].getSign() == '$' && map[this.getPosition().getX()][this.getPosition().getY()+2].getSign() == ' ' ) {
					Figures placeholderBox = map[this.getPosition().getX()][this.getPosition().getY()+1];
					Figures placeholderField = map[this.getPosition().getX()][this.getPosition().getY()+2];
					map[this.getPosition().getX()][this.getPosition().getY()+1] =  map[this.getPosition().getX()][this.getPosition().getY()];
					map[this.getPosition().getX()][this.getPosition().getY()+2] = placeholderBox;
					map[this.getPosition().getX()][this.getPosition().getY()] = placeholderField;
					this.getPosition().setY(+1);
					map[this.getPosition().getX()][this.getPosition().getY()+1].getPosition().setY(+1);
					map[this.getPosition().getX()][this.getPosition().getY()+2].getPosition().setY(-2);
			    }	
				break;
			default:
				break;
		}
	}
	
	public void checkCollision(Figures[][] map) {
		
		
	}
	
}

