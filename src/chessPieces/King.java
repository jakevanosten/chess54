package chessPieces;

import gameBoard.Board;

public class King extends GamePiece{
	public static int castlingFlag = 0;
	
	public King(String tag, int wob, int r, int c) {
		super(tag, wob, r, c);
	}
	
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
	/*make method for Try to Move to see if its a legal move*/
	/*This will be the method that error checks for king specific moves*/
	/*Also will be able to indicate if a move will result in a simple change in location or a kill */
	/*Valid move check should be thorough incase movement will result in putting king in check*/
	
	
	/*make method for setting the actual movement if Try to Move is valid*/
}
