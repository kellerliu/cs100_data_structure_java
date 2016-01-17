import java.util.ArrayList;


public class CarTester {
	public static void main(String[] args) {
		ParkingLot parkingLot = new ParkingLot();
		
		Car car1 = new Car("Honda", "Civic", "gray", 2010);
		parkingLot.addCar(car1);
		Car car2 = new Car("Toyota", "Camry", "green", 2011);
		parkingLot.addCar(car2);
		Car car3 = new Car("Ford", "Focus", "silver", 2001);
		parkingLot.addCar(car3);
		
		
		ArrayList<Car> myCars = parkingLot.getAllCars();
		for (Car car : myCars) {
			System.out.println("There is a " + car.getColor() + " " + car.getModel() + " in the parking lot.");
		}
		
		/*
		  If done correctly, the output should be the following: 
		 		There is a gray Civic in the parking lot.
				There is a green Camry in the parking lot.
				There is a silver Focus in the parking lot.
		 */
	}
}
