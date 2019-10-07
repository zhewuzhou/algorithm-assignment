package zhewuzhou.me.week3;

import edu.princeton.cs.algs4.LinkedBag;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BruteCollinearPointsTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_null_point() {
        Point[] points = new Point[101];
        for (int i = 0; i < 100; i++) {
            points[i] = new Point(i, i);
        }
        points[100] = null;

        new BruteCollinearPoints(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_repeated_point() {
        Point[] points = new Point[101];
        for (int i = 0; i < 100; i++) {
            points[i] = new Point(i, i);
        }
        points[100] = points[50];

        new BruteCollinearPoints(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_array_null() {
        new BruteCollinearPoints(null);
    }

    @Test
    public void should_copy_linked_bag_to_array() {
        LinkedBag<Integer> integers = new LinkedBag<Integer>();
        for (int i = 0; i < 100; i++) {
            integers.add(i);
        }
        Integer[] target = new Integer[100];

        Iterator<Integer> iterator = integers.iterator();
        for (int i = 99; i >= 0; i--) {
            target[i] = iterator.next();
        }

        assertThat(target[99], is(99));
        assertThat(target[0], is(0));
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
        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);

        assertThat(bruteCollinearPoints.numberOfSegments(), is(3));
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
        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);

        assertThat(bruteCollinearPoints.numberOfSegments(), is(10));
    }
}
