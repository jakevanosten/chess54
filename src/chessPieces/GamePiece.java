package chessPieces;

import gameBoard.Board;

/*
 * DIFFERENT RULES
 *  DONE - 2. IsPathClear - checks if all spaces in path to destination are not blocked by other pieces (does not apply to knights)
 *  
 *  DONE 3. IsUp - checks if move is in a straight forward direction (for Pawns, Rooks, Queens, Kings)
 *  DONE 4. IsDown - checks if move is in a backwards direction (for Rooks, Queens, Kings)
 *  DONE 5. IsHoriz - checks if move is to the left or right of current position (for Rooks, Queens, Kings)
 *  DONE 6. IsDiag - checks if move is diagonal from current position (for Bishops, Queens, Kings/pawns when capturing - needs to be opponent there)
 *  DONE 7. IsL - checks if in L from current position (for Knights)
 *  
 *  DONE - in Pawn.java 8. IsFirstMove - checks if they are in the beginning row which would make the two space jump possible (for Pawns)
 */

/**
 * Defines all the rules for each chess piece as their superclass so 
 * they can use varying amounts of them to create their own valid move checks
 * 
 * 
 * @author Jake Van Osten
 * @author Tiffany Moral
 * 
 * @see #GamePiece
 *          
 */
public class GamePiece extends CellType{
	public int whiteOrBlack;
	public int rowPos, colPos = 0;
	
	/*
	 * GamePiece Class constructor
	 */
	public GamePiece(String tag, int whiteOrBlack, int rowPos, int colPos) {
		super(tag);
		this.rowPos = rowPos;
		this.colPos = colPos;
		this.whiteOrBlack = whiteOrBlack;
	}
	
	/**
     * returns an integer corresponding to the pieces color when created
     * 
     * @return 		0 for white pieces and 1 for black pieces
     * 
     */
	public int getColor() {
		return whiteOrBlack;
	}
	
	/**
     * returns an integer corresponding to the row of the gamePiece
     * 
     * @return 		value between 0 and 7 for row index
     * 
     */
	public int getRow() {
		return rowPos;
	}
	
	/**
     * returns an integer corresponding to the column of the gamePiece
     * 
     * @return 		value between 0 and 7 for column index
     * 
     */
	public int getCol() {
		return colPos;
	}
	
	/**
     * returns true if trying to move exactly 1 space away
     * move length restriction for pawns and kings
     * 
     * @param curr  String ID for gamepieces current location
     * @param next  String ID for gamepieces next location
     * 
     * @see Board#Board()
     * @see #transRow(char)
     * @see #transCol(char)
     * 
     * @return 		true or false depending on length of move
     * 
     */
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
	
	/**
     * return true if the spot being moved into is not blocked by the same team
     * 
     * 
     * @param curr  String ID for gamepieces current location
     * @param next  String ID for gamepieces next location
     * 
     * @see Board#Board()
     * @see #transRow(char)
     * @see #transCol(char)
     * 
     * @return 		true or false depending on openness of new space
     * 
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