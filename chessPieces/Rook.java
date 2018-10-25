package chessPieces;

public class Rook extends GamePiece{

	public Rook(String tag) {
		super(tag);
	}
/* subclass of abstract class gamePiece */	
	
	/* Rook Piece: the "castle"
	 * 
	 * Rook Movement: rook can move any # of spaces horizontal or vertical
	 * 
	 * Note: if an opponent's piece blocks the path, that piece may be captured
	 * by moving the rook to (but not beyond) the occupied square and
	 * removing the opponent's piece
	 * 
	 * 
	 * Note: Rooks cannot jump over pieces of either color.
	 * If one of your other pieces blocks your rook's path,
	 * your rook must stop before reaching that square
	 * 
	 */
	
}
