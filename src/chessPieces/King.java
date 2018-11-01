/**
 *Defines all the rules for Bishop pieces in terms of valid moves
 *and potential Castling with Rooks
 * 
 * @author Jake Van Osten
 * @author Tiffany Moral
 * 
 * @see #King
 *          
 */
package chessPieces;

import gameBoard.Board;

public class King extends GamePiece{
	public static int castlingFlag = 0;
	/*
	 * King class constructor with piece tag, team color, and current row 
	 * and column values
	 */
	public King(String tag, int wob, int r, int c) {
		super(tag, wob, r, c);
	}
	/**
     * returns true if king is preparing for a valid castling maneuver
     * 
     * @param curr  String ID for gamepieces current location
     * @param next  String ID for gamepieces next location
     * 
     * @see Board#Board()
     * @see Board#transRow(char)
     * @see Board#transCol(char)
     * 
     * @return 		true or false depending on placement of pieces
     * 
     */
	public boolean isCastling(String curr, String next) {
		int currRow = Board.transRow(curr.charAt(1));
		int currCol = Board.transCol(curr.charAt(0));

		int nextCol = Board.transCol(next.charAt(0));
		
		if(currCol==4 && (currRow==0 || currRow==7) && (currCol-nextCol == 2 || nextCol-currCol == 2)) { //trying to move king horiz 2 spaces, now look for rook in place
			if(currCol-nextCol==2) { //looking toward left side for rook
					int i = currCol-1;
					while(!(Board.cells[currRow][i] instanceof Rook)) {
						if(Board.cells[currRow][i] instanceof GamePiece) {
							return false;
						}
						i--;
					}
					return true;
			}else { //looking to right rook
				int i = currCol+1;
				while(!(Board.cells[currRow][i] instanceof Rook)) {
					if(Board.cells[currRow][i] instanceof GamePiece) {
						return false;
					}
					i++;
				}
				return true;
			}
		}
		return false;
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
     * @see GamePiece#isDiag(String, String)
     * @see GamePiece#isOneSpace(String, String)
     * @see GamePiece#isUp(String, String)
     * @see GamePiece#isDown(String, String)
     * @see GamePiece#isHoriz(String, String)
     * 
     * @return 		true or false depending on openness of path
     * 
     */
	public boolean tryMove(String curr, String next) {
		if(isHoriz(curr,next)) {
			if(isCastling(curr,next)) {
				castlingFlag = 1;
				return true;
			}
		}
		castlingFlag = 0;
		
		if(isValidLoc(curr,next) && isPathClear(curr,next) && isOneSpace(curr,next) && (isUp(curr,next) || isDown(curr,next) || isHoriz(curr,next) || isDiag(curr,next))) {
			return true;
		}
		return false;
	}
}
