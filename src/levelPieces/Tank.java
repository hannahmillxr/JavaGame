package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Tank extends GamePiece implements gameEngine.Moveable {
	
	private static char symbol = '$';
	private static String label = "Tank";
	public Tank(int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}
	
	public void move(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		tankLocation = gameBoard.find('$');
		gameBoard[tankLocation] = ' ';
		tankLocation++;
		while(gameBoard[tankLocation]!= ' '){
			tankLocation++;
			if (tankLocation>BOARD_SIZE){
				tankLocation=0;
			}
		}
		gameBoard[tankLocation] = '$';	
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		tankLocation = gameBoard.find('$');
		bool blocked = False;
		if (tankLocation<playerLocation){
			for (int i = tankLocation; i<playerLocation; i++){
				if (gameBoard[i]== '#' or gameBoard[i] == '^' or gameBoard[i] == '!'){
					blocked =True;
				}
			}	
		}
		else{
			for (int i = tankLocation; i>playerLocation; i--){
				if (gameBoard[i]== '#' or gameBoard[i] == '^' or gameBoard[i] == '!'){
					blocked =True;
				}
			}
		}
		if (blocked == True){
			return InteractionResult.NONE;
		}
		else{
			return InteractionResult.HIT;
		}	
	}
}
