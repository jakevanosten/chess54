/**
 * Main driver for playing chess games, will cycle through stream of input until checkmate
 * 
 * @author Jake Van Osten
 * @author Tiffany Moral
 * 
 * @see #Chess
 *          
 */
package gameBoard;

public class Chess {

	
	public static void main(String[] args){
			String input;
			Board bo = new Board();
			boolean check = false;
			
			boolean whiteMoved = false;
			boolean blackMoved = false;
			
			Player white = new Player('w');
			Player black = new Player('b');
			//System.out.println("White ID is: " + white.getPlayerID());
			
			char wPID = white.getPlayerID();
			char bPID = black.getPlayerID();

			bo.setBoard(bo); 
			//bo.printBoard(bo);
			
		
			//NOTE: maybe a game loop until ischeckMate is true so that the game keeps getting moves and updating the board
		
			while(check == false){
				
				if(whiteMoved == false){
					bo.printBoard(bo);
					input = white.makeMove(wPID, check);
					
					
					if(input.equals("GameOver")){
						return;
					}
					
					//if(enPassant == true){
					
					if(input.length() > 5){
						String delim = "[ ]+";
						String[] tokens = input.split(delim);
						
						if(tokens[2].equals("draw?")){
							input = black.makeMove(bPID, check);
							if(input.equals("GameOver"))
								return;
						}
							
					}
						bo.getMove(bo, input, wPID);
						whiteMoved = true;
						blackMoved = false;
					
				}
				else if(blackMoved == false){
					bo.printBoard(bo);
					input = black.makeMove(bPID, check);
					
					if(input.equals("GameOver")){
						return;
					}
					
					if(input.length() > 5){
						String delim = "[ ]+";
						String[] tokens = input.split(delim);
						
						if(tokens[2].equals("draw?")){
							input = white.makeMove(wPID, check);
							if(input.equals("GameOver"))
								return;
						}	
					}
						bo.getMove(bo, input, bPID);
						blackMoved = true;
						whiteMoved = false;
				}	
			}
		}	
}
