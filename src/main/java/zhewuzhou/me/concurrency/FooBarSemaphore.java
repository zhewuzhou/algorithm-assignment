package zhewuzhou.me.concurrency;

import java.util.concurrent.Semaphore;

public class FooBarSemaphore {
    private final int n;
    private final Semaphore bar = new Semaphore(0);
    private final Semaphore foo = new Semaphore(1);

    public FooBarSemaphore(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }
}
