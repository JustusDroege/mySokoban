
public abstract class Figures {
	
	private char sign;
	private Position position;
	
	Figures (Position position, char sign) {
		this.setPosition(position);
		this.setSign(sign);
	}

	public char getSign() {
		return sign;
	}

	public void setSign(char sign) {
		this.sign = sign;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
}


