package aa_learning.java.concurrency;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class synch_lock {

    int count = 0;
    ReentrantLock reentrantLock;

    void increment() {
        count = count + 1;
    }

    synchronized void incrementSynch() {
        count = count + 1;
    }

    void incrementSynchBlock() {

        synchronized (this) {
            count = count + 1;
        }

    }

    public void doSynchronized() {

        // Synchronized : Java use monitor lock or intrinsic lock to manage it.
        // this monitor is bound to object i.e 1 monitor per object shared by all methods
        // this monitor based on reentrant chaaracteristics i.e. it bounds to current thread.
        // current thread uses same locks for diff methods of same object w/o deadlock in situation like synch method call another synch method of same object.

        var exe = Executors.newFixedThreadPool(10);

        // incrementing count in multithreaded without lock
        IntStream.range(0, 1000).forEach(i -> exe.submit(this::increment));
        System.out.println(count);// this will not print

        // with lock incrementing.
        IntStream.range(0, 1000).forEach(i -> exe.submit(this::incrementSynch));
        IntStream.range(0, 1000).forEach(i -> exe.submit(this::incrementSynchBlock));
        System.out.println(count);// this will print properly
    }

    public void doReentrantLock() {

        // ReentrantLock :

        var ct = 0;
        var executor = Executors.newWorkStealingPool(10);
        reentrantLock = new ReentrantLock();

        executor.submit(() -> {

            // acquired lock
            // If another theread had already acquired then this thread will wait until its free.
            // only one thread can hold lock.

            reentrantLock.lock();
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock(); // released lock
            }
        });

        executor.submit(() -> {
            // alternative lock method which does without pausing current thread.
            // logic must be writen on boolan value though..
            var locked = reentrantLock.tryLock();

        });
    }

    public void doReadWriteLock() {

        //Read Write Lock
        // When write locks happens it wont allow any read and
        // all reads threads have to wait until write locks open
        // multiple threads can read through their read locks without waiting or blocking each other.

        var readwriteLock = new ReentrantReadWriteLock();

        var executor = Executors.newFixedThreadPool(2);
        var map = new HashMap<>();

        executor.submit(() -> {

            //write lock
            readwriteLock.writeLock().lock();

            try {
                sleep(1);
                map.put("foo", "bar");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //unlock write lock.
                readwriteLock.writeLock().unlock();
            }
        });

        Runnable readTask = () -> {

            //lock it.
            readwriteLock.readLock().lock();
            try {
                var res = map.get("foo");
            } finally {
                // release
                readwriteLock.readLock().unlock();
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
    }

    public void doStampedLock() {

        // Stamped Lock : Java 8 +
        // supports Read and Write lock.
        // returns stamps by "long" value.
        // we need to use Stamp to release lock or to check if lock is valid.
        // Apart from RW Lock it does Optimistic lock.

        // Stamped locks don’t implement reentrant characteristics
        // Each call to lock returns new stamp and blocks if no locks available.
        // despite previously locked by same thread.
        // we have to make sure its not deadlock.


        // RW lock with StampedLock.

        var stampedLock = new StampedLock();

        var executor = Executors.newFixedThreadPool(2);
        var map = new HashMap<>();


        executor.submit(() -> {
            //write lock
            var stamp = stampedLock.writeLock();

            try {
                sleep(1);
                map.put("foo", "bar");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //unlock write lock.
                stampedLock.unlockWrite(stamp);
            }
        });


        // Reads
        Runnable readTask = () -> {
            //lock it.
            var stamp = stampedLock.readLock();
            try {
                var res = map.get("foo");
            } finally {
                // release
                stampedLock.unlockRead(stamp);
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);


        //optimistic lock

        executor.submit(() -> {

            //Optimistic Read Lock acquired
            // returns stamp w/o blocking thread no matter if Lock is actually available
            // when in between when write lock becomes active then stamp = 0
            // Also read lock does not block write lock to be acquired unlik RW lock
            // but after write lock acquired and later release , read lock remains invalid.
            // we have to validate lock always for any shared variables.

            var optStamp = stampedLock.tryOptimisticRead();

            try {
                //validating stamp.
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
            //write lock
            var stamp = stampedLock.writeLock();

            try {
                sleep(2);
                map.put("foo", "bar");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //unlock write lock.
                stampedLock.unlock(stamp);
            }
        });

    }

    public void doSemaphores() {

        // Semaphores
        // whereas locks usually grant exclusive access to variable or resources.
        // Semaphores maintain whole set of permits.
        // It basically limits access to long running task.

        var executor = Executors.newFixedThreadPool(10);

        // Semaphore with limit to 5 only..
        var semaphoreLock = new Semaphore(5);

        Runnable longRunningTask = () -> {
            var permits = false;

            try {
                permits = semaphoreLock.tryAcquire(1, TimeUnit.SECONDS);

                if (permits){
                    // semaphore acquired..
                    sleep(5);
                }
                // else not acquired.
            }
            catch (Exception e){
                //
            }
            finally {
                if (permits){
                    semaphoreLock.release();
                }
            }
        };

        //Executing 10 threads in parallel.
        // but Semaphore will limit to 5 only..
        IntStream.range(0, 10)
                .forEach(i -> executor.submit(longRunningTask));



    }
}
