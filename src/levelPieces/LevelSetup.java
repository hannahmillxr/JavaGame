package levelPieces;

import java.util.ArrayList;

public class LevelSetup {
	
	public void createLevel(int levelNum) {
		switch(levelNum) {
			case 0:
				break;
				
			case 1:
				break;
		}
	}
	
	public gameEngine.Drawable[] getBoard(){
		return null;
		
	}
	
	public ArrayList<gameEngine.Moveable> getMovingPieces(){
		return null;
		
	}
	
	public ArrayList<GamePiece> getIntereactingPieces(){
		return null;
		
	}
	
	public int getPlayerStartLoc() {
		return 0;
	}
}
