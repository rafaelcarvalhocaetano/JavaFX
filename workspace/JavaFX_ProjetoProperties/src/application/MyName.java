package application;

import javafx.beans.property.*;

public class MyName {
	
	private double number;

	public double getNumber() {
		if(number != 0)
		return number.get();
		return 0;
	}

	public void setNumber(double number) {
		this.number = number;
	}
	
	

}
