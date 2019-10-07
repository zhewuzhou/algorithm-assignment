package zhewuzhou.me.week3;

import org.junit.Test;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PointTest {
    @Test
    public void should_compare_points() {
        Point middle = new Point(1, 2);
        Point largeV1 = new Point(0, 3);
        Point largeV2 = new Point(2, 2);
        Point smallV1 = new Point(1, 1);
        Point smallV2 = new Point(0, 2);

        assertThat(middle.compareTo(middle), is(0));
        assertThat(largeV1.compareTo(middle), is(1));
        assertThat(largeV2.compareTo(middle), is(1));
        assertThat(smallV1.compareTo(middle), is(-1));
        assertThat(smallV2.compareTo(middle), is(-1));
    }

    @Test
    public void should_slope_points() {
        Point middle = new Point(1, 2);
        Point normal = new Point(2, 3);
        Point vertical = new Point(1, 3);
        Point horizontal = new Point(3, 2);

        assertThat(middle.slopeTo(normal), is(1D));
        assertThat(middle.slopeTo(middle), is(NEGATIVE_INFINITY));
        assertThat(middle.slopeTo(vertical), is(POSITIVE_INFINITY));
        assertThat(middle.slopeTo(horizontal), is(0D));
    }

    @Test
    public void should_negative_zero() {
        Point p = new Point(9, 9);
        Point q = new Point(2, 9);

        assertThat(p.slopeTo(q), is(0.0));
    }

    @Test
    public void should_compare_with_comparator() {
        Point p = new Point(7, 6);
        Point q = new Point(3, 6);
        Point r = new Point(8, 6);

        assertThat(p.slopeOrder().compare(q, r), is(0));
    }
}
