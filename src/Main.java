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
<<<<<<< HEAD
		board.show();
		while (!board.gameOver()) {
			/*if (agent.stash()) {
				board.stash();
			}
			else {*/
			//try {
				Point move = agent.nextMove(board);
				System.out.println("Making move " + move);
				board.playerMove(move);
				board.moveBears();
			//}
			//catch (RuntimeException e) {
				//System.out.println("Invalid move.\n" + e.getMessage());
			//}
			//}
			System.out.println("------------------");
			board.show();
			
=======
		if(boardUI.isVisible() == false) {
			boardUI.setVisible(true);
		}
		
		while(!board.gameOver()) {
			boardUI.StartButton.doClick();
>>>>>>> f2db0b223653e1df0da1a708f08ac9e79c356f36
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