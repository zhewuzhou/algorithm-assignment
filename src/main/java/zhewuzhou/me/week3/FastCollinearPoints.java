package zhewuzhou.me.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FastCollinearPoints {
    private static final int THRESHOLD = 4; // threshold of points number to check collinear line
    private ArrayList<LineSegment> segments;
    private Point[] sortedPoints;

    /**
     * Finds all line segments containing 4 or more points
     *
     * @param points {com.assignment3.Point[]}
     */
    public FastCollinearPoints(Point[] points) {
        Point[] aux = checkInput(points);

        int len = aux.length;
        if (len < 4) return;

        segments = new ArrayList<LineSegment>();

        for (int i = 0; i < len; i++) {
            addLines(sortedPoints, aux, i);
        }

        sortedPoints = null;
    }

    /**
     * Check input
     *
     * @param points {com.assignment3.Point[]}
     * @return {com.assignment3.Point[]} copy of points
     */
    private Point[] checkInput(Point[] points) {
        if (points == null) throw new java.lang.IllegalArgumentException();

        int len = points.length;
        Point[] aux = new Point[len];
        for (int i = 0; i < len; i++) {
            Point p = points[i];
            if (p == null) throw new java.lang.IllegalArgumentException(); // null point found
            aux[i] = p;
        }

        Arrays.sort(aux);
        sortedPoints = new Point[len];
        for (int i = 0; i < len - 1; i++) {
            Point p = aux[i];
            if (p.compareTo(aux[i + 1]) == 0) {
                throw new java.lang.IllegalArgumentException(); // repeated points found
            }
            sortedPoints[i] = p;
        }
        sortedPoints[len - 1] = aux[len - 1];
        return aux;
    }

    /**
     * Add collinear lines
     *
     * @param points    {com.assignment3.Point[]}
     * @param aux       {com.assignment3.Point[]}
     * @param originIdx {int}
     */
    private void addLines(Point[] points, Point[] aux, int originIdx) {
        Point origin = points[originIdx];
        Comparator<Point> cpt = origin.slopeOrder();
        Arrays.sort(aux, cpt); // sort based on slope
        int start;

        for (int j = 1, len = aux.length; j < len; ) {
            start = j;
            Point q = aux[j++];

            while (j < len && cpt.compare(q, aux[j]) == 0) {
                j++;
            }

            if (j - start + 1 >= THRESHOLD) {
                addLine(aux, origin, start, j - 1);
            }
        }
    }

    /**
     * Create line segment based on input points
     *
     * @param points   {ArrayList()}
     * @param origin   {com.assignment3.Point}
     * @param startIdx {int}
     * @param endIdx   {int}
     */
    private void addLine(Point[] points, Point origin, int startIdx, int endIdx) {
        Arrays.sort(points, startIdx, endIdx + 1);
        Point p1 = points[startIdx];
        if (origin.compareTo(p1) < 0) { // not added yet
            segments.add(new LineSegment(origin, points[endIdx]));
        }
    }

    /**
     * The number of line segments
     *
     * @return {int}
     */
    public int numberOfSegments() {
        return (segments != null) ? segments.size() : 0;
    }

    /**
     * The line segments
     *
     * @return {com.assignment3.LineSegment[]}
     */
    public LineSegment[] segments() {
        if (segments == null) {
            return new LineSegment[0];
        }

        LineSegment[] lines = new LineSegment[segments.size()];
        int i = 0;
        for (LineSegment line : segments) {
            lines[i++] = line;
        }
        return lines;
    }
}
