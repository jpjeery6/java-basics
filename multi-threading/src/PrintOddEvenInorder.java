public class PrintOddEvenInorder {

    static class Number {
        int limit = 100;
        Number(int limit) {
            this.limit = limit;
        }
        int i = 1;
        // multiple threads are accessing i
        // access to i should be synchronized
        // synchronized always uses a Object level lock
        // here the lock is taken Number object

        /**
         * Every object in java has a unique lock. If a thread wants to execute a synchronized method on the given object. First, it has to get a lock of that object. Once the thread got the lock then it is allowed to execute any synchronized method on that object. Once method execution completes automatically thread releases the lock.
         *
         */
        synchronized void printEven() throws InterruptedException {
            while (i<=limit) {
                // wait till other thread has incremented i from odd to even
                while (i%2==0) {
                    wait();
                }
                System.out.println(i);
                i++;
                notify();
            }
        }

        synchronized void printOdd() throws InterruptedException {
            while (i<=limit) {
                // wait till other thread has incremented i from even to odd
                while (i%2==1) {
                    wait();
                }
                System.out.println(i);
                i++;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        int limit = 50;
        Number number = new Number(50);

        Thread t1 = new Thread() {
            public void run() {
                try {
                    number.printOdd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                try {
                    number.printEven();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        t1.start();
        t2.start();

    }
}
