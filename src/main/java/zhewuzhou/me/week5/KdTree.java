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
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void insert(Point2D p) {
        checkInput(p);
        KdNode current, prev;
        if (null == this.root) {
            this.root = new KdNode(p, new RectHV(0, 0, 1, 1), Orientation.VERTICAL);
            this.size++;
        } else {
            current = this.root;
            prev = this.root;
            while (null != current) {
                if (current.point.equals(p)) {
                    return;
                }
                prev = current;
                if (current.isRightOrTopOf(p)) {
                    current = current.leftBottom;
                } else {
                    current = current.rightTop;
                }
            }
            if (prev.isRightOrTopOf(p)) {
                prev.leftBottom = new KdNode(p, prev.rectLeftOrBottom(), prev.next());
                this.size++;
            } else {
                prev.rightTop = new KdNode(p, prev.rectRightOrTop(), prev.next());
                this.size++;
            }
        }
    }

    public boolean contains(Point2D p) {
        KdNode current = this.root;
        while (null != current) {
            if (current.point.equals(p)) {
                return true;
            }
            if (current.isRightOrTopOf(p)) {
                current = current.leftBottom;
            } else {
                current = current.rightTop;
            }
        }
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


    private void checkInput(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Can't insert null point");
        }
    }
}
