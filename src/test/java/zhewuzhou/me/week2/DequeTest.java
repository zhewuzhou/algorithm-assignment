package zhewuzhou.me.week2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DequeTest {

    @Test
    public void should_be_able_to_add_first() {
        Deque<Integer> deque = new Deque<Integer>();

        deque.addFirst(1);

        assertThat(deque.isEmpty(), is(false));
        assertThat(deque.size(), is(1));
    }

    @Test
    public void should_be_able_to_add_last() {
        Deque<Integer> deque = new Deque<Integer>();

        deque.addLast(1);

        assertThat(deque.isEmpty(), is(false));
        assertThat(deque.size(), is(1));
    }

    @Test
    public void should_be_able_remove_by_add_first() {
        Deque<Integer> deque = new Deque<Integer>();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);

        Integer last = deque.removeLast();
        Integer first = deque.removeFirst();

        assertThat(last, is(1));
        assertThat(first, is(4));
    }

    @Test
    public void should_be_able_remove_by_add_last() {
        Deque<Integer> deque = new Deque<Integer>();

        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);

        Integer last = deque.removeLast();
        Integer first = deque.removeFirst();

        assertThat(last, is(4));
        assertThat(first, is(1));
    }

    @Test
    public void should_be_able_remove_by_add_last_mixed() {
        Deque<Integer> deque = new Deque<Integer>();

        for (int i = 0; i < 1024; i++) {
            deque.addFirst(i);
        }
        for (int j = 1024; j < 2048; j++) {
            deque.addLast(j);
        }
        for (int k = 2048; k < 3096; k++) {
            deque.addFirst(k);
        }

        Integer last = deque.removeLast();
        Integer first = deque.removeFirst();

        assertThat(last, is(2047));
        assertThat(first, is(3095));

        for (int p = 0; p < 1500; p++) {
            deque.removeLast();
        }
        assertThat(deque.removeLast(), is(477));

        for (int q = 0; q < 1300; q++) {
            deque.removeFirst();
        }
        assertThat(deque.removeFirst(), is(770));
        assertThat(deque.size(), is(292));
    }
}

