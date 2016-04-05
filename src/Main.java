import java.awt.Point;

import edu.princeton.cs.algs4.Stopwatch;

public class Main {
	
	
	
	public static void main(String[] args){
		//HumanGame();
		AIGame();
	}
	
	public static void AIGame() {
		//Stopwatch s = new Stopwatch();
		TripleTownUI boardUI = new TripleTownUI();
		if(boardUI.isVisible() == false) {
			boardUI.setVisible(true);
		}
		
		while(!boardUI.myboard.gameOver()) {
			//try {
				boardUI.StartButton.doClick();
			//}
			//catch (RuntimeException r) {
				//System.out.println(r.getMessage());
			//	break;
			//}
		}
		System.out.println(boardUI.myboard.points + "\t");
		
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