import java.util.ArrayList;
import java.util.Collections;

public class LineSegment implements Comparable<LineSegment> {

	private int myX1, myY1, myX2, myY2;

	public LineSegment(int x1, int y1, int x2, int y2) {
		myX1 = x1;
		myY1 = y1;
		myX2 = x2;
		myY2 = y2;
	}

	public static void main(String[] args) {
		ArrayList<LineSegment> list = new ArrayList<LineSegment>();
		list.add(new LineSegment(0, 0, 4, 0));
		list.add(new LineSegment(-8, 2, 6, -1));
		list.add(new LineSegment(0, 0, 0, -3));
		list.add(new LineSegment(40, 0, 38, 1));
		Collections.sort(list);
		System.out.println(list);
	}

	public String toString() {
		return "<(" + myX1 + ", " + myY1 + "), (" + myX2 + ", " + myY2 + ")>";
	}

	public int compareTo(LineSegment other) {
		// your code goes here
		int otherdis = (other.myX1 - other.myX2) * (other.myX1 - other.myX2)
				+ (other.myY1 - other.myY2) * (other.myY1 - other.myY2);
		int dis = (myX1 - myX2) * (myX1 - myX2) + (myY1 - myY2) * (myY1 - myY2);
		int result = dis - otherdis;
		if (result > 0)
			return 1;
		if (result == 0)
			return 0;
		else
			return -1;

	}
	



	    public boolean equals(Object other) {
	    	//your code goes here
	    	if (this == other)
	            return true;
	        if (other == null)
	            return false;
	        if (getClass() != other.getClass())
	            return false;
	        LineSegment other2 = (LineSegment) other;
	        if(other2.myX1==myX1 && other2.myX2==myX2&&other2.myY1==myY1 && other2.myY2==myY2) {
	            return true;
	        }
	        return false;
	    }
	
	
		 public int hashCode() {
		        return myX1*10000+myX2*1000+myY1*100+myY2*10;
		    }
	
	

}
