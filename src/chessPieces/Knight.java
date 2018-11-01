/**
 * Defines all the rules for Knight pieces in terms of valid moves
 * 
 * @author Jake Van Osten
 * @author Tiffany Moral
 * 
 * @see #Knight
 *          
 */
package chessPieces;

public class Knight extends GamePiece{
	/*
	 * Knight Class constructor with piece tag, team color, and current
	 * row and column values
	 */
	public Knight(String tag, int wob, int r, int c) {
		super(tag, wob, r, c);
	}
	
	/**
     * returns true if path from curr to next is not blocked by other pieces
     * 
     * @param curr  String ID for gamepieces current location
     * @param next  String ID for gamepieces next location
     * 
     * @see GamePiece#isValidLoc(String, String)
     * @see GamePiece#isPathClear(String, String)
     * @see GamePiece#isL(String, String)
     * 
     * @return 		true or false depending on placement of pieces
     * 
     */
	public boolean tryMove(String curr, String next) {
		if(isValidLoc(curr,next) && isPathClear(curr,next) && isL(curr,next)) {return true;}
		
		return false;
	}
}

