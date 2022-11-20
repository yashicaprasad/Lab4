/*
Lab 3
Yashica Prasad and Lois Wong
Purpose of the assignment: Demonstrate use of stacks, queues, and linked lists
 */

import java.text.DecimalFormat;

public abstract class Currency {
	//Class Variables
	protected int currencyWhole;
	protected int currencyFrac;
	
	/*
	setters
	Purpose: assign value to specified variables
	Pre: Takes an int value as input
	Post: Sets the value of currencyWhole or currencyFrac
	Return: N/A

	pseudocode:
	this.currencyFrac = currencyFrac;
	 */

	/*
	getters
	Purpose: get the value of specified variables
	Pre: N/A
	Post: N/A
	Return: the int value of the specified variable

	pseudocode:
	return currencyFrac;

	 */
	public int getCurrencyWhole() {
		return currencyWhole;
	}
	public void setCurrencyWhole(int currencyWhole) {
		this.currencyWhole = currencyWhole;
	}
	public int getCurrencyFrac() {
		return currencyFrac;
	}
	public void setCurrencyFrac(int currencyFrac) {
		this.currencyFrac = currencyFrac;
	}
	
	//Default Construction
	public Currency(){
		currencyWhole = 0;
		currencyFrac = 0;
	}
	//Construction with type double as input
	public Currency(double amt){
        DecimalFormat df = new DecimalFormat("#######0.00");
		String doubleAsString = df.format(amt);
		int indexOfDecimal = doubleAsString.indexOf(".");
		currencyWhole = Integer.parseInt(doubleAsString.substring(0, indexOfDecimal));
		char[] ch = doubleAsString.toCharArray();
		currencyFrac = Character.getNumericValue(ch[indexOfDecimal + 1])*10 + Character.getNumericValue(ch[indexOfDecimal + 2]);
	}
	//Copy Constructor
	public Currency(Currency c){
		currencyWhole = c.currencyWhole;
		currencyFrac =  c.currencyFrac;
	}
	public abstract void add();
	
	public abstract void subtract();
	
	public abstract Boolean isEqual();
	
	public abstract Boolean isGreater();
	
	public abstract String print();
	
	//Destructor
	protected void finalize(){
	}  
}