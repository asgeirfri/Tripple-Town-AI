import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import edu.princeton.cs.algs4.Stopwatch;

public final class UDB1 {
	
	public static UDB1Point calculate(PredictionStats selection, int totalRuns){
		double min = selection.averageScore() - Math.sqrt((2*Math.log(totalRuns)/selection.runs));
		double max = selection.averageScore() + Math.sqrt((2*Math.log(totalRuns)/selection.runs));
		return new UDB1Point(min,max);
	}
}
