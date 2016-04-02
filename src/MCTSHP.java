import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class MCTSHP {
	int MAXDEPTH = 5;
	int ITERATIONS = 100;
	int time = 0;
	ArrayList<Point> plan = new ArrayList<Point>();
	Random rand = new Random();
	
	public void init(int t) {
		time = t;
	}
	
	public MoveInstructions nextMove(TTBoard board) {
		
		
		int maxScore = -500000000;
		MoveInstructions move = new MoveInstructions("n", new Point (0,0));
		
		// Tracking Scores For Each Possible Play
		ArrayList<Integer> scores1 = new ArrayList<Integer>();
		for (Point p : board.freeSpaces) {
			scores1.add(0);
		}
		
		// Tracking Scores For Each Possible Play
		ArrayList<Integer> scores2 = new ArrayList<Integer>();
		for (Point p : board.freeSpaces) {
			scores2.add(0);
		}
		
		// Run Predictions
		for (Point p : board.freeSpaces) {
			// This Code Is Run For Each Possible Move
			int index = board.freeSpaces.indexOf(p);
			// We divide 50000 iterations between all possible moves
			int maxIterations = ITERATIONS / board.freeSpaces.size();
			for (int i = 0; i < maxIterations; i++) {
				int score = scores1.get(index);
				int simulateScore = completeGameWithMove(p, board);
				scores1.set(index, score + simulateScore);
			}
		}
		
		// Run predictions if you stash
		for (Point p : board.freeSpaces) {
			// This Code Is Run For Each Possible Move
			int index = board.freeSpaces.indexOf(p);
			// We divide 50000 iterations between all possible moves
			int maxIterations = ITERATIONS / board.freeSpaces.size();
			for (int i = 0; i < maxIterations; i++) {
				int score = scores2.get(index);
				int simulateScore = completeGameWithStashAndMove(p, board);
				scores2.set(index, score + simulateScore);
			}
		}
		
		// Select Move Based On Predictions for no stash
		for (int i = 0; i < scores1.size(); i++) {
			int score = scores1.get(i);
			if (score > maxScore) {
				maxScore = score;
				move = new MoveInstructions ("n", board.freeSpaces.get(i));
			}
		}
		
		// See if it's better if you stash
		for (int i = 0; i < scores2.size(); i++) {
			int score = scores2.get(i);
			if (score > maxScore) {
				maxScore = score;
				move = new MoveInstructions ("y", board.freeSpaces.get(i));
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
		gameSimulation.playerMove(p);
		gameSimulation.moveBears();
		
		return completeGame(gameSimulation);
	}
	
	
	
	// Complete game after you stash
	public int completeGameWithStashAndMove(Point p, TTBoard b) {
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
		gameSimulation.stash();
		gameSimulation.playerMove(p);
		gameSimulation.moveBears();
		
		return completeGame(gameSimulation);
	}
	
	
	public TTBoard doOneMoveToBoard(Point p, TTBoard b) {
		
		TTBoard gameSimulation = new TTBoard();
		gameSimulation.freeSpaces = new ArrayList<Point>(b.freeSpaces);
		gameSimulation.bears = new ArrayList<Point>(b.bears);
		gameSimulation.stash = b.stash;
		gameSimulation.holding = b.holding;
		gameSimulation.points = b.points;
		gameSimulation.playerMove(p);
		gameSimulation.moveBears();
		
		return gameSimulation;
	}
	
	
	
	public int completeGame (TTBoard gameSimulation) {
		// Complete mock game
		int i = 0;
		while (!gameSimulation.gameOver()) {
			
			
			// TODO: Implement completeGame as a decider on next move
			ArrayList<ValuedPoint> bestMoves = new ArrayList<ValuedPoint>();
			for(int j = 0; j < 3; j++){
				bestMoves.add(new ValuedPoint(0, new Point(0,0)));
			}
			
			for(Point p : gameSimulation.freeSpaces){

				TTBoard temp = doOneMoveToBoard(p,gameSimulation);
				int value = completeGameShort(temp);
				if(value > bestMoves.get(0).value){
					bestMoves.set(0, new ValuedPoint(0, p));
				} else if(value > bestMoves.get(1).value){
					bestMoves.set(0, new ValuedPoint(1, p));					
				} else if(value > bestMoves.get(2).value){
					bestMoves.set(0, new ValuedPoint(2, p));					
				}
			}
			
			
			// Þetta er vandamál
			int size = gameSimulation.freeSpaces.size();
			if(size > 3){
				size = 3;
			}
			Point move = bestMoves.get(rand.nextInt(size)).point;
			
			if (rand.nextInt(MAXDEPTH) == 0) {
				gameSimulation.stash();
			}
			gameSimulation.playerMove(move);
			gameSimulation.moveBears();
			i++;
		}
		
		int a = gameSimulation.points;
		int b = EvaluationHelper.eval(gameSimulation);
		if (b < 0) {
			b = 1;
		}
		int c = a * b;
		System.out.println("Evaluated at : " + a + " - " + b + " = " + c);
		return c;
	}
	
	public int completeGameShort (TTBoard gameSimulation) {
		// Complete mock game
		
		int i = 0;
		while (!gameSimulation.gameOver() && i < MAXDEPTH) {
			// get a random move from freeSpaces
			Point move = gameSimulation.freeSpaces.get(rand.nextInt(gameSimulation.freeSpaces.size()));
			if (rand.nextInt(MAXDEPTH) == 0) {
				gameSimulation.stash();
			}
			gameSimulation.playerMove(move);
			gameSimulation.moveBears();
			i++;
		}
		
		return EvaluationHelper.eval(gameSimulation);
		
	}
		
}