package chessPieces;

public class Queen extends GamePiece{

	public String queenMove;
	
	public Queen(String tag) {
		super(tag);
	}
	
	public String getQueenMove(){
		return queenMove;
	}
	
	public void setqueenMove(String tag){
		queenMove = tag;
	}
	
	/*make method for Try to Move to see if its a legal move*/
	/*This will be the method that error checks for queen specific moves*/
	/*Also will be able to indicate if a move will result in a simple change in location or a kill */
	
	
	/*make method for setting the actual movement if Try to Move is valid*/
	
	//Queen Movement: can move any # spaces horizontally, vertically, diagonally
	//essentially, shes a bad bihhh
}
