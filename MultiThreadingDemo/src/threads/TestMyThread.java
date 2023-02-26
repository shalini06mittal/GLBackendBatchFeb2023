package threads;

public class TestMyThread {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		MyThread t1 = new MyThread();
		t1.setName("T1");
		t1.start();
		MyThread t2 = new MyThread();
		t2.setName("T2");
		t2.start();
		System.out.println("main ends");
//		for (int i = 10; i <= 15; i++) {
//			System.out.println(Thread.currentThread().getName() + " : "+i);
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
}
/**
 * main
main ends
T1 : 1
main : 1
main : 2
T1 : 2
T1 : 3
main : 3
T1 : 4
main : 4
T1 : 5
main : 5
T1 completes the task */

