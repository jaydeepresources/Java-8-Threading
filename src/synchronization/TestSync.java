package synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class TestSync {

	int count = 0;

	void increment() {
		count = count + 1;
	}

	void callIncrement() {
		ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, 10000).forEach(i -> executor.submit(this::increment));

		executor.shutdown();

		System.out.println(count);
	}

	public static void main(String[] args) {

		new TestSync().callIncrement();

	}

}
