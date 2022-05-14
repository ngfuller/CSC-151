package carlot;

public class CarLotTester {
	public static void printCarLot(CarLot carLot) {
		for (int i = 0; i < carLot.size(); i++)
			System.out.println(carLot.get(i).toString());
		System.out.println("\n");
	}

	public static void main(String[] args) {
		CarLot carLot = new CarLot();
		System.out.println("CarLot declared");		
		
		carLot.addCar("F-150", 10000, 45, 25000, 30000);
		carLot.addCar("F-250", 5000, 55, 30000, 35000);
		carLot.addCar("Focus", 15000, 35, 20000, 25000);
		System.out.println("CarLot initialized");
		System.out.println("CarLot inventory size: " + carLot.size());
		
		printCarLot(carLot);
		
		System.out.println("Is car 1 sold: " + carLot.get(0).isSold());
		System.out.println("Selling car 1 for $40000");
		carLot.sellCar("F-150", 40000);
		System.out.println("Is car 1 sold: " + carLot.get(0).isSold());
		System.out.println("\n");
		
		printCarLot(carLot);
		
		System.out.println("Car with highest MPG: " + carLot.getCarWithBestMPG().toString());
		System.out.println("Car with highest Mileage: " + carLot.getCarWithHighestMileage().toString());
		System.out.println("Car Lot average MPG: " + carLot.getAverageMpg());
		System.out.println("Car Lot total profit: $" + carLot.getTotalProfit());
	}
}
