package carlot;

public class Car {
	String id;
	int mileage;
	int mpg;
	double cost;
	double salesPrice;
	boolean sold;
	double priceSold;
	double profit;
	String soldCarID;
	
	/*
	 * Default constructor initializes id to Car and all variables to zero
	 */
	public Car() {
		id = "Car";
		mileage = 0;
		mpg = 0;
		cost = 0.0;
		salesPrice = 0.0;
	}
	
	/*
	 * Constructor with parameters
	 * @param id: the string identifier for the car object
	 * @param mileage: the integer value for car mileage
	 * @param mpg: the integer value for car miles per gallon
	 * @param cost: the double value for car cost
	 * @param salesPrice: the double value for car selling price
	 */
	public Car(String id, int mileage, int mpg, double cost, double salesPrice) {
		this.id = id;
		this.mileage = mileage;
		this.mpg = mpg;
		this.cost = cost;
		this.salesPrice = salesPrice;
	}
	
	/*
	 * Prints all related information for this Car object
	 * @return Returns a String displaying all car variables with labels
	 */
	public String toString() {
		return "Car:  " + id + ", Mileage:  " + mileage + ", MPG:  " + mpg + ", Sold:  " + sold + ", Cost:  $"
				+ cost + ", Selling price:  $" + salesPrice + ", Sold For  $" + priceSold + ", Profit:  $" + profit;
	}
	
	/*
	 * Prints all raw data for this Car object
	 * @return Returns a String displaying all car variables without labels
	 */
	public String toString(int i) {
		return id + " " + mileage + " " + mpg + " " + sold + " " + cost + " " + salesPrice + " " + priceSold + " " + profit + "\n";
	}
	
	/*
	 * Compares this car's MPG to another car
	 * @param otherCar: the other Car object this car is being compared to
	 * @return Returns an integer depending on the relationship of the two mpg values
	 */
	int compareMPG(Car otherCar) {
		if (this.mpg < otherCar.mpg)
			return -1;
		else if (this.mpg > otherCar.mpg)
			return 1;
		else
			return 0;
	}
	
	/*
	 * Compares this car's mileage to another car
	 * @param otherCar: the other Car object this car is being compared to
	 * @return Returns an integer depending on the relationship of the two mileage values
	 */
	int compareMileage(Car otherCar) {
		if (this.mileage < otherCar.mileage)
			return -1;
		else if (this.mileage > otherCar.mileage)
			return 1;
		else
			return 0;
	}
	
	/*
	 * Compares this car's sales price to another car
	 * @param otherCar: the other Car object this car is being compared to
	 * @return Returns an integer depending on the relationship of the two mileage values
	 */
	int compareSalesPrice(Car otherCar) {
		if (this.salesPrice < otherCar.salesPrice)
			return -1;
		else if (this.salesPrice > otherCar.salesPrice)
			return 1;
		else
			return 0;
	}
	
	/*
	 * Marks car as sold
	 * @param priceSold: the double value for the price the car sold for
	 */
	void sellCar(double priceSold) {
		setSold(true);
		setPriceSold(priceSold);
		setProfit(priceSold - this.cost);
	}
	
	String getID() {
		return id;
	}
	
	int getMileage() {
		return mileage;
	}
	
	int getMPG() {
		return mpg;
	}
	
	double getCost() {
		return cost;
	}
	
	double getSalesPrice() {
		return salesPrice;
	}
	
	boolean isSold() {
		return sold;
	}
	
	double getPriceSold() {
		return priceSold;
	}
	
	double getProfit() {
		return profit;
	}
	
	void setID(String id) {
		this.id = id;
	}
	
	void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	void setMPG(int mpg) {
		this.mpg = mpg;
	}
	
	void setCost(double cost) {
		this.cost = cost;
	}
	
	void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}
	
	void setSold(boolean sold) {
		this.sold = sold;
	}
	
	void setPriceSold(double priceSold) {
		this.priceSold = priceSold;
	}
	
	void setProfit(double profit) {
		this.profit = profit;
	}
}
