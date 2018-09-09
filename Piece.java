package Piece;

import java.util.*;


//import java.io.IOException;

import Board.Board;

import Player.Player;

public class Piece extends Player{
	
	//public Piece() {
	//Player? "1O" "2O" -> First move for piece, "1P" "2P" -. Second move for piece, 
	//OR GONE "1X" or "2X", Check "1C" or "2C" C IS FOR EVERY PIECE NEEDED TO STOP CHECK
	public char [] Status;
	//Board, r - rookie, k -knight, b- bishop, p- pawn, K -King, Q -Queen, 0 - Uncharted territory
	public char type;
	//Position on 8X8 BOARD
	public int[] Position;
	//Takes care of movesets for all pieces possible or to be created...
	public String[] Movesets;
	//Movesets restricted for checked king
	public LinkedList<int[]> CMovesets;
	//
	private Scanner reader;
	
	public boolean Castled = false;
	//All Paths that Piece is able to traverse in current position
	//public int[] FreePaths;
	//If Piece can skip over other pieces instead of having to attack within moveset...
	//public boolean Exception;
	//
	//public Player PP;
	//private Scanner reader;
	
	
	//In order to call parent class
	public Piece(char P) {
		super(P);
	}
	
	public Player getP() {
		
		return super.GP();
	}
	//Create Piece Object
	public void Create_Piece(char type,int[] Pos, char[] Status) {
		
		this.type = type;
		this.Position = Pos;
		this.Movesets = CheckType(type);
		this.CMovesets = null;
		this.Status = Status;
		//this.PP = P;
	}
	//Sets Str for pieces Rook, Queen, K
	public String[] SetStr(int sz, int type) {
		
		String[] M = new String[(sz*8)];
		//ROOK
		if(type==1) {
		for(int i=0; i<sz;i++) {
			char[] N = new char[2];
			int incr = 2;
			int ct = 0+8*i;
			for(int j=1; j<=36;j+=incr,incr++) {
				if(i==0) {
				//U
				N[0] = 'u';
				if(j==1) {
					N[1] = Integer.toString(j).toCharArray()[0];
				}
				else {
				N[1] = Integer.toString((ct%8)+1).toCharArray()[0];
				}
				M[ct] = String.copyValueOf(N);
				}
				else if(i==1) {
				//R
					N[0] = 'r';
					if(j==1) {
						N[1] = Integer.toString(j).toCharArray()[0];
					}
					else {
					N[1] = Integer.toString((ct%8)+1).toCharArray()[0];
					}
					M[ct] = String.copyValueOf(N);
				}
				else if(i==2) {
				//D	
					N[0] = 'd';
					if(j==1) {
						N[1] = Integer.toString(j).toCharArray()[0];
					}
					else {
					N[1] = Integer.toString((ct%8)+1).toCharArray()[0];
					}
					M[ct] = String.copyValueOf(N);
					
				}
				else if(i==3) {
				//L	
					N[0] = 'l';
					if(j==1) {
						N[1] = Integer.toString(j).toCharArray()[0];
					}
					else {
					N[1] = Integer.toString((ct%8)+1).toCharArray()[0];
					}
					M[ct] = String.copyValueOf(N);
				}
				//incr++;
				char[] J = new char[2];
				J[0] = M[ct].charAt(0);
				J[1] = M[ct].charAt(1);
				System.out.printf("%c %c == %c %c \n ", N[0],N[1],J[0],J[1]);
				ct++;
			}
		}
		
		return M;
		}
		//Bishop
		else if(type==2) {
			for(int i=0; i<sz;i++) {
				char[] N = new char[2];
				int incr = 2;
				int ct = 0 +8*i;
				for(int j=1; j<=36;j+=incr,incr++) {
					if(i==0) {
					//U
					N[0] = '<';
					if(j==1) {
						N[1] = Integer.toString(j).toCharArray()[0];
					}
					else {
					N[1] = Integer.toString((ct%8)+1).toCharArray()[0];
					}
					M[ct] = String.copyValueOf(N);
					}
					else if(i==1) {
					//R
						N[0] = '>';
						if(j==1) {
							N[1] = Integer.toString(j).toCharArray()[0];
						}
						else {
						N[1] = Integer.toString((ct%8)+1).toCharArray()[0];
						}
						M[ct] = String.copyValueOf(N);
					}
					else if(i==2) {
					//D	
						N[0] = '{';
						if(j==1) {
							N[1] = Integer.toString(j).toCharArray()[0];
						}
						else {
						N[1] = Integer.toString((ct%8)+1).toCharArray()[0];
						}
						M[ct] = String.copyValueOf(N);
						
					}
					else if(i==3) {
					//L	
						N[0] = '}';
						if(j==1) {
							N[1] = Integer.toString(j).toCharArray()[0];
						}
						else {
						N[1] = Integer.toString((ct%8)+1).toCharArray()[0];
						}
						M[ct] = String.copyValueOf(N);
					}
					//incr++;
					char[] J = new char[2];
					J[0] = M[ct].charAt(0);
					J[1] = M[ct].charAt(1);
					System.out.printf("%c %c == %c %c \n ", N[0],N[1],J[0],J[1]);
					ct++;
				}
			}
			
			return M;
		}
		//QUEEN
		else if(type==3) {
			for(int i=0; i<sz;i++) {
				char[] N = new char[2];
				int incr = 2;
				int ct = 0 + 8*i;
				for(int j=1; j<=36;j+=incr,incr++) {
					if(i==0) {
					//U
					N[0] = 'u';
					if(j==1) {
						N[1] = Integer.toString(j).toCharArray()[0];
					}
					else {
					N[1] = Integer.toString((ct%8)+1).toCharArray()[0];
					}
					M[ct] = String.copyValueOf(N);
					}
					else if(i==1) {
					//R
						N[0] = 'r';
						if(j==1) {
							N[1] = Integer.toString(j).toCharArray()[0];
						}
						else {
						N[1] = Integer.toString((ct%8)+1).toCharArray()[0];
						}
						M[ct] = String.copyValueOf(N);
					}
					else if(i==2) {
					//D	
						N[0] = 'd';
						if(j==1) {
							N[1] = Integer.toString(j).toCharArray()[0];
						}
						else {
						N[1] = Integer.toString((ct%8)+1).toCharArray()[0];
						}
						M[ct] = String.copyValueOf(N);
						
					}
					else if(i==3) {
					//L	
						N[0] = 'l';
						if(j==1) {
							N[1] = Integer.toString(j).toCharArray()[0];
						}
						else {
						N[1] = Integer.toString((ct%8)+1).toCharArray()[0];
						}
						M[ct] = String.copyValueOf(N);
					}else if(i==4) {
					//L	
						N[0] = '<';
						if(j==1) {
							N[1] = Integer.toString(j).toCharArray()[0];
						}
						else {
						N[1] = Integer.toString((ct%8)+1).toCharArray()[0];
						}
						M[ct] = String.copyValueOf(N);
					}else if(i==5) {
					//L	
						N[0] = '>';
						if(j==1) {
							N[1] = Integer.toString(j).toCharArray()[0];
						}
						else {
						N[1] = Integer.toString((ct%8)+1).toCharArray()[0];
						}
						M[ct] = String.copyValueOf(N);
					}else if(i==6) {
					//L	
						N[0] = '{';
						if(j==1) {
							N[1] = Integer.toString(j).toCharArray()[0];
						}
						else {
						N[1] = Integer.toString((ct%8)+1).toCharArray()[0];
						}
						M[ct] = String.copyValueOf(N);
					}else if(i==7) {
					//L	
						N[0] = '}';
						if(j==1) {
							N[1] = Integer.toString(j).toCharArray()[0];
						}
						else {
						N[1] = Integer.toString((ct%8)+1).toCharArray()[0];
						}
						M[ct] = String.copyValueOf(N);
					}
					//incr++;
					char[] J = new char[2];
					J[0] = M[ct].charAt(0);
					J[1] = M[ct].charAt(1);
					System.out.printf("%c %c == %c %c \n ", N[0],N[1],J[0],J[1]);
					ct++;
				}
			}
			return M;
		}
		System.out.println("Error Configuring Moveset");
		System.exit(-1);
		return null;
	}
	//Check the type
	private String[] CheckType(char type) {
		//U - Forever up, u -up n times, R- Forever right, r -right n times, D- Forever down, d- down n times
		//L- Forever Left, l-left n times. <<- FOREVER Diagnal up left, >>- FOREVER Diagonal up right
		//, {{- FOREVER Diagonal down left, 
		//}}- FOREVER Diagonal down right
		// <n- n times Diagnal up left, >n- n times Diagonal up right
		//, {n-  n times Diagonal down left, 
		// }n- n times Diagonal down right
		
		
		//MOVE SETS DEFINE RESTRICTIONS TO HOW FAR PIECE CAN GO...
		//FOREVER IMPLIES PIECE IS NOT RESTRICTED IN MOVEMENT TO GO that direction, so long as there
		//is no obstruction, but piece can still place anywhere within the range of available spots
		
		String[] MV = null;
		
		if(type=='r') {
			//Rookie Moveset
			//UNIVERSAL
			//Size can be up to 4 'U' 'R' 'D' 'L' -> in that order
			MV = SetStr(4,1);
			//System.exit(-1);
		}
		else if(type=='k') {
			//Knight Moveset
			//UNIVERSAL ( No flip reference frame needed)
			String[] M = {"u1u1r1","u1u1l1","d1d1r1","d1d1l1","l1l1u1","l1l1d1","r1r1u1","r1r1d1"};
			MV = M;
		}
		else if(type=='b') {
			//Bishop Moveset (Diagonals)
			//UNIVERSAL ( No flip reference frame needed)
			//String[] M = {"<<",">>","{{","}}"};
			
			MV = SetStr(4,2);
		}else if(type=='K') {
			//King Moveset
			//UNIVERSAL ( No flip reference frame needed)
			String[] M = {"u1","d1","l1","r1","<1",">1","{1","}1"};
			
			MV = M;
		}else if(type=='Q') {
			//FOREVER IN ALL IMMEDIATE DIRECTIONS FOR QUEEN
			//UNIVERSAL ( No flip reference frame needed)
			//String[] M = {"U","D","L","R","<<",">>","{{","}}"};
			
			MV = SetStr(8,3);
			//System.exit(-2);
		}else if(type=='p') {
			//PAWN MOVESET ( DIAGONALS INCLUDED, BUT ONLY CAN MOVE DIAG IF ATTACKING ANOTHER PLAYER)
			//Can move up twice ONLY ON FIRST TURN FOR PAWN
			//Else Can only move up once
			//IF Player1, can only go down!
			//IF Player2, IT can only go up!
			String[] M = null;
			//Player 1 Restricted Moveset
			System.out.printf("PLAYER:%c",super.Player);
			if(super.Player=='1') {
				//d2 only for first move, < and < only for attacking
			String[] M1 =  {"d2","d1","{1","}1"};
			M = M1;
			}
			//Player 2 Restricted Moveset
			else {
				//u2 only for first move, < and > only for attacking
			String[] M1 = {"u2","u1","<1",">1"};
			M = M1;
			}
			MV = M;
		}
		else {
			
			reader = new Scanner(System.in);
			
			boolean validSize = false;
			
			int Paths = 0;
			
			while(!validSize) {
			System.out.println("New Type? Enter Number of ALL Path Sequences for new Type Piece");
			Paths = reader.nextInt();
			if(Paths<=0) {	
	     	System.out.printf("\n Enter Valid number of move sets\n");
			}
			else {
				break;
			}
			}
			
			String []M = new String[Paths];
			
			System.out.println("Enter %d Path sequences FORMAT {Finite} u[n] d[n] l[n] r[n] >[n] <[n] {[n] }[n]");
			for(int k=0; k<Paths; k++) {
				String s =reader.next();
				if(!ValidMoveset(s)) {
					System.out.print("Enter Valid Moveset");
					k--;
					continue;
				}
				M[k] = s;
			}
	
			MV = M;
			//reader.close();
			//reader=null;
		}
		
		//String[] s = {"HEKKI"};
		for(int g=0; g<MV.length;g++) {
			System.out.printf("Test Moveset:%s\n",MV[g]);
		//if(MV[g]!=null)
		if(!ValidMoveset(MV[g])) {
			
			System.out.print("INVALID MOVESET");
			System.exit(-1);
		}
		}
		
		return MV;
	}
	//Check if moveset is valid
	public boolean ValidMoveset(String s) {
		
		if(s==null) {
			return true;
			
		}
		
		char[] C = s.toCharArray();

		int incr = 1;
		
		boolean T = false;
		for(int i=0; i<C.length;i= i +incr) {
			if(i!=C.length-1) {
				//System.out.printf("str:%c%c INT VAL: %d\n",C[i],C[i+1],Character.getNumericValue((int)C[i+1]));
				T = (C[i]=='u'&&Character.getNumericValue(C[i+1])>0&&Character.getNumericValue(C[i+1])<9)||(C[i]=='r'&&Character.getNumericValue((int)C[i+1])>0&&Character.getNumericValue((int)C[i+1])<9)||(C[i]=='d'&&Character.getNumericValue((int)C[i+1])>0&&Character.getNumericValue((int)C[i+1])<9)||(C[i]=='l'&&Character.getNumericValue((int)C[i+1])>0&&Character.getNumericValue((int)C[i+1])<9)||(C[i]=='<'&&Character.getNumericValue((int)C[i+1])>0&&Character.getNumericValue((int)C[i+1])<9)||(C[i]=='>'&&Character.getNumericValue((int)C[i+1])>0&&Character.getNumericValue((int)C[i+1])<9)||(C[i]=='{'&&Character.getNumericValue((int)C[i+1])>0&&Character.getNumericValue((int)C[i+1])<9)||(C[i]=='}'&&Character.getNumericValue((int)C[i+1])>0&&Character.getNumericValue((int)C[i+1])<9)/*||(C[i]=='U')||(C[i]=='R')||(C[i]=='D')||(C[i]=='L')||(C[i]=='<'&&C[i+1]=='<')||(C[i]=='>'&&C[i+1]=='>')||(C[i]=='{'&&C[i+1]=='{')||(C[i]=='}'&&C[i+1]=='}')*/;
				incr = 2;
			}
			else {
				//These can be the only cases for last char
				//T =(C[i]=='U')||(C[i]=='R')||(C[i]=='D')||(C[i]=='L'); 
				
				/////////////////////////////////////////////////////////////////ALLOW USER TO CREATE OWN PIECE
				T = false;
				///////////////////////////////////////////////////////////////// MUST MANUALLY SET ALL PIECE MOVESETS
				
				incr = 1;
			}
		if(!T) {
			//If Failed all cases
			return false;
		}
		}
		return true;
	}
	
	public void PrintAll(int[]A,int len) {
		int j=1;
		System.out.println();
		for(int i=0;i<len+2;i=i+2) {
			System.out.printf("ALL[%d]: [%d,%d] \n",j,A[i],A[i+1]);
			j++;
		}
		
	}
	//Return all path sequences for this piece
    public int[][] isAnyPath(/*int [] Start, int[] End,*/Board B) {
    	//Trace Moveset, determine if moveset is valid for current position [Exceptions are knight, which can move OVER pieces
    	//As long as knight's ending position is not taken.
    	//If Pawn
    	
    	//8X8 Board
    	//int BoundR = 8;
    	//int BoundC = 8;
    	
    	//int[][]Seq = null;
    	
    	//int[][]C_ = null;
    	
    	//LinkedList<int[]> L = new LinkedList<int []>();
    	
    	int Max_Mv_ln = 0;
    	for(int k=0;k<this.Movesets.length;k++) {
    		System.out.printf("Compare Mx %s\n",this.Movesets[k]);
    		if(this.Movesets[k]!=null)
    		if(this.Movesets[k].toCharArray().length>Max_Mv_ln) {
    			Max_Mv_ln = this.Movesets[k].toCharArray().length;
    		}
    	}
    	
    	System.out.printf("Maximum Move Size for Piece:%c,%d:",this.type,Max_Mv_ln);
    	
    	//Each row is a moveset, each column is sets of two integers corresponding 
    	//to each move position
    	
    	//List of Path Sequence freedoms for each moveset of this PIECE 
    	LinkedList<int[][]> LAll = new LinkedList<int[][]>();
    	
    	//int Ct = 0;
    	
    	for(int i=0;i<this.Movesets.length;i++) { 
    	//Found MoveSet[ith]
    		if(this.Movesets[i]!=null) {
    	char []Mv = this.Movesets[i].toCharArray();
    	int [] C2 = null;
    	int[][]C = new int[Mv.length][1];
    	System.out.printf("\n\nAnalyze Moveset:%s\n\n", this.Movesets[i]);
    	for(int j=0;j<Mv.length;j++) {
    	//Iterate through each movement pattern
        //Return Collision list of endpoints for pieces
    	if(Mv[j]=='R'||Mv[j]=='D'||Mv[j]=='L'||Mv[j]=='U') {
    		
    		char v = Character.toLowerCase(Mv[j]);
    	
    	}
    	
    	else {
    		if(this.type=='k'&&j<Mv.length-2) {
    			if(j>0)
    			C2 = Collisions(Mv[j],Mv[j+1],/*Start,End,*/B,true,C[j-1]);
    			else
    			C2 = Collisions(Mv[j],Mv[j+1],/*Start,End,*/B,true,null);
    		}
    		else {
    			if(j>0)
    			C2 = Collisions(Mv[j],Mv[j+1],/*Start,End,*/B,false,C[j-1]);
    			else
    			C2 = Collisions(Mv[j],Mv[j+1],/*Start,End,*/B,false,null);
    			
    		}
    		j++;
    	
    	}
    	
    	if(C2==null) {
    		//MoveSet failed, on to next moveset for piece...
    		C=null;
    		break;
    	}
    	else {
    		
    		if(C2[0]<0) {
    			C = null;
    			break;
    		}
    		C[j] = C2;//ReSize(C2,LengthMvSet(this.Movesets[i]));
    		//Ct++;
    		//System.out.println("Add Moveset:\n");
    		//PrintAll(C2,(C2.length/2));
    		//PrintAll(C2,LengthMvSet(this.Movesets[i]));
    		//C[j].length = (C[j].length/2)+6;
    		//Ct++;
    	}
    	
    	}
    	//Add Path seq possibilities to list
    	LAll.add(C);
    	//System.out.println("Add Moveset:\n");
    	/*
    	if(C2!=null)
    	PrintAll(C2,(C2.length/2)//+6//);
    	*/
    	}
    	}
    	
    	System.out.printf("\nALL possible paths for piece %c in position [%d,%d]\n",this.type,this.Position[0],this.Position[1]);
    	
    	//Object[] A = LAll.toArray();
    	System.out.printf("LENGTH Of LIST:%d", LAll.toArray().length);
    	
    	int [] E = new int[2];
    	
    	int[][] EAll = new int[this.Movesets.length][1];
    	
    	for(int i=0;i<LAll.toArray().length;i++) {
    		System.out.printf("Player %c Possibilities for %d Moveset:%s\n",super.Player,i,this.Movesets[i]);
    		int[][]C2 = LAll.get(i);
    		if(C2!=null) {
    			for(int k=0; k<C2.length;k++) {
    			//System.out.printf("Length of this moveset: %d\n",LengthMvSet(this.Movesets[i]));
    			if(C2[k]!=null) {
    			for(int l=0; l<(C2[k].length/2);l=l+2) {
    				System.out.printf("[%d,%d]\n", C2[k][l], C2[k][l+1]);
    				if(l==0) {
    					//System.out.printf("Effective position to Traverse to: [%d,%d]\n", LastElem(C2)[l],LastElem(C2)[l+1]);
    					E = C2[k];
    					//E[0] = C2[k][0];
    					//E[1] = C2[k][1];
    				}
    			}
    			//PrintAll(C2[k],(C2[k].length/2));
    			}
    		}
    			EAll[i] = E;
    			System.out.printf("Effective position to Traverse to: [%d,%d]\n",E[0],E[1]);
    		}
    		else {
    			System.out.println("NO Effective Position to Traverse to!");
    		}
    	}
    	
    	//System.out.printf("Effective Position to Traverse to: [%d,%d]", LAll.get(LAll.size()-1)[LAll.get(LAll.size()-1).length-1][0],LAll.get(LAll.size()-1)[LAll.get(LAll.size()-1).length-1][1]);
    	
    	
    	return EAll;
    }
    
    //WORKS
    //Move up
    public int[] Up(Board B,int dist,boolean IgnoreAll, int[] NPos) {
    	System.out.println("Traverse UP");
    	char[][]Board = B.BoardC;
    	
    	int D = dist;
    	
    	//{[Start,End],....[Startn,Endn]}
    	int [] All = new int[18];
    	InitNeg(All);
    	
    	
    	int[] Pos = null;
    	if(NPos==null) {
    	Pos = this.Position.clone();
    	}
    	else {
    		Pos = NPos;
    	}
    	
    	System.out.printf("START:[%d,%d]\n", Pos[0],Pos[1]);
		
		int i=Pos[0];
    	if(dist<=0) {
    		//No Limits on distance to traverse direction UP
    	    D = dist = 9;
    	    //All = new int[9];
    	}
    	
    	//Get off of current piece position
    	
    	boolean Traversable = false;
    	boolean EnemyFound = false;
    	
    	int AllPos = 0;
    	
    	for(i=Pos[0]-1;i>=0&&dist>0;i--,dist--) {
			//Change in Row UP
    		Player P = B.GetPlayer(i, Pos[1]);
			if(P!=null&&!IgnoreAll) {
			if(Board[i][Pos[1]]!='0') {
				//Either your piece or their piece, check if their piece
				
				if(P.Player==super.Player) {
					//Found your own piece, blocked, backtrace
					System.out.printf("Found YOUR Piece at:[%d,%d], backtracing prev",i,Pos[1]);
					//i++;
					/*
					All[AllPos]= i;
					All[AllPos]
					*/
					break;
				}
				else {
					//Found enemy piece!
					Traversable = true;
					EnemyFound = true;
					System.out.printf("Found Enemy Piece at:[%d,%d]\n",i,Pos[1]);
					All[AllPos] = i;
					All[AllPos+1] = Pos[1];
					break;
				}
			
				}
				
				}
			else {
				All[AllPos]=i;
				All[AllPos+1]=Pos[1];
				AllPos = AllPos+2;
				Traversable = true;
				System.out.printf("Found Empty Position:[%d,%d]\n",i,Pos[1]);	
			}
			
			}
    	if(Traversable) {
    		if(!EnemyFound) {
    			AllPos=AllPos-2;
    			System.out.printf("\nCan Move UP Before [%d,%d] %s times\n",i,Pos[1],D==9? "UnFixed Traversal":Integer.toString((AllPos+2)/2)); 
    		}
    		else {
    			System.out.printf("\nCan Move UP Before or ATTACK ENEMY @ [%d,%d] %s times\n",i,Pos[1],D==9? "UnFixed Traversal":Integer.toString((AllPos+2)/2)); 
    		}
    		}
    	else {
    		System.out.printf("\nCan Move UP Before [%d,%d] 0 times\n",i,Pos[1]); 
    	}
    	
    	System.out.printf("All Positions UP for Piece:%c",this.type);
    	PrintAll(All,AllPos);
    	System.out.println();
    	
    	if(All[0] == 0 && All[1] == 0 && All[2] == 0 && All[3] == 0 ) {
    		
    		All=null;
    	}
    	
    	if(this.type=='p') {
    		if(EnemyFound) {
    			//CANT GO ON ENEMY AS PAWN
    			System.out.printf("\nCANT GO DOWN ON ENEMY for PAWN at Pos [%d,%d]\n",Pos[0],Pos[1]);
    			All=null;
    		}
    	}
    	
    	
    	
    	return All;
    }
    //Move Right
    public int[] Right(Board B,int dist,boolean IgnoreAll, int[] NPos) {
    
    	System.out.println("Traverse RIGHT");
    	char[][]Board = B.BoardC;
    	
    	int D = dist;
    	
    	//{[Start,End],....[Startn,Endn]}
    	int [] All = new int[18];
    	InitNeg(All);
    	
    	
    	int[] Pos = null;
    	if(NPos==null) {
    	Pos = this.Position.clone();
    	}
    	else {
    		Pos = NPos;
    	}
    	
    	System.out.printf("START:[%d,%d]\n", Pos[0],Pos[1]);
		
		int i=Pos[0];
    	if(dist<=0) {
    		//No Limits on distance to traverse direction UP
    	    D = dist = 9;
    	    //All = new int[9];
    	}
    	
    	//Get off of current piece position
    	
    	boolean Traversable = false;
    	boolean EnemyFound = false;
    	
    	int AllPos = 0;
    	
    	for(i=Pos[1]+1;i<8&&dist>0;i++,dist--) {
			//Change in Row UP
    		Player P = B.GetPlayer(Pos[0], i);
			if(P!=null&&!IgnoreAll) {
			if(Board[Pos[0]][i]!='0') {
				//Either your piece or their piece, check if their piece
				
				if(P.Player==super.Player) {
					//Found your own piece, blocked, backtrace
					System.out.printf("Found YOUR Piece at:[%d,%d], backtracing prev",Pos[0],i);
					//i++;
					
					break;
				}
				else {
					//Found enemy piece!
					Traversable = true;
					EnemyFound = true;
					System.out.printf("Found Enemy Piece at:[%d,%d]\n",Pos[0],i);
					All[AllPos] = Pos[0];
					All[AllPos+1] = i;
					break;
				}
			
				}
				
				}
			else {
				All[AllPos]=Pos[0];
				All[AllPos+1]=i;
				AllPos = AllPos+2;
				Traversable = true;
				System.out.printf("Found Empty Position:[%d,%d]\n",Pos[0],i);	
			}
			
			}
    	if(Traversable) {
    		if(!EnemyFound) {
    			AllPos=AllPos-2;
    			System.out.printf("\nCan Move RIGHT Before [%d,%d] %s times\n",Pos[0],i,D==9? "UnFixed Traversal":Integer.toString((AllPos+2)/2)); 
    		}
    		else {
    			System.out.printf("\nCan Move RIGHT Before or ATTACK ENEMY @ [%d,%d] %s times\n",Pos[0],i,D==9? "UnFixed Traversal":Integer.toString((AllPos+2)/2)); 
    		}
    		}
    	else {
    		System.out.printf("\nCan Move RIGHT Before [%d,%d] 0 times\n",Pos[0],i); 
    	}
    	
    	System.out.printf("All Positions RIGHT for Piece:%c",this.type);
    	PrintAll(All,AllPos);
    	System.out.println();
    	
    	if(All[0] == 0 && All[1] == 0 && All[2] == 0 && All[3] == 0) {
    		
    		All=null;
    	}
    	
		
    	return All;
   
    }
    //Move down
    public int [] Down(Board B,int dist,boolean IgnoreAll, int[] NPos) {
    	System.out.println("Traverse Down");
    	char[][]Board = B.BoardC;
    	
    	int D = dist;
    	
    	int [] All = new int[18];
    	InitNeg(All);
    	
    	
    	int[] Pos = null;
    	if(NPos==null) {
    	Pos = this.Position.clone();
    	}
    	else {
    		Pos = NPos;
    	}
    	
    	System.out.printf("START:[%d,%d]\n", Pos[0],Pos[1]);
		
		int i=Pos[0];
    	if(dist<=0) {
    		//No Limits on distance to traverse direction DOWN
    	    D = dist = 9;
    	}
		
    	boolean Traversable = false;
    	boolean EnemyFound = false;
    	
    	int AllPos = 0;
    	
    	//Get off current piece position
    	for(i=Pos[0]+1;i<8&&dist>0;i++,dist--) {
			//Change in Row UP
    		Player P = B.GetPlayer(i, Pos[1]);
			if(P!=null&&!IgnoreAll) {
			if(Board[i][Pos[1]]!='0') {
				//Either your piece or their piece, check if their piece
				
				if(P.Player==super.Player) {
					//Found your own piece, blocked, backtrace
					System.out.printf("Found YOUR Piece at:[%d,%d], backtracing prev",i,Pos[1]);
					//i--;
					break;
				}
				else {
					//Found enemy piece!
					All[AllPos] = i;
					All[AllPos+1] = Pos[1];
					Traversable = true;
					EnemyFound=true;
					System.out.printf("Found Enemy Piece at:[%d,%d]\n",i,Pos[1]);
					break;
				}
			
				}
				
				}
			else {
				All[AllPos] = i;
				All[AllPos+1] = Pos[1];
				AllPos = AllPos+2;
				Traversable = true;
				System.out.printf("Found Empty Position:[%d,%d]\n",i,Pos[1]);	
			}
			
			}
    	
    	if(Traversable) {
    		if(!EnemyFound) {
    			AllPos=AllPos-2;
    		System.out.printf("\nCan Move Down Before [%d,%d] %s times\n",i,Pos[1],D==9? "UnFixed Traversal":Integer.toString((AllPos+2)/2)); 
    		}
    		else {
    	   System.out.printf("\nCan Move UP Before or ATTACK ENEMY @ [%d,%d] %s times\n",i,Pos[1],D==9? "UnFixed Traversal":Integer.toString((AllPos+2)/2));       		
    		}
    		}
    	else {
    		System.out.printf("\nCan Move Down Before [%d,%d] 0 times\n",i,Pos[1]);    	
    	}
    	
    	System.out.printf("All Positions DOWN for Piece:%c",this.type);
    	PrintAll(All,AllPos);
    	System.out.println();
    	
    	
    	if(All[0] == 0 && All[1] == 0 && All[2] == 0 && All[3] == 0 ) {
    		
    		All=null;
    	}
    	
    	if(this.type=='p') {
    		if(EnemyFound) {
    			//CANT GO ON ENEMY AS PAWN
    			System.out.printf("\nCANT GO DOWN ON ENEMY for PAWN at Pos [%d,%d]\n",Pos[0],Pos[1]);
    			All=null;
    		}
    	}
    	
    	return All;
    }
    //Move left
    public int[] Left(Board B,int dist,boolean IgnoreAll,int []NPos) {
    	System.out.println("Traverse LEFT");
    	char[][]Board = B.BoardC;
    	
    	int D = dist;
    	
    	//{[Start,End],....[Startn,Endn]}
    	int [] All = new int[18];
    	InitNeg(All);
    	
    	
    	int[] Pos = null;
    	if(NPos==null) {
    	Pos = this.Position.clone();
    	}
    	else {
    		Pos = NPos;
    	}
    	
    	System.out.printf("START:[%d,%d]\n", Pos[0],Pos[1]);
		
		int i=Pos[0];
    	if(dist<=0) {
    		//No Limits on distance to traverse direction UP
    	    D = dist = 9;
    	    //All = new int[9];
    	}
    	
    	//Get off of current piece position
    	
    	boolean Traversable = false;
    	boolean EnemyFound = false;
    	
    	int AllPos = 0;
    	
    	for(i=Pos[1]-1;i>=0&&dist>0;i--,dist--) {
			//Change in Row UP
    		Player P = B.GetPlayer(Pos[0], i);
			if(P!=null&&!IgnoreAll) {
			if(Board[Pos[0]][i]!='0') {
				//Either your piece or their piece, check if their piece
				
				if(P.Player==super.Player) {
					//Found your own piece, blocked, backtrace
					System.out.printf("Found YOUR Piece at:[%d,%d], backtracing prev",Pos[0],i);
					//i++;
					
					break;
				}
				else {
					//Found enemy piece!
					Traversable = true;
					EnemyFound = true;
					System.out.printf("Found Enemy Piece at:[%d,%d]\n",Pos[0],i);
					All[AllPos] = Pos[0];
					All[AllPos+1] = i;
					break;
				}
			
				}
				
				}
			else {
				All[AllPos]=Pos[0];
				All[AllPos+1]=i;
				AllPos = AllPos+2;
				Traversable = true;
				System.out.printf("Found Empty Position:[%d,%d]\n",Pos[0],i);	
			}
			
			}
    	if(Traversable) {
    		if(!EnemyFound) {
    			AllPos=AllPos-2;
    			System.out.printf("\nCan Move RIGHT Before [%d,%d] %s times\n",Pos[0],i,D==9? "UnFixed Traversal":Integer.toString((AllPos+2)/2)); 
    		}
    		else {
    			System.out.printf("\nCan Move RIGHT Before or ATTACK ENEMY @ [%d,%d] %s times\n",Pos[0],i,D==9? "UnFixed Traversal":Integer.toString((AllPos+2)/2)); 
    		}
    		}
    	else {
    		System.out.printf("\nCan Move RIGHT Before [%d,%d] 0 times\n",Pos[0],i); 
    	}
    	
    	System.out.printf("All Positions RIGHT for Piece:%c",this.type);
    	PrintAll(All,AllPos);
    	System.out.println();
    	
    	
    	
    	if(All[0] == 0 && All[1] == 0 && All[2] == 0 && All[3] == 0 ) {
    		
    		All=null;
    	}
    	
    	
		
    	return All;
    }
    //MOVE < diagonal up left
    public int[] D1(Board B,int dist,boolean IgnoreAll,int [] NPos) {
    	System.out.println("Traverse UP LEFT");
    	char[][]Board = B.BoardC;
    	
    	int D = dist;
    	
    	//{[Start,End],....[Startn,Endn]}
    	int [] All = new int[18];
    	InitNeg(All);
    	
    	
    	int[] Pos = null;
    	if(NPos==null) {
    	Pos = this.Position.clone();
    	}
    	else {
    		Pos = NPos;
    	}
    	
    	System.out.printf("START:[%d,%d]\n", Pos[0],Pos[1]);
    	
    	int i=Pos[0];
    	int j=Pos[1];
		
		if(dist<=0) {
    		//No Limits on distance to traverse direction UP
    	    D = dist = 9;
    	    //All = new int[9];
    	}
    	
    	//Get off of current piece position
    	
    	boolean Traversable = false;
    	boolean EnemyFound = false;
    	
    	int AllPos = 0;
    	
    	
    	for(i=Pos[0]-1,j=Pos[1]-1;i>=0&&j>=0&&dist>0;i--,j--,dist--) {
			//Change in Row UP
    		Player P = B.GetPlayer(i, j);
			if(P!=null&&!IgnoreAll) {
			if(Board[i][j]!='0') {
				//Either your piece or their piece, check if their piece
				
				if(P.Player==super.Player) {
					//Found your own piece, blocked, backtrace
					System.out.printf("Found YOUR Piece at:[%d,%d], backtracing prev",i,j);
					//i++;
					
					break;
				}
				else {
					//Found enemy piece!
					Traversable = true;
					EnemyFound = true;
					System.out.printf("Found Enemy Piece at:[%d,%d]\n",i,j);
					All[AllPos] = i;
					All[AllPos+1] = j;
					break;
				}
			
				}
				
				}
			else {
				All[AllPos]=i;
				All[AllPos+1]=j;
				AllPos = AllPos+2;
				
				Traversable = true;
				System.out.printf("Found Empty Position:[%d,%d]\n",i,j);	
			}
			
			}
    	if(Traversable) {
    		if(!EnemyFound) {
    			AllPos=AllPos-2;
    			System.out.printf("\nCan Move < Before [%d,%d] %s times\n",i,j,D==9? "UnFixed Traversal":Integer.toString((AllPos+2)/2)); 
    		}
    		else {
    			System.out.printf("\nCan Move < Before or ATTACK ENEMY @ [%d,%d] %s times\n",i,j,D==9? "UnFixed Traversal":Integer.toString((AllPos+2)/2)); 
    		}
    		}
    	else {
    		System.out.printf("\nCan Move < Before [%d,%d] 0 times\n",i,j); 
    	}
    	
    	System.out.printf("All Positions < for Piece:%c",this.type);
    	PrintAll(All,AllPos);
    	System.out.println();
		
    	if(All[0] == 0 && All[1] == 0 && All[2] == 0 && All[3] == 0 ) {
    		
    		All=null;
    	}
    	//PAWN CHECK
    	if(this.type=='p') {
    		if(!EnemyFound) {
    			//No Enemy Found from pawn, CANT GO DIAGONAL
    			System.out.printf("\nNo Enemy Found for PAWN at Pos [%d,%d]\n",Pos[0],Pos[1]);
    			All=null;
    		}
    	}
    	
    	return All;
    }
    //Move Diagonal UP RIGHT
    public int[] D2(Board B,int dist,boolean IgnoreAll,int []NPos) {
    	//>
    	System.out.println("Traverse UP RIGHT");
    	char[][]Board = B.BoardC;
    	
    	int D = dist;
    	
    	//{[Start,End],....[Startn,Endn]}
    	int [] All = new int[18];
    	InitNeg(All);
    	
    	
    	int[] Pos = null;
    	if(NPos==null) {
    	Pos = this.Position.clone();
    	}
    	else {
    		Pos = NPos;
    	}
    	
    	System.out.printf("START:[%d,%d]\n", Pos[0],Pos[1]);
		
    	int i=Pos[0];
    	int j=Pos[1];
		
		if(dist<=0) {
    		//No Limits on distance to traverse direction UP
    	    D = dist = 9;
    	    //All = new int[9];
    	}
    	
    	//Get off of current piece position
    	
    	boolean Traversable = false;
    	boolean EnemyFound = false;
    	
    	int AllPos = 0;
    	
    	
    	for(i=Pos[0]-1,j=Pos[1]+1;i>=0&&j<8&&dist>0;i--,j++,dist--) {
			//Change in Row UP RIGHT
    		Player P = B.GetPlayer(i, j);
			if(P!=null&&!IgnoreAll) {
			if(Board[i][j]!='0') {
				//Either your piece or their piece, check if their piece
				
				if(P.Player==super.Player) {
					//Found your own piece, blocked, backtrace
					System.out.printf("Found YOUR Piece at:[%d,%d], backtracing prev",i,j);
					//i++;
					
					break;
				}
				else {
					//Found enemy piece!
					Traversable = true;
					EnemyFound = true;
					System.out.printf("Found Enemy Piece at:[%d,%d]\n",i,j);
					All[AllPos] = i;
					All[AllPos+1] = j;
					break;
				}
			
				}
				
				}
			else {
				All[AllPos]=i;
				All[AllPos+1]=j;
				AllPos = AllPos+2;
				
				Traversable = true;
				System.out.printf("Found Empty Position:[%d,%d]\n",i,j);	
			}
			
			}
    	if(Traversable) {
    		if(!EnemyFound) {
    			AllPos=AllPos-2;
    			System.out.printf("\nCan Move > Before [%d,%d] %s times\n",i,j,D==9? "UnFixed Traversal":Integer.toString((AllPos+2)/2)); 
    		}
    		else {
    			System.out.printf("\nCan Move > Before or ATTACK ENEMY @ [%d,%d] %s times\n",i,j,D==9? "UnFixed Traversal":Integer.toString((AllPos+2)/2)); 
    		}
    		}
    	else {
    		System.out.printf("\nCan Move > Before [%d,%d] 0 times\n",i,j); 
    	}
    	
    	System.out.printf("All Positions > for Piece:%c",this.type);
    	PrintAll(All,AllPos);
    	System.out.println();
		
    	if(All[0] == 0 && All[1] == 0 && All[2] == 0 && All[3] == 0 ) {
    		
    		All=null;
    	}
    	
    	if(this.type=='p') {
    		if(!EnemyFound) {
    			//No Enemy Found from pawn, CANT GO DIAGONAL
    			System.out.printf("\nNo Enemy Found for PAWN at Pos [%d,%d]\n",Pos[0],Pos[1]);
    			All=null;
    		}
    	}
    	
    	
    	
    	
    	return All;
    }
    //Move Down Left
    public int[] D3(Board B,int dist,boolean IgnoreAll,int []NPos) {
    	//>
    	System.out.println("Traverse DOWN LEFT");
    	char[][]Board = B.BoardC;
    	
    	int D = dist;
    	
    	//{[Start,End],....[Startn,Endn]}
    	int [] All = new int[18];
    	InitNeg(All);
    	
    	int[] Pos = null;
    	if(NPos==null) {
    	Pos = this.Position.clone();
    	}
    	else {
    		Pos = NPos;
    	}
    	
    	System.out.printf("START:[%d,%d]\n", Pos[0],Pos[1]);
		
    	int i=Pos[0];
    	int j=Pos[1];
		
		if(dist<=0) {
    		//No Limits on distance to traverse direction UP
    	    D = dist = 9;
    	    //All = new int[9];
    	}
    	
    	//Get off of current piece position
    	
    	boolean Traversable = false;
    	boolean EnemyFound = false;
    	
    	int AllPos = 0;
    	
    	
    	for(i=Pos[0]+1,j=Pos[1]-1;i<8&&j>=0&&dist>0;i++,j--,dist--) {
			//Change in Row UP
    		Player P = B.GetPlayer(i, j);
			if(P!=null&&!IgnoreAll) {
			if(Board[i][j]!='0') {
				//Either your piece or their piece, check if their piece
				
				if(P.Player==super.Player) {
					//Found your own piece, blocked, backtrace
					System.out.printf("Found YOUR Piece at:[%d,%d], backtracing prev",i,j);
					//i++;
					
					break;
				}
				else {
					//Found enemy piece!
					Traversable = true;
					EnemyFound = true;
					System.out.printf("Found Enemy Piece at:[%d,%d]\n",i,j);
					All[AllPos] = i;
					All[AllPos+1] = j;
					break;
				}
			
				}
				
				}
			else {
				All[AllPos]=i;
				All[AllPos+1]=j;
				AllPos = AllPos+2;
				
				Traversable = true;
				System.out.printf("Found Empty Position:[%d,%d]\n",i,j);	
			}
			
			}
    	if(Traversable) {
    		if(!EnemyFound) {
    			AllPos=AllPos-2;
    			System.out.printf("\nCan Move { Before [%d,%d] %s times\n",i,j,D==9? "UnFixed Traversal":Integer.toString((AllPos+2)/2)); 
    		}
    		else {
    			System.out.printf("\nCan Move { Before or ATTACK ENEMY @ [%d,%d] %s times\n",i,j,D==9? "UnFixed Traversal":Integer.toString((AllPos+2)/2)); 
    		}
    		}
    	else {
    		System.out.printf("\nCan Move { Before [%d,%d] 0 times\n",i,j); 
    	}
    	
    	System.out.printf("All Positions { for Piece:%c",this.type);
    	PrintAll(All,AllPos);
    	System.out.println();
    	
    	if(All[0] == 0 && All[1] == 0 && All[2] == 0 && All[3] == 0 ) {
    		
    		All=null;
    	}
    	
    	if(this.type=='p') {
    		if(!EnemyFound) {
    			//No Enemy Found from pawn, CANT GO DIAGONAL
    			System.out.printf("\nNo Enemy Found for PAWN at Pos [%d,%d]\n",Pos[0],Pos[1]);
    			All=null;
    		}
    	}
		
    	return All;
    }
    //Move Down Right
    public int[] D4(Board B,int dist,boolean IgnoreAll, int[] NPos) {
    	//}
    	System.out.println("Traverse DOWN RIGHTT");
    	char[][]Board = B.BoardC;
    	
    	int D = dist;
    	
    	//{[Start,End],....[Startn,Endn]}
    	int [] All = new int[18];
    	InitNeg(All);
    	
    	
    	int[] Pos = null;
    	if(NPos==null) {
    	Pos = this.Position.clone();
    	}
    	else {
    		Pos = NPos;
    	}
    	
    	System.out.printf("START:[%d,%d]\n", Pos[0],Pos[1]);
		
    	int i=Pos[0];
    	int j=Pos[1];
		
		if(dist<=0) {
    		//No Limits on distance to traverse direction UP
    	    D = dist = 9;
    	    //All = new int[9];
    	}
    	
    	//Get off of current piece position
    	
    	boolean Traversable = false;
    	boolean EnemyFound = false;
    	
    	int AllPos = 0;
    	
    	
    	for(i=Pos[0]+1,j=Pos[1]+1;i<8&&j<8&&dist>0;i++,j++,dist--) {
			//Change in Row UP
    		Player P = B.GetPlayer(i, j);
			if(P!=null&&!IgnoreAll) {
			if(Board[i][j]!='0') {
				//Either your piece or their piece, check if their piece
				
				if(P.Player==super.Player) {
					//Found your own piece, blocked, backtrace
					System.out.printf("Found YOUR Piece at:[%d,%d], backtracing prev",i,j);
					//i++;
					
					break;
				}
				else {
					//Found enemy piece!
					Traversable = true;
					EnemyFound = true;
					System.out.printf("Found Enemy Piece at:[%d,%d]\n",i,j);
					All[AllPos] = i;
					All[AllPos+1] = j;
					break;
				}
			
				}
				
				}
			else {
				All[AllPos]=i;
				All[AllPos+1]=j;
				AllPos = AllPos+2;
				
				Traversable = true;
				System.out.printf("Found Empty Position:[%d,%d]\n",i,j);	
			}
			
			}
    	if(Traversable) {
    		if(!EnemyFound) {
    			AllPos=AllPos-2;
    			System.out.printf("\nCan Move } Before [%d,%d] %s times\n",i,j,D==9? "UnFixed Traversal":Integer.toString((AllPos+2)/2)); 
    		}
    		else {
    			System.out.printf("\nCan Move } Before or ATTACK ENEMY @ [%d,%d] %s times\n",i,j,D==9? "UnFixed Traversal":Integer.toString((AllPos+2)/2)); 
    		}
    		}
    	else {
    		System.out.printf("\nCan Move } Before [%d,%d] 0 times\n",i,j); 
    	}
    	
    	System.out.printf("All Positions } for Piece:%c",this.type);
    	PrintAll(All,AllPos);
    	System.out.println();
		
    	if(All[0] == 0 && All[1] == 0 && All[2] == 0 && All[3] == 0 ) {
    		
    		All=null;
    	}
    	
    	if(this.type=='p') {
    		if(!EnemyFound) {
    			//No Enemy Found from pawn, CANT GO DIAGONAL
    			System.out.printf("\nNo Enemy Found for PAWN at Pos [%d,%d]\n",Pos[0],Pos[1]);
    			All=null;
    		}
    	}
    	
    	return All;
    }
    
    //WORKS
    //Maybe add in Exception for special case ( LAST CHAR )
    //WORKS
    public int[] Collisions(char c1,char c2,/* int[]Start, int[]End,*/ Board B, boolean Exception,int[] NPos){
    	//Trace path seq's until collide or hit a boundary
    	//Modify Start for every move, If move is infinite, track until collide the same way.
    	//RETURN ALL END POSITIONS FOUND [n] or Until Collide
    	//Board Player 1 (White)
    	//int [] Ends = null;
    	//char[][]Board = B.BoardC;
    	
    	//if(super.Player == '1') {
    	System.out.printf("\nHandling Collisions for Player %c\n",super.Player);
    		if(c2==' '||c2=='<'||c2=='>'||c2=='{'||c2=='}') {
    		
    		//U,D,L,R, <<, >>, {{, }}
    		System.out.println(" Must be Path Seqs U,D,L,R, <<, >>, {{, }}");
    		if(c1=='U') {
    		//Go all the way up possible
    		//this.Position is current position
    		//int [] All = Up(B,-1);
    		return Up(B,-1,Exception,NPos);	
    		}
    		if(c1=='D') {
    		//Go all the way down possible
    		return Down(B,-1,Exception,NPos);
    		}
    		if(c1=='L') {
    		//Go All the way left possible
    		return Left(B,-1,Exception,NPos);
    		}
    		if(c1=='R') {
    		//Go all the way right possible	
    		return Right(B,-1,Exception,NPos);
    		}
    		
    		if(c1=='<') {
    			if(c2=='<') {
    				//Iterate up left diag until collide
    				return D1(B,-1,Exception,NPos);
    			}
    			else {
    				//Iterate up left diag n times and check collide
    				//NO NEED
    			}
    		}
    		
    		if(c1=='>') {
    			if(c2=='>') {
    				//Iterate up right diag until collide
    				return D2(B,-1,Exception,NPos);
    			}
    			else {
    				//Iterate up right diag n times and check collide
    				//NO NEED
    			}
    			
    		}
    		
    		if(c1=='{') {
    			if(c2=='{') {
    				//Iterate down left diag until collide
    				return D3(B,-1,Exception,NPos);
    			}
    			else {
    				//Iterate down left diag n times and check collide
    			}
    			
    		}
    		
    		if(c1=='}') {
    			if(c2=='}') {
    				//Iterate down right diag until collide
    				return D4(B,-1,Exception,NPos);
    			}
    			else {
    				//Iterate down right diag n times and check collide
    			}
    		}
    	
    	}
    	else {

    		//Must be the other path seq types u[n],...,r[n], >[n],.....,}[n]
    		System.out.println("Must be the other path seq types u[n],...,r[n], >[n],.....,}[n]");
    		if(c1=='u') {
    			int L = Character.getNumericValue(c2);
    			if(L<=0) {
    				System.out.printf("Character:%c failed to convert, invalid char?",c2);
    				System.exit(-1);
    			}
    			return Up(B,L,Exception,NPos);
    		}
    		if(c1=='r') {
    			int L = Character.getNumericValue(c2);
    			if(L<=0) {
    				System.out.printf("Character:%c failed to convert, invalid char?",c2);
    				System.exit(-1);
    			}
    			return Right(B,L,Exception,NPos);
    		}
    		if(c1=='d') {
    			int L = Character.getNumericValue(c2);
    			if(L<=0) {
    				System.out.printf("Character:%c failed to convert, invalid char?",c2);
    				System.exit(-1);
    			}
    			return Down(B,L,Exception,NPos);
    		}
    		if(c1=='l') {
    			int L = Character.getNumericValue(c2);
    			if(L<=0) {
    				System.out.printf("Character:%c failed to convert, invalid char?",c2);
    				System.exit(-1);
    			}
    			return Left(B,L,Exception,NPos);
    		}
    		if(c1=='<') {
    			int L = Character.getNumericValue(c2);
    			if(L<=0) {
    				System.out.printf("Character:%c failed to convert, invalid char?",c2);
    				System.exit(-1);
    			}
    			return D1(B,L,Exception,NPos);
    		}
    		if(c1=='>') {
    			int L = Character.getNumericValue(c2);
    			if(L<=0) {
    				System.out.printf("Character:%c failed to convert, invalid char?",c2);
    				System.exit(-1);
    			}
    			return D2(B,L,Exception,NPos);
    		}
    		if(c1=='{') {
    			int L = Character.getNumericValue(c2);
    			if(L<=0) {
    				System.out.printf("Character:%c failed to convert, invalid char?",c2);
    				System.exit(-1);
    			}
    			return D3(B,L,Exception,NPos);
    		}
    		if(c1=='}') {
    			int L = Character.getNumericValue(c2);
    			if(L<=0) {
    				System.out.printf("Character:%c failed to convert, invalid char?",c2);
    				System.exit(-1);
    			}
    			return D4(B,L,Exception,NPos);    			
    		}
    		
    		
    		}
    		
    		
    	//}
    	
    	
    	return null;
    }
    
    //For Each player, use while loop
    //Return Array of all Possible End Positions from start to end... For this piece
    //Array will be 2 columns and n rows, each row will be end position for each action sequence in piece moveset
    public int[][] Move(/*int []Start, int[]End, */Board B) {
    	if(this.Status[1]=='X'||this.Position[0]<0||this.Position[1]<0) {
    	System.out.println("This piece is eliminated, cannot move");
    	return null;	
    	}
    	/*
    	if(this.Status[1]=='C'&&this.CMovesets==null) {
    	System.out.println("This piece cannot save king in check, cannot move");
    	return null;	
    	}
    	*/
    	/*
    	if(Start==null||End==null) {
    		
    		System.out.println("Null Start or End Positions");
    		
    		return null;
    	}
    	if(Start.length!=2||End.length!=2) {
    		
    		System.out.println("Start or End Positions invalid size");
    		
    		return null;
    		
    	}
    	if(Start[0]!=this.Position[0]||Start[1]!=this.Position[1]) {
    		System.out.println("ERROR, Piece Not Synchronized with where it should be");
    		System.exit(-1);
    	}
    	*/
    	
    	///////////////////////////
    	int [][]PathSeq = isAnyPath(/*Start,End,*/B);
    	
    	if(PathSeq==null) {
    		System.out.println("No Path sequences possible for this piece");
    	//////////////////////////
    		// IF PIECE IS KING, CHECK IF NO MOVES AVAILABLE to destroy enemy, 
    		//block enemy, or if king is only piece left, MOVE king, Then Checkmate!
    	
    	//////////////////////////
    	return null;
    	}
    	
    	/*
    	Scanner reader = new Scanner(System.in);
    	boolean ValidIn=false;
    	while(!ValidIn) {
    		System.out.println("Enter Path seq to be taken");
    		
    		
    	}
    	*/
    	return PathSeq;
    }
        
    
    public int LengthMvSet(String s) {
    	char[] c = s.toCharArray();
    	
    	int length = 0;
    	
    	for(int i=0;i<c.length;i++) {
    		
    		if(Character.isAlphabetic(c[i])) {
    			
    			length++;
    		}
    		
    	}
    	
    	return length;
    	
    }
    
    public void InitNeg(int[] C) {
    	
    	for(int i=0;i<C.length;i++) {
    		C[i]=-5;
    	}
    	
    }
    
    public int[] LastElem(int[][]C) {
    	int[]E = null;
    	for(int i=0;i<C.length-6;i++) {
    		if(C[i]!=null) {
    			if(C[i][0]!=-1||C[i][1]!=-1)
    			E = C[i];
    			
    		}
    	}
    	
    	if(E==null) {
    		E = new int[2];
    		E[0] = 0;
    		E[1] = 0;
    	}
    	
    	return E;
    }
    
    public int[] ReSize(int[]A,int Size) {
    	
    	if(Size<=0||A==null) {
    	System.out.println("Null array");
    	return A;
    	}
    	
    	int[] A2 = new int[Size];
    	
    	for(int i=0;i<Size/2;i=i+2) {
    	A2[i] = A[i];
    	A2[i+1] = A[i+1];
    	}
    	
    	return A2;
    }
    
    public int PrintOptions(int[][] T) {
		System.out.println("Options to take");
		int i=0;
		
		for(i=0; i<T.length;i++) {
		if(T[i]!=null) {
		
		for(int j=0;j<T[i].length;j++) {
			System.out.printf("%d ",T[i][j]);
		}
		System.out.println();
		}
		
		}
		
		return i;
	}
	
    
	}
	//WORKS

