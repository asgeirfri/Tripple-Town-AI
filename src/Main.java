import java.awt.Point;

public class Main {
	
	public static void main(String[] args){
		TTAgent agent = new TTAgent();
		TTBoard board = new TTBoard();
		board.init();
		board.show();
		while (!board.gameOver()) {
			Point move = agent.nextMove(board);
			board.playerMove(move);
			board.moveBears();
			System.out.println("------------------");
			board.show();
		}
	}
}