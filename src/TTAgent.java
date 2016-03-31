import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class TTAgent {
	int time = 0;
	
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
		int depth = 5;
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
		return move;
	}
	
	public int evaluate (TTBoard b) {
		return b.points;
	}
	
	
	// expands a state and returns an ArrayList with its expansions and firstMove
	public ArrayList<StateMove> expand(TTBoard b, Point firstMove) {
		ArrayList<StateMove> expansions = new ArrayList<StateMove>();
		for (Point p : b.freeSpaces) {
			StateMove newState = new StateMove(b,firstMove);
			newState.board.playerMove(p);
			// we may have to fix this, it only makes random bear moves, for move presicion, take into account move in every direction
			newState.board.moveBears();
			expansions.add(newState);
		}
		return expansions;
	}
		
}
