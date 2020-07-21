package zhewuzhou.me.concurrency;


import java.util.List;

import static java.util.List.of;

public class FooBar {
    private int n;
    private volatile Boolean fooTurn = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (true) {
                if (fooTurn) {
                    printFoo.run();
                    fooTurn = false;
                    break;
                }
                Thread.sleep(1);
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (true) {
                if (!fooTurn) {
                    printBar.run();
                    fooTurn = true;
                    break;
                }
                Thread.sleep(1);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar foobar = new FooBar(10);
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

