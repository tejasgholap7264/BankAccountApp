package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		
		
		/*
		Checking chkacc1=new Checking("Tom Wilson","321456879",1500);
		Saving savacc1=new Saving("Rich Lowe","456657897",2500);
		
		chkacc1.showInfo();
		System.out.println("****************");
		savacc1.showInfo();
		
		savacc1.deposit(5000);
		savacc1.withdraw(1000);
		savacc1.transfer("Ramesh", 500);
		
		savacc1.compound();
		*/
		
		List<Account> accounts=new LinkedList<>();
		
        //Read a csv file and then creaate new account based on that data
		String file="C:\\file_code_demo\\NewBankAccounts.csv";
		List<String[]> newAccountHolder = utilities.CSV.read(file);
		for(String[] accountHolder:newAccountHolder) {
			String name=accountHolder[0];
			String sSN=accountHolder[1];
			String accountType=accountHolder[2];
			double initDeposit=Double.parseDouble(accountHolder[3]);
			
			if(accountType.equals("Savings")){
				accounts.add(new Saving(name,sSN,initDeposit));
			}
			else if(accountType.equals("Checking")) {
				accounts.add(new Checking(name,sSN,initDeposit));
			}
			else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}		
		}
		
		for(Account acc:accounts) {
			System.out.println("*****************************");
			acc.showInfo();
			System.out.println();
		}
	}

}
