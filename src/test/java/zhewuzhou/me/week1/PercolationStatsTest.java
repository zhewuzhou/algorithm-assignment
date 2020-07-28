package zhewuzhou.me.week1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PercolationStatsTest {
    @Test
    public void should_calculate_confidence_range_for_given_percolation() {
        PercolationStats percolationStats = new PercolationStats(100, 100);

        assertThat(percolationStats.mean() > 0, is(true));
    }
}
