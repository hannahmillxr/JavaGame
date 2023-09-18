package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

//Should actually be done!

public class Mine extends GamePiece{

	public Mine(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(this.getLocation() == playerLocation) return InteractionResult.KILL;
		return InteractionResult.NONE;
	}

}
 