import java.awt.Point;

public class Main {
	
	public static TripleTownUI board = new TripleTownUI();
	
	public static void main(String[] args){
		HumanGame();
		//AIGame();

	}
	
	public static void AIGame() {
		TTAgent agent = new TTAgent();
		TTBoard board = new TTBoard();
		board.init();
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
			//	System.out.println("Invalid move.\n" + e.getMessage());
			//}
			//}
			System.out.println("------------------");
			board.show();
			
		}
	}
	public static void HumanGame() {
		if(board.isVisible() == false) {
			board.setVisible(true);
		}
	}
}