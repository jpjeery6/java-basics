import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCreation {
    // Create a custom thread class by extending Thread class and override the run method
    static class MyThread extends Thread {
        public void run() {
            System.out.println("MyThread running: " + getName());
        }
    }

    // Runnable are tasks that can be submitted to threads
    static class MyRunnable implements Runnable {
        public void run() {
            System.out.println("MyRunnable running: " + Thread.currentThread().getName());
        }
    }

    /**
     * In this example we create 4 threads
     * following 2 techniques
     * 1. creating a Thread by extending the Thread class and overriding the run method
     * 2. create a runnable(task) implementing the run method and then pass it to a thread during creation
     * 3. executor service running a single threaded pool
     * @param args
     */
    public static void main(String[] args) {
        // 1. create a thread - by anonymous class overriding run method
        Thread t1 = new Thread() {
            public void run() {
                System.out.println("Running from " + getName());
            }
        };

        // 2. create a runnable task and pass it to thread
        Runnable task = () -> {
            System.out.println("Hello from runnable task: " + Thread.currentThread().getName());
        };
        // pass to thread
        Thread t2 = new Thread(task);

        // 3. create custom thread directly
        MyThread t3 = new MyThread();

        // 4. create custom thread and pass to thread
        MyRunnable r1 = new MyRunnable();
        Thread t4 = new Thread(r1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // 5. via executor service - single thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(task);
        // program won't finish if we don't shutdown
        executorService.shutdown();

    }
}
