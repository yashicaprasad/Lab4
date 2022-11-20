/*
Lab 2
Yashica Prasad and Lois Wong
Purpose of the assignment: Demonstrate use of classes, polymorphism, and inheritance
 */

/*
 * Modified isGreater for clarity and added isLess
 */

public class Dollar extends Currency{
	public Dollar(){
		super();
	}
	
	public Dollar(double amt) {
        	super(amt);
    	}

	public Dollar(Dollar c){
		super(c);
	}
	private String currencyType = "Dollar";

	/*
	setter
	Purpose: assign value to currencyType
	Pre: Takes a String value as input
	Post: Sets the value of currencyType
	Return: N/A

	pseudocode:
	this.currencyType = currencyType;

	getter
	Purpose: get the value of currencyType
	Pre: N/A
	Post: N/A
	Return: the value of currencyType

	pseudocode:
	return currencyType;

	 */
	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	/*
        add()
        Purpose: adds an input object of the same currency type
        Pre: takes a Dollar object as input
        Post: currencyWhole and currencyFrac are updated / added to
        Return: N/A

        pseudocode
        if (c.currencyWhole > 0)
            currencyWhole += c.currencyWhole
            int netCents = currencyWhole * 100 + currencyFrac + c.currencyFrac //total value in cents
            currencyWhole = netCents / 100
            currencyFrac = netCents % 100

        else throw exception e if c.currencyWhole <= 0
         */
	public void add(Dollar c) {		
		try {
			if(c.currencyWhole >= 0) {
				currencyWhole += c.currencyWhole;
				//convert all calculations to cents
				int netCents = currencyWhole*100 + currencyFrac + c.currencyFrac;
				currencyWhole = netCents/100;
				currencyFrac = netCents%100;
			}
			else {
				System.out.println("Invalid addition");
			}
		}
		catch(Exception e) {
			System.out.println("Invalid addition");
		}
	}
	/*
	subtract()
	Purpose: subtracts an input object of the same currency type
	Pre: takes a Dollar object as input
	Post: currencyWhole and currencyFrac are updated / subtracted from
	Return: N/A

	subrract() pseudocode
	if (c.currencyWhole > 0 && !isGreater(c))

		if (isEqual(c))
			currencyWhole = 0
			currencyFrac = 0
		else
			currencyWhole -= c.currencyWhole
			int netCents = currencyWhole * 100 + currencyFrac - c.currencyFrac //total value in cents
			currencyWhole = netCents / 100
			currencyFrac = netCents % 100

	else throw exception e if c.currencyWhole <= 0 or !isGreater(c)
	 */
	public void subtract(Dollar c) {
		try {
			if(c.currencyWhole >= 0 && !isGreater(c)) {
				currencyWhole -= c.currencyWhole;
				//convert all calculations to cents
				int netCents = currencyWhole*100 + currencyFrac - c.currencyFrac;
				currencyWhole = netCents/100;
				currencyFrac = netCents%100;
			}	
			else {
				System.out.println("Invalid subtraction");
			}
		}
		catch(Exception e) {
			System.out.println("Invalid subtraction");
		}
	}
	/*
		isEqual()
		Purpose: checks if the input object's balance is equal or inequal
		Pre: takes a Dollar object as input
		Post: N/A
		Return: true if (currencyWhole == c.currencyWhole && currencyFrac == c.currencyFrac)

	isEqual() pseudocode
		if (currencyWhole == c.currencyWhole && currencyFrac == c.currencyFrac)
			return true
	return false
	 */
	public Boolean isEqual(Dollar c) {
		if(currencyWhole == c.currencyWhole && currencyFrac == c.currencyFrac) {
			return true;
		}
		return false;
	}
	/*
		isGreater()
		Purpose: checks if the input object's balance is greater
		Pre: takes a Dollar object as input
		Post: N/A
		Return: true if input object's balance is greater

	isGreater() pseudocode
		if (currencyWhole == c.currencyWhole)
			if (currencyFrac <= c.currencyFrac)
				return true
			else return false
		else if (currencyWhole < c.currencyWhole)
			return true;
		return false
	 */
	public Boolean isGreater(Dollar c) {
		if(currencyWhole > c.currencyWhole) 
			return true;
		else  
			return false;
	}
	
	public Boolean isLess(Dollar c) {
		if(currencyWhole < c.currencyWhole) 
			return true;
		else  
			return false;
	}
	/*
	print()
		Purpose: prints the balance and currency of the input object
		Pre: takes a Dollar object as input
		Post: N/A
		Return: N/A

	public void print(Dollar c) {	
		System.out.println(c.currencyWhole + "." + c.currencyFrac + currencyType);
	}
	 */
	public String print() {	
		System.out.println(this.currencyWhole + "." + this.currencyFrac + " " + this.currencyType);
		return this.currencyWhole + "." + this.currencyFrac + " " + this.currencyType;
	}
	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void subtract() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean isEqual() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isGreater() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
