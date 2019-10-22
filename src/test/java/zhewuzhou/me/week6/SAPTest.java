package zhewuzhou.me.week6;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class SAPTest {
    private Digraph graph;

    @Before
    public void setUp() {
        In in = new In("digraph25.txt");
        graph = new Digraph(in);
    }

    @Test
    public void should_calculate_shortest_distance_given_v_w() {
        SAP sap = new SAP(graph);

        assertThat(sap.length(13, 16), is(4));
        assertThat(sap.length(16, 13), is(4));
    }
}
