import java.util.ArrayList;

public class ParkingLot {

	ArrayList<Car> Carlist = new ArrayList<Car>();

	public void addCar(Car carx) {
		Carlist.add(carx);
	}

	public ArrayList<Car> getAllCars() {

		return Carlist;

	}

}
