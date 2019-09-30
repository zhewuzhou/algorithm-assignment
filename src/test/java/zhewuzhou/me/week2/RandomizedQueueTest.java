package zhewuzhou.me.week2;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class RandomizedQueueTest {

    @Test
    public void should_enqueue_dequeue_1k_items_and_dequeue() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();

        for (int i = 0; i < 1024; i++) {
            queue.enqueue(i);
        }

        assertThat(queue.size(), is(1024));
        assertThat(queue.sample(), is(not(-1)));

        for (int j = 0; j < 1023; j++) {
            assertThat(queue.sample(), is(not(-1)));
            assertThat(queue.dequeue(), is(not(-1)));
        }
        queue.dequeue();
        assertThat(queue.isEmpty(), is(true));
    }
}
