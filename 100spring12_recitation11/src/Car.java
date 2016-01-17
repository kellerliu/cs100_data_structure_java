
public class Car implements Comparable<Car>{
	private String myMake;
	private String myModel;
	private String myColor;
	private int myYear;

	public Car(String make, String model, String color, int year) {
		myMake = make;
		myModel = model;
		myColor = color;
		myYear = year;
	}

	public String getModel() {
		return myModel;
	}

	public String getColor() {
		return myColor;
	}

	public String getMake() {
		return myMake;
	}

	public int getYear() {
		return myYear;
	}

	public String toString() {
		return myYear + " " + myColor + " " + myMake + " " + myModel;
	}

	@Override
	public int compareTo(Car other) {
		if (!this.getMake().equals(other.getMake())) {
			return this.getMake().compareTo(other.getMake());
		}
		if (!this.getModel().equals(other.getModel())) {
			return this.getModel().compareTo(other.getModel());
		}
		if (this.getYear() != other.getYear()) {
			return this.getYear() - other.getYear();
		}

		return this.getColor().compareTo(other.getColor());
	}
}
