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
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				board[i][j] = 0;
			}
		}
		bears = new ArrayList<Point>();
		findFreeSpaces();
		stash = 0;
		points = 0;
		holding = 1;
	}
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
	public boolean gameOver() {
		if (freeSpaces.size() == 0) {
			return true;
		}
		return false;
	}
	public void playerMove(Point move){
		if (!freeSpaces.contains(move)) {
			throw new RuntimeException();
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
	public void moveBears() {
		Random rand = new Random();
		for (int i = 0; i < bears.size(); i++) {
			Point currentBear = bears.get(i);
			int move = rand.nextInt(4);
			//bear moves down
			if ( move == 0) {
				Point newBearSlot = new Point (currentBear.x+1, currentBear.y);
				if (freeSpaces.contains(newBearSlot)) {
					bears.set(i, newBearSlot);
					int temp = freeSpaces.indexOf(newBearSlot);
					freeSpaces.set(temp, currentBear);
					board[currentBear.x][currentBear.y] = 0;
					board[newBearSlot.x][newBearSlot.y] = -1;
				}
			}
			//bear moves right
			else if ( move == 1) {
				Point newBearSlot = new Point (currentBear.x, currentBear.y+1);
				if (freeSpaces.contains(newBearSlot)) {
					bears.set(i, newBearSlot);
					int temp = freeSpaces.indexOf(newBearSlot);
					freeSpaces.set(temp, currentBear);
					board[currentBear.x][currentBear.y] = 0;
					board[newBearSlot.x][newBearSlot.y] = -1;
				}
			}
			//bear moves up
			else if ( move == 2) {
				Point newBearSlot = new Point (currentBear.x-1, currentBear.y);
				if (freeSpaces.contains(newBearSlot)) {
					bears.set(i, newBearSlot);
					int temp = freeSpaces.indexOf(newBearSlot);
					freeSpaces.set(temp, currentBear);
					board[currentBear.x][currentBear.y] = 0;
					board[newBearSlot.x][newBearSlot.y] = -1;
				}
			}
			//bear moves left
			else {
				Point newBearSlot = new Point (currentBear.x, currentBear.y-1);
				if (freeSpaces.contains(newBearSlot)) {
					bears.set(i, newBearSlot);
					int temp = freeSpaces.indexOf(newBearSlot);
					freeSpaces.set(temp, currentBear);
					board[currentBear.x][currentBear.y] = 0;
					board[newBearSlot.x][newBearSlot.y] = -1;
				}
			}
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
			points += connections.size() * board[move.x][move.y];
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
	
	public int findHolding() {
		Random rand = new Random();
		int temp = rand.nextInt() % 100;
		if (temp < 66) {
			return 1;
		}
		else if (temp < 81) {
			return 2;
		}
		else if (temp < 96) {
			return -1;
		}
		else if (temp < 98) {
			return 3;
		}
		else {
			return 4;
		}
	}
}

