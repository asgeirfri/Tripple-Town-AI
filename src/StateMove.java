import java.awt.Point;
import java.util.ArrayList;

public class StateMove {
	TTBoard board;
	ArrayList<Point> history;
	
	public StateMove(TTBoard b, ArrayList<Point> list, Point p) {
		board = new TTBoard();
		board.board = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				board.board[i][j] = b.board[i][j];

			}
		}
		board.freeSpaces = new ArrayList<Point>(b.freeSpaces);
		board.bears = new ArrayList<Point>(b.bears);
		board.stash = b.stash;
		board.holding = b.holding;
		board.points = b.points;
		history = new ArrayList<Point>(list);
		history.add(p);
	}
}
