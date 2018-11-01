/**
 * Generates a blankspace object to hold the empty place of the chessboard
 * 
 * @author Jake Van Osten
 * @author Tiffany Moral
 * 
 * @see #BlankSpace
 *          
 */
package chessPieces;

public class BlankSpace extends CellType{
	int isBlack = 0;
	
	/*
	 * BlankSpace class constructor
	 */
	public BlankSpace(String tag) {
		super(tag);
		if(tag == "  ") {
			this.isBlack = 0;
		}else if (tag == "##"){
			this.isBlack = 1;
		}
	}
		
}
