/**
 * Defines all the rules for Rook pieces in terms of valid moves
 * 
 * 
 * @author Jake Van Osten
 * @author Tiffany Moral
 * 
 * @see #Rook
 *          
 */
package chessPieces;

public class Rook extends GamePiece{
	/*
	 * Rook class constructor with piece tag, team color, and current row 
	 * and column values
	 */
	public Rook(String tag, int wob, int r, int c) {
		super(tag, wob, r, c);
	}
	
	/**
     * return true if the path from curr to next is not blocked by other pieces
     * 
     * 
     * @param curr  String ID for gamepieces current location
     * @param next  String ID for gamepieces next location
     * 
     * @see GamePiece#isValidLoc(String, String)
     * @see GamePiece#isPathClear(String, String)
     * @see GamePiece#isUp(String, String)
     * @see GamePiece#isDown(String, String)
     * @see GamePiece#isHoriz(String, String)
     * 
     * @return 		true or false depending on openness of path
     * 
     */
	public boolean tryMove(String curr, String next) {
		if(isValidLoc(curr,next) && isPathClear(curr,next) && (isUp(curr,next) || isDown(curr,next) || isHoriz(curr,next))) {return true;}
		
		return false;
	}
}
