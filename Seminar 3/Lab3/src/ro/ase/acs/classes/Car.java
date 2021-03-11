package ro.ase.acs.classes;

import ro.ase.acs.interfaces.Taxable;

public final class Car extends Vehicle implements Taxable {
	private String color;
	private int carCapacity;
	
	public Car() {
		super();
		color = "white";
		carCapacity = 49;
	}
	
	public Car(String name, int speed, String color, int carCapacity) {
		super(name, speed);
		this.color = color;
		this.carCapacity = carCapacity;
	}

	public int getCarCapacity() {
		return carCapacity;
	}

	public void setCarCapacity(int carCapacity) {
		this.carCapacity = carCapacity;
	}

	@Override
	public double computeTax() {
		float tax = 0;
		if(carCapacity < 2000) {
			tax = (float)carCapacity / 1000 * 50;
		}
		else {
			tax = (float)carCapacity / 1000 * 100;
		}
		return tax < MIN_TAX ? MIN_TAX : tax;
	}

	@Override
	public final void moveVehicle() {
		System.out.println("The car is moving");
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Car copy =  (Car)super.clone();
		copy.color = color;
		copy.carCapacity = carCapacity;
		return copy;
	}
}
