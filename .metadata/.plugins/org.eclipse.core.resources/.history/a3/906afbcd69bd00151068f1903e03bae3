import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Rec11Prep {

	private class ColorCarSorter implements Comparator<Car>{
		public int compare(Car a, Car b){
			if (!a.getColor().equals(b.getColor())) {
				return a.getColor().compareTo(b.getColor());
			}
			if (!a.getMake().equals(b.getMake())) {
				return a.getMake().compareTo(b.getMake());
			}
			if (a.getModel() != b.getModel()) {
				return a.getModel().compareTo(b.getModel());
			}

			return a.getYear()-(b.getYear());
		}
	}
	public void sortCarsByColor(Car[] cars) {
		
		Arrays.sort(cars, new ColorCarSorter());
	}

	public static void main(String[] args) {
		Car car1 = new Car("Toyota", "Avalon", "gray", 2010);
		Car car2 = new Car("Toyota", "Camry", "green", 2011);
		Car car3 = new Car("Honda", "Civic", "gray", 2010);
		Car car4 = new Car("Ford", "Focus", "silver", 2001);
		Car car5 = new Car("Nissan", "Versa", "gray", 2009);
		Car car6 = new Car("Ford", "Fusion", "silver", 2000);
		Car[] cars = {car1, car2, car3, car4, car5, car6};

		Rec11Prep c = new Rec11Prep();
		c.sortCarsByColor(cars);
		for (Car car : cars)
			System.out.println(car);


		/*
		  If done correctly, the output should be the following: 
		 		2010 gray Honda Civic
				2009 gray Nissan Versa
				2010 gray Toyota Avalon
				2011 green Toyota Camry
				2001 silver Ford Focus
				2000 silver Ford Fusion
		 */
	}

}
