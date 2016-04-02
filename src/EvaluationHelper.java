import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class EvaluationHelper {
	
	public static int eval(TTBoard board){
		return board.freeSpaces.size() * 10 - triEval(board) - noStonesAllowed(board); //noStonesAllowed(board) + noGrassAllowed(board); //+ spreadEval(board);
	}
	
	// Ásgeirs "triangle evaluation"
	// Tries to divide board into 2 groups and place nevative integers in 1 triangle and positive in the other
	// It punishes you for having it not the way it wants
	public  static int triEval(TTBoard board) {
		int eval = 0;
		int eval1 = 0;
		int eval2 = 0;
		
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < i; j++){
				eval1 += 3 * board.board[i][j];
			}
		}
		for(int i = 0; i < 6; i++){
			for(int j = 5; j >= i; j--){
				eval2 += 3 * board.board[i][j];
			}
		}
		//eval = Math.abs(eval1) + Math.abs(eval2);
		eval = Math.abs(eval1+eval2);
		return eval;
	}
	
	// Ásgeirs implementation of eval for short term planing
	// Tries to reward you for grouping together things that belong together
	public static int aEval(TTBoard board) {
		int eval = 0;
		
		//Evaluate Things on map
		dPoint meanAsgeir = new dPoint ();
		int countAsgeir = 0;
		dPoint meanKath = new dPoint ();
		int countKath = 0;
		dPoint meanChurch = new dPoint ();
		int countChurch = 0;
		dPoint meanStone = new dPoint();
		int countStone = 0;
		dPoint meanGrass = new dPoint ();
		int countGrass = 0;
		dPoint meanBush = new dPoint ();
		int countBush = 0;
		dPoint meanTree = new dPoint ();
		int countTree = 0;
		dPoint meanHouse = new dPoint ();
		int countHouse = 0;
		dPoint meanMansion = new dPoint ();
		int countMansion = 0;
		dPoint meanCastle = new dPoint ();
		int countCastle = 0;
		dPoint meanFCastle = new dPoint ();
		int countFCastle = 0;
		dPoint meanTCastle = new dPoint ();
		int countTCastle = 0;
		
		// Count things and prepare to calculate mean
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				int object = board.board[i][j];
				switch (object) {
					// Ásgeir is on the map
					case -5:
						meanAsgeir.x += i;
						meanAsgeir.y += j;
						countAsgeir++;
						break;
					// Kathedral is on the map
					case -4:
						meanKath.x += i;
						meanKath.y += j;
						countKath++;
						break;
					// Church is on the map
					case -3:
						meanChurch.x += i;
						meanChurch.y += j;
						countChurch++;
						break;
					// Stone is on the map
					case -2:
						meanStone.x += i;
						meanStone.y += j;
						countStone++;
						break;
					// Grass is on the map
					case 1:
						meanGrass.x += i;
						meanGrass.y += j;
						countGrass++;
						break;
					// Bush is on the map
					case 2:
						meanBush.x += i;
						meanBush.y += j;
						countBush++;
						break;
					// Tree is on the map
					case 3:
						meanTree.x += i;
						meanTree.y += j;
						countTree++;
						break;
					// House is on the map
					case 4:
						meanHouse.x += i;
						meanHouse.y += j;
						countHouse++;
						break;
					// Castle is on the map
					case 5:
						meanCastle.x += i;
						meanCastle.y += j;
						countCastle++;
						break;
					// FCastle is on the map
					case 6:
						meanFCastle.x += i;
						meanFCastle.y += j;
						countFCastle++;
						break;
					// TCastle is on the map
					case 7:
						meanTCastle.x += i;
						meanTCastle.y += j;
						countTCastle++;
						break;		
				}
			}
		}
		if (countAsgeir != 0) {
			meanAsgeir.x /= countAsgeir;
			meanAsgeir.y /= countAsgeir;
		}
		if (countKath != 0) {
			meanKath.x /= countKath;
			meanKath.y /= countKath;
		}
		if (countChurch != 0) {
			meanChurch.x /= countChurch;
			meanChurch.y /= countChurch;
		}
		if (countStone != 0) {
			meanStone.x /= countStone;
			meanStone.y /= countStone;
		}
		if (countGrass != 0) {
			meanGrass.x /= countGrass;
			meanGrass.y /= countGrass;
		}
		if (countBush != 0) {
			meanBush.x /= countBush;
			meanBush.y /= countBush;
		}
		if (countTree != 0) {
			meanTree.x /= countTree;
			meanTree.y /= countTree;
		}
		if (countHouse != 0) {
			meanHouse.x /= countHouse;
			meanHouse.y /= countHouse;
		}
		if (countMansion != 0) {
			meanMansion.x /= countMansion;
			meanMansion.y /= countMansion;
		}
		if (countCastle != 0) {
			meanCastle.x /= countCastle;
			meanCastle.y /= countCastle;
		}
		if (countFCastle != 0) {
			meanFCastle.x /= countFCastle;
			meanFCastle.y /= countFCastle;
		}
		if (countTCastle != 0) {
			meanTCastle.x /= countTCastle;
			meanTCastle.y /= countTCastle;
		}
		
		// Evaluate
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				int object = board.board[i][j];
				switch (object) {
					// Ásgeir is on the map
					case -5:
						eval -= Math.abs(meanAsgeir.x - i) * object;
						eval -= Math.abs(meanAsgeir.y - j) * object;
						eval -= Math.abs(meanKath.x - i);
						eval -= Math.abs(meanKath.y - j);
						eval += object^4;
						break;
					// Kathedral is on the map
					case -4:
						eval -= Math.abs(meanKath.x - i) * object;
						eval -= Math.abs(meanKath.y - j) * object;
						eval -= Math.abs(meanChurch.x - i);
						eval -= Math.abs(meanChurch.y - j);
						eval += object^4;
						break;
					// Church is on the map
					case -3:
						eval -= Math.abs(meanChurch.x - i) * object;
						eval -= Math.abs(meanChurch.y - j) * object;
						eval -= Math.abs(meanStone.x - i);
						eval -= Math.abs(meanStone.y - j);
						eval += object^4;
						break;
					// Stone is on the map
					case -2:
						eval -= Math.abs(meanStone.x - i) * object;
						eval -= Math.abs(meanStone.y - j) * object;
						eval -= 50;
						break;
					case -1:
						eval -= 2;
						break;
					// Grass is on the map
					case 1:
						eval -= Math.abs(meanGrass.x - i) * object;
						eval -= Math.abs(meanGrass.y - j) * object;
						eval -= Math.abs(meanBush.x - i);
						eval -= Math.abs(meanBush.y - j);
						eval += object^4;
						break;
					// Bush is on the map
					case 2:
						eval -= Math.abs(meanBush.x - i) * object;
						eval -= Math.abs(meanBush.y - j) * object;
						eval -= Math.abs(meanTree.x - i);
						eval -= Math.abs(meanTree.y - j);
						eval += object^4;
						break;
					// Tree is on the map
					case 3:
						eval -= Math.abs(meanTree.x - i) * object;
						eval -= Math.abs(meanTree.y - j) * object;
						eval -= Math.abs(meanHouse.x - i);
						eval -= Math.abs(meanHouse.y - j);
						eval += object^4;
						break;
					// House is on the map
					case 4:
						eval -= Math.abs(meanHouse.x - i) * object;
						eval -= Math.abs(meanHouse.y - j) * object;
						eval -= Math.abs(meanCastle.x - i);
						eval -= Math.abs(meanCastle.y - j);
						eval += object^4;
						break;
					// Castle is on the map
					case 5:
						eval -= Math.abs(meanCastle.x - i) * object;
						eval -= Math.abs(meanCastle.y - j) * object;
						eval -= Math.abs(meanFCastle.x - i);
						eval -= Math.abs(meanFCastle.y - j);
						eval += object^4;
						break;
					// FCastle is on the map
					case 6:
						eval -= Math.abs(meanFCastle.x - i) * object;
						eval -= Math.abs(meanFCastle.y - j) * object;
						eval -= Math.abs(meanTCastle.x - i);
						eval -= Math.abs(meanTCastle.y - j);
						eval += object^4;
						break;
					// TCastle is on the map
					case 7:
						eval -= Math.abs(meanTCastle.x - i) * object;
						eval -= Math.abs(meanTCastle.y - j) * object;
						eval += object^4;
						break;		
				}
			}
		}
		return eval;
	}
	
	
	//Punish for toombstone
	public static int noStonesAllowed(TTBoard board){
		int max = 0;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(board.board[i][j] == -2){
					max += 5;
				}
			}
		}
		
		return max;
	}
	
	public static int noGrassAllowed(TTBoard board){
		int max = 0;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(board.board[i][j] == 1){
					max += 30;
				}
			}
		}
		
		return max;
	}
	
	public static int punish (TTBoard board){
		int max = 0;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(board.board[i][j] == 1){
					max += 20;
				}
				else if(board.board[i][j] == -2){
					max += 30;
				}
				else if(board.board[i][j] == -3){
					max += 5;
				}
				else if(board.board[i][j] == 2){
					max += 10;
				}
				else if(board.board[i][j] == 3){
					max += 5;
				}
				else if(board.board[i][j] == 0){
					max -= 50;
				}
			}
		}
		
		return max;
	}
	
	
	public static int spreadEval(TTBoard board){

		ArrayList<Point> objects = new ArrayList<Point>();
		ArrayList<Integer> objectCount = new ArrayList<Integer>();
		ArrayList<Integer> distances = new ArrayList<Integer>();
		for(int i = 0; i < 14; i++){
			objects.add(new Point(0,0));
			objectCount.add(0);
			distances.add(0);
		}
		
		// Find mean point for each 
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				for(int a = 0; a < 14; a++){
					if(board.board[i][j] == a-5 /*&& a != 5*/){
						Point temp = objects.get(a);
						temp.x += i;
						temp.y += j;
						objects.set(a, temp);
						objectCount.set(a, objectCount.get(a)+1);
					}
				}
			}
		}
		
		// Get Average Point
		for(int i = 0; i < 14; i++){
			if(objectCount.get(i) != 0){
				objects.set(i, new Point(objects.get(i).x/objectCount.get(i),objects.get(i).y/objectCount.get(i)));
			}
		}
		
		// Find Manhattan Distance
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				for(int a = 0; a < 14; a++){
					if(board.board[i][j] == a-5 /*&& a != 5 && a != 6*/){
						distances.set(a, distances.get(a) + Math.abs(board.board[i][j]^2)*(Math.abs(i-objects.get(a).x)-1));
						distances.set(a, distances.get(a) + Math.abs(board.board[i][j]^2)*(Math.abs(j-objects.get(a).y)-1));
					}
				}
			}
		}

		
		int max = 0;
		for(int i = 0; i < 14; i++){
			max += distances.get(i);
		}
		
		return max;
		
	}
}
