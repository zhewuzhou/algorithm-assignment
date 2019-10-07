package zhewuzhou.me.week3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FastCollinearPointsTest {
    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_null_point() {
        Point[] points = new Point[101];
        for (int i = 0; i < 100; i++) {
            points[i] = new Point(i, i);
        }
        points[100] = null;

        new FastCollinearPoints(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_repeated_point() {
        Point[] points = new Point[101];
        for (int i = 0; i < 100; i++) {
            points[i] = new Point(i, i);
        }
        points[100] = points[50];

        new FastCollinearPoints(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_array_null() {
        new FastCollinearPoints(null);
    }

    @Test
    public void should_calculate_line_segment_brute_very_simple_case() {
        ArrayList<Point> container = new ArrayList<Point>();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 4; j++) {
                Point p = new Point(j, i * j);
                container.add(p);
            }
        }
        Point[] points = container.toArray(new Point[12]);
        FastCollinearPoints fastCollinearPoints = new FastCollinearPoints(points);

        assertThat(fastCollinearPoints.numberOfSegments(), is(3));
    }

    @Test
    public void should_calculate_line_segment_brute_complicated_case() {
        ArrayList<Point> container = new ArrayList<Point>();
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                Point point = new Point(i, j);
                container.add(point);
            }
        }
        Point[] points = container.toArray(new Point[12]);
        FastCollinearPoints fastCollinearPoints = new FastCollinearPoints(points);
        LineSegment[] segments = fastCollinearPoints.segments();
        List<LineSegment> list = Arrays.asList(segments);
        ArrayList<String> toStrings = new ArrayList<String>();
        for (LineSegment ls : list) {
            toStrings.add(ls.toString());
            System.out.print(ls.toString());
        }


        assertThat(fastCollinearPoints.numberOfSegments(), is(10));
    }
}
