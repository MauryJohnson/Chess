package Player;

import Piece.Piece;

public class Player {

public char Player;
//'1' or '2'
public Piece[] Pieces;
// 'O' No Check and 'C' Checked player
public char Checked;

//public Board B;

public Player(char Player) {
	this.Player = Player;
	this.Pieces = null;
}


public Player GP() {
	return this;
}
//Create Player object
public void SetPlayer(char Player, char[][]B) {
	//CREATE ALL PIECES
	//Create_Piece(char type,int[] Pos, char Status)
	//TYPES r k b K Q p
	//Piece[] P = new Piece[16];
	if(Player=='1') {
	//Start at coords 0	
	this.Player='1';
	this.Pieces = new Piece[16];
	for(int i=0; i<16; i++){
		this.Pieces[i]=new Piece('1');
	}
	System.out.println("Have Player 1 Set");
	}
	else if(Player=='2') {
	//Start at coords 7
	this.Player='2';
	this.Pieces= new Piece[16];
	for(int i=0; i<16; i++){
		this.Pieces[i]=new Piece('2');
	}
	System.out.println("Have Player 2 Set");
		
	}
	else {
		System.out.println("There can only be Player 1 or Player 2! [SetPlayer]");
		System.exit(-1);
	}
	
	this.SetPieces(B);
}

public char getPlayerId() {
	return this.Player;
}

public Piece[] SetPieces(char [][] Board) {
	//Loop through all piece configurations
	// Create_Piece(char type,int[] Pos, char[] Status)
	//Player? "1O" "2O" OR GONE "1X" or "2X", CheckMated(Only For King) "1C" or "2C"
	if(this.Player=='1') {
		//Player 1 Piece set [Top]
		int J  = 8;
		int start = 0;
		for(int i=0;i<2;i++) {
			for(int j=start;j<J;j++) {
				//O is unaffected state
				//X is eliminated
				//C is check/checkmate (King)
				char type = Board[i][j-start];
				int[] Pos = {i,j-start};
				char[] Status = {'1','O'};
				//System.out.printf("TYPE: %c Position: [%d,%d], Status: [%c,%c]\n",type,i,j-start,Status[0],Status[1]);
				this.Pieces[j].Create_Piece(type,Pos , Status);
			}
			start = J;
			J = start+start;
		}
		System.out.println();
		
	}
	else {
		//Player 2 Piece set [Bottom]
		int L  = 8;
		int start = 0;
		for(int i=6;i<8;i++) {
			for(int j=start;j<L;j++) {
				char type = Board[i][j-start];
				int[] Pos = {i,j-start};
				//O is unaffected state
				//X is eliminated
				//C is check/checkmate (King)
				char[] Status = {'2','O'};
				//System.out.printf("TYPE: %c Position: [%d,%d], Status: [%c,%c]\n",type,i,j-start,Status[0],Status[1]);
				this.Pieces[j].Create_Piece(type,Pos , Status);
			}
			start = L;
			L=start+start;
		}
		System.out.println();
		
	}
	
	return null;
}

/*
public void PrintPiecePos(int[]Pos) {
	
	
	
}
*/
public void PrintPieces() {
	
	System.out.printf("\nPieces For Player %c\n",this.Player);
	
	for(int i=1;i<Pieces.length;i++) {
	if(Pieces[i].Status[1]=='X') {
		//Dead
		System.out.printf("Piece %d: %c,X,[%d,%d]\n",i,Pieces[i].type,Pieces[i].Position[0],Pieces[i].Position[1]);
	}
	else {
		//Alive
		System.out.printf("Piece %d: %c,O,[%d,%d]\n",i,Pieces[i].type,Pieces[i].Position[0],Pieces[i].Position[1]);
	}
		
	}
	
}
	
	
}
