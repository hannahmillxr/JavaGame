package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Mine extends GamePiece implements gameEngine.Moveable{

	private static char symbol = '*';
	private static String label = "Mine";
	public Mine(int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		return null;
	}

}
 