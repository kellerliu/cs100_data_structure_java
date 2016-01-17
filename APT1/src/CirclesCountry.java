public class CirclesCountry {
	public int leastBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2) {

	int count=0;
	for (int i=0; i< x.length;i++){
	int centerX=x[i];
	int centerY=y[i];
	int radius=r[i];
	Boolean point1=isPointInCircle(x1, y1, centerX, centerY, radius);
	Boolean point2=isPointInCircle(x2, y2, centerX, centerY, radius);
	if (point1&&!point2)
		count++;
		else if (!point1 && point2)
		count++;

	}
	return count;
	}
	public boolean isPointInCircle(int x, int y, int centerX, int centerY, int r){
		int distSquared = (x-centerX)* (x-centerX)+ (y-centerY)* (y-centerY);

	if (distSquared < r*r) 
	return true;
	else
	return false;

	}
	 }


