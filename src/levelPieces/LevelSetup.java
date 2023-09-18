/*
 * Citations:
 * Lines 39->40 (Determining if a piece is moveable) https://www.baeldung.com/java-check-class-implements-interface 
 */
package levelPieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gameEngine.Drawable;

public class LevelSetup {
	private Drawable[] board;
	private static boolean knife;
	private int playerStartLocation;
	public void createLevel(int levelNum) {
		setKnife(false);
		switch(levelNum) {
			case 1:
				board = new Drawable[gameEngine.GameEngine.BOARD_SIZE];
				board[4] = new Guard(4);
				board[5] = new Bush(5);
				board[9] = new Mine(9);
				board[12] = new Knife(12);
				board[15] = new Bush(15);
				board[16] = new Guard(16);
				board[20] = new Target(20);
				break;
				
			case 2:
				board = new Drawable[gameEngine.GameEngine.BOARD_SIZE];
				board[4] = new Bush(4);
				board[5] = new Bush(5);
				board[7] = new Mine(7);
				board[8] = new Knife(8);
				board[9] = new Mine(9);
				board[10] = new Tank(10);
				board[15] = new Bush(15);
				board[16] = new Guard(16);
				board[20] = new Target(20);
				break;
				
			default:
				break;
		}
	}
	
	public gameEngine.Drawable[] getBoard(){
		return board;
		
	}
	
	public ArrayList<gameEngine.Moveable> getMovingPieces(){
		ArrayList<gameEngine.Moveable> movingPieces = new ArrayList<gameEngine.Moveable>();
		for(Drawable piece : board) {
			if(piece==null)continue;
			List<Class<?>> interfaces = Arrays.asList(piece.getClass().getInterfaces());
			if(interfaces.contains(gameEngine.Moveable.class))
				movingPieces.add((gameEngine.Moveable)piece);
		}
		return movingPieces;
		
	}
	
	public ArrayList<GamePiece> getInteractingPieces(){
		ArrayList<GamePiece> interactingPieces = new ArrayList<GamePiece>();
		for(Drawable piece : board) {
			if(piece==null)continue;
			if(piece instanceof GamePiece)
				interactingPieces.add((GamePiece)piece);
		}
		return interactingPieces;
	}
	
	public int getPlayerStartLoc() {
		return playerStartLocation;
	}
	
	public static void setKnife(boolean state) {
		knife = state;
	}
	public static boolean getKnife() {
		return knife;
	}
}
