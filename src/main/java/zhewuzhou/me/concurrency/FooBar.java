package zhewuzhou.me.concurrency;


import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.util.List.of;

public class FooBar {
    private int n;
    private AtomicBoolean fooTurn = new AtomicBoolean(true);
    private AtomicBoolean barTurn = new AtomicBoolean(false);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!fooTurn.compareAndSet(true, false)) {
                Thread.sleep(1);
            }
            printFoo.run();
            barTurn.set(true);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!barTurn.compareAndSet(true, false)) {
                Thread.sleep(1);
            }
            printBar.run();
            fooTurn.set(true);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBarSemaphore foobar = new FooBarSemaphore(2);
        Thread foo = new Thread(() -> {
            try {
                foobar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread bar = new Thread(() -> {
            try {
                foobar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        List<Thread> threads = of(foo, bar);
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
    }
}

