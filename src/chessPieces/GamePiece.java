package chessPieces;

import gameBoard.Board;
import gameBoard.Player;

/*
 * DIFFERENT RULES
 * 	DONE - 1. IsValidLoc - If space that youre trying to move to is blocked by your team (if opponent is there you capture them)
 *  DONE - 2. IsPathClear - checks if all spaces in path to destination are not blocked by other pieces (does not apply to knights)
 *  
 *  DONE 3. IsUp - checks if move is in a straight forward direction (for Pawns, Rooks, Queens, Kings)
 *  DONE 4. IsDown - checks if move is in a backwards direction (for Rooks, Queens, Kings)
 *  DONE 5. IsHoriz - checks if move is to the left or right of current position (for Rooks, Queens, Kings)
 *  DONE 6. IsDiag - checks if move is diagonal from current position (for Bishops, Queens, Kings/pawns when capturing - needs to be opponent there)
 *  DONE 7. IsL - checks if in L from current position (for Knights)
 *  
 *  DONE - in Pawn.java 8. IsFirstMove - checks if they are in the beginning row which would make the two space jump possible (for Pawns)
 *  
 *  9. IsOneSpace - move length restriction for pawns and kings
 */

public class GamePiece extends CellType{
	public int whiteOrBlack;
	public int rowPos, colPos = 0;
	
	public GamePiece(String tag, int whiteOrBlack, int rowPos, int colPos) {
		super(tag);
		this.rowPos = rowPos;
		this.colPos = colPos;
		this.whiteOrBlack = whiteOrBlack;
	}
	
	public int getColor() {
		return whiteOrBlack;
	}
	
	public int getRow() {
		return rowPos;
	}
	
	public int getCol() {
		return colPos;
	}
	
	public boolean tryMove(String curr, String next) {return false;}; //going to be overridden by each piece since they have different standards for moving

	
	public boolean isOneSpace(String curr, String next) {
		int currRow = Board.transRow(curr.charAt(1));
		int currCol = Board.transCol(curr.charAt(0));
		int nextRow = Board.transRow(next.charAt(1));
		int nextCol = Board.transCol(next.charAt(0));
		
		if (nextCol-currCol==1 && nextRow-currRow==1) { //bottom right
			return true;
		}else if (nextCol-currCol==1 && currRow-nextRow==1) { //top right
			return true;
		}else if (nextCol-currCol==1 && currRow==nextRow) { //directly right
			return true;
		}else if (currCol-nextCol==1 && currRow-nextRow==1) { //top left
			return true;
		}else if (nextCol==currCol && currRow-nextRow==1) { //directly up
			return true;
		}else if (currCol-nextCol==1 && currRow==nextRow) { //directly left
			return true;
		}if (currCol-nextCol==1 && nextRow-currRow==1) { //bottom left
			return true;
		}else if (nextCol==currCol && nextRow-currRow==1) { //directly down
			return true;
		}
		
		return false;
	}
	
/*	
	public int[][] getLegalPositions() {
		int[][] coords;
		int currRow = Board.transRow(curr.charAt(1));
		int currCol = Board.transCol(curr.charAt(0));
		int nextRow = Board.transRow(next.charAt(1));
		int nextCol = Board.transCol(next.charAt(0));
		for(int i = 0; i<8;i++) {
			for(int k = 0; k<8;k++) {
				
			}
		}
		
		return null;
	}
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
	
	public boolean inCheck(int kingRow, int kingCol, Player p) {
		//locate king of players color on board - do reverse pathClear for every pieces path type, if piece from other team found on path then check
		int theirColor;
		if(p.getPlayerID() == 'w') { theirColor=1;}
		else { theirColor=0;}
		
		String king = Board.convRow(kingRow).concat(Board.convCol(kingCol));
		GamePiece curr;
		String currLoc;
		for(int i =0;i<8;i++) {
			for(int k=0;k<8;k++) {
				if (Board.cells[i][k] instanceof GamePiece) {
					if(((GamePiece) Board.cells[i][k]).whiteOrBlack == theirColor) { //opponents piece
						curr = (GamePiece) Board.cells[i][k];
						currLoc = Board.convRow(i).concat(Board.convCol(kingCol));
						if(curr instanceof Bishop){
							Bishop currB = (Bishop) curr;
							if(currB.tryMove(currLoc, king)) { return true;}
						}
						else if(curr instanceof Knight){
							Knight currB = (Knight) curr;
							if(currB.tryMove(currLoc, king)) { return true;}
						}
						else if(curr instanceof Pawn){
							Pawn currB = (Pawn) curr;
							if(currB.tryMove(currLoc, king)) { return true;}
						}
						else if(curr instanceof Queen){
							Queen currB = (Queen) curr;
							if(currB.tryMove(currLoc, king)) { return true;}
						}
						else if(curr instanceof Rook){
							Rook currB = (Rook) curr;
							if(currB.tryMove(currLoc, king)) { return true;}
						}
					}
				}
			}
		}
		return false;
	}
	
	public boolean isPathClear(String curr, String next) {
		int currRow = Board.transRow(curr.charAt(1));
		int currCol = Board.transCol(curr.charAt(0));
		int nextRow = Board.transRow(next.charAt(1));
		int nextCol = Board.transCol(next.charAt(0));
		
		/*DONE -if only row changes, move along the columns. 
		 *DONE - if only col changes, move along the row.
		 * DONE - if row and col changed by same amount, move along diagonal.
		 * otherwise, must be a knight, return true since they can jump over pieces
		 */
		if(currCol == nextCol && currRow != nextRow && currRow < nextRow) { //check each row on path - moving down the board
			for(int i=currRow+1;i<=nextRow;i++) {
				if(i==nextRow && Board.cells[i][currCol] instanceof GamePiece && ((GamePiece) Board.cells[i][currCol]).whiteOrBlack != this.whiteOrBlack) { 
					return true;
				}else if(Board.cells[i][currCol] instanceof GamePiece) { //piece in the way
					return false;
				}
			}
			return true;
		}else if (currCol == nextCol && currRow != nextRow && currRow > nextRow) { //moving up
			for(int i=currRow-1;i>=nextRow;i--) {
				if(i==nextRow && Board.cells[i][currCol] instanceof GamePiece && ((GamePiece) Board.cells[i][currCol]).whiteOrBlack != this.whiteOrBlack) { 
					return true;
				}else if(Board.cells[i][currCol] instanceof GamePiece) { //piece in the way
					return false;
				}
			}
			return true;
		}else if (currCol != nextCol && currRow == nextRow && currCol < nextCol) { //moving right
			for(int i=currCol+1;i<=nextCol;i++) {
				if(i==nextCol && Board.cells[currRow][i] instanceof GamePiece && ((GamePiece) Board.cells[currRow][i]).whiteOrBlack != this.whiteOrBlack) { 
					return true;
				}else if(Board.cells[currRow][i] instanceof GamePiece) { //piece in the way
					return false;
				}
			}
			return true;
		}else if (currCol != nextCol && currRow == nextRow && currCol > nextCol) { //moving left
			for(int i=currCol-1;i>=nextCol;i--) {
				if(i==nextCol && Board.cells[currRow][i] instanceof GamePiece && ((GamePiece) Board.cells[currRow][i]).whiteOrBlack != this.whiteOrBlack) { 
					return true;
				}else if(Board.cells[currRow][i] instanceof GamePiece) { //piece in the way
					return false;
				}
			}
			return true;
		}else if (nextCol-currCol==nextRow-currRow || nextCol-currCol==currRow-nextRow) { //moving diagonally
			int k = currRow;
			if(nextCol>currCol && nextRow>currRow) {//down and right
				k = currRow+1;
				for(int i=currCol+1;i<=nextCol;i++) {
					if(i==nextCol && Board.cells[k][i] instanceof GamePiece && ((GamePiece) Board.cells[k][i]).whiteOrBlack != this.whiteOrBlack) { 
						return true;
					}else if(Board.cells[k][i] instanceof GamePiece) { //piece in the way
						return false;
					}
					k++;
				}
				return true;
			}else if(nextCol>currCol && nextRow<currRow) {//up and right
				k = currRow-1;
				for(int i=currCol+1;i<=nextCol;i++) {
					if(i==nextCol && Board.cells[k][i] instanceof GamePiece && ((GamePiece) Board.cells[k][i]).whiteOrBlack != this.whiteOrBlack) { 
						return true;
					}else if(Board.cells[k][i] instanceof GamePiece) { //piece in the way
						return false;
					}
					k--;
				}
				return true;
			}else if(nextCol<currCol && nextRow>currRow) {//down and left
				k = currRow+1;
				for(int i=currCol-1;i>=nextCol;i--) {
					if(i==nextCol && Board.cells[k][i] instanceof GamePiece && ((GamePiece) Board.cells[k][i]).whiteOrBlack != this.whiteOrBlack) { 
						return true;
					}else if(Board.cells[k][i] instanceof GamePiece) { //piece in the way
						return false;
					}
					k++;
				}
				return true;
			}else { //up and left
				k = currRow-1;
				for(int i=currCol-1;i>=nextCol;i--) {
					if(i==nextCol && Board.cells[k][i] instanceof GamePiece && ((GamePiece) Board.cells[k][i]).whiteOrBlack != this.whiteOrBlack) { 
						return true;
					}else if(Board.cells[k][i] instanceof GamePiece) { //piece in the way
						return false;
					}
					k--;
				}
				return true;
			}
		}
		return true;
	}
	
	public boolean isUp(String curr, String next) {
		int currRow = Board.transRow(curr.charAt(1));
		int currCol = Board.transCol(curr.charAt(0));
		int nextRow = Board.transRow(next.charAt(1));
		int nextCol = Board.transCol(next.charAt(0));
		
		if (currCol == nextCol && currRow != nextRow && currRow > nextRow) { //moving up
			return true;
		}
		return false;
	}
	
	public boolean isDown(String curr, String next) {
		int currRow = Board.transRow(curr.charAt(1));
		int currCol = Board.transCol(curr.charAt(0));
		int nextRow = Board.transRow(next.charAt(1));
		int nextCol = Board.transCol(next.charAt(0));
		
		if (currCol == nextCol && currRow != nextRow && currRow < nextRow){ //moving up
			return true;
		}
		return false;
	}
	
	public boolean isHoriz(String curr, String next) {
		int currRow = Board.transRow(curr.charAt(1));
		int currCol = Board.transCol(curr.charAt(0));
		int nextRow = Board.transRow(next.charAt(1));
		int nextCol = Board.transCol(next.charAt(0));
		
		if ((currCol != nextCol) && (currRow == nextRow)) {
			return true;
		}
		return false;
	}
	
	public boolean isDiag(String curr, String next) {
		int currRow = Board.transRow(curr.charAt(1));
		int currCol = Board.transCol(curr.charAt(0));
		int nextRow = Board.transRow(next.charAt(1));
		int nextCol = Board.transCol(next.charAt(0));
		
		if (nextCol-currCol==nextRow-currRow || nextCol-currCol==currRow-nextRow) {
			return true;
		}
		return false;
	}
	
	public boolean isL(String curr, String next) {
		int currRow = Board.transRow(curr.charAt(1));
		int currCol = Board.transCol(curr.charAt(0));
		int nextRow = Board.transRow(next.charAt(1));
		int nextCol = Board.transCol(next.charAt(0));
		
		if ((nextCol-currCol==2 || currCol-nextCol==2) && (nextRow-currRow==1 || currRow-nextRow==1)) { //left or right 2 and up or down 1
			return true;
		}else if ((nextRow-currRow==2 || currRow-nextRow==2) && (nextCol-currCol==1 || currCol-nextCol==1)) { //up or down 2 and left or right 1
			return true;
		}
		return false;
	}

	
}