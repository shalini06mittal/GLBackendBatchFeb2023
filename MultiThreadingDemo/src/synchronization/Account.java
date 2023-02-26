package synchronization;

public class Account {

	private int aid;
	private double balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int aid, double balance) {
		super();
		this.aid = aid;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public synchronized void withdraw(double amount)
	{
		System.out.println(Thread.currentThread().getName()+" in withdraw");
		//1 . get the balance
		double actual = getBalance();
		//2. validate if withdraw can happen
		if(actual - amount < 0)
		{
			System.out.println("Withdraw cannot happen");
			return;
		}
		// 3. deduct
		double total = actual - amount;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//4. update the amount
		balance = total;
		System.out.println(Thread.currentThread().getName()+" complete withdraw");
	}
	
}
