/**
 * Defines the two player teams of the game (Black and White) and gives IDs
 * to determine move order
 * 
 * @author Jake Van Osten
 * @author Tiffany Moral
 * 
 * @see #Player
 *          
 */

package gameBoard;

import java.util.Scanner;

import chessPieces.Bishop;
import chessPieces.GamePiece;
import chessPieces.Knight;
import chessPieces.Pawn;
import chessPieces.Queen;
import chessPieces.Rook;

public class Player {

	private char playerID;

	
	/*
	 * Player Class constructor
	 */
	public Player(char playerID){
		this.playerID = playerID;
	}
	
	/**
     * returns an integer corresponding to the teams color when created
     * 
     * @return 		0 for white team and 1 for black team
     * 
     */
	public char getPlayerID(){
		return playerID;
	}
	
	/**
     * reads in user input and checks against commands, then returns input string
     * 
     * @param pID	char used to delineate colors of teams
     * @param isCheckmate	boolean used to determine if the game is over
     * 
     * @return 		String of user input (coordinates for piece moving)
     * 
     */
	public String makeMove(char pID, boolean isCheckmate){
		System.out.println();
		Scanner reader = new Scanner(System.in);
		String input;
		if(pID == 'w'){
			System.out.print("White's Move: ");	
			input = reader.nextLine();
			
			
			
			
			if(input.equals("resign") || input.equals("Resign")){
				System.out.println("Black wins");
				reader.close();
				return "GameOver";
			}
			
			if(input.equals("draw")){
				reader.close();
				return "GameOver";
			}
			
			while((input.charAt(0) < 'a') || (input.charAt(0) > 'h') || (input.charAt(3) < 'a') || (input.charAt(3) > 'h') || (input.charAt(1) < '1') || (input.charAt(1) > '8') || (input.charAt(4) < '1') || (input.charAt(4) > '8')) {
				
				
				System.out.println("Illegal move, try again");
				System.out.print("White's Move: ");
				input = reader.nextLine();
			}
			
		}else{
			System.out.print("Black's Move: ");
			input = reader.nextLine();
			
			
			
			if(input.equals("resign") || input.equals("Resign")){
				System.out.println("White wins");
				reader.close();
				return "GameOver";
			}
			
			if(input.equals("draw")){
				reader.close();
				System.out.println("exiting player class");
				return "GameOver";
			}
			
			while((input.charAt(0) < 'a') || (input.charAt(0) > 'h') || (input.charAt(3) < 'a') || (input.charAt(3) > 'h') || (input.charAt(1) < '1') || (input.charAt(1) > '8') || (input.charAt(4) < '1') || (input.charAt(4) > '8')) {
				
				
				System.out.println("Illegal move, try again");
				System.out.print("Black's Move: ");
				input = reader.nextLine();
			}
			
		}
		
		
		if(isCheckmate == true)
			reader.close();
		
		
		return input;
	}
	
	/**
     * checks the location of the players king to show if he 
     * is in check from any players on the opposing team
     * 
     * @param kingRow	int for the row value of the kings location
     * @param kingCol	int for the col value of the kings location
     * @param p			Player whose king is in question
     * 
     * @return 		true if king is in check from other team's pieces, false otherwise
     * 
     */
	public boolean inCheck(int kingRow, int kingCol, Player p) {
		//locate king of players color on board - do reverse pathClear for every pieces path type, if piece from other team found on path then check
		int theirColor;
		if(p.getPlayerID() == 'w') { theirColor=1;}
		else { theirColor=0;}
		
		String king = Board.convRow(kingRow).concat(Board.convCol(kingCol));
		GamePiece curr;
		String currLoc;
		for(int i =0;i<8;i++) {
			for(int k=0;k<8;k++) {
				if (Board.cells[i][k] instanceof GamePiece) {
					if(((GamePiece) Board.cells[i][k]).whiteOrBlack == theirColor) { //opponents piece
						curr = (GamePiece) Board.cells[i][k];
						currLoc = Board.convRow(i).concat(Board.convCol(kingCol));
						if(curr instanceof Bishop){
							Bishop currB = (Bishop) curr;
							if(currB.tryMove(currLoc, king)) { return true;}
						}
						else if(curr instanceof Knight){
							Knight currB = (Knight) curr;
							if(currB.tryMove(currLoc, king)) { return true;}
						}
						else if(curr instanceof Pawn){
							Pawn currB = (Pawn) curr;
							if(currB.tryMove(currLoc, king)) { return true;}
						}
						else if(curr instanceof Queen){
							Queen currB = (Queen) curr;
							if(currB.tryMove(currLoc, king)) { return true;}
						}
						else if(curr instanceof Rook){
							Rook currB = (Rook) curr;
							if(currB.tryMove(currLoc, king)) { return true;}
						}
					}
				}
			}
		}
		return false;
	}
	
}
