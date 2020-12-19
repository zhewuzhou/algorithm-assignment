package zhewuzhou.me.concurrency;

import java.util.Vector;

/**
 * Even for Vector: the add/remove/get all of the methods protected by synchronized
 * It's still important to do sync stuff in call side
 * Exception in thread "Thread-132" java.lang.ArrayIndexOutOfBoundsException:
 * It might be the situation of: i is removed mean while it using by another thread
 */
public class ThreadExamples {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread removedThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < vector.size(); j++) {
                        vector.remove(j);
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int k = 0; k < vector.size(); k++) {
                        System.out.println(vector.get(k));
                    }
                }
            });

            removedThread.start();
            printThread.start();
            while (Thread.activeCount() > 20) ;
        }
    }
}
