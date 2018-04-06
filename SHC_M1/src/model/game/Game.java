package model.game;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import model.pieces.heroes.Armored;
import model.pieces.heroes.Hero;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKickP1;
import model.pieces.sidekicks.SideKickP2;

public class Game {

	private final int payloadPosTarget = 6;
	private final int boardWidth = 6;
	private final int boardHeight = 7;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private Cell[][] board;

	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		currentPlayer = player1;
		board = new Cell[boardHeight][boardWidth];
		assemblePieces();
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public int getPayloadPosTarget() {
		return payloadPosTarget;
	}

	@Override
	public String toString() {
		String s = "";
		System.out.println("      " + getPlayer2().getName());
		System.out.print("| ");
		for (int i = 0; i < board[0].length; i++)
			System.out.print("--");
		System.out.println("|");
		for (int i = 0; i < board.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == null)
					System.out.print("n ");
				else
					System.out.print(board[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.print("| ");
		for (int i = 0; i < board[0].length; i++)
			System.out.print("--");
		System.out.println("|");
		System.out.println("    " + getPlayer1().getName());
		return s;
	}

	public int getBoardWidth() {
		return boardWidth;
	}

	public int getBoardHeight() {
		return boardHeight;
	}
 public void assemblePieces() { 
	 
	 for(int i=0;i<7;i++)
	 {
		 for(int j=0;j<6;j++)
		 {
			    board[i][j]=new Cell();
			 
		 }
		 
	 }
	for(int i=0;i<6;i++)
	{
		SideKickP2 P2=new SideKickP2(this,"Side Kick Player(2)_"+(i+1));
	    P2.setPosI(2);
	    P2.setPosJ(i);
	    board[2][i]=new Cell();
		board[2][i].setPiece(P2);
	}
	for(int i=0;i<6;i++)
	{
		SideKickP1 P1=new SideKickP1(this,"Side Kick Player(1)_"+(i+1));
	    P1.setPosI(4);
	    P1.setPosJ(i);
	    board[4][i]=new Cell();
		board[4][i].setPiece(P1);
	}
    char[] h={'P','R','M','A','S','T'};
    //Player 1
    shuffleArray(h);
    for(int i=0;i<6;i++)
    {
    	Hero hero = null; 

    	switch(h[i])
    	{
    	case'P':
    	    hero=new Super(player1,this,"");
    		break;
    	case 'R':
    	    hero=new Ranged(player1,this,"");
    		break;
    	case 'M':
    	    hero=new Medic(player1,this,"");
    		break;
    	case 'A':
    	    hero=new Armored(player1,this,"");
            break;
    	case 'S':
    	    hero=new Speedster(player1,this,"");
            break;
    	case 'T':
    	    hero=new Tech(player1,this,"");
            break;
    	}
    	hero.setPosI(5);
	    hero.setPosJ(i);
	    board[5][i]=new Cell();
		board[5][i].setPiece(hero);
    }
    //Player 2
    for(int i=0;i<6;i++)
    {
    	Hero hero = null; 

    	switch(h[i])
    	{
    	case'P':
    	    hero=new Super(player2,this,"");
    		break;
    	case 'R':
    	    hero=new Ranged(player2,this,"");
    		break;
    	case 'M':
    	    hero=new Medic(player2,this,"");
    		break;
    	case 'A':
    	    hero=new Armored(player2,this,"");
            break;
    	case 'S':
    	    hero=new Speedster(player2,this,"");
            break;
    	case 'T':
    	    hero=new Tech(player2,this,"");
            break;
    	}
    	hero.setPosI(1);
	    hero.setPosJ(i);
	    board[1][i]=new Cell();
		board[1][i].setPiece(hero);
    }

	 }
static void shuffleArray(char[] ar)
{
  // If running on Java 6 or older, use `new Random()` on RHS here
  Random rnd = ThreadLocalRandom.current();
  for (int i = ar.length - 1; i > 0; i--)
  {
    int index = rnd.nextInt(i + 1);
    // Simple swap
    char a = ar[index];
    ar[index] = ar[i];
    ar[i] = a;
  }
}
	public void switchTurns(){
		
	    if(currentPlayer==player1 )
	   
	    	currentPlayer=player2;
	    else 
	    	if (currentPlayer==player2)
	    		
	    		currentPlayer=player1;
		
		}
	public boolean checkWinner(){
	// ana 3wza a2ol 2no law PosPayload = ps target el hia 6 , yb2a el current player aw el owner hwa el winner 
	
		if (getCurrentPlayer().getPayloadPos()==6)
			return true;
		else 
			return false;
		
	}
	 public Cell getCellAt(int i, int j){
		return board [i][j];
	
	 }
		

}
