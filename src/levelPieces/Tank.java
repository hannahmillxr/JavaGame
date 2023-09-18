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
		tankLocation = gameBoard.find('$'); //.find() doesnt work for arrays, use a for loop
		gameBoard[tankLocation] = ' '; //gameBoard is a Drawable array, not a char array. Plus multiple tanks can be on the board. Look for "this" instead of '$'
		tankLocation++;
		while(gameBoard[tankLocation]!= ' '){ // char array see above
			tankLocation++;
			if (tankLocation>BOARD_SIZE){ //>= (array at 0)
				tankLocation=0; //Do we want it to sweep back to the left or just teleport. Either way is good tbh
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
