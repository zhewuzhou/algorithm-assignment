package zhewuzhou.me.concurrency;

class Foo {
    private volatile boolean first = true;
    private volatile boolean second = false;
    private volatile boolean third = false;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (true) {
            if (second) {
                printSecond.run();
                third = true;
                break;
            }
            Thread.sleep(1);
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (true) {
            if (third) {
                printThird.run();
                break;
            }
            Thread.sleep(1);
        }
    }
}
