package zhewuzhou.me.week5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class KdTree {
    private KdNode root;
    private int size = 0;

    private enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    private class KdNode {
        private Orientation orientation;
        private RectHV nodeRect;
        private Point2D point;
        private KdNode leftBottom;
        private KdNode rightTop;

        public KdNode(Point2D point, RectHV nodeRect, Orientation orientation) {
            this.orientation = orientation;
            this.nodeRect = nodeRect;
            this.point = point;
        }

        public boolean isRightOrTopOf(Point2D p) {
            if (orientation == Orientation.VERTICAL) {
                return point.x() > p.x();
            } else {
                return point.y() > p.y();
            }
        }

        public Orientation next() {
            if (orientation == Orientation.VERTICAL) {
                return Orientation.HORIZONTAL;
            }
            return Orientation.VERTICAL;
        }

        public RectHV rectLeftOrBottom() {
            if (orientation == Orientation.VERTICAL) {
                return new RectHV(nodeRect.xmin(), nodeRect.ymin(), point.x(), nodeRect.ymax());
            }
            return new RectHV(nodeRect.xmin(), nodeRect.ymin(), nodeRect.xmax(), point.y());
        }

        public RectHV rectRightOrTop() {
            if (orientation == Orientation.VERTICAL) {
                return new RectHV(point.x(), nodeRect.ymin(), nodeRect.xmax(), nodeRect.ymax());
            }
            return new RectHV(nodeRect.xmin(), point.y(), nodeRect.xmax(), nodeRect.ymax());
        }
    }

    public KdTree() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(Point2D p) {

    }

    public boolean contains(Point2D p) {
        return false;
    }

    public void draw() {

    }

    public Iterable<Point2D> range(RectHV rect) {
        return null;
    }

    public Point2D nearest(Point2D p) {
        return null;
    }
}
