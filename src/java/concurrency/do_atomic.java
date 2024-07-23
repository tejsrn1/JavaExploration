package aa_learning.java.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class do_atomic {

    public void do1() {

        // Atomic :
        // java.concurrent.atomic
        // Allow safely performs operation in parallel w/o using Synchronized or locks.
        // Internally Atomic uses compare and swap techniques.
        // supported by all modern CPU.
        // e.g.AtomicLong , AtomicInteger etc.


        //E,g, AtomicInteger
        //AtomicInteger supports various kinds of atomic operations.

        //declare atomic thread safe integer DS
        var atomicInt = new AtomicInteger(0);
        var executore = Executors.newFixedThreadPool(10);

        // increment counter in parallel safely.
        IntStream.range(0, 1000).forEach(
                v -> executore.submit(atomicInt::incrementAndGet)
        );

        System.out.println(atomicInt.get());// will do right and reach 1000.


    }
}
