
public class Rectangle implements Comparable<Rectangle>{
    private int myWidth;
    private int myHeight;
    
    public Rectangle(int width, int height) {
        myWidth = width;
        myHeight = height;
    }

    public int hashCode() {
        int someInt = 31;
        return someInt*myWidth + myHeight;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rectangle other = (Rectangle) obj;
        if (myHeight != other.myHeight)
            return false;
        if (myWidth != other.myWidth)
            return false;
        return true;
    }

    public int compareTo(Rectangle other) {
        int myArea = myWidth*myHeight;
        int otherArea = other.myWidth * other.myHeight;
        if(myArea < otherArea)
            return -1;
        if(myArea > otherArea)
            return 1;
        return 0;
        // I could also just say
        // return myArea - otherArea
    }
}
