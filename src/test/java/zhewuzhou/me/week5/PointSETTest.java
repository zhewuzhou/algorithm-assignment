package zhewuzhou.me.week5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PointSETTest {
    @Test
    public void should_work_out_closest_point() {
        PointSET pointSET = new PointSET();

        for (int i = 1; i < 10000; i++) {
            pointSET.insert(new Point2D(i, i));
        }

        assertThat(pointSET.contains(new Point2D(100, 100)), is(true));
        assertThat(pointSET.nearest(new Point2D(0, 0)), is(new Point2D(1, 1)));
        assertThat(pointSET.nearest(new Point2D(100, 102)), is(new Point2D(101, 101)));
        Iterable<Point2D> pointsInRange = pointSET.range(new RectHV(500, 400, 600, 800));
        int count = 0;
        for (Point2D point2D : pointsInRange) {
            count++;
        }
        assertThat(count, is(101));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_add_null() {
        PointSET pointSET = new PointSET();
        pointSET.insert(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_contains_null() {
        PointSET pointSET = new PointSET();
        pointSET.contains(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_nearest_null() {
        PointSET pointSET = new PointSET();
        pointSET.nearest(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_range_null() {
        PointSET pointSET = new PointSET();
        pointSET.range(null);
    }

}
