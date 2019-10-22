package zhewuzhou.me.week6;

import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SAP {
    private Digraph graph;
    private HashMap<String, SAPInfo> cache = new HashMap<>();

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        this.graph = G;
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        if (!cache.containsKey(generateKey(v, w))) {
            calculateSAP(v, w);
        }
        return cache.get(generateKey(v, w)).sap;
    }


    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        if (!cache.containsKey(generateKey(v, w))) {
            calculateSAP(v, w);
        }
        return cache.get(generateKey(v, w)).commonAncestor;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        return handleCollections(v, w).sap;
    }


    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        return handleCollections(v, w).commonAncestor;
    }

    // do unit testing of this class
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length = sap.length(v, w);
            int ancestor = sap.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }

    private void calculateSAP(int v, int w) {
        checkVertexRange(v);
        checkVertexRange(w);
        BreadthFirstDirectedPaths vPath = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths wPath = new BreadthFirstDirectedPaths(graph, w);
        ArrayList<Integer> ancestors = new ArrayList<>();
        for (int i = 0; i < graph.V(); i++) {
            if (vPath.hasPathTo(i) && wPath.hasPathTo(i)) {
                ancestors.add(i);
            }
        }
        int minSAP = -1;
        int commonAncestor = -1;
        for (int a : ancestors) {
            int sumDistance = vPath.distTo(a) + wPath.distTo(a);
            if (minSAP < 0 || minSAP > sumDistance) {
                minSAP = sumDistance;
                commonAncestor = a;
            }
        }
        SAPInfo sapInfo = new SAPInfo(commonAncestor, minSAP);
        cache.put(generateKey(v, w), sapInfo);
    }

    private String generateKey(int v, int w) {
        if (v < w) {
            return v + "_" + w;
        }
        return w + "_" + v;
    }

    private void checkVertexCollection(Iterable<Integer> v) {
        if (null == v) {
            throw new IllegalArgumentException("Collection can not be null");
        }
        for (Integer vertex : v) {
            if (null == vertex) {
                throw new IllegalArgumentException("Vertex can not be null");
            }
            checkRepeatedItems(v);
            checkVertexRange(vertex);
        }
    }

    private void checkRepeatedItems(Iterable<Integer> v) {
        Set<Integer> vertexSet = StreamSupport.stream(v.spliterator(), false)
            .collect(Collectors.toSet());
        List<Integer> vertexList = StreamSupport.stream(v.spliterator(), false)
            .collect(Collectors.toList());
        if (vertexSet.size() != vertexList.size()) {
            throw new IllegalArgumentException("Repeated Vertex Found");
        }
    }

    private void checkVertexRange(int v) {
        if (v < 0 || v >= graph.V()) {
            throw new IllegalArgumentException("Vertex can not be negative or larger than total number of vertexes");
        }
    }

    private SAPInfo handleCollections(Iterable<Integer> v, Iterable<Integer> w) {
        checkVertexCollection(v);
        checkVertexCollection(w);
        int minLength = Integer.MAX_VALUE;
        int commonAncestor = -1;
        for (int vVertex : v) {
            for (int wVertex : w) {
                int lengthVW = this.length(vVertex, wVertex);
                if (minLength > lengthVW) {
                    minLength = lengthVW;
                    commonAncestor = this.ancestor(vVertex, wVertex);
                }
            }
        }
        return new SAPInfo(commonAncestor, minLength);
    }

    private class SAPInfo {
        public SAPInfo(int commonAncestor, int sap) {
            this.commonAncestor = commonAncestor;
            this.sap = sap;
        }

        private int commonAncestor;
        private int sap;
    }
}
