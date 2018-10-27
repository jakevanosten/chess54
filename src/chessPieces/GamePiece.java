package chessPieces;

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
	 * 	1. IsValidLoc - If space that youre trying to move to is blocked by your team (if opponent is there you capture them)
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
		
		
		return true;
	}
}
