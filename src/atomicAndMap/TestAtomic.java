package atomicAndMap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class TestAtomic {

	public static void main(String[] args) throws InterruptedException {

		AtomicInteger atomicInt = new AtomicInteger(0);

		ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, 1000).forEach(i -> executor.submit(atomicInt::incrementAndGet));

		System.out.println(atomicInt.get());
		
		executor.awaitTermination(5, TimeUnit.SECONDS);

		executor.shutdown();
	}
}
