package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Knife extends GamePiece implements Drawable {

	private static char symbol = '/';
	private static String label = "Knife";
	private int location;

	public Knife(int location) {
		super(symbol, label, location);
		this.location = location;
		LevelSetup.setKnife(false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		int currPos = this.getLocation();
		if (currPos == playerLocation) {
			LevelSetup.setKnife(true);
			gameBoard[this.getLocation()] = null;
			if(LevelSetup.getKnife() == false)
				return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;

	}

}

