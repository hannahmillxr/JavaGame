package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

//Should actually be done!

public class Mine extends GamePiece{
	private static char symbol = '*';
	private static String label = "Mine";
	public int location;
	public Mine(int location) {
		super(symbol, label, location);
		this.location = location;
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(this.getLocation() == playerLocation) return InteractionResult.KILL;
		return InteractionResult.NONE;
	}

}
 