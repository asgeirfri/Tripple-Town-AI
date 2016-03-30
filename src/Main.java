import java.awt.Point;

public class Main {
	
	public static void main(String[] args){
		TTAgent agent = new TTAgent();
		TTBoard board = new TTBoard();
		board.init();
		board.show();
		while (!board.gameOver()) {
			if (agent.stash()) {
				board.stash();
			}
			else {
				try {
					Point move = agent.nextMove(board);
					board.playerMove(move);
					board.moveBears();
				}
				catch (RuntimeException e) {
					System.out.println("Invalid move.");
				}
			}
			System.out.println("------------------");
			board.show();
		}
	}
}