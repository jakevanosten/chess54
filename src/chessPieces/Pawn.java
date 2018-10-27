package chessPieces;

public class Pawn extends GamePiece{

	public String pawnMove;
	
	public Pawn(String tag, int wob) {
		super(tag, wob);
	}	
	
	public String getPawnMove(){
		return pawnMove;
	}
	
	public void setPawnMove(String tag){
		pawnMove = tag;
	}
	
	/*make method for Try to Move to see if its a legal move*/
	/*This will be the method that error checks for pawn specific moves*/
	/*Also will be able to indicate if a move will result in a simple change in location or a kill */
	
	
	/*make method for setting the actual movement if Try to Move is valid*/
}
