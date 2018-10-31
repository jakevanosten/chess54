package chessPieces;


public class CellType {
	String tag;
	public boolean attackedByWhite;
	public boolean attackedByBlack;
	
	public CellType(String tag) {
		this.tag = tag;
	}
	
	public String getTag() {
		return tag;
	}
}
