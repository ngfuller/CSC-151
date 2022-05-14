package carlot;

public class CarTester {
	public static void toString(Car[] carArray) {
		for (int i = 0; i < carArray.length; i++)
			System.out.println(carArray[i].toString());
		
		System.out.println("---------------------------------------------------");
	}
	
	public static void main(String[] args) {
		Car[] carArray = new Car[4];
		carArray[0] = new Car();
		carArray[1] = new Car("F-150", 15000, 45, 25000, 30000);
		carArray[2] = new Car("F-250", 15000, 45, 25000, 30000);
		carArray[3] = new Car("Focus", 10000, 30, 20000, 25000);
		
		toString(carArray);
		
		System.out.println("Adding car Fiesta with mpg: 30 cost: 20000 salesPrice: 25000 mileage: 10000");
		carArray[0].setID("Fiesta");
		carArray[0].setMPG(30);
		carArray[0].setCost(20000);
		carArray[0].setSalesPrice(25000);
		carArray[0].setMileage(10000);
		
		if (carArray[0].compareMileage(carArray[3]) != 0 || carArray[0].compareMPG(carArray[3]) != 0 || carArray[0].compareSalesPrice(carArray[3]) != 0)
			System.err.println("Equal comparison failure");
		
		if (carArray[2].compareMileage(carArray[3]) != 1 || carArray[2].compareMPG(carArray[3]) != 1 || carArray[2].compareSalesPrice(carArray[3]) != 1)
			System.err.println("Greater than failure");
		
		if (carArray[0].compareMileage(carArray[2]) != -1 || carArray[0].compareMPG(carArray[2]) != -1 || carArray[0].compareSalesPrice(carArray[2]) != -1)
			System.err.println("Less than failure");
		
		toString(carArray);
		
		System.out.println("Selling Fiesta for 40000 and profit of 20000");
		carArray[0].sellCar(40000);
		
		toString(carArray);
	}
}
