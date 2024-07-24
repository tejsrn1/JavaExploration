package javaExpo;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * This class demonstrates the use of AtomicInteger in Java.
 * AtomicInteger is a part of java.util.concurrent.atomic package.
 * It allows us to perform atomic operations in parallel without using synchronized blocks or locks.
 * Internally, AtomicInteger uses compare and swap techniques which are supported by all modern CPUs.
 */
public class Atomic {

    /**
     * This method demonstrates the use of AtomicInteger.
     * It creates an AtomicInteger and increments it in parallel using multiple threads.
     * Finally, it prints the value of AtomicInteger which should be 1000 as we increment it 1000 times.
     */
    public void do1() {
        // Declare an atomic, thread-safe integer data structure
        AtomicInteger atomicInt = new AtomicInteger(0);

        // Create a thread pool with 10 threads
        var executor = Executors.newFixedThreadPool(10);

        // Increment the counter in parallel safely
        // For each value in the range of 0 to 1000, submit a task to the executor
        // The task increments the atomic integer
        IntStream.range(0, 1000).forEach(
                v -> executor.submit(atomicInt::incrementAndGet)
        );

        // Print the value of atomic integer
        // If the operations are thread-safe, it should print 1000
        System.out.println(atomicInt.get());
    }
}
