package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Target extends GamePiece implements gameEngine.Drawable {

	private static char symbol = '^';
	private static String label = "Assassination Target";
	private int location;
	
	public Target(int location) {
		super(symbol, label, location);
		this.location = location;
		// TODO Auto-generated constructor stub
	}

	@Override

	//Player will advance iff the player location matches the target location and if the player has already picked up the knife
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		int currPos = this.getLocation();
		if (currPos == playerLocation && LevelSetup.getKnife()) {
			return InteractionResult.ADVANCE;
		}
		return InteractionResult.NONE;

	}

}
