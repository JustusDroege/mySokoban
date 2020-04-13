package figures;


public abstract class Figures {
	
	private char sign;
	
	Figures (char sign) {
		this.setSign(sign);
	}

	public char getSign() {
		return sign;
	}

	public void setSign(char sign) {
		this.sign = sign;
	}
	
}


