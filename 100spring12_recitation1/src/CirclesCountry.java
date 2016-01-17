
public class CirclesCountry {
	public int leastBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2) {

	int count=0;
	for (int i=0; i< x.length;i++){
	int centerX=x[i];
	int centerY=y[i];
	int radius=r[i];
	
	boolean countcircle=twosideofCircle(x1, y1, x2, y2,  centerX,  centerY,  radius);
	if (countcircle)
	count++;
	}
	return count;
	}
	
	
	
	
	
	public boolean twosideofCircle(int x1, int y1, int x2, int y2, int centerX, int centerY, int r){
		int side = ((x1-centerX)*(x1-centerX)+ (y1-centerY)*(y1-centerY)-r*r)*((x2-centerX)*(x2-centerX)+(y2-centerY)*(y2-centerY)-r*r);

	if (side <0 )
		return true;
	else
		return false;

	}
	 }


