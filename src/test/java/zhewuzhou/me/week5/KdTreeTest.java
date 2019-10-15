package zhewuzhou.me.week5;

import edu.princeton.cs.algs4.Point2D;
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
