package zhewuzhou.me;

import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FordFulkerson;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class PrincetonTest {
    @Test
    public void should_solve_max_flow_problems() {
        FlowNetwork network = new FlowNetwork(8);
        network.addEdge(new FlowEdge(0, 1, 10));
        network.addEdge(new FlowEdge(0, 2, 5));
        network.addEdge(new FlowEdge(0, 3, 15));
        network.addEdge(new FlowEdge(1, 4, 9));
        network.addEdge(new FlowEdge(1, 5, 15));
        network.addEdge(new FlowEdge(1, 2, 4));
        network.addEdge(new FlowEdge(2, 3, 4));
        network.addEdge(new FlowEdge(2, 5, 8));
        network.addEdge(new FlowEdge(3, 6, 16));
        network.addEdge(new FlowEdge(4, 7, 10));
        network.addEdge(new FlowEdge(4, 5, 15));
        network.addEdge(new FlowEdge(5, 7, 10));
        network.addEdge(new FlowEdge(5, 6, 15));
        network.addEdge(new FlowEdge(6, 2, 6));
        network.addEdge(new FlowEdge(6, 7, 10));

        FordFulkerson algorithm = new FordFulkerson(network, 0, 7);

        assertThat(algorithm.value(), is(28D));
    }
}
