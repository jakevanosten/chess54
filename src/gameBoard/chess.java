package gameBoard;
import chessPieces. *;
import gameBoard. *;

public class chess {

	
	
	public static void main(String[] args){
		
		Board bo = new Board();
		
		bo.setBoard(bo);
		bo.printBoard(bo);
	
		while(bo.isCheckmate(bo) == false){
			
		}
		
	}
	
	
}
