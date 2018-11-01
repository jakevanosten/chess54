/**
 * Defines all the rules for Bishop pieces in terms of valid moves
 * 
 * @author Jake Van Osten
 * @author Tiffany Moral
 * 
 * @see #Bishop
 *          
 */
package chessPieces;

public class Bishop extends GamePiece{

	/*
	 * Bishop class constructor with piece tag, team color, and current row 
	 * and column values
	 */
	public Bishop(String tag, int wob, int r, int c) {
		super(tag, wob, r, c);
	}
	
	/**
     * returns true if can successfully move the piece from curr to next
     * under the piece's specific rules
     * 
     * @param curr  String ID for gamepieces current location
     * @param next  String ID for gamepieces next location
     * 
     * @see GamePiece#isValidLoc(String, String)
     * @see GamePiece#isPathClear(String, String)
     * @see GamePiece#isDiag(String, String)
     * 
     * @return 		true if it can pass diagonally unobstructed to a blankspace or opponent
     * 
     */
	public boolean tryMove(String curr, String next) {
		if(isValidLoc(curr,next) && isPathClear(curr,next) && isDiag(curr,next)) {return true;}
		
		return false;
	}
	
}
