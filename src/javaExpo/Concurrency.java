package javaExpo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concurrency {


// The Concurrency API was developed to avoid directly working with the Thread class.
// ExecutorService is a concept of the Concurrency API.

// Executors are factory methods that create different kinds of ExecutorServices.
// Executors can run tasks asynchronously and maintain a thread pool, reusing threads from the pool.
// ExecutorServices need to be stopped by calling shutdown(), otherwise they will keep running.

    /**
     * This method demonstrates the use of ExecutorService to run a simple task.
     * It first runs the task directly, then runs it in a new thread, and finally runs it using an ExecutorService.
     *
     * @throws InterruptedException if the current thread was interrupted while waiting
     */
    public void do1() throws InterruptedException {
        // Simple thread-level method.
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done");

        // Executors or ExecutorService

        // Create a new single-thread pool executor to run it.
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(task); // Submit does not wait for the task to complete.

        executor.shutdown(); // Must stop, else it keeps running.
        executor.awaitTermination(5, TimeUnit.SECONDS); // Give 5 seconds for the task to finish, after that it will force a shutdown.
        executor.shutdownNow(); // Immediately shuts down.
    }

    /**
     * This method demonstrates the use of Callable with ExecutorService.
     * It creates a Callable task and submits it to the ExecutorService.
     * It then retrieves the result of the task using Future.
     *
     * @throws Exception if unable to compute a result
     */
    public void do2() throws Exception {
        // Callable Task AND future return type.
        Callable<String> callableTask = () -> {
            return "Tejpal";
        };

        // 2 threads of pool created by executors.
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> future = executor.submit(callableTask); // Return future as task won't be finished right away.

        var a = future.isDone();
        var res = future.get(); // Blocks thread until callable task completes.
        // executor.shutdownNow(); shutting executor will fail and throw exception while waiting result from callable.

        var resTimeout = future.get(2, TimeUnit.SECONDS); // Max wait 2 seconds to allow callable to finish its task else throw timeout exception.
    }

    /**
     * This method demonstrates the use of invokeAll and invokeAny with ExecutorService.
     * It creates a list of Callable tasks and submits them to the ExecutorService.
     * It then retrieves the results of the tasks using Future.
     *
     * @throws Exception if unable to compute a result
     */
    public void do3() throws Exception {
        // Batch submit.

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2"
        );

        // ForkJoinPool type of executors.
        // Created for parallelism size based on the number of CPU cores.
        var executor = Executors.newWorkStealingPool();

        executor.invokeAll(callables)
                .stream()
                .map(stringFuture -> {
                            try {
                                return stringFuture.get();

                            } catch (Exception e) {
                                throw new IllegalStateException(e);
                            }
                        }

                )
                .forEach(System.out::println);

        // Works differently as it blocks thread until first callable gives result back.
        var result = executor.invokeAny(callables);

        // Various Executors.
        var scheduleExe = Executors.newScheduledThreadPool(1);
        // scheduleExe.scheduleWithFixedDelay(task,0,1,TimeUnit.values();

        var exc = Executors.newCachedThreadPool();
    }

    /**
     * This method demonstrates the use of CompletableFuture.
     * It creates a CompletableFuture and performs various operations on it such as thenApply, thenAccept, thenRun, thenCompose, thenCombine.
     *
     * @throws ExecutionException   if the computation threw an exception
     * @throws InterruptedException if the current thread was interrupted while waiting
     */
    public void do4() throws ExecutionException, InterruptedException {
        // CompletableFuture.. Java 8 +
        // 50 methods to support async via composing, combining and executing.
        // CompletableFuture can be used as a simple future return type with Executor.
        // Although Executor + CompletableFuture as future it is a lot of code.
        // Instead use runAsync and supplyAsync methods of CF.
        // Runnable interface is the same old interface that is used in threads and it does not allow to return a value.
        // Supplier interface is a generic functional interface with a single method that has no arguments and returns a value of a parameterized type.
        // The methods without the Async postfix run the next execution stage using a calling thread.
        // In contrast, the Async method without the Executor argument runs a step using the common fork/join pool.

        // CF
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");

        // CF append another one.
        var appendAnotherCF = completableFuture.thenApply(s -> s + "India");
        // Hello India

        // CF stop chaining.
        var finalCF = completableFuture.thenAccept(s -> s.toUpperCase()); // This method receives a Consumer and passes it the result of the computation.
        var finalRes = finalCF.get(); // Final result based on final CF.

        // No input and no output at end of chain level then just i.e. use Runnable just run and forget.

        var runnableCF = CompletableFuture.supplyAsync(() -> "Just run");
        var anotherRunCF = runnableCF.thenRun(() -> System.out.println("something"));
        anotherRunCF.get();

        // thenCompose() method to chain two Futures sequentially.
        var composedCF = CompletableFuture.supplyAsync(() -> "a")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "b"));

        var r = composedCF.get(); // a b

        // thenCompose = flatMap (receives a function that returns another object of the same type.)
        // thenApply = map
        // Both together can build blocks for async.

        // thenCombine() when execute 2 CF independently but then do something with their result.
        var combineCF = CompletableFuture.supplyAsync(() -> "A")
                .thenCombine(
                        CompletableFuture.supplyAsync(() -> "B"),
                        (p, q) -> p + q
                );
        var resCombineCF = combineCF.get(); // A B
    }

    /**
     * This method demonstrates the use of CompletableFuture.allOf.
     * It creates multiple CompletableFutures and waits for all of them to complete.
     */
    public void do5() {
        // Multiple CF in parallel.

        // Problem:
        // When we need to execute multiple Futures in parallel,
        // we usually want to wait for all of them to execute and
        // then process their combined results.

        // Solution:
        // CompletableFuture.allOf() allows to wait for completion of all futures.

        var cf1 = CompletableFuture.supplyAsync(() -> "Hello");
        var cf2 = CompletableFuture.supplyAsync(() -> "USA");

        // But it is void so we need to get result individually by get().
        var allOfCF = CompletableFuture.allOf(cf1, cf2);
        var a = cf1.isDone();
        var b = cf2.isDone();

        // Fix: use join().
        // join() method is similar to the get method,
        // but it throws an unchecked exception in case the Future does not complete normally.
        var joined = Stream.of(cf1, cf2).map(CompletableFuture::join)
                .collect(Collectors.joining(" ")); // Prints Hello USA.

        // Errors.
        String name = null;
        var handleError = CompletableFuture.supplyAsync(
                        () -> {
                            if (name == null) {
                                throw new RuntimeException("Computation error!");
                            }
                            return "Hello, " + name;
                        }).
                handle((res, err) -> res != null ? res : "default result" + err.getMessage());
    }

    /**
     * This method demonstrates the use of ForkJoinPool.
     * It creates a simple task and runs it using ForkJoinPool.
     */
    public void do6() {
        // ForkJoin pools work on a work-stealing algorithm.
        // i.e. Free threads try to steal work from the dequeue of busy threads.
        // It reduces waiting time for a thread to get work.

        // How it works? First fork breaks the task into smaller independent subtasks until they can be executed asynchronously.
        // Then join will join the result of all subtasks into a single result.

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };
    }


}