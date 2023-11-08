
public class SavingsAccount extends BankAccount{
	//attributes
	//set rate to 2.5 as annual interest rate
	private double rate = 2.5;
	//initialized to 0
	private int savingsNumber = 0;
	private String accountNumber;
	
	public SavingsAccount(String name, double amount)
	{
		//calls superclass constructor
		super(name, amount);
		//takes accountNumber + "-" + savingsNumber
		this.accountNumber = (super.getAccountNumber() + "-" + this.savingsNumber);
	}
	
	public SavingsAccount(SavingsAccount oldAccount, double amount)
	{
		//take original savings account from same person
		//call copy constructor of superclass, assign savingsNumber to be 
		//1 more than savingsNumber of the original savings account
		//assign accountNumber to be the accountNumber of superclass concatenated with the hypen 
		//and the savingsNumber of the new account
		super(oldAccount, amount);
		savingsNumber++;
		this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	public void postInterest()
	{
		//calculate 1 month worth of interest on balance and deposit into account
		double interest = super.getBalance() * (rate/100) /12;
		super.deposit(interest);
	}
	
	@Override
	public String getAccountNumber() 
	{
		//override getAccountNumber method in superclass
		return this.accountNumber;
	}
}
