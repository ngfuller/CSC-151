package carlot;

import java.util.Scanner;

public class CarLotMain {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CarLot carLot = new CarLot();
		
		while(true) {
			System.out.println("[0] Exit\n"
					+ "[1] Add a car to inventory\n"
					+ "[2] Sell a car from inventory\n"
					+ "[3] List inventory by order of acquisition\n"
					+ "[4] List inventory from best MPG to worst MPG\n"
					+ "[5] Display car with best MPG\n"
					+ "[6] Display car with the highest mileage\n"
					+ "[7] Display overall MPG for the entire inventory\n"
					+ "[8] Display profit for all sold cars\n"
					+ "[9] Load data from file\n"
					+ "[10] Save data to file\n");
			System.out.print("Enter a number from 0 to 10: ");
			
			switch(input.nextInt()) {
			case 1:
				System.out.print("Enter name of car to add: ");
				String id = input.next();
				System.out.print("Enter mileage of car to add: ");
				int mileage = input.nextInt();
				System.out.print("Enter MPG of car to add: ");
				int mpg = input.nextInt();
				System.out.print("Enter cost of car to add: ");
				double cost = input.nextDouble();
				System.out.print("Enter sales price of car to add: ");
				double salesPrice = input.nextDouble();
				
				carLot.addCar(id, mileage, mpg, cost, salesPrice);
				
				break;
			case 2:
				System.out.print("Enter name of car to sell: ");
				String identifier = input.next();
				System.out.print("Enter price to sell for: ");
				int sellPrice = input.nextInt();
				
				carLot.sellCar(identifier, sellPrice);
				
				break;
			case 3:
				for (int i = 0; i < carLot.size(); i++)
					System.out.println(carLot.get(i).toString());				
				
				break;
			case 4:
				CarLot inventoryMPG = carLot.getCarsSortedByMPG();
				
				for (int i = inventoryMPG.size() - 1; i >= 0; i--)
					System.out.println(inventoryMPG.get(i).toString());				
				
				break;
			case 5:
				System.out.println("Car with best MPG: " + carLot.getCarWithBestMPG().toString());				
				
				break;
			case 6:
				System.out.println("Car with highest mileage: " + carLot.getCarWithHighestMileage().toString());	
				
				break;
			case 7:
				System.out.println("Average MPG of all cars in inventory: " + carLot.getAverageMpg());
				
				break;
			case 8:
				System.out.println("Total profit for all sold cars: $" + carLot.getTotalProfit());
				
				break;
			case 9:
				carLot.loadFromDisk();
				
				break;
			case 10:
				carLot.saveToDisk();
				
				break;
			default:
				System.out.println("Exiting program...");
				input.close();
				System.exit(0);
			}
		}
	}
}
