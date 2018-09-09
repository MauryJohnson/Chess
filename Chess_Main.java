import java.util.*;

import Board.Board;

import Player.Player;

import Piece.Piece;

public class Chess_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Board, r - rookie, k -knight, b- bishop, p- pawn, K -King, Q -Queen, 0 - Uncharted territory
		//Rows, Columns, Out
		//3D Board contains information about each position, and third dimension to contain info about the players
		//char [][][]B = CreateBoard();
		//PrintBoard(B);
		
		char[][]B_ = CreateBoard2();
		
		//PrintBoard2(B_);

		Board B = new Board();
		
		B.SetBoard(B_);
	
	    B.PrintBoard();
	    
	    //int[] Err = B.Pieces[8].Position;
	    
	    //Player 1 Pawn
	    int Type = 1;
	    int [] Start = B.Players[0].Pieces[Type].Position;
	    int [] End = B.Players[0].Pieces[Type].Position;
	    //Ends
	    System.out.printf("Type Check:%c\n",B.Players[1].Pieces[Type].type );
	    B.Players[1].Pieces[Type].Right(B, -1,false,null);//.Move(Start, End,B);
	    int [] P = {5,1};
	    int [] P2 = {4,6};
	    //Set New Position
	    //B.Move(B.Players[1].Pieces[Type], P);
	    //B.Move(B.Players[0].Pieces[14], P2);
	   
	    ///////////////// NEW POS
	    B.PrintBoard();
	    
	    /////////////////
	    
	    /*
	    int []G = new int[2];
	    G[0] = 5;
	    G[1] = 5;
	    
	    B.Move(B.Players[0].Pieces[14], G,B.Players[0],false);
	    
	    int[]G2 = new int[2];
	    G2[0] = 6;
	    G2[1] = 6;
	    B.Move(B.Players[1].Pieces[12], G2, B.Players[1], false);
	    
	    */
	    //MAKE SURE YOU RESET KING.STATUS[1] TO O AFTER RESOLVED THE CHECK!
	    //////////
	    //////
	    //
	    //
	    /*
	    int [] M = new int[2];
	    M[0] = 2;
	    M[1] = 5;
	    B.Move(B.Players[0].Pieces[1], M,B.Players[0],false);
	    M[1] = 3;
	    B.Move(B.Players[0].Pieces[2], M,B.Players[0],false);
	    M[1] = 4;
	    B.Move(B.Players[0].Pieces[3], M,B.Players[0],false);
	    M[1] = 2;
	    B.Move(B.Players[0].Pieces[5], M,B.Players[0],false);
	    M[1] = 0;
	    B.Move(B.Players[0].Pieces[6], M,B.Players[0],false);
	    M[1] = 0;
	    M[0] = 0;
	    B.Move(B.Players[1].Pieces[8],M, B.Players[1], false);
	    */
	   /* 
	    if(Check(B,B.Players[0],B.Players[1]) && (OtherOpt(B,B.Players[0],B.Players[1]))) {
	    	
	    	//System.out.println("King Cannot attack way out and check! GAME OVER@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	    	
	    	System.out.println("@@@@@@@@@@@@@@@@ CHECKMATE!! Player 1 WINS @@@@@@@@@@@@@@@@@");
	    	
	    	B.PrintBoard();
	    	
	    	System.exit(-1);
	    }
	    
	    if(Check(B,B.Players[1],B.Players[0])){ 
    		if ((OtherOpt(B,B.Players[1],B.Players[0]))) {
    	
    	//System.out.println("King Cannot attack way out and check! GAME OVER@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    	
    	System.out.println("@@@@@@@@@@@@@@@@ CHECKMATE!! Player 2 WINS @@@@@@@@@@@@@@@@@");
    	
    	B.PrintBoard();
    	
    	System.exit(-1);
    		}
    		
    		for(int b=0; b<B.Players[1].Pieces.length;b++) {
	    		B.Players[1].Pieces[b].Status[1] = 'O';
	    	}
    		
    		
    		System.out.println("PLAYER 1 is in CHECK");
	    	
    		}
	    
	    */
	        B.PrintBoard(); 
	    
	    //Left Right Test
	    /*
	    B.Players[1].Pieces[Type].Right(B, 7);
	    B.Players[0].Pieces[14].Left(B, 7);
	    */
	    //Diagonal test
	    //B.Players[0].Pieces[14].D1(B, 0);
	    //B.Players[1].Pieces[Type].D2(B, 0);
	    //B.Players[1].Pieces[Type].D1(B, 0);
	    //B.Players[0].Pieces[14].D4(B, 0);
	 
	    
	    //Now just take care of pawns
	    ////////TAKING CARE OF EVERY PAWN (1st turn)...
	    //This Deletes first moveset (PAWN)_____(PAWN) AFTER IT's TAKEN
	    //B.Players[0].Pieces[8].Movesets[0]="";
	    ///////////////////////////////////////
	    
	    
	    //B.Move(B.Players[0].Pieces[0], M,B.Players[0],false);
	    //B.Move(, j, P2, Temp)
	        
	    
	    boolean End1 = false;
	    
	    boolean Castled1 = false;
	    boolean Castled2 = false;
	    
	    while(!End1) {
	    	
	    B.PrintBoard();	
	    
	    //B.Players[0].PrintPieces();
	    //System.out.println("Choose Piece to move");
	    int IN = -1;
	    while(IN<0||IN>15) {
	    	//B.Players[0].PrintPieces();
	    	System.out.print("Choose Piece to move for PLAYER 1 from 1(r)->16(p)");
	    Scanner reader = new Scanner(System.in);
	    IN = reader.nextInt();
	    IN--;
	    if(IN<0||IN>15) {
	    	System.out.println("Enter Valid input");
	    	continue;
	    }
	    
	    boolean P1Ck = false;
	    
	    if(B.Players[0].Checked == 'C') {
	    	P1Ck = true;
	    }
	    
	    //ALL MOVE OPTIONS FOR KNIGHT PLAYER 1 [top left]
	    int [][]PathSeq = B.Players[0].Pieces[IN].Move(B);
	    ////////////////////////////////	
	    //B.Players[0].Pieces[IN].PrintOptions(PathSeq);
	  
	    B.PrintBoard();	
	    
	    LinkedList <int[]> LL = null;
	   
	    if(P1Ck) {
	    	//Restricted Moves
	    LL = B.Players[0].Pieces[IN].CMovesets;
	    if(LL!=null) {
	    System.out.println("Options");
	    for(int g=0; g<LL.size();g++) {
	    	System.out.printf("[%d,%d]\n",LL.get(g)[0],LL.get(g)[1] );
	    }
	    }
	    else {
	    	System.out.println("No Options");
	    }
	    }
	    else {
	    	//All MOVEs possible
	    LL = LastMv2(PathSeq);
	    LL = Compress(LL);
	    
	    
	    
	    if(IN==4&&!Castled1) {
	    Castled1=true;
	    LinkedList <int[]> A = Castle(B,B.Players[0],B.Players[1]);
	    if(A.size()>0) {
	    LL.addAll(A);
	    LL = Compress(LL);
	    }
	    }
	    if(IN==4) {
	    Castled1=true;
	    }
	    }
	    
	    
	    //CHECK IF LAST MOVE IS VALID (IS a Last Move for Checked piece or not
	    
	    int IN2 = IN;
	    
	    if(LL!=null) {
	    	System.out.printf("\nChoose Option from #1 ->#%d\n",LL.size());
	    	IN = -1;
		    while(IN<=0||IN>LL.size()) {
		    Scanner readerr = new Scanner(System.in);
		    IN = readerr.nextInt();
		    if(IN<=0||IN>LL.size()) {
		    	System.out.println("Enter Valid input");
		    }
		    }
		    IN--;
		    
		    int [] Prev = new int[2];
		    Prev[0] = B.Players[0].Pieces[IN2].Position[0];
		    Prev[1] = B.Players[0].Pieces[IN2].Position[1];
		    
		    if(B.Players[0].Pieces[IN2].Status[1]!='K'&&B.Players[0].Pieces[IN2].CMovesets==null) {
			    
		    Piece H = B.Move(B.Players[0].Pieces[IN2], LL.get(IN),B.Players[0],true);
		    
		    if(Check(B,B.Players[1],B.Players[0])) {
		    OtherOpt(B,B.Players[1],B.Players[0]);
		    //Restore Position
		    if(H!=null) {
		    H.Position[0] = LL.get(IN)[0];
		    H.Position[1] = LL.get(IN)[1];
		    H.Status[1] = 'O';
		    B.BoardC[LL.get(IN)[0]][LL.get(IN)[1]]=H.type;
		    }
		    
		    B.Players[0].Pieces[IN2].Position[0] = Prev[0];
		    B.Players[0].Pieces[IN2].Position[1] = Prev[1];
		    
		    B.BoardC[Prev[0]][Prev[1]] = B.Players[0].Pieces[IN2].type;
		    
		    Check(B,B.Players[1],B.Players[0]);
		    
		    if(B.Players[0].Pieces[IN2].Status[1]!='K') {
		    B.Players[0].Pieces[IN2].Status[1]='C';
		    }
		    
		    System.out.println("Enter Valid Piece/Move");
		    
		    B.PrintBoard();
		    
		    IN = -1;
		    continue;
		    }
		    
		    }
		    
		   // B.Players[0].Pieces[IN2].Status[1] = 'O';
		    
		    B.Move(B.Players[0].Pieces[IN2], LL.get(IN),B.Players[0],false);
		    
		    B.BoardC[B.Players[0].Pieces[IN2].Position[0]][B.Players[0].Pieces[IN2].Position[1]] = B.Players[0].Pieces[IN2].type;
		    
		    
		    if(Check(B,B.Players[0],B.Players[1]) ) {
		    	if((OtherOpt(B,B.Players[0],B.Players[1])/*||KingOpt(B.GetPlayer(GetKing(B.Players[1])[0],GetKing(B.Players[1])[1]),B,B.Players[0],B.Players[1])*/)) {
		    	
		    	//System.out.println("King Cannot attack way out and check! GAME OVER@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		    	
		    	System.out.println("@@@@@@@@@@@@@@@@ CHECKMATE!! Player 1 WINS @@@@@@@@@@@@@@@@@");
		    	
		    	B.PrintBoard();
		    	
		    	System.exit(-1);
		    	}
		    	/*
		    	for(int b=0; b<B.Players[0].Pieces.length;b++) {
		    		B.Players[0].Pieces[b].Status[1] = 'O';
		    	}
		    	*/
		    	System.out.println("PLAYER 2 is in CHECK");
		    	OtherOpt(B,B.Players[1],B.Players[0]);
		    	
		    }
		    
		    	P1Ck = false;
		    	//Had to have taken the move to get out of check...
		    	//Set Piece Status back to normal and remove Check Movesets
		    	for(int f=0;f<B.Players[0].Pieces.length;f++) {
		    		B.Players[0].Pieces[f].Status[1] = 'O';
		    		B.Players[0].Pieces[f].CMovesets = null;
		    	}
		    	
		    	B.PrintBoard();     
	    	}
	    else {
	    	System.out.printf("Piece: %c Cannot Move anywhere!\n",B.Players[0].Pieces[IN].type);
	    	IN = -1;	
	    	}
	    	
	    }
	    
	    //B.Players[0].Pieces[IN2].Status[1] = 'O';
	    
	    IN = -1;
	    while(IN<0||IN>15) {
	    	//B.Players[1].PrintPieces();
	    	System.out.print("Choose Piece to move for PLAYER 2 from 1(p)->16(r)");
	    Scanner reader = new Scanner(System.in);
	    IN = reader.nextInt();
	    IN--;
	    if(IN<0||IN>15) {
	    	System.out.println("Enter Valid input");
	    	continue;
	    }
	    
	    boolean P1Ck = false;
	    
	    if(B.Players[1].Checked == 'C') {
	    	P1Ck = true;
	    }
	    
	    //ALL MOVE OPTIONS FOR KNIGHT PLAYER 1 [top left]
	    int [][]PathSeq = B.Players[1].Pieces[IN].Move(B);
	    ////////////////////////////////	
	    //B.Players[0].Pieces[IN].PrintOptions(PathSeq);
	  
	    B.PrintBoard();	
	    
	    LinkedList <int[]> LL = null;
	   
	    
	    
	    if(P1Ck) {
	    	//Restricted Moves
	    LL = B.Players[1].Pieces[IN].CMovesets;
	    if(LL!=null) {
	    System.out.println("Options");
	    for(int g=0; g<LL.size();g++) {
	    	System.out.printf("[%d,%d]\n",LL.get(g)[0],LL.get(g)[1] );
	    }
	    }
	    else {
	    	System.out.println("No Options");
	    }
	    }
	    else {
	    	//All MOVEs possible
	    LL = LastMv2(PathSeq);
	    LL = Compress(LL);
	    
	    
	    if(IN==12&&!Castled2) {
	    Castled2=true;
	    LinkedList <int[]> A = Castle(B,B.Players[0],B.Players[1]);
	    if(A.size()>0) {
		LL.addAll(A);
		LL = Compress(LL);
		}
	    }
	    //For any Move king makes, still have to remove option to castle
	    if(IN==12) {
		 Castled2=true;
		}
	    }
	    
	    
	    //CHECK IF LAST MOVE IS VALID (IS a Last Move for Checked piece or not
	    
	    int IN2 = IN;
	    
	    if(LL!=null) {
	    	System.out.printf("\nChoose Option from #1 ->#%d\n",LL.size());
	    	IN = -1;
		    while(IN<=0||IN>LL.size()) {
		    Scanner readerr = new Scanner(System.in);
		    IN = readerr.nextInt();
		    if(IN<=0||IN>LL.size()) {
		    	System.out.println("Enter Valid input");
		    }
		    }
		    IN--;
		    
		    //B.Move(B.Players[1].Pieces[IN2], LL.get(IN),B.Players[1],false);
		    
		    int [] Prev = new int[2];
		    Prev[0] = B.Players[1].Pieces[IN2].Position[0];
		    Prev[1] = B.Players[1].Pieces[IN2].Position[1];
		    
		    if(B.Players[1].Pieces[IN2].Status[1]!='K'&&B.Players[1].Pieces[IN2].CMovesets==null) {
		    
		    Piece H = B.Move(B.Players[1].Pieces[IN2], LL.get(IN),B.Players[1],true);
		    
		    if(Check(B,B.Players[0],B.Players[1]) ) {
		    
		    OtherOpt(B,B.Players[0],B.Players[1]);
		    
		    //Restore Position
		    if(H!=null) {
		    H.Position[0] = LL.get(IN)[0];
		    H.Position[1] = LL.get(IN)[1];
		    H.Status[1] = 'O';
		    B.BoardC[LL.get(IN)[0]][LL.get(IN)[1]]=H.type;
		    }
		    
		    B.Players[1].Pieces[IN2].Position[0] = Prev[0];
		    B.Players[1].Pieces[IN2].Position[1] = Prev[1];
		    
		    B.BoardC[Prev[0]][Prev[1]] = B.Players[1].Pieces[IN2].type;
		    
		    Check(B,B.Players[0],B.Players[1]);
		    
		    if(B.Players[1].Pieces[IN2].Status[1]!='K') {
		    B.Players[1].Pieces[IN2].Status[1]='C';
		    }
		    
		    System.out.println("Enter Valid Piece/Move");
		    
		    B.PrintBoard();
		    
		    IN = -1;
		    continue;
		    }
		    
		    }
		    //B.Players[1].Pieces[IN2].Status[1] = 'O';
		    
		    B.Move(B.Players[1].Pieces[IN2], LL.get(IN),B.Players[1],false);
		    
		    B.BoardC[B.Players[1].Pieces[IN2].Position[0]][B.Players[1].Pieces[IN2].Position[1]] = B.Players[1].Pieces[IN2].type;
		    
		    if(Check(B,B.Players[1],B.Players[0])){ 
		    		if ((OtherOpt(B,B.Players[1],B.Players[0])/*||KingOpt(B.GetPlayer(GetKing(B.Players[1])[0],GetKing(B.Players[1])[1]),B,B.Players[0],B.Players[1])*/)) {
		    	
		    	//System.out.println("King Cannot attack way out and check! GAME OVER@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		    	
		    	System.out.println("@@@@@@@@@@@@@@@@ CHECKMATE!! Player 2 WINS @@@@@@@@@@@@@@@@@");
		    	
		    	B.PrintBoard();
		    	
		    	System.exit(-1);
		    		}
		    		
		    		/*
		    		for(int b=0; b<B.Players[1].Pieces.length;b++) {
			    		B.Players[1].Pieces[b].Status[1] = 'O';
			    	}
		    		*/
		    		
		    		System.out.println("PLAYER 1 is in CHECK");
		    		OtherOpt(B,B.Players[0],B.Players[1]);
			    	
		    		}
		    
		    	P1Ck = false;
		    	//Had to have taken the move to get out of check...
		    	//Set Piece Status back to normal and remove Check Movesets
		    	for(int f=0;f<B.Players[1].Pieces.length;f++) {
		    		B.Players[1].Pieces[f].Status[1] = 'O';
		    		B.Players[1].Pieces[f].CMovesets = null;
		    	}
		    	
		    	B.PrintBoard();     
	    	}
	    else {
	    	System.out.printf("Piece: %c Cannot Move anywhere!\n",B.Players[1].Pieces[IN].type);
	    	IN = -1;	
	    	}
	    	
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    //LOOP
	    }
	    //B.Move(B.Players[0].Pieces[9],P);
	    //B.Move(B.Players[0].Pieces, j);
	    //TAKING CARE OF CHECKMATE PROBLEM...
	    /* if(Move(p) has position of enemy K in sight && (Move(Enemy_k) == NULL|| Move(Enemy_k) 
	     * Not NULL but every move is in Line of sight of an ENEMY && AlliesFailedtoBlock(Enemy_Every_Piece_block_1_attacker) >=1, 
	     * where num is number of attackers still for 1 MOVE) -> CHECKMATE 
	    
	    /////////////////////////////////////
	    
	    
	    //B.PrintBoard();	
	    }
	
		*/
	}
	
	public static LinkedList<int[]>Compress(LinkedList<int[]> L){
		if(L==null) {
			return null;
		}
		LinkedList<int[]> LL = new LinkedList<int[]>();
		int r = -1;
		int c = -1;
		System.out.println("Options:");
		for(int i=0;i<L.size();i++) {
			if(L.get(i)!=null) {
			//No duplicates
			if(r!=L.get(i)[0]||c!=L.get(i)[1]) {
			r = L.get(i)[0];
			c = L.get(i)[1];
			int[] R = new int[2];
			R[0] = r;
			R[1] = c;
			LL.add(R);
			System.out.printf("[%d,%d] \n", r,c);
			}
			
			}
		}
		
		return LL;
	}
	
	//Returns {[],[]}, {[],[]}
	//King pos, rook pos 1, king pos2, rook pos 2
	//If size is 2,4,0, handle each case
	//When call Move, check if type is king and difference ==2! 
	public static LinkedList<int[]> Castle(Board B, Player P,Player Other){
		if(P==null||B==null||Other==null) {
			return null;
		}
		int[] K = GetKing(P);
		if(K==null) {
			System.out.println("FAILURE TO GET KING");
			System.exit(-2);
		}
		int i=0;
		int [] Mv = new int[2];
		
		int Kpos = -1;
		
		if(P.Player=='1') {
		//Player 1 castling moves
		Mv[0] = 0;
		Kpos = 4;
		}
		else {
		Mv[0] = 7;
		Kpos = 12;
		}
		
		LinkedList <int[]> LL = new LinkedList<int[]>();
		
		int[] Prev = new int[2];
		Prev[0] = P.Pieces[Kpos].Position[0];
		Prev[1] = P.Pieces[Kpos].Position[1];
		int[] Prev2 = new int[2];
		
		for(i=2;i<7;i++) {
			Mv[1] = i;
			//MOCK MOVEMENT
			Piece H = null;
			
			System.out.printf("ITH: %d\n", i);
			
			if(i!=4) {	
			System.out.println("Moving king...");
			H = B.Move(P.Pieces[Kpos], Mv, P, true);
			if(H!=null) {
			Prev2[0] = H.Position[0];
			Prev2[1] = H.Position[1];
			
			//ERASE PIECE TEMPORARILY
			H.Position[0] = -5;
			H.Position[1] = -5;
			B.PrintBoard();
			H.Status[1] = 'X';
			//ERASE PIECE TEMPORARILY
			}
			}
			
			if(H==null) {
			//No Piece Collision, now check	
			if(Check(B,Other,P)) {
			System.out.printf("Player %c is in check @ [%d,%d] STOPPING MOVEMENT\n",P.Player,Mv[0],Mv[1]);
			return LL;
			}
			else {
			//No check, and to collision,
			if(i==4) {
			//Append first case
			//LL.add(Mv);
			//Mv[1] = Mv[1]-1;
			int[] J = new int[2];
			J[0] = Mv[0];
			J[1] = 2;
			LL.add(J);
			//Mv[1] = Mv[1]+1;
			/*
			J[1] = J[1] +1;
			LL.add(J);
			*/
			System.out.printf("Adding [%d,%d] KING and [%d,%d] Rook 1 For Player %c",J[0],J[1],J[0],J[1]+1,P.Player);
			//System.exit(-2);
			}
			else if(i==6) {
			//Append Final case
				int[] J = new int[2];
				J[0] = Mv[0];
				J[1] = 6;
				LL.add(J);
				//Mv[1] = Mv[1]+1;
				/*J[1] = J[1] -1;
				LL.add(J);
				*/
				System.out.printf("Adding [%d,%d] KING and [%d,%d] Rook 2 For Player %c",J[0],J[1],J[0],J[1]-1,P.Player);	
			}
			
			}
			}
			else {
			//If COLLISION WITH PIECE
			System.out.printf("Pieces Player: %c\n",H.Player);
			System.out.println("Collision with any piece not allowed for castling...");
			
			//RESTORE PIECE
			H.Status[1] = 'O';
			H.Position[0] = Prev2[0];
			H.Position[1] = Prev2[1];
			B.BoardC[H.Position[0]][H.Position[1]]=H.type;
			//RESTORE PIECE
			P.Pieces[Kpos].Status[1] = 'O';
			P.Pieces[Kpos].Position = Prev;
			B.BoardC[P.Pieces[Kpos].Position[0]][P.Pieces[Kpos].Position[1]] = P.Pieces[Kpos].type;
			
			B.PrintBoard();
			
			if(i<4) {
				//Stage 1
				i = 4;
				continue;
			}
			else {
				return LL;
			}
			//Restore H
			}
		
		}
			
		return LL;
	}
	
	//Search all player 2's pieces and call KingOpt on each of them until can eliminate the check! 
	//return true if have options, false if not
	public static boolean OtherOpt(Board B, Player P2, Player P1) {
		
		boolean[] Options = new boolean[1];
		Options[0] = false;
		
		//WORKS, but PRINT STATEMENTS MAKE IT LOOOK LIKE IT DOESN't!!!!!!!!!!!!!!!!! MAKE SURE ISOLATE PRINT STATEMENT IF 
		//ISOLATE IF WANT TO CHECK A CASE PIECE...
		
		LinkedList <boolean[]> Bz = new LinkedList<boolean[]>();
		
		
		
		for(int i=0;i<P1.Pieces.length;i++) {
			//Or these options with the rest, if at least one option, return false.
			//if(P1.Pieces[i].type!='K') {
			Options[0] = KingOpt(P1.Pieces[i],B,P2,P1);
			Bz.add(Options);
			//P1.Pieces[i].Status[1] = 'C';
			//}
		}
		
		boolean Result = false;
		for(int j=0;j<P1.Pieces.length;j++) {
			//for(int y=0; y<Bz.get(j).length;y++) {
				 if(P1.Pieces[j].Status[1]=='K'||P1.Pieces[j].Status[1]=='O') {
					 //IT IS POSSIBLE TO GET OUT OF CHECK
					 System.out.println("Possible to get OUT");
					 Result = true;
				 }
		}
		
		//Options = KingOpt(P1.Pieces[4],B,P2,P1);
		//False if possible to eliminate check
		//False if can get out of check
		//True if cannot get out of check WITH ALL PIECES EXCEPT KING!
		return !Result;
	}
	
/*
	public static boolean OtherAttack(Board B, Player P2, Player P1) {
		
		return false;
	}
	
*/
	public static boolean KingOpt(Piece P, Board B, Player P2, Player P1) {
		if(P==null||B==null||P2==null) {
			System.out.println("Null Pointer");
		return false;	
		}
		if(P.Status[1]!='C') {
			System.out.printf("Piece %c Not In Check, No need to test Checkmate\n",P.type);
			return false;
		}
		//Board D =B
		int [][]PSeq = null;
		
		//char[][] CPY 
		
		int[] Prev1 = new int[2];
		Prev1[0]=P.Position[0];
		Prev1[1] = P.Position[1];
		
		int[] Prev2 = new int[2];
		PSeq = P.Move(B);
		LinkedList<int[]> LL = new LinkedList<int[]>();
		
		System.out.printf("\n%c ATTACK Player:%c\n",P.type,P1.Player);
		
		LL = LastMv2(PSeq);
		
		LinkedList<int[]> Opt = new LinkedList<int[]>();
		
		boolean Options = false;
		
		//System.out.printf("SHOULD ATTACK! [%d,%d]",LL.get(1)[0],LL.get(1)[1]);
		
		System.out.printf("\n\n\n\n\n\n\n");
		//System.exit(-1);
		if(LL!=null) {
		System.out.printf("\n Size: %d",LL.size());
		//System.exit(-1);
		LinkedList<int[]> LP = null;
		for(int f=0;f<LL.toArray().length;f++) {
		//Try all king moves and see if there's a piece to attack
		//if(f==1) {
		System.out.printf("SHOULD ATTACK! [%d,%d]",LL.get(f)[0],LL.get(f)[1]);
		//System.exit(-1);
		//}
		Piece H = B.Move(P, LL.get(f), P2, true);
			//Temporarily KILL Piece found by king
			if(H!=null) {
			
			Prev2[0] = H.Position[0];
			Prev2[1] = H.Position[1];
			
			H.Position[0] = -5;
			H.Position[1] = -5;
			B.PrintBoard();
			H.Status[1] = 'X';
				
			
		if(Check(B,P2,P1)) {
			//Found ONE instance of check after attacking
			//RESTORE PREV STATE
			System.out.println("STILL CHECKED!!!!!!!!!");
		
			Options = false;
			//Opt.add(LL.get(f));
		}
		else {
		//No check after attack, restore prev position...	
			System.out.println("No CHECK");
			
			Options = true;
			Opt.add(LL.get(f));
		}
		
		H.Status[1] = 'O';
		H.Position[0] = Prev2[0];
		H.Position[1] = Prev2[1];
		B.BoardC[H.Position[0]][H.Position[1]]=H.type;
		
		/*
		if(f==1) {
			System.exit(-1);
		}
		*/
			}
			
			
			else {
				System.out.printf("No Piece to Attack Found for %c\n",P.type);
				
				//B.PrintBoard();
				//Check if safe to go there...
				
				Prev2[0] = P.Position[0];
				Prev2[1] = P.Position[1];
				B.PrintBoard();
				//if(P.type=='K') {
				//CHECKS opposing PLAYER IS IN CHECK!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
				if(Check(B,P2,P1)) {
					//
					System.out.println("Cannot move here w/o another check");
					//B.PrintBoard();
					Options = false;
				}
				else {
					System.out.println("Can Move here w/o another check");
					//B.PrintBoard();
					Opt.add(LL.get(f));
					Options = true;
				}
				/*if(P.type=='p') {
					//Restore Double move set
					System.out.printf("Moveset [0] %s",P.Movesets[0]);
				}
				*/
				
				P.Position[0]=Prev2[0];
				P.Position[1]=Prev2[1];
				B.PrintBoard();
			}
			/*
			else {
				System.out.println("NULLLLLLLLLLLLLL No Moves for King");
				//No WAY OUT for KING!!
			return true;
			}
			*/
		}
		
		}
		
		else {
			System.out.printf("NULLLLLLLLLLLLLL No Moves for %c\n",P.type);
			P.Position = Prev1;
			//P.Status[1] = 'O';
			//No WAY OUT for KING!!
		return true;
		}
		
		
		//Options is true if found one way out
		//NOW Add these option sets to pieces
		if(Opt.size()<=0) {
			//NO OPTIONS
			P.CMovesets = null;
			P.Status[1] = 'C';
		}
		else {
			//Have some options
			//P.CMovesets = new int[Opt.size()*2];
			//JUST point to the list...
			P.CMovesets = Opt;
			P.Status[1] = 'K';
		
		for(int h=0;h<Opt.size();h++) {
			System.out.printf("\nOptions %d: [%d,%d]\n",h,Opt.get(h)[0],Opt.get(h)[1]);
		}
		
		}
		/*
		for(int g=0;g<P.Pieces.length;g++)
		
		}
		*/
		
		P.Position[0] = Prev1[0];
		P.Position[1] = Prev1[1];
		
		return Opt.size()>0? false:true;
	}
	
	//Check if opposing player is in check then checkmate
	public static boolean Check(Board B,Player P, Player OppP) {
		int [][]PathSeq = null;
		
		//int []I = new int[2];
		
		//All Attacker THREAT positions to Opp King
		LinkedList<int[]> AttackerPos = new LinkedList<int[]>();
		
		boolean Check = false;
		
		for(int i = 0; i<P.Pieces.length;i++) {
			
		PathSeq = P.Pieces[i].Move(B);
		//List of all end points for player piece to go to
	    LinkedList<int[]> LL = LastMv2(PathSeq);
	    
		int [] I = null;
		I = GetKing(OppP);
		
		//boolean Check2 = false;
		
		B.PrintBoard();
		
	    //if(I!=null) {
		if(LL!=null) {
	    for(int j = 0; j<LL.size();j++) {
	    	
	    	System.out.printf("Compare Pos [%d,%d] to [%d,%d] FOR P:%c\n",I[0],I[1], LL.get(j)[0],LL.get(j)[1],P.Pieces[i].type);
	    	
	    	if(I[0]==LL.get(j)[0]&&I[1]==LL.get(j)[1]) {
	    	//KING IN CHECK!
	    		System.out.printf("\nKING is IN CHECK FOR PLAYER:%c Piece: %c @ [%d,%d] \n",OppP.Player,B.GetPlayer(I[0], I[1]).type,B.GetPlayer(I[0], I[1]).Position[0],B.GetPlayer(I[0], I[1]).Position[1]);
	    		
	    		B.GetPlayer(I[0], I[1]).Status[1]='C';
	    		
	    		//System.exit(-1);
	    		Check = true;
	    	}
	    }
	    	
		}
		}
		//If king is in check, set all pieces status in check
		if(Check) {
		OppP.Checked = 'C';
			
		for(int h=0; h<OppP.Pieces.length;h++) {
			//if(OppP.Pieces[h].Status[1]!='K'&&OppP.Pieces[h].CMovesets==null) {
			
			OppP.Pieces[h].Status[1]='C';
			
			//}
		}
		//OppP.Pieces[0].Status[1] = 'C';
		}
		else {
		//Unchecked King.. Good!
			for(int h=0; h<OppP.Pieces.length;h++) {
				//if(OppP.Pieces[h].Status[1]!='K'&&OppP.Pieces[h].CMovesets==null) {
				
				OppP.Pieces[h].Status[1]='O';
				OppP.Pieces[h].CMovesets=null;
				//}
			}
			
		OppP.Checked = 'O';
		}
		
		return Check;
	}
	
	public static int[] GetKing(Player O) {
		int [] I = new int[2];
		I[0] = -1;
		I[1] = -1;
		for(int i=0; i<O.Pieces.length;i++) {
			if(O.Pieces[i].type=='K')
				I = O.Pieces[i].Position;
			
		}
		if(I[0]==-1) {
			System.out.printf("\nKING FOR PLAYER :%c NOT FOUND! ERROR!!!!!!",O.Player);
			System.exit(-2);
		}
		return I;
	}
	
	public static LinkedList<int[]> LastMv2(int[][]P2) {
		if(P2==null) {
			return null;
		}
		
		LinkedList<int[]> LL = new LinkedList<int[]>();
		
		for(int h=0;h<P2.length;h++) {
		    int []J = LastMv(P2[h],h);
		    if(J!=null) {
		    for(int i=0;i<J.length/2;i+=2) {
		    	
		    	System.out.printf("\n[%d,%d]\n", J[i],J[i+1]);
		    	LL.add(J);
		    }
		    }
		    }
		if(LL.size()<=0) {
			return null;
		}
		
		return LL;
		
	}
	
	public static int[] LastMv(int[]P,int h) {
		int Ct1 = 0;
		int Ct2 = 0;
		
		//int sz = 0;
		
		int[] Lst = new int[2];
		
		boolean mv = false;
		
		//for(int i=0;i<P.length;i++) {
			if(P.length>1) {
			Ct1 = P[0];
			Ct2 = P[1];
			mv = false;
			//sz = 0;
			Lst[0] = P[0];
			Lst[1] = P[1];
			for(int j=2;j<P.length;j=j+2) {
				//System.out.printf("\n Effective Move %d: [%d,%d]",h+1, Lst[0],Lst[1]);
				if((Ct1==P[j]+1)||Ct1==P[j]-1) {
					Ct1 = P[j];
					Lst[0] = Ct1;
					mv = true;
				}
				if((Ct2==P[j+1]-1||Ct2==P[j+1]+1)) {
					Ct2 = P[j+1];
					Lst[1]=Ct2;
					mv = true;
				}
				else if(!(Ct2==P[j+1]-1||Ct2==P[j+1]+1)&&!((Ct1==P[j]+1)||Ct1==P[j]-1)) {
					mv = false;
					break;
				}
				if(mv) {
					//sz++;
				}
				
			}
			}
			else {
				
				return null;
			}
		//}
		
		return Lst;
	}
	
	public static void PrintBoard2(char[][] B) {
		
		System.out.println("Print Board\n");
		//char []O = B[0][0];
		//System.out.printf("Board First Row: %s",O);
		
		for(int i=0; i<B.length;i++) {
			char[] O = B[i];
			for(int k=0; k<O.length;k++) {
				System.out.printf("%c ",O[k]);
			}	
			System.out.println();
		}
			System.out.println();
			
	
	
	}
	/*
	public static void PrintBoard(char[][][] B) {
		
		System.out.println("Print Board\n");
		//char []O = B[0][0];
		//System.out.printf("Board First Row: %s",O);
		
		for(int i=0; i<B.length;i++) {
			char[] O = B[i][0];
			for(int k=0; k<O.length;k++) {
				System.out.printf("%s ",O[k]);
			}	
			System.out.println();
		}
			System.out.println();
			
	
	
	}
	*/
	
	
	public static char[][] CreateBoard2(){
		
		//Later on create Board of classes, each position either has a piece or does not
		//Each piece will be classified like this, each char pertains to a different type of piece. Char used to name a piece
		
		char [] R1 = {'r','k','b','Q','K','b','k','r'};	
		char [] R2 = {'p','p','p','p','p','p','p','p'};	
		
		char [] R3 = {'p','p','p','p','p','p','p','p'};	
		char [] R4 = {'r','k','b','Q','K','b','k','r'};	
		
		char []RN = {'0','0','0','0','0','0','0','0'};	
		
		//3d Board of pieces + Statuses of each piece 'w' - white piece here,'b' - black piece here,'0' - uncharted
		char [][]Board = new char[8][8];
		
		System.out.printf("Board Rows Length:%d\n",Board.length);
		System.out.printf("Board Columns Length:%d\n",Board[0].length);
		//System.out.printf("Board outskirt Length:%d\n",Board[0][0].length);
		
		int i=0;
	
		for(i=0;i<Board.length;i++) {
			if(i==0) {
				Board[i]=R1;
			}
			else if(i==1) {
				Board[i]=R2;
			}
			else if(i==6) {
				Board[i]=R3;
			}
			else if(i==7) {
				Board[i]=R4;
			}else {
				Board[i]=RN;
			}
		}
		
		
		
		//Board = {{{"ggg"}}, {{}}};
		
		return Board;
	}
	
	/*
	//Create Board First Time
	public static char[][][] CreateBoard(){
		
		//Later on create Board of classes, each position either has a piece or does not
		//Each piece will be classified like this, each char pertains to a different type of piece. Char used to name a piece
		
		char [][] R1 = {{'r','k','b','K','Q','b','k','r'}, {'w','w','w','w','w','w','w','w'}};	
		char [][] R2 = {{'p','p','p','p','p','p','p','p'}, {'w','w','w','w','w','w','w','w'}};	
		
		char [][] R3 = {{'p','p','p','p','p','p','p','p'}, {'b','b','b','b','b','b','b','b'}};	
		char [][] R4 = {{'r','k','b','K','Q','b','k','r'}, {'b','b','b','b','b','b','b','b'}};	
		
		char [][]RN = {{'0','0','0','0','0','0','0','0'}, {'0','0','0','0','0','0','0','0'}};	
		
		//3d Board of pieces + Statuses of each piece 'w' - white piece here,'b' - black piece here,'0' - uncharted
		char [][][]Board = new char[8][8][1];
		
		System.out.printf("Board Rows Length:%d\n",Board.length);
		System.out.printf("Board Columns Length:%d\n",Board[0].length);
		System.out.printf("Board outskirt Length:%d\n",Board[0][0].length);
		
		int i=0;
		
		for(i=0; i<Board.length;i++) {
		    if(i==0) {
			//Set Up Board for white status for third dim is 'w' for white
		    	/*for(int k=0;k<Board[i].length;k++) {
		    	
		    		
		    		
		    		
		    	}
		    	
		    	Board[i] = R1;
		    }	
		    else if(i==1) {
		    	//Set up board for white PAWNS 'w' for third dim
		    	Board[i]=R2;
		    }
			else if(i==6) {
			//Set Up Board for black status for third dim is 'b' for black PAWNS
			Board[i]=R3;	
			}
			else if(i==7) {
			//Set up Board to black 'b' status in third dim
				Board[i]=R4;	
			}
			else {
			//Set Up Uncharted territory for Board -- include board status (third dimension)
				Board[i]=RN;
			}
				
		}
		
		
		
		//Board = {{{"ggg"}}, {{}}};
		
		return Board;
	}
	 */
	
}