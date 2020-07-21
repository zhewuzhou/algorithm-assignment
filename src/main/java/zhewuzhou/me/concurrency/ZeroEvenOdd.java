package zhewuzhou.me.concurrency;

import java.util.List;
import java.util.function.IntConsumer;

import static java.util.List.of;

public class ZeroEvenOdd {
    private int n;
    private boolean isZero = true;
    private boolean isOdd = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (!isZero) {
                    wait();
                }
                printNumber.accept(0);
                isZero = false;
                notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            synchronized (this) {
                while (isZero || isOdd) {
                    wait();
                }
                printNumber.accept(i);
                isZero = true;
                isOdd = true;
                notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            synchronized (this) {
                while (isZero || !isOdd) {
                    wait();
                }
                printNumber.accept(i);
                isZero = true;
                isOdd = false;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(11);
        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        List<Thread> threads = of(t1, t2, t3);
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
