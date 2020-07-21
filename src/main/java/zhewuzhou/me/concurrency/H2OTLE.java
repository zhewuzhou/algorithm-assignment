package zhewuzhou.me.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class H2OTLE {
    private Lock lock = new ReentrantLock();
    private Condition hydrogenReleased = lock.newCondition();
    private Condition oxygenReleased = lock.newCondition();
    private int hydrogenCount = 0;

    public H2OTLE() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        try {
            lock.lock();
            while (hydrogenCount == 2) {
                hydrogenReleased.await();
            }
            releaseHydrogen.run();
            hydrogenCount += 1;
            oxygenReleased.signal();
        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        try {
            lock.lock();
            while (hydrogenCount < 2) {
                oxygenReleased.await();
            }
            releaseOxygen.run();
            hydrogenCount = 0;
            hydrogenReleased.signal();
        } finally {
            lock.unlock();
        }
    }
}
