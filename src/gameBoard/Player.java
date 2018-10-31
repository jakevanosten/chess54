package gameBoard;

import java.util.Scanner;

public class Player {

	private char playerID;

	
	
	public Player(char playerID){
		this.playerID = playerID;
	}
	
	public char getPlayerID(){
		return playerID;
	}
	
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
	
}
