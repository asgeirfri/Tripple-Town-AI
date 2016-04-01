import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import edu.princeton.cs.algs4.Stopwatch;

public final class UDB1 {
	
	public static UDB1Point calculate(int a, int b, int c){
		double min = a - Math.sqrt((2*Math.log(b)/c));
		double max = a + Math.sqrt((2*Math.log(b)/c));
		return new UDB1Point(min,max);
	}
}
