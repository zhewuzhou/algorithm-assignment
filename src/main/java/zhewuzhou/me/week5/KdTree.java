package zhewuzhou.me.week5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;

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
        draw(root);
    }

    public Iterable<Point2D> range(RectHV rect) {
        ArrayList<Point2D> result = new ArrayList<>();
        addPoints(root, rect, result);
        return result;
    }


    public Point2D nearest(Point2D p) {
        checkInput(p);
        if (null == root) return null;
        Point2D result = null;
        double min = Double.MAX_VALUE;
        Queue<KdNode> queue = new Queue<>();
        queue.enqueue(root);
        // 使用队列，而不是递归
        while (!queue.isEmpty()) {
            KdNode current = queue.dequeue();
            double dis = p.distanceSquaredTo(current.point);
            if (dis < min) {
                result = current.point;
                min = dis;
            }
            if (null != current.leftBottom && current.leftBottom.nodeRect.distanceSquaredTo(p) < min) {
                queue.enqueue(current.leftBottom);
            }
            if (null != current.rightTop && current.rightTop.nodeRect.distanceSquaredTo(p) < min) {
                queue.enqueue(current.rightTop);
            }
        }
        return result;
    }

    private void checkInput(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Can't insert null point");
        }
    }

    private void addPoints(KdNode node, RectHV rect, ArrayList<Point2D> result) {
        if (null == node) {
            return;
        } else {
            if (rect.distanceTo(node.point) == 0.0) {
                result.add(node.point);
            }
            if (node.leftBottom != null && rect.intersects(node.leftBottom.nodeRect)) {
                addPoints(node.leftBottom, rect, result);
            }
            if (node.rightTop != null && rect.intersects(node.rightTop.nodeRect)) {
                addPoints(node.rightTop, rect, result);
            }
        }
    }

    private void draw(KdNode n) {
        if (null == n) return;
        draw(n.leftBottom);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        n.point.draw();
        StdDraw.setPenRadius();
        if (n.orientation.equals(Orientation.VERTICAL)) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(n.point.x(), n.nodeRect.ymin(), n.point.x(), n.nodeRect.ymax());
        } else {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(n.nodeRect.xmin(), n.point.y(), n.nodeRect.xmax(), n.point.y());
        }
        draw(n.rightTop);
    }
}
