package chessPieces;

public class King extends GamePiece{

	public String kingMove;
	
	public King(String tag) {
		super(tag);
	}
	
	public String getKingMove(){
		return kingMove;
	}
	
	public void setKingMove(String tag){
		kingMove = tag;
	}
	
	/*make method for Try to Move to see if its a legal move*/
	/*This will be the method that error checks for king specific moves*/
	/*Also will be able to indicate if a move will result in a simple change in location or a kill */
	/*Valid move check should be thorough incase movement will result in putting king in check*/
	
	
	/*make method for setting the actual movement if Try to Move is valid*/
}
