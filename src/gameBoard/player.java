package gameBoard;

import java.util.Scanner;

public class player {

	private char playerID;

	
	
	public player(char playerID){
		this.playerID = playerID;
	}
	
	public char getPlayerID(){
		return playerID;
	}
	
	public String makeMove(char pID, boolean isCheckmate){
		
		Scanner reader = new Scanner(System.in);
		String input;
		if(pID == 'w'){
			System.out.print("White Move: ");	
			input = reader.nextLine();
		}else{
			System.out.print("Black Move: ");
			input = reader.nextLine();
		}
		
		while(input.length() != 5 || (input.charAt(0) == input.charAt(3) && input.charAt(1) == input.charAt(4)) || (input.charAt(0) < 'a') || (input.charAt(0) > 'h') || (input.charAt(3) < 'a') || (input.charAt(3) > 'h') || (input.charAt(1) < '1') || (input.charAt(1) > '8') || (input.charAt(4) < '1') || (input.charAt(4) > '8')) {
			System.out.println("Illegal move, try again");
			System.out.print("White Move: ");
			input = reader.nextLine();
		}
		
		
		
		
		if(isCheckmate == true)
			reader.close();
		
		
		return input;
	}
	
}
