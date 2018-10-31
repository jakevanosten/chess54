/**
 * Generates a board object that sets, updates, and maintains the physical
 * representation of a chess board.
 * The board is a standard 8x8 board with actual 9x9 dimensions to account for the letter&number tags
 * 
 * @author Jake Van Osten
 * @author Tiffany Moral
 * 
 * @see #Board
 *          
 */

package gameBoard;

import chessPieces.*;

public class Board{
	int row, col = 9;
	public static CellType[][] cells;
	public static String prevPawn;
	
	
	/**
     * Board Class constructor
     */
	
	public Board(){
		this.row = 9;
		this.col = 9;
		cells = new CellType[this.row][this.col];
	}
	
	
	/**
     * returns an integer.
     * translates the given input value into corresponding row
     * returns promptly when match occurs
     * 
     * @param num	 the char row value to be compared to find equivalent to array index
     * @return 		value that corresponds to the row within 2d array
     * 
     */
	public static int transRow(char num) {
		if(num == '1') {
			return 7;
		}else if (num == '2') {
			return 6;
		}else if (num == '3') {
			return 5;
		}else if (num == '4') {
			return 4;
		}else if (num == '5') {
			return 3;
		}else if (num == '6') {
			return 2;
		}else if (num == '7') {
			return 1;
		}else if (num == '8') {
			return 0;
		}
		
		return 69;
	}
	
	/**
     * returns an String literal.
     * translates the given input value into corresponding row number
     * returns promptly when match occurs
     * 
     * @param num	 the integer row value to be compared to find equivalent to array index
     * @return 		String value that corresponds to the row within 2d array legend
     * 
     */
	public static String convRow(int num) {
		if(num == 7) {
			return "1";
		}else if (num == 6) {
			return "2";
		}else if (num == 5) {
			return "3";
		}else if (num == 4) {
			return "4";
		}else if (num == 3) {
			return "5";
		}else if (num == 2) {
			return "6";
		}else if (num == 1) {
			return "7";
		}else if (num == 0) {
			return "8";
		}
		
		return "9";
	}
	
	/**
     * returns an integer.
     * translates the given input value into corresponding column
     * returns promptly when match occurs
     * 
     * @param num	 the char value to be compared to find equivalent to array index
     * @return 		value that corresponds to the column within 2d array
     * 
     */
	public static int transCol(char letter) {
		if(letter == 'a') {
			return 0;
		}else if (letter == 'b') {
			return 1;
		}else if (letter == 'c') {
			return 2;
		}else if (letter == 'd') {
			return 3;
		}else if (letter == 'e') {
			return 4;
		}else if (letter == 'f') {
			return 5;
		}else if (letter == 'g') {
			return 6;
		}else if (letter == 'h') {
			return 7 ;
		}
		
		return 69;
	}
	
	/**
     * returns a String literal.
     * translates the given input value into corresponding column letter
     * returns promptly when match occurs
     * 
     * @param num	 the int value to be compared to find equivalent to array index letter
     * @return 		String letter that corresponds to the column within 2d array
     * 
     */
	public static String convCol(int num) {
		if(num == 0) {
			return "a";
		}else if (num == 1) {
			return "b";
		}else if (num == 2) {
			return "c";
		}else if (num == 3) {
			return "d";
		}else if (num == 4) {
			return "e";
		}else if (num == 5) {
			return "f";
		}else if (num == 6) {
			return "g";
		}else if (num == 7) {
			return "h";
		}
		
		return "x";
	}
	/**
     * sets up the objects on the 9x9 matrix chess board
     * void return nothing as the setting of the board is all done internally
     * returns promptly when match occurs
     * 
     * @param board	 board in its current start state
     * 
     * @see Rook#Rook(String, int,int,int)
     * @see Knight#Knight(String, int,int,int)
     * @see Bishop#Bishop(String, int,int,int)
     * @see Queen#Queen(String, int,int,int)
     * @see King#King(String, int,int,int)
     * @see Pawn#Pawn(String, int,int,int)
     * @see Legend#Legend(String)
     * @see BlankSpace#BlankSpace(String)
     *
     * 
     */
	public void setBoard(Board b) {
		
		Board.cells[0][0] = new Rook("bR", 1, 0,0);
		Board.cells[0][1] = new Knight("bN",1,0,1);
		Board.cells[0][2] = new Bishop("bB",1,0,2);
		Board.cells[0][3] = new Queen("bQ",1,0,3);
		Board.cells[0][4] = new King("bK",1,0,4);
		Board.cells[0][5] = new Bishop("bB",1,0,5);
		Board.cells[0][6] = new Knight("bN",1,0,6);
		Board.cells[0][7] = new Rook("bR",1,0,7);
		Board.cells[0][8] = new Legend("8"); 
		
		Board.cells[1][0] =  new Pawn("bp",1,1,0);
		Board.cells[1][1] =  new Pawn("bp",1,1,1);
		Board.cells[1][2] =  new Pawn("bp",1,1,2);
		Board.cells[1][3] =  new Pawn("bp",1,1,3);
		Board.cells[1][4] =  new Pawn("bp",1,1,4);
		Board.cells[1][5] =  new Pawn("bp",1,1,5);
		Board.cells[1][6] =  new Pawn("bp",1,1,6);
		Board.cells[1][7] =  new Pawn("bp",1,1,7);
		Board.cells[1][8] =  new Legend("7"); 
		
		Board.cells[2][0] =  new BlankSpace("  ");
		Board.cells[2][1] =  new BlankSpace("##");
		Board.cells[2][2] =  new BlankSpace("  ");
		Board.cells[2][3] =  new BlankSpace("##");
		Board.cells[2][4] =  new BlankSpace("  ");
		Board.cells[2][5] =  new BlankSpace("##");
		Board.cells[2][6] =  new BlankSpace("  ");
		Board.cells[2][7] =  new BlankSpace("##");
		Board.cells[2][8] =  new Legend("6");
		
		Board.cells[3][0] =  new BlankSpace("##");
		Board.cells[3][1] =  new BlankSpace("  ");
		Board.cells[3][2] =  new BlankSpace("##");
		Board.cells[3][3] =  new BlankSpace("  ");
		Board.cells[3][4] =  new BlankSpace("##");
		Board.cells[3][5] =  new BlankSpace("  ");
		Board.cells[3][6] =  new BlankSpace("##");
		Board.cells[3][7] =  new BlankSpace("  ");
		Board.cells[3][8] =  new Legend("5");
		
		Board.cells[4][0] =  new BlankSpace("  ");
		Board.cells[4][1] =  new BlankSpace("##");
		Board.cells[4][2] =  new BlankSpace("  ");
		Board.cells[4][3] =  new BlankSpace("##");
		Board.cells[4][4] =  new BlankSpace("  ");
		Board.cells[4][5] =  new BlankSpace("##");
		Board.cells[4][6] =  new BlankSpace("  ");
		Board.cells[4][7] =  new BlankSpace("##");
		Board.cells[4][8] =  new Legend("4");
		
		Board.cells[5][0] =  new BlankSpace("##");
		Board.cells[5][1] =  new BlankSpace("  ");
		Board.cells[5][2] =  new BlankSpace("##");
		Board.cells[5][3] =  new BlankSpace("  ");
		Board.cells[5][4] =  new BlankSpace("##");
		Board.cells[5][5] =  new BlankSpace("  ");
		Board.cells[5][6] =  new BlankSpace("##");
		Board.cells[5][7] =  new BlankSpace("  ");
		Board.cells[5][8] =  new Legend("3");
		
		Board.cells[6][0] =  new Pawn("wp",0,6,0);
		Board.cells[6][1] =  new Pawn("wp",0,6,1);
		Board.cells[6][2] =  new Pawn("wp",0,6,2);
		Board.cells[6][3] =  new Pawn("wp",0,6,3);
		Board.cells[6][4] =  new Pawn("wp",0,6,4);
		Board.cells[6][5] =  new Pawn("wp",0,6,5);
		Board.cells[6][6] =  new Pawn("wp",0,6,6);
		Board.cells[6][7] =  new Pawn("wp",0,6,7);
		Board.cells[6][8] =  new Legend("2"); 
		
		Board.cells[7][0] =  new Rook("wR",0,7,0);
		Board.cells[7][1] =  new Knight("wN",0,7,1);
		Board.cells[7][2] =  new Bishop("wB",0,7,2);
		Board.cells[7][3] =  new Queen("wQ",0,7,3);
		Board.cells[7][4] =  new King("wK",0,7,4);
		Board.cells[7][5] =  new Bishop("wB",0,7,5);
		Board.cells[7][6] =  new Knight("wN",0,7,6);
		Board.cells[7][7] =  new Rook("wR",0,7,7);
		Board.cells[7][8] =  new Legend("1"); 
		
		Board.cells[8][0] =  new Legend("a");
		Board.cells[8][1] =  new Legend("b");
		Board.cells[8][2] =  new Legend("c");
		Board.cells[8][3] =  new Legend("d");
		Board.cells[8][4] =  new Legend("e");
		Board.cells[8][5] =  new Legend("f");
		Board.cells[8][6] =  new Legend("g");
		Board.cells[8][7] =  new Legend("h");
		Board.cells[8][8] =  new Legend(""); 
	}
	/**
     * prints the chess board 2d array
     * compares each celltype to get the type of gamePiece and returns it
     * accordingly on the chess board
     * 
     * 
     * @param b	 the chess board 2d array
     * @see GamePiece#getTag()
     * 
     */
	
	public void printBoard(Board b) {
		
		String cellTag = "";
		for (int i=0; i<b.row;i++) {
			for(int k=0;k<b.col;k++) {
				CellType cell = Board.cells[i][k];
				
				if(cell instanceof Bishop || cell instanceof King || cell instanceof Knight || cell instanceof Pawn || cell instanceof Queen || cell instanceof Rook) {
					cellTag = ((GamePiece) Board.cells[i][k]).getTag();
				}else if(cell instanceof BlankSpace) {
					cellTag = ((BlankSpace) Board.cells[i][k]).getTag();
				}else if(cell instanceof Legend) {
					cellTag = ((Legend) Board.cells[i][k]).getTag() + " ";
				}
				
				System.out.print(cellTag + " ");
			}
			System.out.println();
		}
		
		

	}

	/**
     * evaluates the origin/destination input string given by user.
     * Translates the input into array coordinates, and based on object
     * within those coordinates, decides if valid move
     * 
     * @param b	 	the chess board 2d array
     * @param input the String origin &destination input given by the user
     * @param pID	the char that distinguishes b/w white and black player
     * 
     * 
     * @see #transRow(char)
     * @see #transCol(char)
     * @see #updateBoard(Board, String, String, String, char)
     * @see GamePiece#tryMove(String, String)
     * @see Pawn#isFirstMove(String)
     * @see #enPassant(Board, String, char, String, String)
     */
	public void getMove(Board b, String input, char pID){
		
		String delim = "[ ]+";
		String[] tokens = input.split(delim);
		
		
		char originLetter = tokens[0].charAt(0);
		char originNumber = tokens[0].charAt(1);
		
		char destLetter = tokens[1].charAt(0);
		char destNumber = tokens[1].charAt(1);
		String promoType = "Queen";
		
		if(tokens.length == 3) { //promotion letter
			if(tokens[2].equals("R")) {
				promoType = "Rook";
			}else if(tokens[2].equals("N")) {
				promoType = "Knight";
			}else if(tokens[2].equals("B")) {
				promoType = "Bishop";
			}else if(tokens[2].equals("Q")) {
				promoType = "Queen";
			}
		}
		
		int originRow = transRow(originNumber);
		int originCol = transCol(originLetter);
		int destRow = transRow(destNumber);
		int destCol = transCol(destLetter);
		
		boolean isValidMove;
		boolean isFirstMovement;
		
		
		
		CellType currCell = Board.cells[originRow][originCol];
		
		if (currCell instanceof BlankSpace)
			System.out.println("not valid");
		
		
		if(currCell instanceof Pawn){
			 boolean isEPcapturePREV = false;
			 boolean isEPcaptureNEXT = false;
			 char opPID;
			
			isValidMove = (((Pawn) currCell).tryMove(tokens[0],tokens[1]) && (((((Pawn) currCell).whiteOrBlack == 0 ) && pID=='w') || ((((Pawn) currCell).whiteOrBlack == 1 ) && pID=='b')));
			
			
			isFirstMovement = ((Pawn) currCell).isFirstMove(tokens[0]);
			
			if(isFirstMovement == true){
				String prevOPPawn = tokens[1];
				//System.out.println("prevPawn Coords: " + prevOPPawn);
				System.out.println("this is the pawn's first move");
				
				
				//UPDATE THE BOARD
				if(!isValidMove){
					System.out.println("illegal move, try again");
					isValidMove = (((Pawn) currCell).tryMove(tokens[0],tokens[1]) && (((((Pawn) currCell).whiteOrBlack == 0 ) && pID=='w') || ((((Pawn) currCell).whiteOrBlack == 1 ) && pID=='b')));
				}
				
				//allow other player to check if en passant
				CellType tempCell = Board.cells[destRow][destCol+1];
				CellType tempCell2 = Board.cells[destRow][destCol-1];
				
				
				//String prevPawnLoc = "" + (destRow-1) + (destCol-1);
				String prevPawnLoc = "" + destRow +(destCol+1);
				System.out.println("prevPawnLoc: " + prevPawnLoc);
				String nextPawnLoc = "" + destNumber + (destCol+1);
				System.out.println("nextPawnLoc: " + nextPawnLoc);
				
				
				if ((destRow - originRow == 2) && tempCell instanceof Pawn){
					System.out.println("En Passant is possible in prev column " + (destCol+1));
					
					
					
					updateBoard(b, tokens[0], tokens[1], "Pawn", pID);
					isEPcapturePREV = true;
				}
				else if ((destRow - originRow == 2) && tempCell2 instanceof Pawn){
					System.out.println("En Passant is possible in column " + (destCol-1));
					updateBoard(b, tokens[0], tokens[1], "Pawn", pID);
					isEPcaptureNEXT = true;
				}else{
					System.out.println("En passant not valid");
					updateBoard(b, tokens[0], tokens[1], "Pawn", pID);
				}
				//prevOPPawn: stores previous pawn move
				//opPID: sends in opponents PID to make next move
				//tempCell: stores location of which pawn can potentially make EP capture
				if(isEPcapturePREV == true){
					String possEP_Pawn = "prevcol";
					System.out.println("lets do the EP  on the left");
					//Let next player decide to do EP or not
					if(pID == 'w'){
						opPID = 'b';
					}else{
						opPID = 'w';
					}
					enPassant(b, prevOPPawn, opPID, prevPawnLoc, possEP_Pawn);
				}
				else if(isEPcaptureNEXT == true){
					String possEP_Pawn = "nextcol";
					System.out.println("lets do EP on the right");
					//Let next player decide to do EP or not
					if(pID == 'w'){
						opPID = 'b';
					}else{
						opPID = 'w';
					}
					enPassant(b, prevOPPawn, opPID, nextPawnLoc, possEP_Pawn);	
				}
			}	
			else{	//if not pawn's first time moving
				System.out.println("Not pawn's first move; En passant not valid");
				if(Pawn.promotionFlag==1) { //a promotion occurred, get rid of pawn and update with whatever is in user input
					updateBoard(b, tokens[0], tokens[1], promoType, pID);
				}else {
					updateBoard(b, tokens[0], tokens[1], "Pawn", pID);
				}
			}
		} else if(currCell instanceof Bishop){
			
			isValidMove = (((Bishop) currCell).tryMove(tokens[0],tokens[1]) && (((((Bishop) currCell).whiteOrBlack == 0 ) && pID=='w') || ((((Bishop) currCell).whiteOrBlack == 1 ) && pID=='b')));
			
			if(isValidMove){
				updateBoard(b, tokens[0], tokens[1], "Bishop", pID);
			}
			else
				System.out.println("fail");
			
		} else if(currCell instanceof King){
			
			isValidMove = (((King) currCell).tryMove(tokens[0],tokens[1]) && (((((King) currCell).whiteOrBlack == 0 ) && pID=='w') || ((((King) currCell).whiteOrBlack == 1 ) && pID=='b')));
			
			if(isValidMove){
				if(King.castlingFlag==1) { //a castling occurred, must change rook as well
					updateBoard(b, tokens[0], tokens[1], "King", pID);
					if(pID =='w' && destLetter>originLetter) {//rook at h1 going to f1
						updateBoard(b,"h1","f1","Rook", pID);
					}else if(pID =='w' && destLetter < originLetter) { //rook at a1 going to d1
						updateBoard(b,"a1","d1","Rook",pID);
					}else if(pID =='b' && destLetter>originLetter) {//rook at h8 going to f8
						updateBoard(b,"h8","f8","Rook", pID);
					}else if(pID =='b' && destLetter < originLetter) { //rook at a8 going to d8
						updateBoard(b,"a8","d8","Rook",pID);
					}
				}
				updateBoard(b, tokens[0], tokens[1], "King", pID);
			}
			else
				System.out.println("fail");
			
		}else if(currCell instanceof Queen){
			
			isValidMove = (((Queen) currCell).tryMove(tokens[0],tokens[1]) && (((((Queen) currCell).whiteOrBlack == 0 ) && pID=='w') || ((((Queen) currCell).whiteOrBlack == 1 ) && pID=='b')));
			
			if(isValidMove){
				updateBoard(b, tokens[0], tokens[1], "Queen", pID);
			}
			else
				System.out.println("fail");
			
		}else if(currCell instanceof Knight){
			
			isValidMove = (((Knight) currCell).tryMove(tokens[0],tokens[1]) && (((((Knight) currCell).whiteOrBlack == 0 ) && pID=='w') || ((((Knight) currCell).whiteOrBlack == 1 ) && pID=='b')));
			
			if(isValidMove){
				updateBoard(b, tokens[0], tokens[1], "Knight", pID);
			}
			else
				System.out.println("fail");
			
		}else if(currCell instanceof Rook){
			
			isValidMove = (((Rook) currCell).tryMove(tokens[0],tokens[1]) && (((((Rook) currCell).whiteOrBlack == 0 ) && pID=='w') || ((((Rook) currCell).whiteOrBlack == 1 ) && pID=='b')));
			
			if(isValidMove){
				 updateBoard(b, tokens[0], tokens[1], "Rook", pID);
			}
			else
				System.out.println("fail");
			
		}	
		
	}
	
	/**
     * executes when pawns move into the en passant position
     * this allows an opponent to capture the other if the other person moves their pawn 2 moves
     * 
     * @param b	 		   the chess board 2d array
     * @param prevPawnMove the location of the pawn that moved two spaces
     * @param pID	       the char that distinguishes b/w white and black player
     * @param prevPawnLoc  the location of pawn that can carry the en passant capture move
     * @param possEP_Pawn  the string indication of whether the capture will take place in previous or next column to the prevPawnLoc
     * 
     * 
     * @see #transRow(char)
     * @see #transCol(char)
     * @see #updateBoard(Board, String, String, String, char)
     * @see GamePiece#tryMove(String, String)
     * @see Pawn#isFirstMove(String)
     */
	public void enPassant(Board b, String prevPawnMove, char pID, String prevPawnLoc, String possEP_Pawn){
		
	
		System.out.println("previous pawn move coordinates: " + prevPawnMove);
		System.out.println("current player: " + pID);
		System.out.println("player current location: " + prevPawnLoc);
		
		
		int prevPRow = transRow(prevPawnMove.charAt(1));
		int prevPCol = transCol(prevPawnMove.charAt(0));
		//int clearPRow = (prevPawnLoc.charAt(1));
		//System.out.println("clearPRow: " + clearPRow);
		//int clearPCol = (prevPawnLoc.charAt(0));
		//System.out.println("clearPCol: " + clearPCol);
		
		if(possEP_Pawn.equals("prevcol")){
			
			
			
			if(pID == 'w'){
				
				Board.cells[prevPRow-1][prevPCol-1] = new Pawn("wp", 0,prevPRow-1,prevPCol-1);
				//b.cells[prevPRow][prevPCol] = new BlankSpace("  ");
				//b.cells[clearPRow][clearPCol] = new BlankSpace("  ");
				 
			}
			else if(pID == 'b'){
				Board.cells[prevPRow+1][prevPCol-1] = new Pawn("bp", 1,prevPRow+1,prevPCol-1);
				//b.cells[prevPRow][prevPCol] = new BlankSpace("  ");
			}
			
		}
	}
	
		
		//if every possible move is impossible to escape check, that is a checkmate. 
		//(check all possible moves for a king (8 kinds) to see if they do not set off the check, if they all do checkmate

	/**
     * evaluates if chess board is in checkmate position prompting for the game to end
     * 
     * @param b	 	the chess board 2d array
     * 
     *
     */
	
	public static boolean isCheckmate(Board b){
		
		//Scan board to see if in CheckMate position
		
		//if not in CheckMate
		return false;
		//else, return true!
	}
	
	
	
	/**
     * updates the board based on the input given by the user
     * the method first clears the origin cell and then updates the destination cell for the correct player
     * 
     * @param b	 		the chess board 2d array
     * @param curr  	string for the origin location
     * @param next  	string for the next (destination) location
     * @param pieceType string that indicates the type of chess piece
     * @param pID		char that indicates white or black player 
     * 
     * @see #transRow(char)
     * @see #transRow(char)
     * @see BlankSpace#BlankSpace(String)
     * @see Pawn#Pawn(String, int,int,int)
     * @see Bishop#Bishop(String, int,int,int)
     * @see Knight#Knight(String, int,int,int)
     * @see Rook#Rook(String, int,int,int)
     * @see Queen#Queen(String, int,int,int) 
     * @see King#King(String, int,int,int)
     *
     */
	//ROWS REFER TO LETTERS
	public void updateBoard(Board b, String curr, String next, String pieceType, char pID){
		
		int originRow = transRow(curr.charAt(1));
		int originCol = transCol(curr.charAt(0));
		int destRow = transRow(next.charAt(1));
		int destCol = transCol(next.charAt(0));
		//clear old cell
		System.out.println();
		
		if((originRow == 2 || originRow == 4) && (originCol % 2 != 0))
			Board.cells[originRow][originCol] = new BlankSpace("##");
		
		else if((originRow == 2 || originRow == 4) && (originCol % 2 == 0))
			Board.cells[originRow][originCol] = new BlankSpace("  ");
		
		else if((originRow == 3 || originRow == 5) && (originCol % 2 == 0))
			Board.cells[originRow][originCol] = new BlankSpace("##");
		
		else if((originRow == 3 || originRow == 5) && (originCol % 2 != 0))
			Board.cells[originRow][originCol] = new BlankSpace("  ");
		
		else if((originRow == 0 || originRow == 6) && (originCol % 2 == 0))
			Board.cells[originRow][originCol] = new BlankSpace("  ");
		
		else if((originRow == 0 || originRow == 6) && (originCol % 2 != 0))
			Board.cells[originRow][originCol] = new BlankSpace("##");
		
		else if((originRow == 1 || originRow == 7) && (originCol % 2 != 0))
			Board.cells[originRow][originCol] = new BlankSpace("  ");
		
		else if((originRow == 1 || originRow == 7) && (originCol % 2 == 0))
			Board.cells[originRow][originCol] = new BlankSpace("##");
		
		
		
			
		//Update new cell 
		
		//Pawn Piece Update
		if(pieceType.equals("Pawn") && pID == 'w'){
			Board.cells[destRow][destCol] = null;
			Board.cells[destRow][destCol] = new Pawn("wp", 0,destRow,destCol);
		}
		else if(pieceType.equals("Pawn") && pID == 'b'){
			Board.cells[destRow][destCol] = null;
			Board.cells[destRow][destCol] = new Pawn("bp", 1,destRow,destCol);
		}
		
		//Bishop Piece Update
		if(pieceType.equals("Bishop") && pID == 'w'){
			Board.cells[destRow][destCol] = null;
			Board.cells[destRow][destCol] = new Bishop("wB", 0,destRow,destCol);
		}
		else if(pieceType.equals("Bishop") && pID == 'b'){
			Board.cells[destRow][destCol] = null;
			Board.cells[destRow][destCol] = new Bishop("bB", 1,destRow,destCol);
		}
		
		//Knight Piece Update
		if(pieceType.equals("Knight") && pID == 'w'){
			Board.cells[destRow][destCol] = null;
			Board.cells[destRow][destCol] = new Knight("wN", 0,destRow,destCol);
		}
		else if(pieceType.equals("Knight") && pID == 'b'){
			Board.cells[destRow][destCol] = null;
			Board.cells[destRow][destCol] = new Knight("bN", 1,destRow,destCol);
		}
		
		//Rook Piece Update
		if(pieceType.equals("Rook") && pID == 'w'){
			Board.cells[destRow][destCol] = null;
			Board.cells[destRow][destCol] = new Rook("wR", 0,destRow,destCol);
		}
		else if(pieceType.equals("Rook") && pID == 'b'){
			Board.cells[destRow][destCol] = null;
			Board.cells[destRow][destCol] = new Rook("bR", 1,destRow,destCol);
		}
		
		//Queen Piece Update
		if(pieceType.equals("Queen") && pID == 'w'){
			Board.cells[destRow][destCol] = null;
			Board.cells[destRow][destCol] = new Queen("wQ", 0,destRow,destCol);
		}
		else if(pieceType.equals("Queen") && pID == 'b'){
			Board.cells[destRow][destCol] = null;
			Board.cells[destRow][destCol] = new Queen("bQ", 1,destRow,destCol);
		}
		
		//King Piece Update
		if(pieceType.equals("King") && pID == 'w'){
			Board.cells[destRow][destCol] = null;
			Board.cells[destRow][destCol] = new King("wK", 0,destRow,destCol);
		}
		else if(pieceType.equals("King") && pID == 'b'){
			Board.cells[destRow][destCol] = null;
			Board.cells[destRow][destCol] = new King("bK", 1,destRow,destCol);
		}
		
	}
	
	
	public static void main(String[] args) {
		
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