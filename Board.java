package Board;

import java.util.*;

import Piece.Piece;

import Player.Player;

public class Board {
//Board Class contains Board
	//Has all characters and their status
	public char[][] BoardC;
	//ALL Board Pieces included in Board
	public Player[] Players;
    //Board Constructor
	public Board() {
		this.BoardC=null;
		this.Players=null;
	}
	public void SetBoard(char[][]B) {
		this.BoardC = B.clone();
		//Two New Players
		Player P1 = new Player('1');
		P1.SetPlayer('1',B);
		Player P2 = new Player('2');
		P2.SetPlayer('2',B);
		//Have Both Players For Board Game
		Player[] P = new Player[2];
		P[0] = P1;
		P[1]=P2;
		this.Players = P;
	}
	public void PrintBoard() {
	    char[][]B = this.BoardC;
		
		System.out.println("Print Board, Status, Movesets\n");
		
		for(int i=0; i<B.length;i++) {
			for(int k=0; k<B[i].length;k++) {
				//System.out.printf("%c,%c ",B[i][k],GetPlayer(i,k));
				Piece P = GetPlayer(i,k);
				if(P!=null) {
					//TYPEEEEEEEEEEEEEEEEEEEEEEEEEE
				if(P.Status[1]=='O') {
				System.out.printf("%c,%c,%c ",P.Player, P.type,/*P.CMovesets==null? 'C':'K'*/P.Status[1]);
				}
				else {
					System.out.printf("%c,%c,%c ",P.Player, P.type,P.CMovesets==null? 'C':'K');	
				}
				B[i][k]=P.type;
				/*
				System.out.printf("[%c,%c,%c,[",B[i][k],P.Status[0],P.Status[1]);
				for(int h=0;h<P.Movesets.length;h++) {
					if(h==P.Movesets.length-1) {
						System.out.printf("%s",P.Movesets[h]);
					}
					else
					System.out.printf("%s,",P.Movesets[h]);
				}
				if(k==B[i].length-1) {
				System.out.print("]] ");
				}
				else
				System.out.print("]], ");
				*/
				}
				
				else {
					//B[i][k]='0';
					//System.out.printf("%c,X ",B[i][k]);////////////////////////IMPORTANT
					////////////////////////////////////////////////////////////////////// CHANGED OUTPUT TO IGNORE
					//IGNOREING IF P is NULL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					System.out.printf("0,0,0 ");
					//System.out.printf("0,X ");
				}
			}	
			System.out.println();
		}
			System.out.println();
	}
	//Searches each player's pieces for matching position, then returns the player 1 or 2
	//If no player owns piece in i,j, returns X
	public Piece GetPlayer(int i, int j) {
		//Get Player Type given position
		Piece [] P1p = Players[0].Pieces;
		for(int k=0;k<16;k++) {
			//System.out.printf("Compare piece pos [%d,%d] to Board Pos [%d,%d]\n",P1p[k].Position[0],P1p[k].Position[1],i,j);
			if(P1p[k].Position[0]==i&&P1p[k].Position[1]==j) {
				//Found piece of player 1(black)
				return P1p[k];
				}
		}
		
		Piece [] P2p = Players[1].Pieces;
		
		for(int l=0;l<16;l++) {
			//System.out.printf("Compare piece pos [%d,%d] to Board Pos [%d,%d]\n",P1p[l].Position[0],P1p[l].Position[1],i,j);
			if(P2p[l].Position[0]==i&&P2p[l].Position[1]==j) {
			//Found piece of player 2(black)
			return P2p[l];
			}
			
		}
		
		return null;
	}
	
	public Piece Move(Piece P, int[] j, Player P2, boolean Temp) {
		
		//Set New Position
	    //this.Players[1].Pieces[Type].Position =P;
		
		/*
		if(P.Status[1]=='C'||P.CMovesets!=null&&!Temp) {
	    	System.out.println("This piece cannot save king in check, cannot move");
	    	return null;	
	    }
		*/
		
		int Difference =0;
	    
		int [] OldPos = new int[2];
		OldPos[0] = P.Position[0];
		OldPos[1] = P.Position[1];
		//P.Position = j;
		this.BoardC[OldPos[0]][OldPos[1]] = '0';
		
		int j1 = j[0];
		int j2 = j[1];
		
		int D1 = (j1-OldPos[0]);
		
		int D2 = (j2 - OldPos[1]);
		if(D1<0) {
			D1 = D1*-1;
		}
		if(D2<0) {
			D2 = D2*-1;
		}
		
		Difference = D1+D2;
		
		//Difference = Math.sqrt((j1-OldPos[0])^2+(j2-OldPos[1])^2);
		
		if(Difference<0) {
			Difference = Difference*-1;
		}
		else if(Difference==0) {
			System.out.println("FAILURE DIFFerence SHOULD never by 0, because moved");
			//System.exit(-2);
		}
		
		System.out.printf("GOTO: [%d,%d]\n",j1,j2);
		
		//KILL ANY PIECE THERE
		Piece H = null;
		if(!Temp)
		KillPiece(j1,j2);
		else {
		//Found Piece, OR NOT
		H = GetPlayer(j1,j2);
		
		P.Position[0] = j[0];
		P.Position[1] = j[1];
		this.BoardC[j1][j2]  = P.type;
		
		System.out.printf("\nTEMPORARY BOARD Traverse to: [%d,%d]\n",j1,j2);
		
		return H;
		
		}
		/////////////////////
		//HERE
		int [] Prev = new int[2];
		Prev[0] = P.Position[0];
		Prev[1] = P.Position[1];
		
		P.Position[0] = j[0];
		P.Position[1] = j[1];
		/*
		if(P.type=='k')
		BoardC[j1][j2]  = 'k';
		else if(P.type=='K')
		BoardC[j1][j2] = 'K';
		else
			*/
		this.BoardC[j1][j2] = P.type;
		
		PrintBoard();
		
		//System.out.printf("\nDifference: %d\n", Difference);
	
		System.out.printf("PIECE Type: %c\n",P.type);
		
		if(P.type=='r') {
			//Rook moved, castling is voided.
			P.Castled = true;
		}
		
		/*
		if(P.type!='p'&&P.type!='K') {
			return null;
		}
		*/
		System.out.printf("\nDifference: %d, %d + %d\n", Difference,D1,D2);
		
		if((Difference>=2)&&(P.type=='K')) {
			int Rfrom = -1;
			int Rto = -1;
			
			if(j2<4) {
				//Rook1 castle
				Rto = j2+1;
				Rfrom = 0;
			}
			else {
				Rto = j2-1;
				Rfrom = 7;
			}
			
			System.out.printf("King Wants to Castle to: [%d,%d] AND ROOK TO\n",j1,j2,j1,Rto);
			//MOVE ROOK
			Piece Rook = GetPlayer(j1, Rfrom);
			if(Rook==null) {
				
				System.out.printf("\nFAILED TO FIND ROOK @ [%d,%d]\n",j1,Rfrom);
				
				System.exit(-1);
				
			}
			if(Rook.Castled) {
				System.out.println("Rook Has already castled OR Rook has already moved");
				
				P.Position[0] = Prev[0];
				P.Position[1] = Prev[1];
				
				BoardC[j1][j2] = 0;
				
				return null;
			}
			Rook.Castled = true;
			BoardC[j1][Rto] = Rook.type;
			Rook.Position[0] = j1;
			Rook.Position[1] = Rto;
			
			PrintBoard();
			
			//return null;
		}
		
		System.out.println("TEST PAWN CASE 11111111");
		if((P.type=='p')&&(P.Movesets.length>3)) {
			//Pawn Moved two tiles, remove option now
			System.out.println("Pawn Moved twice on first turn, remove option now");
			String [] NewM = new String[3];
			for(int i=0;i<P.Movesets.length;i++) {
				if(i<P.Movesets.length-1)
				NewM[i] = P.Movesets[i+1];
			}
			P.Movesets = NewM;
		}
		//Check if pawn reached end
		if((P.Position[0]==0||P.Position[0]==7)&&(P.type=='p')) {
			int R = 0;
			System.out.println("Pawn Reached End! Revive >0 or not> <=0?");
			Scanner reader = new Scanner(System.in);
			
			R = reader.nextInt();
		
			if(R>=0) {
			
			
			this.RevivePiece( P2, P.Position[0], P.Position[1]);	
			}
		}
		
		//BC[j1-1][j2] = '0';
	    
		return null;
	}
	
	//Kill Player's Piece from board..
	public void KillPiece(int i, int j) {
		Piece P = GetPlayer(i,j);
		if(P!=null) {
		P.Position[0]=-1;
		P.Position[1]=-1;
		P.Status[1]='X';
		this.BoardC[i][j]='0';
		System.out.printf("\nKILLED PIECE %c of PLAYER:%c @ [%d,%d]\n", P.type,P.Status[0],i,j);
		}
		else {
		System.out.printf("\nCannot kill piece @ [%d,%d] - NO PIECE EXISTS\n",i,j);	
		}
	}
	
	public void RevivePiece(Player P,int k, int j) {
		
		if(P==null) {
			System.out.println("Failed to Get Player");
			System.exit(-1);
		}
		
		String c = " ";
		while(c==" ") {
		System.out.println("All Pieces");
		int DCount = 0;
		for(int g=0;g<P.Pieces.length;g++) {
			if(P.Pieces[g].Status[1]=='X') {
				DCount++;
			System.out.printf("%c\n", P.Pieces[g].type);
			if(c.toCharArray()[0]==P.Pieces[g].type) {
				System.out.println("FOUND A PIECE TO RESTORE!");
				break;
			}
			}
		}
		if(DCount==0) {
			
			System.out.println("No Pieces to restore");
			
			return;
			
		}
		System.out.println("Enter Piece type to revive");
		Scanner reader = new Scanner(System.in);
		String c2 = reader.next();
		if(c2.length()>1||c2.length()<=0) {
			System.out.println("Invalid Piece type");
			c = c2 = " ";
			continue;
		}
		c = c2;
		}
		
		System.out.printf("Revive Piece for Player:%c\n",P.Player);
		
		for(int i=0;i<P.Pieces.length;i++) {
		if(P.Pieces[i].type==c.toCharArray()[0]&&P.Pieces[i].Status[1]=='X') {	
		//FOUND PIECE TO REVIVE	
			System.out.printf("Reviving:%s For Player:%c", c,P.Player);
			P.Pieces[i].Status[1]='O';
			//KILL PAWN
			KillPiece(k,j);
			//KILL PAWN
			//ONLY PAWN POSITION WILL REVIVE IT
			P.Pieces[i].Position[0] = k;
			P.Pieces[i].Position[1]= j;
			
			this.BoardC[k][j]=P.Pieces[i].type;
			
			return;
		}
		}
		//SHOULD NEVER NOT FIND PIECE!! 
		System.out.println("FAILURE to FIND PIECE");
		System.exit(-1);
	}
	
	
	
}

