/**
 * Top of the hierarchy for all spaces on the Board, includes game pieces,
 * legends, and blankspace objects
 * 
 * 
 * @author Jake Van Osten
 * @author Tiffany Moral
 * 
 * @see #CellType
 *          
 */
package chessPieces;


public class CellType {
	String tag;
	public boolean attackedByWhite;
	public boolean attackedByBlack;
	
	/*
	 * CellType Class constructor
	 */
	public CellType(String tag) {
		this.tag = tag;
	}
	
	/**
     * returns an String corresponding to the type and content of Space on Board
     * 
     * @return 		String indicating color and type of gamepiece, or legend
     * 				or blankspace
     * 
     */
	public String getTag() {
		return tag;
	}
}
