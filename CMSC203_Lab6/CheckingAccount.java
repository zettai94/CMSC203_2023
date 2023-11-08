
public class CheckingAccount extends BankAccount{
	//attributes final static 15 cents
	public static final double FEE = 0.15;
	
	//takes a name and an initial amount as parameters
	public CheckingAccount(String name, double amount)
	{
		//call superclass
		super(name, amount);
		//initialize amountNumber to be the current value in 
		//accountNumber concatenated with -10
		//there can only be 1 checking account for each account number
		super.setAccountNumber(super.getAccountNumber() + "-10");
		
	}
	
	@Override
	public boolean withdraw(double amount)
	{
		//take the amount to withdraw, add to it the fee for check clearing,
		//call withdraw method from superclass
		double totalAmount = amount + FEE;
		return super.withdraw(totalAmount);
	}
	
}
