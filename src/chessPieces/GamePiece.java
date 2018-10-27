package chessPieces;

import gameBoard.Board;

public class GamePiece extends CellType{
	int whiteOrBlack;
	
	public GamePiece(String tag, int whiteOrBlack) {
		super(tag);
		this.whiteOrBlack = whiteOrBlack;
	}
	
	public int getColor() {
		return whiteOrBlack;
	}
	
	/*
	 * DIFFERENT RULES
	 * 	DONE - 1. IsValidLoc - If space that youre trying to move to is blocked by your team (if opponent is there you capture them)
	 *  2. IsPathClear - checks if all spaces in path to destination are not blocked by other pieces (does not apply to knights)
	 *  
	 *  3. IsUp - checks if move is in a straight forward direction (for Pawns, Rooks, Queens, Kings)
	 *  4. IsDown - checks if move is in a backwards direction (for Rooks, Queens, Kings)
	 *  5. IsHoriz - checks if move is to the left or right of current position (for Rooks, Queens, Kings)
	 *  6. IsDiag - checks if move is diagonal from current position (for Bishops, Queens, Kings/pawns when capturing - needs to be opponent there)
	 *  7. IsL - checks if in L from current position (for Knights)
	 *  
	 *  8. IsFirstMove - checks if they are in the beginning row which would make the two space jump possible (for Pawns)
	 */
	
	public boolean isValidLoc(String curr, String next) {
		CellType curCell = Board.cells[Board.transRow(curr.charAt(1))][Board.transCol(curr.charAt(0))];
		CellType nxtCell = Board.cells[Board.transRow(next.charAt(1))][Board.transCol(next.charAt(0))];
		
		GamePiece currPiece = (GamePiece) curCell;
		int currColor = currPiece.whiteOrBlack;
		
		if(nxtCell instanceof BlankSpace) {
			return true;
		}else { //game piece in cell
			GamePiece gameCell = (GamePiece) nxtCell;
			if (gameCell.whiteOrBlack == currColor) { //same color in next, can't move
				return false;
			}
		}
		return true;
	}
	
	public boolean isPathClear(String curr, String next) {
		int currRow = Board.transRow(curr.charAt(1));
		int currCol = Board.transRow(curr.charAt(0));
		int nextRow = Board.transRow(next.charAt(1));
		int nextCol = Board.transRow(next.charAt(0));
		
		/*DONE -if only row changes, move along the columns. 
		 *DONE - if only col changes, move along the row.
		 * DONE - if row and col changed by same amount, move along diagonal.
		 * otherwise, must be a knight, return true since they can jump over pieces
		 */
		if(currCol == nextCol && currRow != nextRow && currRow < nextRow) { //check each row on path - moving down the board
			for(int i=currRow+1;i<=nextRow;i++) {
				if(Board.cells[i][currCol] instanceof GamePiece) { //piece in the way
					return false;
				}
			}
			return true;
		}else if (currCol == nextCol && currRow != nextRow && currRow > nextRow) { //moving up
			for(int i=currRow-1;i>=nextRow;i--) {
				if(Board.cells[i][currCol] instanceof GamePiece) { //piece in the way
					return false;
				}
			}
			return true;
		}else if (currCol != nextCol && currRow == nextRow && currCol < nextCol) { //moving right
			for(int i=currCol+1;i<=nextCol;i++) {
				if(Board.cells[currRow][i] instanceof GamePiece) { //piece in the way
					return false;
				}
			}
			return true;
		}else if (currCol != nextCol && currRow == nextRow && currCol > nextCol) { //moving left
			for(int i=currCol-1;i>=nextCol;i--) {
				if(Board.cells[currRow][i] instanceof GamePiece) { //piece in the way
					return false;
				}
			}
			return true;
		}else if (nextCol-currCol==nextRow-currRow) { //moving diagonally
			int k = currRow;
			if(nextCol>currCol && nextRow>currRow) {//down and right
				k = currRow+1;
				for(int i=currCol+1;i<=nextCol;i++) {
					if(Board.cells[k][i] instanceof GamePiece) { //piece in the way
						return false;
					}
					k++;
				}
				return true;
			}else if(nextCol>currCol && nextRow<currRow) {//up and right
				k = currRow-1;
				for(int i=currCol+1;i<=nextCol;i++) {
					if(Board.cells[k][i] instanceof GamePiece) { //piece in the way
						return false;
					}
					k--;
				}
				return true;
			}else if(nextCol<currCol && nextRow>currRow) {//down and left
				k = currRow+1;
				for(int i=currCol-1;i>=nextCol;i--) {
					if(Board.cells[k][i] instanceof GamePiece) { //piece in the way
						return false;
					}
					k++;
				}
				return true;
			}else { //up and left
				k = currRow-1;
				for(int i=currCol-1;i>=nextCol;i--) {
					if(Board.cells[k][i] instanceof GamePiece) { //piece in the way
						return false;
					}
					k--;
				}
				return true;
			}
		}
		return true;
	}
}
