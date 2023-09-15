package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Knife extends GamePiece implements Drawable {

	private static char symbol = '/';
	private static String label = "Knife";
	public Knife(int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		return null;
	}

}
