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
		
		
		
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		return null;
	}

}
