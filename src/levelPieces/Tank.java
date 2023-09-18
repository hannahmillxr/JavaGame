package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Tank extends GamePiece implements gameEngine.Moveable {
	
	private static char symbol = '$';
	private static String label = "Tank";
	private int location;
	
	
	public Tank(int location) {
		super(symbol, label, location);
		this.location = location;
		// TODO Auto-generated constructor stub
	}
	
	
	//the tank will always move right, it will skip over objects in its path until it finds an empty spot
	public void move(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		int currPos = this.getLocation();
		currPos++;
		while(gameBoard[currPos]!= null){
			currPos++;
			if (currPos>gameBoard.length)
				currPos=0;
		}
		this.setLocation(currPos);
	}

	
	// the player can hide behind a bush, the guard or the target from the tank, otherwise, tank will hit
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		boolean blocked = false;
		int currPos = this.getLocation();
		
		//Hiding in bush
		if(gameBoard[playerLocation].getClass().getTypeName() == "Bush") 
			blocked = true;
		if (currPos<playerLocation){
			for (int i = currPos; i<playerLocation; i++){
				String type = gameBoard[i].getClass().getTypeName(); 
				if (type== "Bush" || type== "Target" || type== "Gaurd")
					blocked =true;
			}	
		}
		else{
			for (int i = currPos; i>playerLocation; i--){
				String type = gameBoard[i].getClass().getTypeName(); 
				if (type== "Bush" || type== "Target" || type== "Gaurd")
					blocked =true;
			}
		}
		if (blocked == true)
			return InteractionResult.NONE;
		else
			return InteractionResult.HIT;	
	}
}
