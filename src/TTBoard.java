import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class TTBoard {
	public int[][] board = new int[6][6];
	public ArrayList<Point> freeSpaces;
	public ArrayList<Point> bears;
	public int stash;
	public int holding;
	public int points;
	  
	public void init() {
		// initialize the board
		Random rand = new Random();
		bears = new ArrayList<Point>();
		int max = 14;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				int randomNum2 = rand.nextInt((4 - 1));
				if(max != 0 && randomNum2 == 1) {
					int temp = initializationObject();
					if(temp == -1) {
						bears.add(new Point(i, j));
					}
					board[i][j] = temp;
					max--;
				}
				else {
					board[i][j] = 0;
				}
			}
		}
		
		findFreeSpaces();
		stash = 0;
		points = 0;
		holding = 1;
	}
	
	public int initializationObject() {
		Random rand = new Random();
		int temp = rand.nextInt(100);
		if (temp < 40) {
			return 1;
		}
		else if (temp < 55) {
			return 2;
		}
		else if (temp < 65) {
			return -1;
		}
		else if (temp < 80) {
			return 3;
		}
		else if(temp < 90) {
			return 4;
		}
		else {
			return -2;
		}
	}
	
	// show the board
	public void show() {
		System.out.println("Points: " + points + "\t" + "Stash: " + stash + "\t" + "Holding: " + holding);
		for (int i = 0; i < 6; i++) {
			System.out.println("");
			for (int j = 0; j < 6; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println("");
		}
	}
	
	// returns true if no more moves can be made
	public boolean gameOver() {
		if (freeSpaces.size() == 0) {
			return true;
		}
		return false;
	}
	
	// puts number where the user wants to put it, then updates the thing that the user holds
	public void playerMove(Point move){
		if (!freeSpaces.contains(move)) {
			throw new RuntimeException();
		}
		if (holding == 20) {
			int value = makeDiamondMove(move);
			if (value == 0) {
				points -= 20;
				return;
			}
			holding = value;
		}
		board[move.x][move.y] = holding;
		if (holding != -1) {
			points += holding;
			unify(move);
		}
		else {
			bears.add(move);
		}
		findFreeSpaces();
		holding = findHolding();
	}
	
	// finds the highest value that a diamond can unite
	public int makeDiamondMove(Point move) {
		int max = 0;
		if (move.x + 1 < 6) {
			Point temp = new Point(move.x+1, move.y);
			board[move.x][move.y] = board[temp.x][temp.y];
			if(countConnections(move).size() > 2) {
				if (board[move.x][move.y] > max) {
					max = board[move.x][move.y];
				}
			}
		}
		if (move.x - 1 > -1) {
			Point temp = new Point(move.x-1, move.y);
			board[move.x][move.y] = board[temp.x][temp.y];
			if(countConnections(move).size() > 2) {
				if (board[move.x][move.y] > max) {
					max = board[move.x][move.y];
				}
			}
			
		}
		if (move.y + 1 < 6) {
			Point temp = new Point(move.x, move.y+1);
			board[move.x][move.y] = board[temp.x][temp.y];
			if(countConnections(move).size() > 2) {
				if (board[move.x][move.y] > max) {
					max = board[move.x][move.y];
				}
			}
		}
		if (move.y -1 > -1) {
			Point temp = new Point(move.x, move.y-1);
			board[move.x][move.y] = board[temp.x][temp.y];
			if(countConnections(move).size() > 2) {
				if (board[move.x][move.y] > max) {
					max = board[move.x][move.y];
				}
			}
		}
		board[move.x][move.y] = 0;
		return max;
	}
	
	// Return true if bear can move in direction move
	public boolean validateBearMove (Point bear, int move) {
		if ( move == 0) {
			Point newBearSlot = new Point (bear.x+1, bear.y);
			if (freeSpaces.contains(newBearSlot)) {
				return true;
			}
		}
		//bear moves right
		else if ( move == 1) {
			Point newBearSlot = new Point (bear.x, bear.y+1);
			if (freeSpaces.contains(newBearSlot)) {
				return true;
			}
		}
		//bear moves up
		else if ( move == 2) {
			Point newBearSlot = new Point (bear.x-1, bear.y);
			if (freeSpaces.contains(newBearSlot)) {
				return true;
			}
		}
		//bear moves left
		else {
			Point newBearSlot = new Point (bear.x, bear.y-1);
			if (freeSpaces.contains(newBearSlot)) {
				return true;
			}
		}
		return false;
	}
	
	// moves bears and checks if they die
	public void moveBears() {
		killBears();
		Random rand = new Random();
		ArrayList<Point> unmovedBears = new ArrayList<Point>(bears);
		int i = 0;
		while (unmovedBears.size() != 0) {
			Point currentBear = unmovedBears.get(i);
			int move = rand.nextInt(4);
			int attempts = 0;
			// if we can't move, we attempt another move up to 4 times
			while (!validateBearMove(currentBear, move) && attempts < 4) {
				move = (move + 1) % 4;
				attempts++;
			}
			// if we tried all, we try again later
			if (attempts == 4) {
				//Point tempBear = unmovedBears.get(0);
				unmovedBears.remove(0);
				/*unmovedBears.add(tempBear);
				if (unmovedBears.get(0).equals(tempBear)) {
					return;
				}*/
			} else {
				Point newBearSlot;
				//bear moves down
				if ( move == 0) {
					newBearSlot = new Point (currentBear.x+1, currentBear.y);
				}
				//bear moves right
				else if ( move == 1) {
					newBearSlot = new Point (currentBear.x, currentBear.y+1);
				}
				//bear moves up
				else if ( move == 2) {
					newBearSlot = new Point (currentBear.x-1, currentBear.y);
				}
				//bear moves left
				else {
					newBearSlot = new Point (currentBear.x, currentBear.y-1);
				}
				int bearIndex = bears.indexOf(currentBear);
				bears.set(bearIndex, newBearSlot);
				int freeSpacesIndex = freeSpaces.indexOf(newBearSlot);
				freeSpaces.set(freeSpacesIndex, currentBear);
				board[currentBear.x][currentBear.y] = 0;
				board[newBearSlot.x][newBearSlot.y] = -1;
				unmovedBears.remove(0);
			}
		}
	}
	
	//kills all bears that should be killed and unifies them
	public void killBears () {
		//System.out.println("KILL");
		//System.out.println("--------------");
		//System.out.println("Bears: " + bears.size());
		/*for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}*/
		
		for (int i = bears.size() -1; i >= 0; i--) {
			Point bear = bears.get(i);
			boolean kill = killBear(bear);
			if (kill) {
				unifyBears(bear);
				killBears();
				return;
			}
		}
	}
	
	// Returns True If Bear Should be Killed
	public boolean killBear(Point bear) {
		if (board[bear.x][bear.y] != -1) {
			bears.remove(bear);
			return false;
		}
		if (bear.x + 1 < 6) {
			Point temp = new Point(bear.x+1, bear.y);
			if (board[temp.x][temp.y] == 0) {
				return false;
			}
			if (board[temp.x][temp.y] == -1) {
				board[bear.x][bear.y] = 50;
				boolean shouldReturn = killBear(temp);
				board[bear.x][bear.y] = -1;
				if (shouldReturn == false) {
					return false;
				}
			}
		}
		if (bear.x - 1 > -1) {
			Point temp = new Point(bear.x-1, bear.y);
			if (board[temp.x][temp.y] == 0) {
				return false;
			}
			if (board[temp.x][temp.y] == -1) {
				board[bear.x][bear.y] = 50;
				boolean shouldReturn = killBear(temp);
				board[bear.x][bear.y] = -1;
				if (shouldReturn == false) {
					return false;
				}
			}
		}
		if (bear.y + 1 < 6) {
			Point temp = new Point(bear.x, bear.y+1);
			if (board[temp.x][temp.y] == 0) {
				return false;
			}
			if (board[temp.x][temp.y] == -1) {
				board[bear.x][bear.y] = 50;
				boolean shouldReturn = killBear(temp);
				board[bear.x][bear.y] = -1;
				if (shouldReturn == false) {
					return false;
				}
			}
		}
		if (bear.y -1 > -1) {
			Point temp = new Point(bear.x, bear.y-1);
			if (board[temp.x][temp.y] == 0) {
				return false;
			}
			if (board[temp.x][temp.y] == -1) {
				board[bear.x][bear.y] = 50;
				boolean shouldReturn = killBear(temp);
				board[bear.x][bear.y] = -1;
				if (shouldReturn == false) {
					return false;
				}
			}
		}
		return true;
	}
	
	//unifies toobstones (-2) into churches (-3) and so on
	public void unifyBears(Point move) {
		ArrayList<Point> connections = countConnections(move);
		if (board[move.x][move.y] == -1) {
			points += connections.size() * (-board[move.x][move.y])*(-board[move.x][move.y]);
			for (Point p : connections) {
				board[p.x][p.y] = -2;
				bears.remove(p);
			}
			unifyBears(move);
			return;
		}
		if (connections.size() > 2) {
			points += connections.size() * (-board[move.x][move.y])*(-board[move.x][move.y]);
			int newScore = board[move.x][move.y] - 1;
			for (int i = 0; i < connections.size(); i++) {
				Point temp = connections.get(i);
				//bears.remove(temp);
				board[temp.x][temp.y] = 0;
				bears.remove(temp);
			}
			board[move.x][move.y] = newScore;
			findFreeSpaces();
			unifyBears(move);
		}
	}
	
	//puts all free spaces in array
	public void findFreeSpaces() {
		freeSpaces = new ArrayList<Point>();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (board[i][j] == 0) {
					freeSpaces.add(new Point(i,j));
				}
			}
		}
	}
	
	//unifies if possible the value at move and makes all unified values free except for the move, he raises that value
	public void unify(Point move) {
		ArrayList<Point> connections = countConnections(move);
		if (connections.size() > 2) {
			points += connections.size() *  board[move.x][move.y] * board[move.x][move.y];
			int newScore = board[move.x][move.y] + 1;
			for (int i = 0; i < connections.size(); i++) {
				Point temp = connections.get(i);
				board[temp.x][temp.y] = 0;
			}
			board[move.x][move.y] = newScore;
			findFreeSpaces();
			unify(move);
		}
	}
	
	// counts the all spots conenctet to p that have the same value
	public ArrayList<Point> countConnections(Point p) {
		ArrayList<Point> connections = new ArrayList<Point>();
		ArrayList<Point> unexplored = new ArrayList<Point>();
		connections.add(p);
		unexplored.add(p);
		int value = board[p.x][p.y];
		while (unexplored.size() != 0) {
			Point exploring = unexplored.get(0);
			unexplored.remove(0);
			if (exploring.x + 1 < 6) {
				Point temp = new Point(exploring.x+1, exploring.y);
				if (board[temp.x][temp.y] == value && !connections.contains(temp)) {
					connections.add(temp);
					unexplored.add(temp);
				}
			}
			if (exploring.x - 1 > -1) {
				Point temp = new Point(exploring.x-1, exploring.y);
				if (board[temp.x][temp.y] == value && !connections.contains(temp)) {
					connections.add(temp);
					unexplored.add(temp);
				}
			}
			if (exploring.y + 1 < 6) {
				Point temp = new Point(exploring.x, exploring.y+1);
				if (board[temp.x][temp.y] == value && !connections.contains(temp)) {
					connections.add(temp);
					unexplored.add(temp);
				}
			}
			if (exploring.y -1 > -1) {
				Point temp = new Point(exploring.x, exploring.y-1);
				if (board[temp.x][temp.y] == value && !connections.contains(temp)) {
					connections.add(temp);
					unexplored.add(temp);
				}
			}
		}
		return connections;
	}
	
	// gets "random" thing to hold"
	public int findHolding() {
		Random rand = new Random();
		int temp = rand.nextInt(100);
		if (temp < 66) {
			return 1;
		}
		else if (temp < 80) {
			return 2;
		}
		else if (temp < 95) {
			return -1;
		}
		else if (temp < 97) {
			return 3;
		}
		else if (temp < 98) {
			return 20;
		}
		else {
			return 4;
		}
	}
	
	// stashes the value that the player is holding and holds the value that the player is stashing, if the values is 0, he gets a new value to hold
	public void stash() {
		int temp = holding;
		if (stash != 0) {
			holding = stash;
		} else {
			holding = findHolding();
		}
		stash = temp;
	}
}

