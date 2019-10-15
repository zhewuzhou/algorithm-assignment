package zhewuzhou.me.week5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

import java.util.ArrayList;

public class PointSET {
    private SET<Point2D> points = new SET<>();

    public PointSET() {
    }

    public boolean isEmpty() {
        return points.isEmpty();
    }

    public int size() {
        return points.size();
    }

    public void insert(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Can not add null to points set.");
        }
        this.points.add(p);
    }

    public boolean contains(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Null is invalid to be able to say if contains");
        }
        return points.contains(p);
    }

    public void draw() {
        for (Point2D p : points) {
            p.draw();
        }
    }

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new IllegalArgumentException("range() is called with null object");
        }
        ArrayList<Point2D> result = new ArrayList<>();
        for (Point2D p : points) {
            if (rect.distanceSquaredTo(p) == 0) {
                result.add(p);
            }
        }
        return result;
    }

    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("nearest() is called with null");
        }
        double minDistance = Double.MAX_VALUE;
        Point2D closestPoint = null;
        for (Point2D point : points) {
            double distance = p.distanceTo(point);
            if (distance < minDistance) {
                minDistance = distance;
                closestPoint = point;
            }
        }
        return closestPoint;
    }
}
