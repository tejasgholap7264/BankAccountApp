package bankaccountapp;

public class Saving extends Account  {
	//List properties specific to a Checking account
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	//Constructor to initialize saving account properties
	public Saving(String name,String sSN,double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber="1"+accountNumber;
        setSafetyDepositBox();
	}
	
	@Override
	public void setRate() {
		rate=getBaseRate()- .25;
	}

	//List any methods specific to checking methods
	private void setSafetyDepositBox() {
		safetyDepositBoxID=(int)(Math.random()*Math.pow(10, 3));
		safetyDepositBoxKey=(int)(Math.random()*Math.pow(10, 4));
	}
	
	public void showInfo(){
		System.out.println("ACCOUNT TYPE: SAVING");
		super.showInfo();
		System.out.println(
				"Your Saving Account Features " +
		        "\nSafety Deposit Box ID: "+ safetyDepositBoxID +
		        "\nSafety Deposit Box Key: "+ safetyDepositBoxKey
				);
    }
}
