package zhewuzhou.me;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PercolationTest {
    @Test
    public void should_open_site() throws Exception {
        Percolation percolation = new Percolation(3);
        percolation.open(0, 1);
        percolation.open(1, 0);
        percolation.open(1, 2);
        percolation.open(2, 1);
        percolation.open(2, 1);

        assertThat(percolation.isOpen(0, 1), is(true));
        assertThat(percolation.isOpen(1, 0), is(true));
        assertThat(percolation.isOpen(1, 2), is(true));
        assertThat(percolation.isOpen(2, 1), is(true));
    }

    @Test
    public void should_connect_when_open_site() throws Exception {
        Percolation percolation = new Percolation(3);
        percolation.open(0, 1);
        percolation.open(1, 0);
        percolation.open(1, 1);
        percolation.open(1, 2);
        percolation.open(2, 1);

        assertThat(percolation.isFull(2, 1), is(true));
        assertThat(percolation.numberOfOpenSites(), is(5));
        assertThat(percolation.percolates(), is(true));
    }

}
