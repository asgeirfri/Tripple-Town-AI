import java.awt.Point;
import java.util.Scanner;

public class TTAgent {
	public Point nextMove(TTBoard board) {
		//return board.freeSpaces.get(0);
		Scanner reader = new Scanner(System.in); 
		System.out.print("line: ");
		int x = reader.nextInt();
		System.out.print("row: ");
		int y = reader.nextInt();
		return new Point(x,y);
	}
	public boolean stash() {
		Scanner reader = new Scanner(System.in);
		System.out.print("stash? (y/n): ");
		String x = reader.nextLine().toString().toLowerCase();
		if (x.equals("y")) {
			return true;
		}
		else
			return false;
	}
}
