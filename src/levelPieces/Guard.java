package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import java.util.Random;

public class Guard extends GamePiece implements gameEngine.Moveable{

	private int direction = 1; //1 is right, -1 is left
	private static char symbol = '$';
	private static String label = "Guard";
	public int location;
	public Guard(int location) {
		super(symbol, label, location);
		this.location = location;
	}
	
	/**
	 * Moves the guard back and forth between the nearest left object and
	 * the nearest right object.
	 */
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int currPos = this.getLocation();
		int leftBound = -1;
		int rightBound = -1;
		for(int i = currPos; i < gameBoard.length; i++) { //Right object
			if(gameBoard[i] != null || i == gameBoard.length-1) rightBound = i;
		}
		for(int i = currPos; i >= 0; i--) { //Left object
			if(gameBoard[i] != null || i == 0) leftBound = i;
		}
		int nextPos = currPos + direction;
		if(nextPos > leftBound && nextPos < rightBound) {
			gameBoard[currPos] = null;
			gameBoard[nextPos] = this;
		}
		else {
			direction *= -1;
			move(gameBoard, playerLocation);
		}
	}
	/**
	 * Hits the player if adjacent or on top of them. Ignores if hiding in bush
	 */
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		int pos = this.getLocation();
		//Check if player is hiding in a bush
		for(int i = 0; i < gameBoard.length-1; i++) {
			String type = gameBoard[i].getClass().getTypeName(); //Get the subclass of the drawable
			if(type == "Bush" && i == playerLocation){
				return InteractionResult.NONE;
			}
		}
		//If guard next to (or on) player
		if(pos + 1 == playerLocation || pos - 1 == playerLocation || pos == playerLocation) return InteractionResult.HIT;
		return InteractionResult.NONE;
	}

}
