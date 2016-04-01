
public class PredictionStats {
	
	public int runs;
	public double combinedScore;
	public UDB1Point values;
	
	public double averageScore(){
		return combinedScore/runs;
	}
	
	public PredictionStats(int runs, double combinedScore){
		this.runs = runs;
		this.combinedScore = combinedScore;
	}
}
