import java.awt.Point;


// This class contains instructions for an Agent move
public class MoveInstructions {
	String stash = "";
	Point move = new Point(0,0);
	
	MoveInstructions(String s, Point p) {
		stash = s;
		move = p;
	}
}
