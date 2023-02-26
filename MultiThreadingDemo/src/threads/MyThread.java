package threads;
/*
 * 1. extends Thread or implements Runnable
 * 2. overrride run() => task to be dont by the thread
 * 3. create object of your class
 * 4. call start()
 */
public class MyThread extends Thread{
	// run is a method what task your thread will do
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " : "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " completes the task ");
	}

}
