package gameBoard;

public class BlankSpace {
	String tag;
	int isBlack = 0;
	
	public BlankSpace(int isBlack) {
		this.isBlack = isBlack;
		
		if(isBlack == 0) {
			this.tag = "  ";
		}else {
			this.tag = "##";
		}
	}	
	
	public String getTag() {
		return tag;
	}
}
