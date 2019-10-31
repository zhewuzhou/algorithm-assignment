package zhewuzhou.me.week6;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SAP {
    private final Digraph graph;
    private final HashMap<String, SAPInfo> cache = new HashMap<>();

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        if (null == G) {
            throw new IllegalArgumentException("Graph is null");
        }
        this.graph = G;
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        checkVertexRange(v);
        checkVertexRange(w);
        if (!cache.containsKey(generateKey(v, w))) {
            handleTwoPoints(v, w);
        }
        return cache.get(generateKey(v, w)).distance;
    }


    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        checkVertexRange(v);
        checkVertexRange(w);
        if (!cache.containsKey(generateKey(v, w))) {
            handleTwoPoints(v, w);
        }
        return cache.get(generateKey(v, w)).ancestor;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        checkVertexCollection(v);
        checkVertexCollection(w);
        if (!cache.containsKey(generateKey(v, w))) {
            handleCollections(v, w);
        }
        return cache.get(generateKey(v, w)).distance;
    }


    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        checkVertexCollection(v);
        checkVertexCollection(w);
        if (!cache.containsKey(generateKey(v, w))) {
            handleCollections(v, w);
        }
        return cache.get(generateKey(v, w)).ancestor;
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

    private void handleTwoPoints(int v, int w) {
        BreadthFirstDirectedPaths vPath = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths wPath = new BreadthFirstDirectedPaths(graph, w);
        SAPInfo sapInfo = calculateSAP(vPath, wPath);
        cache.put(generateKey(v, w), sapInfo);
    }

    private String generateKey(int v, int w) {
        if (v < w) {
            return v + "_" + w;
        }
        return w + "_" + v;
    }

    private String generateKey(Iterable<Integer> v, Iterable<Integer> w) {
        Set<Integer> first, second;
        Set<Integer> vList = StreamSupport
            .stream(v.spliterator(), false)
            .collect(Collectors.toCollection(TreeSet::new));
        Set<Integer> wList = StreamSupport
            .stream(w.spliterator(), false)
            .collect(Collectors.toCollection(TreeSet::new));
        if (vList.size() > wList.size()) {
            first = vList;
            second = wList;
        } else {
            first = wList;
            second = vList;
        }
        StringBuilder key = new StringBuilder("_");
        for (int vVertex : first) {
            key.append(vVertex).append("_");
        }
        for (int wVertex : second) {
            key.append(wVertex).append("_");
        }
        return key.toString();
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
        BreadthFirstDirectedPaths vPath = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths wPath = new BreadthFirstDirectedPaths(graph, w);
        SAPInfo sapInfo = calculateSAP(vPath, wPath);
        cache.put(generateKey(v, w), sapInfo);
        return sapInfo;
    }

    private SAPInfo calculateSAP(BreadthFirstDirectedPaths vPath, BreadthFirstDirectedPaths wPath) {
        int minLength = -1;
        int commonAncestor = -1;
        for (int s = 0; s < graph.V(); s++) {
            if (vPath.hasPathTo(s) && wPath.hasPathTo(s)) {
                int distance = vPath.distTo(s) + wPath.distTo(s);
                if (minLength < 0 || distance < minLength) {
                    minLength = distance;
                    commonAncestor = s;
                }
            }
        }
        return new SAPInfo(commonAncestor, minLength);
    }

    private class SAPInfo {
        private final int ancestor;
        private final int distance;

        public SAPInfo(int ancestor, int distance) {
            this.ancestor = ancestor;
            this.distance = distance;
        }
    }
}
