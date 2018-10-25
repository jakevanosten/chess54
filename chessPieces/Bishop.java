package chessPieces;

public class Bishop extends GamePiece{

	public Bishop(String tag) {
		super(tag);
	}

/* subclass of abstract class gamePiece */	
	
	/* Bishop Piece: the "nipple"
	 * 
	 * Bishop Movement: any number of vacant squares in any diagonal direction. 
	 * Note: like rooks, they may capture an opponent's piece within its path
	 * by stopping on that piece's square
	 * 
	 * Note: because a bishop moves diagonally, it remains throughout the game on
	 * the same color squares on which it begins the game. Thus, each player
	 * has a white-square bishop and a dark-square bishop
	 * 
	 * Note: if another of your pieces blocks your bishop's path, the bishop must
	 * stop before reaching the occupied square. If the blocking piece belongs to your
	 * opponent, you may stop before reaching that square, or you may stop on that square
	 * and capture the occupying piece.
	 * 
	 * Note: a bishop may not jump over any piece
	 * 
	 * 
	 */
	
}
