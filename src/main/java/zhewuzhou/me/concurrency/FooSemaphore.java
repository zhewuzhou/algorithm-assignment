package zhewuzhou.me.concurrency;

import java.util.concurrent.Semaphore;

public class FooSemaphore {
    private final Semaphore run2 = new Semaphore(0);
    private final Semaphore run3 = new Semaphore(0);

    public FooSemaphore() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        run2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        run2.acquire();
        printSecond.run();
        run3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        run3.acquire();
        printThird.run();
    }
}
