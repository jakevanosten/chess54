package chessPieces;

import gameBoard.Board;

public class Pawn extends GamePiece{
	public static int promotionFlag = 0;
	
	public Pawn(String tag, int wob, int r, int c) {
		super(tag, wob, r, c);
	}	
	
	
	public boolean isFirstMove(String curr) {
		
		if((this.whiteOrBlack == 0 && curr.charAt(1) == '2') || (this.whiteOrBlack == 1 && curr.charAt(1) == '7')){
			return true;
		}
		return false;
	}
	
	public boolean isPromoting(String curr, String next) {
		CellType curCell = Board.cells[Board.transRow(curr.charAt(1))][Board.transCol(curr.charAt(0))];
		
		GamePiece currPiece = (GamePiece) curCell;
		int currColor = currPiece.whiteOrBlack;
		
		if(currColor == 0 && next.charAt(1) == '8') { //white pawn reaching top row of board
			return true;
		}else if(currColor == 1 && next.charAt(1) == '1') { //black pawn reaching bottom row of board
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
			if (gameCell.whiteOrBlack != currColor) { //same color in next, can't move
				return true;
			}
			return false;
		}
		return false;
	}
	
	
	public boolean tryMove(String curr, String next) { //This is complicated, need to do diagonal if trying to capture, otherwise get length to be 1 or 2
		boolean val = isValidLoc(curr,next);
		boolean path = isPathClear(curr,next);
		promotionFlag = 0;
		
		if(isPromoting(curr,next)) { 
			promotionFlag = 1;
		}
		
		if(isFirstMove(curr) && val && path && ((isUp(curr,next) && this.whiteOrBlack == 0) || (isDown(curr,next) && this.whiteOrBlack == 1))) {//can move two spaces
			int currRow = Board.transRow(curr.charAt(1));
			int nextRow = Board.transRow(next.charAt(1));
			
			if(isOneSpace(curr,next) && isDiag(curr,next) && oppInSpace(curr,next)) { return true; } //first move is a capture
			
			if(((nextRow==currRow-2 || nextRow==currRow-1) && this.whiteOrBlack == 0) || ((nextRow==currRow+2 || nextRow==currRow+1) && this.whiteOrBlack == 1)) {
				return true;
			}
			
			return false;
		}
		  
		if(val && path && isOneSpace(curr,next)) { //now check if going up, or going diagonally to capture

			if(isDiag(curr,next) && oppInSpace(curr,next)) { //valid capture
				return true;
			}else if((isUp(curr,next) && this.whiteOrBlack == 0) || (isDown(curr,next) && this.whiteOrBlack == 1)) {return true;} //moving white up or black down
		}
		return false;
	}
}