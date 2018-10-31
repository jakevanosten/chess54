package chessPieces;

public class Queen extends GamePiece{

	public Queen(String tag, int wob, int r, int c) {
		super(tag, wob, r, c);
	}
	
	public boolean tryMove(String curr, String next) {
		if(isValidLoc(curr,next) && isPathClear(curr,next) && (isUp(curr,next) || isDown(curr,next) || isHoriz(curr,next) || isDiag(curr,next))) {return true;}
		
		return false;
	}
	/*make method for Try to Move to see if its a legal move*/
	/*This will be the method that error checks for queen specific moves*/
	/*Also will be able to indicate if a move will result in a simple change in location or a kill */
	
	
	/*make method for setting the actual movement if Try to Move is valid*/
	
	//Queen Movement: can move any # spaces horizontally, vertically, diagonally
	//essentially, shes a bad bihhh
}
