package zhewuzhou.me.concurrency;

import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    private volatile int cur = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (cur <= n) {
            synchronized (this) {
                if (cur % 3 == 0 && cur % 5 != 0) {
                    printFizz.run();
                    cur += 1;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (cur <= n) {
            synchronized (this) {
                if (cur % 3 != 0 && cur % 5 == 0) {
                    printBuzz.run();
                    cur += 1;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (cur <= n) {
            synchronized (this) {
                if (cur % 15 == 0) {
                    printFizzBuzz.run();
                    cur += 1;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (cur <= n) {
            synchronized (this) {
                if (cur % 3 != 0 && cur % 5 != 0) {
                    printNumber.accept(cur);
                    cur += 1;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }
}
