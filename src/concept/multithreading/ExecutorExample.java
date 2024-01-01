package concept.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*----------------------------------ExecutorService---------------------------------- */

        /**
         Thread pool is a software design pattern that maintains multiple threads waiting for tasks to be allocated
         for concurrent execution.

         The following line of code will create a thread pool with 10 threads
         **/
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //Runnable Task
        Runnable runnableTask = () -> System.out.println("runnableTask");
        //Calling Runnable Task
        executorService.execute(runnableTask);

        //Callable Task
        Callable<String> callableTask = () -> "callableTask";

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        //Calling Callable Task
        Future<String> future = executorService.submit(callableTask);

        try {
            String result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        /** The ScheduledExecutorService runs tasks after some predefined delay and/or periodically. **/

        // ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        //Future<String> resultFuture = scheduledExecutorService.schedule(callableTask, 1, TimeUnit.SECONDS);


        /*----------------------------------------CompletableFuture------------------------------------- */

        /**
         CompletableFuture is used for asynchronous programming in Java.
         Asynchronous programming is a means of writing non-blocking code by running a task on a
         separate thread than the main application thread and notifying the main thread about its progress,
         completion or failure.
         **/

        CompletableFuture<String> completableFuture0 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> completableFuture01 = completableFuture0.thenApply(s -> s + " World");
        System.out.println(completableFuture01.get());


        /**
         Let's consider a real-time example to illustrate the usage of CompletableFuture.
         Suppose you want to fetch data from two different sources asynchronously and then combine the results. In this example,
         we'll use a hypothetical scenario where you want to fetch weather information and news headlines asynchronously.
         **/

        // Fetch weather information asynchronously
        CompletableFuture<String> weatherFuture = CompletableFuture.supplyAsync(() -> {
            // Simulating fetching weather information from an external service
            return "Sunny";
        });

        // Fetch news headlines asynchronously
        CompletableFuture<String> newsFuture = CompletableFuture.supplyAsync(() -> {
            // Simulating fetching news headlines from an external service
            return "Breaking: Important News";
        });

        // Combine results when both tasks are complete
        CompletableFuture<Void> combinedFuture = weatherFuture.thenCombine(newsFuture, (weather, news) -> {
                    // Combine the results
                    return "Weather: " + weather + "\nNews: " + news;
                })

                .thenAcceptAsync(combinedResult -> {
                    // Process the combined result (in this case, just print it)
                    System.out.println("Combined Result:\n" + combinedResult);
                });

        // Ensure the program doesn't exit before the asynchronous computations are complete
        combinedFuture.join();

    }
}
