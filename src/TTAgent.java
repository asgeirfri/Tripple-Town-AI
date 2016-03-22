import java.awt.Point;
import java.util.Scanner;

public class TTAgent {
	public Point nextMove(TTBoard board) {
		Scanner reader = new Scanner(System.in); 
		System.out.print("line: ");
		int x = reader.nextInt();
		System.out.print("row: ");
		int y = reader.nextInt();
		return new Point(x,y);
	}
}
