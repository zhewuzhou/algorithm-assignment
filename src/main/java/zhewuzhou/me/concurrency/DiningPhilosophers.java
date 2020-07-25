package zhewuzhou.me.concurrency;

import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
    private Semaphore maxNumber = new Semaphore(4);
    private Semaphore[] forks = new Semaphore[]{
        new Semaphore(1),
        new Semaphore(1),
        new Semaphore(1),
        new Semaphore(1),
        new Semaphore(1)
    };


    public DiningPhilosophers() {
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;
        maxNumber.acquire();
        forks[leftFork].acquire();
        forks[rightFork].acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        maxNumber.release();
        forks[leftFork].release();
        forks[rightFork].release();
    }
}
