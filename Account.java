package bankaccountapp;

// we are not creating object from Account class thatswhy we will make it abstract but we can create objects from classes that inherit
public abstract class Account implements IBaseRate {
    //List common properties for savings and checking accounts
	private String name;
	private String sSN;   //Social Security Number
	private double balance;
	
	private static int index=10000;
	protected String accountNumber;
	protected double rate;
	
	
	//Constructor to set base properties and initialize the account
	public Account(String name,String sSN,double initDeposit) {
		this.name=name;
		this.sSN=sSN;
		balance=initDeposit;
		
		//Set Account number
		index++;
		this.accountNumber=setAccountNumber();
		
		setRate();
		
	}
	
	public abstract void setRate();
	
	private String setAccountNumber() {
		String lastTwoOfSSN= sSN.substring(sSN.length()-2, sSN.length());
		int uniqueId=index;
		int randomNumber=(int)(Math.random()*Math.pow(10, 3));
		return lastTwoOfSSN + uniqueId + randomNumber;
	}
	
	public void compound() {
		double accruedInterest=balance*(rate/100);
		balance=balance+accruedInterest;
		System.out.println("Accrued Interest: Rs "+accruedInterest);
		printBalance();
	}
	
	//List the common methods
	
	public void deposit(double amount) {
		balance=balance+amount;
		System.out.println("Depositing Rs "+amount);
		printBalance();
	}
	
    public void withdraw(double amount) {
		balance=balance-amount;
		System.out.println("Withdrawing Rs "+amount);
		printBalance();
	}
    
    public void transfer(String toWhere,double amount) {
		balance=balance-amount;
		System.out.println("Transfering Rs "+amount+"to"+toWhere);
		printBalance();
    }
    
    public void printBalance() {
    	System.out.println("Your balance is now: Rs "+ balance);
    }
	
	public void showInfo() {
		System.out.println(
				"NAME: "+ name +
				"\nACCOUNT NUMBER: "+ accountNumber +
				"\nBALANCE: " + balance+
				"\nRATE: "+ rate +"%"
				);
	}
}
