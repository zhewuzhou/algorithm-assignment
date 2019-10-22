package zhewuzhou.me.week6;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
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
        assertThat(sap.ancestor(16, 13), is(3));
    }

    @Test
    public void should_calculate_v_v() {
        SAP sap = new SAP(graph);

        assertThat(sap.length(13, 13), is(0));
        assertThat(sap.ancestor(13, 13), is(13));
        assertThat(sap.length(asList(13, 23, 24), asList(6, 16, 17, 13)), is(0));
        assertThat(sap.ancestor(asList(13, 23, 24), asList(6, 16, 17, 13)), is(13));
    }

    @Test
    public void should_calculate_shortest_distance_given_v_w_collections() {
        SAP sap = new SAP(graph);

        assertThat(sap.length(asList(13, 23, 24), asList(6, 16, 17)), is(4));
        assertThat(sap.ancestor(asList(13, 23, 24), asList(6, 16, 17)), is(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_given_v_w_collections_when_null_collection() {
        SAP sap = new SAP(graph);

        assertThat(sap.length(null, asList(6, 16, 17)), is(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_given_v_w_collections_when_null_item() {
        SAP sap = new SAP(graph);

        assertThat(sap.length(asList(13, 23, null), asList(6, 16, 17)), is(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_given_v_w_collections_when_repeated_item() {
        SAP sap = new SAP(graph);

        assertThat(sap.length(asList(13, 23, 13), asList(6, 16, 17)), is(4));
    }
}
