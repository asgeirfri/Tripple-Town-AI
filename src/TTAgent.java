import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import edu.princeton.cs.algs4.Stopwatch;

public class TTAgent {
	int time = 0;
	ArrayList<Point> plan = new ArrayList<Point>();
	Random rand = new Random();
	
	public void init(int t) {
		time = t;
	}
	
	public Point nextMove(TTBoard board) {
		/*if (plan.size() == 0 || !board.freeSpaces.contains(plan.get(0)) || board.holding != 0) {
			for (int i = 0; i < 6; i++) {
				DFS (board, i);
			}
		}
		Point p = plan.get(0);
		plan.remove(0);
		return  p;*/
		int maxScore = 0;
		Point move = new Point(0,0);
		
		ArrayList<Integer> scores = new ArrayList<Integer>();
		for (Point p : board.freeSpaces) {
			scores.add(0);
		}
		
		Double meanTime = 0.0;
		for (Point p : board.freeSpaces) {
			int index = board.freeSpaces.indexOf(p);
			Stopwatch s = new Stopwatch();
			for (int i = 0; i < 10000; i++) {
				int score = scores.get(index);
				int simulateScore = completeGameWithMove(p, board);
				scores.set(index, score + simulateScore);
				// Comment out if we want to use mean
				/*if (simulateScore > maxScore) {
					maxScore = simulateScore;
					move = p;
					System.out.println("new highest : " + maxScore);
				}*/
			}
			meanTime += s.elapsedTime();
		}
		
		System.out.println("Simulation mean run time for " + board.freeSpaces.size() + " moves: " + meanTime/board.freeSpaces.size());
		// UNcomment if we want to use mean
		for (int i = 0; i < scores.size(); i++) {
			int score = scores.get(i);
			if (score > maxScore) {
				maxScore = score;
				move = board.freeSpaces.get(i);
			}
		}
		return move;
	}
	
	public int completeGameWithMove(Point p, TTBoard b) {
		// Create a mock game with same stats
		TTBoard gameSimulation = new TTBoard();
		gameSimulation.board = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				gameSimulation.board[i][j] = b.board[i][j];

			}
		}
		gameSimulation.freeSpaces = new ArrayList<Point>(b.freeSpaces);
		gameSimulation.bears = new ArrayList<Point>(b.bears);
		gameSimulation.stash = b.stash;
		gameSimulation.holding = b.holding;
		gameSimulation.points = b.points;
		// Complete mock game
		while (!gameSimulation.gameOver()) {
			// get a random move from freeSpaces
			Point move = gameSimulation.freeSpaces.get(rand.nextInt(gameSimulation.freeSpaces.size()));
			gameSimulation.playerMove(move);
			gameSimulation.moveBears();
		}
		return gameSimulation.points;
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
		int evaluation = b.freeSpaces.size() - b.bears.size() + b.points;
		return evaluation;
	}
	
	
	// expands a state and returns an ArrayList with its expansions and firstMove
	public ArrayList<StateMove> expand(TTBoard b, ArrayList<Point> history) {
		ArrayList<StateMove> expansions = new ArrayList<StateMove>();
		for (Point p : b.freeSpaces) {
			StateMove newState = new StateMove(b, history, p);
			newState.board.playerMove(p);
			newState.board.holding = 1;
			// we may have to fix this, it only makes random bear moves, for move presicion, take into account move in every direction
			//newState.board.moveBears();
			expansions.add(newState);
		}
		return expansions;
	}
		
}
