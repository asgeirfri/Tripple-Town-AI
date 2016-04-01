import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class TTAgent {
	int time = 0;
	ArrayList<Point> plan = new ArrayList<Point>();
	
	public void init(int t) {
		time = t;
	}
	
	public Point nextMove(TTBoard board) {
		/*int depth = 5;
		Point move = new Point(0,0);
		int maxScore = 0;
		ArrayList<StateMove> states = new ArrayList<StateMove>();
		// initialize list with firstMove for each value in freeSpaces.
		for (Point p : board.freeSpaces) { 
			StateMove newState = new StateMove(board,p);
			newState.board.playerMove(p);
			// we may have to fix this, it only makes random bear moves, for move precision, take into account move in every direction
			newState.board.moveBears();
			states.add(newState);
		}
		while (states.size() != 0 && depth >= 0) {
			// these states will be checked in the next depth
			ArrayList<StateMove> nextStates = new ArrayList<StateMove>();
			for (StateMove sm : states) {
				ArrayList<StateMove> newStates = expand(sm.board,sm.firstMove);
				for (StateMove nsm : newStates) {
					nextStates.add(nsm);
					int evaluation = evaluate(nsm.board);
					if ( evaluation > maxScore) {
						maxScore = evaluation;
						move = nsm.firstMove;
					}
				}
			}
			depth--;
			states = new ArrayList<StateMove>(nextStates);
		}
		return move;*/
		if (plan.size() == 0 || !board.freeSpaces.contains(plan.get(0)) || board.holding != 0) {
			for (int i = 0; i < 5; i++) {
			DFS (board, i);
			}
		}
		Point p = plan.get(0);
		plan.remove(0);
		return  p;
	}
	
	public void DFS (TTBoard board, int maxDepth) {
		int depth = 0;
		int maxScore = 0;
		ArrayList<StateMove> frontier = new ArrayList<StateMove>();
		// initialize list with firstMove for each value in freeSpaces.
		for (Point p : board.freeSpaces) { 
			StateMove newState = new StateMove(board, new ArrayList<Point>(), p);
			newState.board.playerMove(p);
			// we may have to fix this, it only makes random bear moves, for move precision, take into account move in every direction
			newState.board.moveBears();
			frontier.add(newState);
		}
    	while (!frontier.isEmpty() && depth <= maxDepth) {
    		//System.out.println("Frontier not empty");
    		StateMove N = frontier.get(0);
    		frontier.remove(0);
    		TTBoard s = N.board;
    		if (evaluate(s) > maxScore && depth == maxDepth) {
    			maxScore = evaluate(s);
    			//make new plan
    			plan = new ArrayList<Point>(N.history);
    		}
			else {
				ArrayList<StateMove> successors = expand(N.board, N.history);
				for (StateMove successor:successors) {
					frontier.add(0, successor);
				}
			}
    		depth++;
		}
	}
	
	public int evaluate (TTBoard b) {
		return b.points;
	}
	
	
	// expands a state and returns an ArrayList with its expansions and firstMove
	public ArrayList<StateMove> expand(TTBoard b, ArrayList<Point> history) {
		ArrayList<StateMove> expansions = new ArrayList<StateMove>();
		for (Point p : b.freeSpaces) {
			StateMove newState = new StateMove(b, history, p);
			newState.board.playerMove(p);
			// we may have to fix this, it only makes random bear moves, for move presicion, take into account move in every direction
			newState.board.moveBears();
			expansions.add(newState);
		}
		return expansions;
	}
		
}
