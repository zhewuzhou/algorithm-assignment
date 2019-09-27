package zhewuzhou.me;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PercolationStatsTest {
    @Test
    public void should_calculate_confidence_range_for_given_percolation() throws Exception {
        PercolationStats percolationStats = new PercolationStats(100, 100);

        assertThat(percolationStats.mean() > 0, is(true));
    }
}
