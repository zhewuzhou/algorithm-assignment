package zhewuzhou.me.week3;

import edu.princeton.cs.algs4.Merge;

import java.util.ArrayList;

public class BruteCollinearPoints {
    private Point[] points;
    private LineSegment[] segments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        for (Point point : points) {
            if (point == null) {
                throw new IllegalArgumentException();
            }
        }
        Merge.sort(points);
        for (int i = 1; i < points.length; i++) {
            if (points[i - 1].compareTo(points[i]) == 0) {
                throw new IllegalArgumentException();
            }
        }
        this.points = points;
        calculateSegments();
    }

    public int numberOfSegments() {
        return segments.length;
    }

    public LineSegment[] segments() {
        return segments;
    }

    private void calculateSegments() {
        ArrayList<LineSegment> result = new ArrayList<LineSegment>();
        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    for (int m = k + 1; m < points.length; m++) {
                        double ijSlope = points[i].slopeTo(points[j]);
                        if (ijSlope == points[i].slopeTo(points[k]) && ijSlope == points[i].slopeTo(points[m])) {
                            result.add(new LineSegment(points[i], points[m]));
                        }
                    }
                }
            }
        }
        this.segments = result.toArray(new LineSegment[result.size()]);
    }
}
