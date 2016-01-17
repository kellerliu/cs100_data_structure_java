import java.util.HashSet;

public class Internet {
	int n;
	boolean con[][];
	boolean fal[];
	boolean copy[];
	boolean isArtPoint=false;
	
	public int articulationPoints(String[] routers) {
		buildArray(routers);
		int ret = 0;
		for (int i = 0; i < con.length; i++) {
			isArtPoint=false;
			copy = con[i];
			con[i] = fal;
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				for (int k = j + 1; k < n; k++) {
					if (i == k)
						continue;
					if (!isConnected(j, k, con,new HashSet<Integer>()))
						isArtPoint=true;
					}
			}
			con[i] = copy;
			
			if(isArtPoint)
				ret++;
			
		}
		return ret;
	}

	public void buildArray(String[] s) {
		n = s.length;
		con = new boolean[n][n];
		fal=new boolean[n];
		for (int i = 0; i < n; i++) {
			fal[i] = false;
			String tmp = s[i];
			if (!tmp.equals("")) {// All routers will be connected to each
									// other, so this line unnecessary
				String dArray[] = tmp.split(" ");
				for (int j = 0; j < dArray.length; j++) {
					int t = Integer.parseInt(dArray[j]);
					con[i][t] = true;
				}
			}
		}
	}

	public boolean isConnected(int a, int b, boolean c[][], HashSet<Integer> v) {
		if(v.contains(a))
			return false;		
		if (c[a][b])
			return true;		
		v.add(a);		
		for (int i = 0; i < c.length; i++) {
			if (c[a][i]) {
				if (isConnected(i, b, c, v))
					return true;
			}
		}
		return false;
	}
	
	public static void main(String argo[]){
		Internet test= new Internet();
		String[]s1={"2","2 3","0 1 3 4","1 2","2 5 6","4 6","4 5"};
		
		String[]s2={"3 10","8 4","7 10","0 9","6 1","9","4 11","11 2","1","3 5","0 2","7 6"};
		
		System.out.println(test.articulationPoints(s1)+"");
		System.out.println(test.articulationPoints(s2)+"");						
	}	
}
