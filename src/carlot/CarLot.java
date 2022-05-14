package carlot;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CarLot extends ArrayList<Car>{
	// File location where the inventory of a CarLot is stored
	public static final String CARLOT_INVENTORY_LOCATION = "src\\carlot\\carlot.txt";
	
	/*
	 * Default Constructor
	 * Calls loadFromDisk to initialize CarLot
	 */
	CarLot() {
		super.clear();
		loadFromDisk();
	}
	
	/*
	 * Load the cars from file stored in CARLOT_INVENTORY_LOCATION
	 */
	void loadFromDisk() {
		try {
			File carFile = new File(CARLOT_INVENTORY_LOCATION);
			Scanner input = new Scanner(carFile);
			this.clear();
			while (input.hasNext()) {
				String id = input.next();
				int mileage = Integer.parseInt(input.next());
				int mpg = Integer.parseInt(input.next());
				boolean isSold = Boolean.parseBoolean(input.next());
				double cost = Double.parseDouble(input.next());
				double salesPrice = Double.parseDouble(input.next());
				double priceSold = Double.parseDouble(input.next());
				double profit = Double.parseDouble(input.next());
				profit = priceSold - cost;
				
				addCar(id, mileage, mpg, cost, salesPrice);
				if(isSold)
					this.sellCar(id, priceSold);
			}
			
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERR: The file was not found!");
			e.printStackTrace();
		}
	}
	
	/*
	 * Save the cars in this CarLot to the file stored in CARLOT_INVENTORY_LOCATION
	 */
	void saveToDisk() {
		try {
			File carFile = new File(CARLOT_INVENTORY_LOCATION);
			System.out.println("Checking if file exists...");
			if (carFile.createNewFile())
				System.out.println("File does not exist, new file created: " + carFile.getName());
			else
				System.out.println("File exists.");
			
			FileWriter carWriter = new FileWriter(CARLOT_INVENTORY_LOCATION);
			System.out.println("Writing data...");
			for (int i = 0; i < this.size(); i++) {
				System.out.println(this.get(i).toString(i));
				carWriter.write(this.get(i).toString(i));
			}
			
			carWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERR: The file was not found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERR: Unknown error occurred.");
			e.printStackTrace();
		}
	}
	
	CarLot getInventory() {
		return this;
	}
	
	/*
	 * Calculate average mpg of all cars in the lot
	 * @return Returns the average mpg of all cars in the lot
	 */
	double getAverageMpg() {
		double temp = 0;
		for (int i = 0; i < super.size(); i++)
			temp += super.get(i).getMPG();
		
		return temp / super.size();
	}
	
	/*
	 * Calculate car with highest mpg
	 * @return Returns the Car object with the highest mpg value
	 */
	Car getCarWithBestMPG() {
		CarLot inventoryMPG = getCarsSortedByMPG();
		return inventoryMPG.get(inventoryMPG.size() - 1);
	}
	
	/*
	 * Calculate car with highest mileage
	 * @return Returns the Car object with the higheset mileage value
	 */
	Car getCarWithHighestMileage() {
		CarLot inventoryMileage = getCarsSortedByMileage();
		return inventoryMileage.get(inventoryMileage.size() - 1);
	}
	
	/*
	 * Calculate total profit for all sold cars
	 * @return Returns the sum of all car object profit values
	 */
	double getTotalProfit() {
		double profit = 0;
		
		for (int i = 0; i < this.size(); i++)
			profit += this.get(i).getProfit();
		
		return profit;
	}
	
	/*
	 * Copy current list and sort by mpg value descending
	 * @return Returns a new list containing all cars in inventory sorted by mpg descending
	 */
	CarLot getCarsSortedByMPG() {
		CarLot inventoryMPG = this;
		int n = inventoryMPG.size();
		
		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (inventoryMPG.get(j).compareMPG(inventoryMPG.get(min_idx)) == -1 ||
					inventoryMPG.get(j).compareMPG(inventoryMPG.get(min_idx)) == 0)
					min_idx = j;
			
			Car temp = inventoryMPG.get(min_idx);
			inventoryMPG.set(min_idx, inventoryMPG.get(i));
			inventoryMPG.set(i, temp);
		}
		
		return inventoryMPG;
	}
	
	/*
	 * Copy current list and sort by mileage value descending
	 * @return Returns a new list containing all cars in inventory sorted by mileage descending
	 */
	CarLot getCarsSortedByMileage() {
		CarLot inventoryMileage = this;
		int n = inventoryMileage.size();
		
		for (int i = 0; i < n - 1; i++) {
			int min_idx = 1;
			for (int j = i + 1; j < n; j++)
				if (inventoryMileage.get(j).compareMileage(inventoryMileage.get(min_idx)) == -1 ||
					inventoryMileage.get(j).compareMileage(inventoryMileage.get(min_idx)) == 0)
					min_idx = j;
			Car temp = inventoryMileage.get(min_idx);
			inventoryMileage.set(min_idx, inventoryMileage.get(i));
			inventoryMileage.set(i, temp);
		}
		
		return inventoryMileage;
	}
	
	/*
	 * Sell the car identified by the identifier for the priceSold
	 * @param identifier: String id of car to be sold
	 * @param priceSold: double value of price car sold for
	 */
	void sellCar(String identifier, double priceSold) {
		Car temp = findCarByIdentifier(identifier);
		
		if (temp != null)
			temp.sellCar(priceSold);
		else
			System.out.println("ERR: Car not found!");
	}
	
	/*
	 * Add a new car to this CarLot
	 * @param id: the string identifier for the car object
	 * @param mileage: the integer value for car mileage
	 * @param mpg: the integer value for car miles per gallon
	 * @param cost: the double value for car cost
	 * @param salesPrice: the double value for car selling price
	 */
	void addCar(String id, int mileage, int mpg, double cost, double salesPrice) {
		Car newCar = new Car(id, mileage, mpg, cost, salesPrice);
		super.add(newCar);
	}
	
	/*
	 * Find car in inventory using String value
	 * @param identifier: String value to search for
	 * @return Returns Car object that matches the identifier or null if not found
	 */
	Car findCarByIdentifier(String identifier) {
		for (Car car : this)
			if (car.getID().equals(identifier))
				return car;
		
		return null;
	}
}
