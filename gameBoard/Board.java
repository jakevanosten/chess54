package gameBoard;

import chessPieces.*;

public class Board{
	int row, col = 0;
	private CellType[][] cells;
	
	public Board(){
		this.row = 9;
		this.col = 9;
		cells = new CellType[this.row][this.col];
	}
	
	public static int transRow(String num) {
		if(num.equals("1")) {
			return 7;
		}else if (num.equals("2")) {
			return 6;
		}else if (num.equals("3")) {
			return 5;
		}else if (num.equals("4")) {
			return 4;
		}else if (num.equals("5")) {
			return 3;
		}else if (num.equals("6")) {
			return 2;
		}else if (num.equals("7")) {
			return 1;
		}else if (num.equals("8")) {
			return 0;
		}
		
		return 0;
	}
	
	public static int transCol(String letter) {
		if(letter.equals("a")) {
			return 0;
		}else if (letter.equals("b")) {
			return 1;
		}else if (letter.equals("c")) {
			return 2;
		}else if (letter.equals("d")) {
			return 3;
		}else if (letter.equals("e")) {
			return 4;
		}else if (letter.equals("f")) {
			return 5;
		}else if (letter.equals("g")) {
			return 6;
		}else if (letter.equals("h")) {
			return 7 ;
		}
		
		return 0;
	}
	
	public static void setBoard(Board b) {
		
		b.cells[0][0] = new Rook("bR");
		b.cells[0][1] = new Knight("bN");
		b.cells[0][2] = new Bishop("bB");
		b.cells[0][3] = new Queen("bQ");
		b.cells[0][4] = new King("bK");
		b.cells[0][5] = new Bishop("bB");
		b.cells[0][6] = new Knight("bN");
		b.cells[0][7] = new Rook("bR");
		b.cells[0][8] = new Legend("8"); 
		
		b.cells[1][0] =  new Pawn("bp");
		b.cells[1][1] =  new Pawn("bp");
		b.cells[1][2] =  new Pawn("bp");
		b.cells[1][3] =  new Pawn("bp");
		b.cells[1][4] =  new Pawn("bp");
		b.cells[1][5] =  new Pawn("bp");
		b.cells[1][6] =  new Pawn("bp");
		b.cells[1][7] =  new Pawn("bp");
		b.cells[1][8] =  new Legend("7"); 
		
		b.cells[2][0] =  new BlankSpace("  ");
		b.cells[2][1] =  new BlankSpace("##");
		b.cells[2][2] =  new BlankSpace("  ");
		b.cells[2][3] =  new BlankSpace("##");
		b.cells[2][4] =  new BlankSpace("  ");
		b.cells[2][5] =  new BlankSpace("##");
		b.cells[2][6] =  new BlankSpace("  ");
		b.cells[2][7] =  new BlankSpace("##");
		b.cells[2][8] =  new Legend("6");
		
		b.cells[3][0] =  new BlankSpace("##");
		b.cells[3][1] =  new BlankSpace("  ");
		b.cells[3][2] =  new BlankSpace("##");
		b.cells[3][3] =  new BlankSpace("  ");
		b.cells[3][4] =  new BlankSpace("##");
		b.cells[3][5] =  new BlankSpace("  ");
		b.cells[3][6] =  new BlankSpace("##");
		b.cells[3][7] =  new BlankSpace("  ");
		b.cells[3][8] =  new Legend("5");
		
		b.cells[4][0] =  new BlankSpace("  ");
		b.cells[4][1] =  new BlankSpace("##");
		b.cells[4][2] =  new BlankSpace("  ");
		b.cells[4][3] =  new BlankSpace("##");
		b.cells[4][4] =  new BlankSpace("  ");
		b.cells[4][5] =  new BlankSpace("##");
		b.cells[4][6] =  new BlankSpace("  ");
		b.cells[4][7] =  new BlankSpace("##");
		b.cells[4][8] =  new Legend("4");
		
		b.cells[5][0] =  new BlankSpace("##");
		b.cells[5][1] =  new BlankSpace("  ");
		b.cells[5][2] =  new BlankSpace("##");
		b.cells[5][3] =  new BlankSpace("  ");
		b.cells[5][4] =  new BlankSpace("##");
		b.cells[5][5] =  new BlankSpace("  ");
		b.cells[5][6] =  new BlankSpace("##");
		b.cells[5][7] =  new BlankSpace("  ");
		b.cells[5][8] =  new Legend("3");
		
		b.cells[6][0] =  new Pawn("wp");
		b.cells[6][1] =  new Pawn("wp");
		b.cells[6][2] =  new Pawn("wp");
		b.cells[6][3] =  new Pawn("wp");
		b.cells[6][4] =  new Pawn("wp");
		b.cells[6][5] =  new Pawn("wp");
		b.cells[6][6] =  new Pawn("wp");
		b.cells[6][7] =  new Pawn("wp");
		b.cells[6][8] =  new Legend("2"); 
		
		b.cells[7][0] =  new Rook("wR");
		b.cells[7][1] =  new Knight("wN");
		b.cells[7][2] =  new Bishop("wB");
		b.cells[7][3] =  new Queen("wQ");
		b.cells[7][4] =  new King("wK");
		b.cells[7][5] =  new Bishop("wB");
		b.cells[7][6] =  new Knight("wN");
		b.cells[7][7] =  new Rook("wR");
		b.cells[7][8] =  new Legend("1"); 
		
		b.cells[8][0] =  new Legend("a");
		b.cells[8][1] =  new Legend("b");
		b.cells[8][2] =  new Legend("c");
		b.cells[8][3] =  new Legend("d");
		b.cells[8][4] =  new Legend("e");
		b.cells[8][5] =  new Legend("f");
		b.cells[8][6] =  new Legend("g");
		b.cells[8][7] =  new Legend("h");
		b.cells[8][8] =  new Legend(""); 
	}
	
	public static void printBoard(Board b) {
		/*
		String[][] board = { { "bR ", "bN ", "bB ", "bQ ", "bK ", "bB ", "bN ", "bR ", "8" },
				{ "bp ", "bp ", "bp ", "bp ", "bp ", "bp ", "bp ", "bp ", "7" },
				{ "  ", " ## ", "  ", " ## ", "  ", " ## ", "  ", " ## ", "6" },
				{ "## ", "  ", " ## ", "  ", " ## ", "  ", " ## ", "   ", "5" },
				{ "  ", " ## ", "  ", " ## ", "  ", " ## ", "  ", " ## ", "4" },
				{ " ## ", "  ", " ## ", "  ", " ## ", "  ", " ## ", "  ", "3" },
				{ "wp ", "wp ", "wp ", "wp ", "wp ", "wp ", "wp ", "wp ", "2" },
				{ "wR ", "wN ", "wB ", "wQ ", "wK ", "wB ", "wN ", "wR ", "1" },
				{ " a ", " b ", " c ", " d ", " e ", " f ", " g ", " h " } };
		
		
		
		for (int row = 0; row < board.length; row++) {

			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + " ");
			}
			System.out.println();
		}
		*/
		String cellTag = "";
		for (int i=0; i<b.row;i++) {
			for(int k=0;k<b.col;k++) {
				CellType cell = b.cells[i][k];
				
				if(cell instanceof Bishop || cell instanceof King || cell instanceof Knight || cell instanceof Pawn || cell instanceof Queen || cell instanceof Rook) {
					cellTag = ((GamePiece) b.cells[i][k]).getTag();
				}else if(cell instanceof BlankSpace) {
					cellTag = ((BlankSpace) b.cells[i][k]).getTag();
				}else if(cell instanceof Legend) {
					cellTag = ((Legend) b.cells[i][k]).getTag() + " ";
				}
				
				System.out.print(cellTag + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Board bo = new Board();
		setBoard(bo); 
		printBoard(bo);

	}

}