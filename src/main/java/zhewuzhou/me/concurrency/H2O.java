package zhewuzhou.me.concurrency;

import java.util.List;

import static java.util.List.of;

public class H2O {
    private int hCount = 0;

    public H2O() {

    }

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (hCount == 2) {
            wait();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hCount += 1;
        notifyAll();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (hCount != 2) {
            wait();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hCount = 0;
        notifyAll();
    }

    public static void main(String[] args) {
        H2OTLE h2O = new H2OTLE();
        Thread t1 = new Thread(() -> {
            try {
                h2O.hydrogen(() -> System.out.println("H"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                h2O.oxygen(() -> System.out.println("O"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        List<Thread> threads = of(t1, t2);
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
