package oops_practice;


import java.util.Scanner;

public class BankAccount {
	public static void main(String[] args) {
		SavingAccount obj = new SavingAccount("124569", "vicky", 0.0);
		
//		
//		CheckingAccount obj = new CheckingAccount("12456", "vicky");
//		obj.setBalance(10000);
//		System.out.println("Account Balance is " + obj.getBalance());
//		obj.getAccountName();
//		obj.getAccountNumber();
//		obj.deposit(2000);
//		obj.deposit(2000);
//		obj.deposit(2000);
//		obj.deposit(2000);
		
		// if deductcharges need to apply transact more than three times
		// obj.deposit(2000);
//		 obj.deductFees();
	}

}

class BankAccountM {
	private String AccountName;
	private String AccountNumber;
	private double Balance = 2000.00;

	public String getAccountName() {
		System.out.println(AccountName);
		return AccountName;
	}

	public String getAccountNumber() {
		System.out.println(AccountNumber);
		return AccountNumber;
	}

	public double getBalance() {

		return Balance;
	}

	public void setBalance(double balance) {
		Balance = Balance + balance;
	}

	BankAccountM(String accNumber, String accName) {
	
		this.AccountName = accName;
		this.AccountNumber = accNumber;
		try {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Account Number : ");
		AccountNumber = input.next();
		System.out.println("Enter the Account Name : ");
		AccountName = input.next();

		System.out.println("Enter 1 to deposit ");
		System.out.println("Enter 2 to withdraw ");
		System.out.println("Enter 3 to check Balance ");
		System.out.println("Enter the Option : ");
		int option = input.nextInt();
		if (option == 1) {
			System.out.println("Enter the amount to deposit : ");
			double depositAmt = input.nextDouble();
			deposit(depositAmt);

		} else if (option == 2) {
			System.out.println("Enter the amount to withdraw : ");
			double withdrawAmt = input.nextDouble();
			withdraw(withdrawAmt);

		} else if (option == 3) {
			getBalance();
			System.out.println("Balance is " + Balance);

		}
		}
		catch (Exception e){
			System.out.println("Invalid input");
			  
			}
		return;
		}

	
	

	void deposit(double deposit) {
		setBalance(deposit);
		Scanner input2 = new Scanner(System.in);
		System.out.println(
				"If you need to check balance please enter 1 to continue \n or if you want to exit the transaction please enter 2");
		System.out.println();
		System.out.println();
		System.out.println("Please Enter the choice : ");
		int choice = input2.nextInt();

		if (choice == 1) {
			getBalance();
			System.out.println("Balance is " + Balance);

		} else {

		}

	}

	void withdraw(double withdraw) {
		setBalance(-withdraw);
		Scanner input2 = new Scanner(System.in);
		System.out.println(
				"If you need to check balance please enter 1 to continue \n or if you want to exit the transaction please enter 2");
		System.out.println();
		System.out.println();
		System.out.println("Please Enter the choice : ");
		int choice = input2.nextInt();

		if (choice == 1) {
			getBalance();
			System.out.println("Balance is " + Balance);

		} else {

		}

	}

	void greeting() {
		System.out.println("THANKYOU FOR BANKING WITH US");
	}

}

class SavingAccount extends BankAccountM {
	private double Interestrate;

	public double getInterestrate() {
		Interestrate = getBalance() * 8 / 100;
		return Interestrate;
	}

	public void setInterestrate(double interestrate) {
		Interestrate = interestrate;
	}

	SavingAccount(String accNumber, String accName, double rate) {
		super(accNumber, accName);
		this.Interestrate = rate;
		Scanner input3 = new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.println("In our bank interest rate is 8% ");
		System.out.println("If we want show your balance if that interest is added Press 1");
		System.out.println("If you want exit the transaction Press 2 ");
		System.out.println("Enter the choice : ");
		int choice = input3.nextInt();
		if (choice == 1) {
			rate = getInterestrate();
			setBalance(rate);
			System.out.println("Balance After Interest Rate is " + getBalance());
			greeting();

		} else {
			greeting();
		}

	}

	void greeting() {
		System.out.println("THANKYOU FOR BANKING WITH US");
	}

}

class CheckingAccount {
	private String accountNumber;
	private String accountName;
	private double Balance;
	double amount;
	int transaction = 0;



	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {

		this.Balance = balance;
	}

	public String getAccountNumber() {
		System.out.println("Acccount Num : " +accountNumber);
		return accountNumber;
	}

	public String getAccountName() {
		System.out.println("Acccount Name : " + accountName);
		return accountName;
	}

	CheckingAccount(String accNumber, String accName) {
		this.accountNumber = accNumber;
		this.accountName = accName;

	}

	void deposit(double amount) {
		this.amount=amount;
		double deposit = getBalance() + amount;
		setBalance(deposit);
		transaction++;
		if(transaction > 3){
			deductFees();
	}

	}

	void withdraw(double amount) {
		this.amount=amount;
		double withdraw = getBalance() - amount;
		setBalance(withdraw);
		transaction++;
		if(transaction > 3){
			deductFees();
	}
	}

	void deductFees() {
		double deductFee = 300;
		// if (transaction > 3) {
		// 	double newBalance = getBalance() - deductFee;
		// 	setBalance(newBalance);
		// 	System.out
		// 			.println("Transaction greater than 3, So deduct charge is 300, The new Balance is " + getBalance());
		// } else {
		// 	System.out.println("Transaction less than 3, So NO deduct charges, The new Balance is " + getBalance());
		// }
		double newBalance = getBalance() - deductFee;
		setBalance(newBalance);
		System.out.println("Transaction greater than 3, So deduct charge is 300, The new Balance is " + getBalance());
	
	}
}
