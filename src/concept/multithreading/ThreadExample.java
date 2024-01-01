package concept.multithreading;

class ThreadExample extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running : " + Thread.currentThread().getId());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class ThreadExampleRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running : " + Thread.currentThread().getId());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class TestThread {
    public static void main(String[] args) {
        Thread threadExample = new ThreadExample();
        threadExample.start();

        Thread runnable = new Thread(new ThreadExampleRunnable());
        //Thread runnable = new Thread(() -> System.out.println("Thread is running : " + Thread.currentThread().getId()));
        runnable.start();
    }
}