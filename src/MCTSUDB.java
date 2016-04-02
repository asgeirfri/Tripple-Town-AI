import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class MCTSUDB {
	
	int MAXDEPTH = 6;
	Random rand = new Random();
	
	public Point nextMoveUDB(TTBoard board) {
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
	
	public int completeGame (TTBoard gameSimulation) {
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
		int a = gameSimulation.points;
		int b = EvaluationHelper.eval(gameSimulation);
		if (b < 0) {
			b = 1;
		}
		int c = a * b;
		System.out.println("Evaluated at : " + a + " - " + b + " = " + c);
		return c;
	}
}
