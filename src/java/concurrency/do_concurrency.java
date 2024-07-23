package aa_learning.java.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class do_concurrency {

    // Concurrency API developed to avoid directly working with Thread class.
    // ExecutorService is a concept of concurrency API

    // Executors are factory method to create different kind of ExecSvc.
    // Executors can run task Asyn and maintain Thread pool and thread will be reused from the pool.
    // ExeSvc needs to stop by shutdown() as it wont otherwise.

    // ref https://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/


    public void do1() throws InterruptedException {

        // Simple Thread level method.
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done");

        //        Hello Thread-0
        //        Done


        //Executors or  ExecSvc

        //create new single thread pool executor to run it.
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(task); // submit does not wait for task to complete.


        executor.shutdown();// must to do stop else its keep running
        executor.awaitTermination(5, TimeUnit.SECONDS); // give 5 sec to task to finish after that it will force to shut.
        executor.shutdownNow(); //immidately shuts.

    }

    public void do2() throws Exception {

        // Callable Task AND future return type.
        Callable<String> callableTask = () -> {
            return "Tejpal";
        };

        // 2 threads of  pool created by executors.
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> future = executor.submit(callableTask);// return future as task wont be finished right away

        var a = future.isDone();
        var res = future.get();//blocks thread till callable task completes.
        // executor.shutdownNow(); shutting executor will fail and throw exception while waiting result from callable.

        var resTimout = future.get(2, TimeUnit.SECONDS);// max wait 2 sec to allow callable to finish its task else throw timeout exception.


    }

    public void do3() throws Exception {

        //Batch submit.


        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2"
        );

        // ForkJoinPool type of executors.
        // created for parallelism size based on no of cpu cores.
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

        // works differently as it blocks thread until first callable give result back.
        var result = executor.invokeAny(callables);


        //various Executors.
        var scheduleExe = Executors.newScheduledThreadPool(1);
        //scheduleExe.scheduleWithFixedDelay(task,0,1,TimeUnit.values();

        var exc = Executors.newCachedThreadPool();
    }

    public void do4() throws ExecutionException, InterruptedException {

        // completableFuture.. Java 8 +
        // 50 methods to support async via composing , combining and executing
        // completablefuture can be used as simple future return type with Executor.
        // Although Executor + CompletableFuture as future it is lot of code.
        // Instead use runAsync and supplyAsynch methods of CF.
        // Runnable interface is the same old interface that is used in threads and it does not allow to return a value
        // Supplier interface is a generic functional interface with a single method that has no arguments and returns a value of a parameterized type
        //The methods without the Async postfix run the next execution stage using a calling thread.
        // In contrast, the Async method without the Executor argument runs a step using the common fork/join pool


        // CF
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");

        //CF append another one.
        var appendAnotherCF = completableFuture.thenApply(s -> s + "India");
        // Hello India

        // CF stop chaining
        var finalCF = completableFuture.thenAccept(s -> s.toUpperCase());//this method receives a Consumer and passes it the result of the computation
        var finalres = finalCF.get(); //final res based on final CF


        // NO input and NO output at end of chain level then just i.e. use Runnable just run and forget.

        var runnableCF = CompletableFuture.supplyAsync(() -> "Just run");
        var anotherRunCF = runnableCF.thenRun(() -> System.out.println("something"));
        anotherRunCF.get();


        //thenCompose () method to chain two Futures sequentially
        var composedCF = CompletableFuture.supplyAsync(() -> "a")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "b"));

        var r = composedCF.get(); // a b

        // thencompose = flatmap (eceives a function that returns another object of the same type.)
        // thenapply = map
        // both together can build blocks for async


        //thenCombine ()  when execute 2 CF independently but then do sth with their result
        var combineCF = CompletableFuture.supplyAsync(() -> "A")
                .thenCombine(
                        CompletableFuture.supplyAsync(() -> "B"),
                        (p, q) -> p + q
                );
        var rescombindCF = combineCF.get(); // A B


    }

    public void do5() {

        // Multiple CF in parallel.

        //Problem
        //When we need to execute multiple Futures in parallel,
        // we usually want to wait for all of them to execute and
        // then process their combined results

        //Solution:
        // CompletableFuture.allOf ()  allows to wait for completion of all futures.


        var cf1 = CompletableFuture.supplyAsync(() -> "Hello");
        var cf2 = CompletableFuture.supplyAsync(() -> "USA");

        // But it is void so we need to get result individualy by get()
        var allofCF = CompletableFuture.allOf(cf1, cf2);
        var a = cf1.isDone();
        var b = cf2.isDone();

        // Fix : use join()
        // join() method is similar to the get method,
        // but it throws an unchecked exception in case the Future does not complete normally
        var joined = Stream.of(cf1, cf2).map(CompletableFuture::join)
                .collect(Collectors.joining(" ")); // prints Hello USA


        // Errors
        String name = null;
        var handlerror = CompletableFuture.supplyAsync(
                        () -> {
                            if (name == null) {
                                throw new RuntimeException("Computation error!");
                            }
                            return "Hello, " + name;
                        }).
                handle((res, err) -> res != null ? res : "default result" + err.getMessage());

    }

    public void do6() {
        // ForkJoin pools works on work stealing z_old_dsalog.do_ds.algorithm
        // i.e. Free threads try to steal work from dequeue of busy threads.
        // it reduced waiting time for thread to get work.

        // how it works ? First fork break task in to smaller independent subtask until they can be executed async
        // then join will join result of all subtask in to single result.

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };


        //provide a reference to the common pool, which is a default thread pool for every ForkJoinTask
        var commonFJpool = ForkJoinPool.commonPool();

        //submit task to pool via

        commonFJpool.execute(task);
        commonFJpool.submit(task);

        //method forks the task and waits for the result
        // doesn’t need any manual joining
        //var cfinvoke = commonFJpool.invoke(task);

        //method submit a sequence of ForkJoinTasks to the ForkJoinPool
        //var cfinvokeall= commonFJpool.invokeAll(tasks);

        // Note:
        // Alternatively, you can use separate fork() and join() methods.
        // The fork() method submits a task to a pool,
        // but it doesn't trigger its execution.
        // The join() method must be used for this purpose


    }


}