import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class EvaluationHelper {
	
	public static int eval(TTBoard board){
		return noStonesAllowed(board) + spreadEval(board);
	}
	
	public static int noStonesAllowed(TTBoard board){
		int max = 0;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(board.board[i][j] == -2){
					max += 10;
				}
			}
		}
		
		return max;
	}
	
	public static int spreadEval(TTBoard board){
		int churches = 0;

		ArrayList<Point> objects = new ArrayList<Point>();
		ArrayList<Integer> objectCount = new ArrayList<Integer>();
		ArrayList<Integer> distances = new ArrayList<Integer>();
		for(int i = 0; i < 14; i++){
			objects.add(new Point(0,0));
			objectCount.add(0);
			distances.add(0);
		}
		
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				for(int a = 0; a < 14; a++){
					if(board.board[i][j] == a-5 && a != 5){
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
		
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				for(int a = 0; a < 14; a++){
					if(board.board[i][j] == a-5 && a != 5 && a != 6){
						distances.set(a, distances.get(a) + Math.abs(i-objects.get(a).x));
						distances.set(a, distances.get(a) + Math.abs(i-objects.get(a).y));
					}
				}
			}
		}

		
		int max = 0;
		for(int i = 0; i < 14; i++){
			max += distances.get(i);
		}
		
		return max/2;
		
	}
}
