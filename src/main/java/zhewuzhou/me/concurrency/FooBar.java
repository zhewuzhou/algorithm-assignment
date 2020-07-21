package zhewuzhou.me.concurrency;


import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.List.of;

public class FooBar {
    private int n;
    private Lock lock = new ReentrantLock();
    private Boolean fooTurn = true;

    private Condition fooCond = lock.newCondition();
    private Condition barCond = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (!fooTurn) {
                    fooCond.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooTurn = false;
                barCond.signalAll();
            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (fooTurn) {
                    barCond.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooTurn = true;
                fooCond.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar foobar = new FooBar(20);
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

