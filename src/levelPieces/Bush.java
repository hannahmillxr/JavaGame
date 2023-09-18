package levelPieces;

public class Bush implements gameEngine.Drawable {
	private static char symbol = '#';
	private static String label = "Bush";
	public int location;
	public Bush(int location) {
		this.location = location;
	}
	@Override
	public void draw() {
		System.out.print(symbol);
	}
	
	@Override
	public String toString() {
		return symbol + " - " + label ; 
	}

}
