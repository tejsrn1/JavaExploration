package javaExpo;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class SynchLock {

    int count = 0;
    ReentrantLock reentrantLock;

    /**
     * This method increments the count variable by 1.
     */
    void increment() {
        count = count + 1;
    }

    /**
     * This method increments the count variable by 1 in a synchronized manner.
     */
    synchronized void incrementSynch() {
        count = count + 1;
    }

    /**
     * This method increments the count variable by 1 in a synchronized block.
     */
    void incrementSynchBlock() {
        synchronized (this) {
            count = count + 1;
        }
    }

    /**
     * This method demonstrates the use of synchronized methods and blocks.
     * It creates a fixed thread pool and increments the count variable in a multithreaded environment.
     */
    public void doSynchronized() {
        // Synchronized : Java uses monitor lock or intrinsic lock to manage it.
        // This monitor is bound to an object i.e 1 monitor per object shared by all methods.
        // This monitor is based on reentrant characteristics i.e. it bounds to the current thread.
        // The current thread uses the same locks for different methods of the same object without deadlock in a situation like a synchronized method calling another synchronized method of the same object.

        var exe = Executors.newFixedThreadPool(10);

        // Incrementing count in multithreaded without lock
        IntStream.range(0, 1000).forEach(i -> exe.submit(this::increment));
        System.out.println(count); // This will not print the correct count

        // With lock incrementing.
        IntStream.range(0, 1000).forEach(i -> exe.submit(this::incrementSynch));
        IntStream.range(0, 1000).forEach(i -> exe.submit(this::incrementSynchBlock));
        System.out.println(count); // This will print the correct count
    }

    /**
     * This method demonstrates the use of ReentrantLock.
     * It creates a fixed thread pool and acquires a lock to perform a task.
     */
    public void doReentrantLock() {
        // ReentrantLock :

        var ct = 0;
        var executor = Executors.newWorkStealingPool(10);
        reentrantLock = new ReentrantLock();

        executor.submit(() -> {
            // Acquired lock
            // If another thread had already acquired then this thread will wait until it's free.
            // Only one thread can hold the lock.

            reentrantLock.lock();
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock(); // Released lock
            }
        });

        executor.submit(() -> {
            // Alternative lock method which does without pausing the current thread.
            // Logic must be written on boolean value though..
            var locked = reentrantLock.tryLock();
        });
    }

    /**
     * This method demonstrates the use of ReadWriteLock.
     * It creates a fixed thread pool and acquires a write lock to perform a task.
     * Then it acquires a read lock to read the data.
     */
    public void doReadWriteLock() {
        // Read Write Lock
        // When write locks happen it won't allow any read and
        // all reads threads have to wait until write locks open
        // Multiple threads can read through their read locks without waiting or blocking each other.

        var readwriteLock = new ReentrantReadWriteLock();

        var executor = Executors.newFixedThreadPool(2);
        var map = new HashMap<>();

        executor.submit(() -> {
            // Write lock
            readwriteLock.writeLock().lock();

            try {
                sleep(1);
                map.put("foo", "bar");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Unlock write lock.
                readwriteLock.writeLock().unlock();
            }
        });

        Runnable readTask = () -> {
            // Lock it.
            readwriteLock.readLock().lock();
            try {
                var res = map.get("foo");
            } finally {
                // Release
                readwriteLock.readLock().unlock();
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
    }

    /**
     * This method demonstrates the use of StampedLock.
     * It creates a fixed thread pool and acquires a write lock to perform a task.
     * Then it acquires a read lock to read the data.
     * It also demonstrates the use of optimistic lock.
     */
    public void doStampedLock() {
        // Stamped Lock : Java 8 +
        // Supports Read and Write lock.
        // Returns stamps by "long" value.
        // We need to use Stamp to release lock or to check if lock is valid.
        // Apart from RW Lock it does Optimistic lock.

        // Stamped locks don’t implement reentrant characteristics
        // Each call to lock returns a new stamp and blocks if no locks available.
        // Despite previously locked by the same thread.
        // We have to make sure it's not a deadlock.

        // RW lock with StampedLock.

        var stampedLock = new StampedLock();

        var executor = Executors.newFixedThreadPool(2);
        var map = new HashMap<>();

        executor.submit(() -> {
            // Write lock
            var stamp = stampedLock.writeLock();

            try {
                sleep(1);
                map.put("foo", "bar");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Unlock write lock.
                stampedLock.unlockWrite(stamp);
            }
        });

        // Reads
        Runnable readTask = () -> {
            // Lock it.
            var stamp = stampedLock.readLock();
            try {
                var res = map.get("foo");
            } finally {
                // Release
                stampedLock.unlockRead(stamp);
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);

        // Optimistic lock

        executor.submit(() -> {
            // Optimistic Read Lock acquired
            // Returns stamp without blocking thread no matter if Lock is actually available
            // When in between when write lock becomes active then stamp = 0
            // Also read lock does not block write lock to be acquired unlike RW lock
            // But after write lock acquired and later release, read lock remains invalid.
            // We have to validate lock always for any shared variables.

            var optStamp = stampedLock.tryOptimisticRead();

            try {
                // Validating stamp.
                var a = stampedLock.validate(optStamp);
                sleep(1);

                var b = stampedLock.validate(optStamp);
                sleep(1);

                var c = stampedLock.validate(optStamp);
                sleep(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                stampedLock.unlock(optStamp);
            }

        });

        executor.submit(() -> {
            // Write lock
            var stamp = stampedLock.writeLock();

            try {
                sleep(2);
                map.put("foo", "bar");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Unlock write lock.
                stampedLock.unlock(stamp);
            }
        });

    }

    /**
     * This method demonstrates the use of Semaphores.
     * It creates a fixed thread pool and acquires a semaphore to perform a task.
     */
    public void doSemaphores() {
        // Semaphores
        // Whereas locks usually grant exclusive access to variable or resources.
        // Semaphores maintain a whole set of permits.
        // It basically limits access to long running task.

        var executor = Executors.newFixedThreadPool(10);

        // Semaphore with limit to 5 only..
        var semaphoreLock = new Semaphore(5);

        Runnable longRunningTask = () -> {
            var permits = false;

            try {
                permits = semaphoreLock.tryAcquire(1, TimeUnit.SECONDS);

                if (permits) {
                    // Semaphore acquired..
                    sleep(5);
                }
                // Else not acquired.
            } catch (Exception e) {
                //
            } finally {
                if (permits) {
                    semaphoreLock.release();
                }
            }
        };

        // Executing 10 threads in parallel.
        // But Semaphore will limit to 5 only..
        IntStream.range(0, 10)
                .forEach(i -> executor.submit(longRunningTask));
    }


}
