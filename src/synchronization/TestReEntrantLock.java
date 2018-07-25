package synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class TestReEntrantLock {

	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		ReentrantLock lock = new ReentrantLock();

		executor.submit(() -> {
		    lock.lock();
		    try {
		    	System.out.println("Gonna Sleep !");
		        Thread.sleep(100);
		        System.out.println("Woke Up !");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
		        lock.unlock();
		    }
		});

		executor.submit(() -> {
		    System.out.println("Locked: " + lock.isLocked());
		    System.out.println("Held by me: " + lock.isHeldByCurrentThread());
		    boolean locked = lock.tryLock();
		    System.out.println("Lock acquired: " + locked);
		});

		executor.shutdown();

	}

}
