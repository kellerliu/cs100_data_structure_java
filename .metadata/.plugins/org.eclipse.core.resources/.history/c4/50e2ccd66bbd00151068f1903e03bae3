import java.io.File;
// http://www.cs.duke.edu/csed/newapt/circuits.html
	
public class Circuits {
	public int howLong(String[] connects, String[] costs) {
		// fill in code here
		int n = connects.length;
		int cost[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			String con = connects[i];
			String cos = costs[i];
			if (!con.equals("")) {
				String conArray[] = con.split(" ");
				String cosArray[] = cos.split(" ");
				for (int j = 0; j < conArray.length; j++) {
					int t = Integer.parseInt(conArray[j]);
					cost[i][t] = Integer.parseInt(cosArray[j]);
				}
			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (cost[i][k] != 0 && cost[k][j] != 0
							&& cost[i][j] < cost[i][k] + cost[k][j]) {
						cost[i][j] = cost[i][k] + cost[k][j];
					}
				}
			}
		}
		int max=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(max<cost[i][j])
					max=cost[i][j];
			}
		}
		return max;
	}

    public static void main(String[] args) {
    	Circuits circuits = new Circuits();
    	String[] connects = {"1 2", "2", ""};
    	String[] costs = {"5 3", "7", ""};
    	int length = circuits.howLong(connects, costs);
    	System.out.println( "longest path is "+ length);
    }
}
