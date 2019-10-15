package zhewuzhou.me.week5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class KdTreeTest {
    @Test
    public void should_insert_nodes_in_order() {
        KdTree tree = createTree();

        assertThat(tree.size(), is(5));
    }

    @Test
    public void should_tell_if_contains_node() {
        KdTree tree = createTree();

        assertThat(tree.contains(new Point2D(0.4, 0.7)), is(true));
        assertThat(tree.contains(new Point2D(0.4, 0.6)), is(false));
    }

    @Test
    public void should_give_range_points() {
        KdTree tree = createTree();

        Iterable<Point2D> fullRange = tree.range(new RectHV(0, 0, 1, 1));
        Iterable<Point2D> halfRange = tree.range(new RectHV(0, 0, 0.7, 0.4));
        Iterable<Point2D> cornerRange = tree.range(new RectHV(0.1, 0.1, 0.3, 0.3));
        assertThat(countPoints(fullRange), is(5));
        assertThat(countPoints(halfRange), is(3));
        assertThat(countPoints(cornerRange), is(1));
    }

    private int countPoints(Iterable<Point2D> fullRange) {
        int count = 0;
        for (Point2D p : fullRange) {
            count++;
        }
        return count;
    }

    private KdTree createTree() {
        KdTree tree = new KdTree();

        tree.insert(new Point2D(0.7, 0.2));
        tree.insert(new Point2D(0.5, 0.4));
        tree.insert(new Point2D(0.2, 0.3));
        tree.insert(new Point2D(0.4, 0.7));
        tree.insert(new Point2D(0.9, 0.6));
        return tree;
    }
}
