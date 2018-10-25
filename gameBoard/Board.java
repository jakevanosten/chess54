package gameBoard;

import java.util.StringJoiner;
import chessPieces.*;

public class Board<T>{
	int row, col = 0;
	private T cells[][];
	
	public Board(){
		this.row = 9;
		this.col = 9;
	}
	
	@SuppressWarnings("unchecked")
	public void setBoard(Board<T> b) {
		
		b.cells[0][0] = (T) new Rook("bR");
		b.cells[0][1] = (T) new Knight("bN");
		b.cells[0][2] = (T) new Bishop("bB");
		b.cells[0][3] = (T) new Queen("bQ");
		b.cells[0][4] = (T) new King("bK");
		b.cells[0][5] = (T) new Bishop("bB");
		b.cells[0][6] = (T) new Knight("bN");
		b.cells[0][7] = (T) new Rook("bR");
		b.cells[0][8] = (T) new Legend("8"); 
		
		b.cells[1][0] = (T) new Pawn("bp");
		b.cells[1][1] = (T) new Pawn("bp");
		b.cells[1][2] = (T) new Pawn("bp");
		b.cells[1][3] = (T) new Pawn("bp");
		b.cells[1][4] = (T) new Pawn("bp");
		b.cells[1][5] = (T) new Pawn("bp");
		b.cells[1][6] = (T) new Pawn("bp");
		b.cells[1][7] = (T) new Pawn("bp");
		b.cells[1][8] = (T) new Legend("7"); 
		
		b.cells[2][0] = (T) new BlankSpace(0);
		b.cells[2][1] = (T) new BlankSpace(1);
		b.cells[2][2] = (T) new BlankSpace(0);
		b.cells[2][3] = (T) new BlankSpace(1);
		b.cells[2][4] = (T) new BlankSpace(0);
		b.cells[2][5] = (T) new BlankSpace(1);
		b.cells[2][6] = (T) new BlankSpace(0);
		b.cells[2][7] = (T) new BlankSpace(1);
		b.cells[2][8] = (T) new Legend("6");
		
		b.cells[3][0] = (T) new BlankSpace(1);
		b.cells[3][1] = (T) new BlankSpace(0);
		b.cells[3][2] = (T) new BlankSpace(1);
		b.cells[3][3] = (T) new BlankSpace(0);
		b.cells[3][4] = (T) new BlankSpace(1);
		b.cells[3][5] = (T) new BlankSpace(0);
		b.cells[3][6] = (T) new BlankSpace(1);
		b.cells[3][7] = (T) new BlankSpace(0);
		b.cells[3][8] = (T) new Legend("5");
		
		b.cells[4][0] = (T) new BlankSpace(0);
		b.cells[4][1] = (T) new BlankSpace(1);
		b.cells[4][2] = (T) new BlankSpace(0);
		b.cells[4][3] = (T) new BlankSpace(1);
		b.cells[4][4] = (T) new BlankSpace(0);
		b.cells[4][5] = (T) new BlankSpace(1);
		b.cells[4][6] = (T) new BlankSpace(0);
		b.cells[4][7] = (T) new BlankSpace(1);
		b.cells[4][8] = (T) new Legend("4");
		
		b.cells[5][0] = (T) new BlankSpace(1);
		b.cells[5][1] = (T) new BlankSpace(0);
		b.cells[5][2] = (T) new BlankSpace(1);
		b.cells[5][3] = (T) new BlankSpace(0);
		b.cells[5][4] = (T) new BlankSpace(1);
		b.cells[5][5] = (T) new BlankSpace(0);
		b.cells[5][6] = (T) new BlankSpace(1);
		b.cells[5][7] = (T) new BlankSpace(0);
		b.cells[5][8] = (T) new Legend("3");
		
		b.cells[6][0] = (T) new Pawn("wp");
		b.cells[6][1] = (T) new Pawn("wp");
		b.cells[6][2] = (T) new Pawn("wp");
		b.cells[6][3] = (T) new Pawn("wp");
		b.cells[6][4] = (T) new Pawn("wp");
		b.cells[6][5] = (T) new Pawn("wp");
		b.cells[6][6] = (T) new Pawn("wp");
		b.cells[6][7] = (T) new Pawn("wp");
		b.cells[6][8] = (T) new Legend("2"); 
		
		b.cells[7][0] = (T) new Rook("wR");
		b.cells[7][1] = (T) new Knight("wN");
		b.cells[7][2] = (T) new Bishop("wB");
		b.cells[7][3] = (T) new Queen("wQ");
		b.cells[7][4] = (T) new King("wK");
		b.cells[7][5] = (T) new Bishop("wB");
		b.cells[7][6] = (T) new Knight("wN");
		b.cells[7][7] = (T) new Rook("wR");
		b.cells[7][8] = (T) new Legend("1"); 
		
		b.cells[8][0] = (T) new Legend("a");
		b.cells[8][1] = (T) new Legend("b");
		b.cells[8][2] = (T) new Legend("c");
		b.cells[8][3] = (T) new Legend("d");
		b.cells[8][4] = (T) new Legend("e");
		b.cells[8][5] = (T) new Legend("f");
		b.cells[8][6] = (T) new Legend("g");
		b.cells[8][7] = (T) new Legend("h");
		b.cells[8][8] = (T) new Legend(""); 
	}
	
	public void printBoard(Board<T> b) {
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
				T cell = b.cells[i][k];
				
				if(cell instanceof Bishop || cell instanceof King || cell instanceof Knight || cell instanceof Pawn || cell instanceof Queen || cell instanceof Rook) {
					cellTag = ((GamePiece) b.cells[i][k]).getTag();
				}else if(cell instanceof BlankSpace) {
					cellTag = ((BlankSpace) b.cells[i][k]).getTag();
				}else if(cell instanceof Legend) {
					cellTag = ((Legend) b.cells[i][k]).getTag();
				}
				
				System.out.print(cellTag + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Board<T> bo = new Board<T>();
		setBoard(bo);
		printBoard(bo);

	}

}