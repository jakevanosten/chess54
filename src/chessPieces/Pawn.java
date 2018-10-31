package chessPieces;

import gameBoard.Board;

public class Pawn extends GamePiece{

	public Pawn(String tag, int wob) {
		super(tag, wob);
	}	
	
	public boolean isFirstMove(String curr) {
		
		if((this.whiteOrBlack == 0 && curr.charAt(1) == '2') || (this.whiteOrBlack == 1 && curr.charAt(1) == '7')){
			return true;
		}
		return false;
	}
	
	public boolean oppInSpace(String curr, String next) {
		CellType curCell = Board.cells[Board.transRow(curr.charAt(1))][Board.transCol(curr.charAt(0))];
		CellType nxtCell = Board.cells[Board.transRow(next.charAt(1))][Board.transCol(next.charAt(0))];
		
		GamePiece currPiece = (GamePiece) curCell;
		int currColor = currPiece.whiteOrBlack;
		
		if(nxtCell instanceof GamePiece) {
			GamePiece gameCell = (GamePiece) nxtCell;
			if (gameCell.whiteOrBlack == currColor) { //same color in next, can't move
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean tryMove(String curr, String next) { //This is complicated, need to do diagonal if trying to capture, otherwise get length to be 1 or 2
		if(isFirstMove(curr) && isUp(curr,next)) {//can move two spaces
			int currRow = Board.transRow(curr.charAt(1));
			int nextRow = Board.transRow(next.charAt(1));
			if(nextRow==currRow-2 || nextRow==currRow-1) {
				return true;
			}
			return false;
		}
		  
		if(isValidLoc(curr,next) && isPathClear(curr,next) && isOneSpace(curr,next)) { //now check if going up, or going diagonally to capture
			if(isDiag(curr,next) && oppInSpace(curr,next)) { //valid capture
				return true;
			}else if(isUp(curr,next)) {return true;} //moving upwards
		}
		return false;
	}
	/*make method for Try to Move to see if its a legal move*/
	/*This will be the method that error checks for pawn specific moves*/
	/*Also will be able to indicate if a move will result in a simple change in location or a kill */
	
	
	/*make method for setting the actual movement if Try to Move is valid*/
}