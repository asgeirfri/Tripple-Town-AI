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
		
		// Stat Tracking
		int totalRuns = 0;
		Point move = new Point(0,0);
		
		// Tracking Scores For Each Possible Play
		ArrayList<PredictionStats> stats = new ArrayList<PredictionStats>();
		for (Point p : board.freeSpaces) {
			stats.add(new PredictionStats(0, 0));
		}
		
		// Run Initial 100 Plays
		for (Point p : board.freeSpaces) {
			// This Code Is Run For Each Possible Move
			
			int index = board.freeSpaces.indexOf(p);
			
			for (int i = 0; i < 100; i++) {
				PredictionStats stat = stats.get(index);
				int simulateScore = completeGameWithMove(p, board);
				stat.combinedScore += simulateScore;
				stat.runs += 1;
				totalRuns += 1;
				stats.set(index, stat);
			}
			
		}
		
		
		
		// UDB1 Equation Without Discount(Sigmoid) Function
		
		// Pre-generate Equation Values For All Possible Plays
		// So We Dont Generate New Values For All  Plays Each Cycle
		for(PredictionStats s : stats){
			s.values = UDB1.calculate(s, totalRuns);
		}
		
		
		for(int i = 0; i < 45000; i++){
			
			
			// Determine The Highest UDB1 Score
			double max = 0;
			int maxIndex = -1;
			for(int j = 0; j < stats.size(); j++){
				if(max < stats.get(j).values.high){
					max = stats.get(j).values.high;
					maxIndex = j;
				}
			}
			
			PredictionStats stat = stats.get(maxIndex);
			Point p = board.freeSpaces.get(maxIndex);
			int simulateScore = completeGameWithMove(p, board);
			stat.combinedScore += simulateScore;
			stat.runs += 1;
			totalRuns += 1;
			stat.values = UDB1.calculate(stat, totalRuns);
			stats.set(maxIndex, stat);
		}
		
		// Print Statistics For Initial Plays
		for (Point p: board.freeSpaces){
			int i = board.freeSpaces.indexOf(p);
			System.out.println("Score For Option: " + i);
			System.out.println("Runs: " + stats.get(i).runs);
			//System.out.println("Score: " + stats.get(i).combinedScore);
			System.out.println("Average: " + stats.get(i).averageScore());
			//System.out.println("UDB - High: " + stats.get(i).values.high + " Low : " + stats.get(i).values.low);
		}
		int max = 0;
		for(int i = 0; i < stats.size(); i++){
			if(max < stats.get(i).averageScore()){
				max = i;
			}
		}
		
		return board.freeSpaces.get(max);
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
		gameSimulation.playerMove(p);
		gameSimulation.moveBears();
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
