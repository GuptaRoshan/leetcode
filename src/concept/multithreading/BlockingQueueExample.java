package concept.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args) {

        /**
         A BlockingQueue in Java is a queue that supports operations that wait for the queue to become
         non-empty when retrieving an element or wait for space to become available in the queue when adding an element.

         The key feature of a BlockingQueue is its ability to block or wait for certain conditions to be satisfied,
         making it a useful tool for producer-consumer scenarios or any situation where threads need to
         communicate and coordinate their work.

         Some common implementations of the BlockingQueue interface include
         LinkedBlockingQueue, ArrayBlockingQueue, PriorityBlockingQueue, and DelayQueue.
         **/

        // Create a LinkedBlockingQueue with a maximum capacity of 3
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(3);

        // Create a producer thread using runnable function interface
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    String item = "Item " + i;
                    blockingQueue.put(item); // Blocking call if the queue is full
                    System.out.println("Produced: " + item);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Create a consumer thread using runnable function interface
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    String item = blockingQueue.take(); // Blocking call if the queue is empty
                    System.out.println("Consumed: " + item);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the producer and consumer threads
        producer.start();
        consumer.start();
    }
}
