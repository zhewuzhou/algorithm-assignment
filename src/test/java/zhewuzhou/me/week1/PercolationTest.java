package zhewuzhou.me.week1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PercolationTest {
    @Test
    public void should_open_site() {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 2);
        percolation.open(2, 1);
        percolation.open(2, 3);
        percolation.open(3, 2);
        percolation.open(3, 2);

        assertThat(percolation.isOpen(1, 2), is(true));
        assertThat(percolation.isOpen(2, 1), is(true));
        assertThat(percolation.isOpen(2, 3), is(true));
        assertThat(percolation.isOpen(3, 2), is(true));
    }

    @Test
    public void should_connect_when_open_site() {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 2);
        percolation.open(2, 1);
        percolation.open(2, 2);
        percolation.open(2, 3);
        percolation.open(3, 2);

        assertThat(percolation.isFull(3, 2), is(true));
        assertThat(percolation.numberOfOpenSites(), is(5));
        assertThat(percolation.percolates(), is(true));
    }

    @Test
    public void should_test_is_full() {
        Percolation percolation = new Percolation(10);

        percolation.open(1, 10);

        assertThat(percolation.isFull(1, 10), is(true));
    }

    @Test
    public void test_edge_case() {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 3);
        percolation.open(2, 1);

        assertThat(percolation.isFull(2, 1), is(false));
    }
}
