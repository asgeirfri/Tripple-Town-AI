import java.awt.Point;

public class Main {
	
	
	
	public static void main(String[] args){
		//HumanGame();
		AIGame();

	}
	
	public static void AIGame() {
		TripleTownUI boardUI = new TripleTownUI();
		TTBoard board = new TTBoard();
		board.init();
		if(boardUI.isVisible() == false) {
			boardUI.setVisible(true);
		}
		
		while(!board.gameOver()) {
			boardUI.StartButton.doClick();
		}
	}
	public static void HumanGame() {
		TripleTownUI boardUI = new TripleTownUI();
		TTBoard board = new TTBoard();
		board.init();
		if(boardUI.isVisible() == false) {
			boardUI.setVisible(true);
		}
	}
}