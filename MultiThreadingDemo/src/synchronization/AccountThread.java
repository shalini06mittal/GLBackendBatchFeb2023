package synchronization;

public class AccountThread extends Thread{

	private Account account;
	private double amount;

	public AccountThread(Account account, String name, double amount) {
		super(name);
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" in run");
		account.withdraw(amount);
	}
	public static void main(String[] args) throws InterruptedException {
		Account a1 = new Account(1, 10000);
		Account a2 = new Account(1, 15000);
		AccountThread t1 = new AccountThread(a1, "Shalini", 2000);
		AccountThread t2 = new AccountThread(a1, "Prattik", 4000);
		t1.start();
		t2.start();
		
		System.out.println("Waiting for other thread to complete\n");
		t1.join();
		t2.join();
		System.out.println(a1.getBalance());
		//System.out.println(a2.getBalance());
		
	}
}
