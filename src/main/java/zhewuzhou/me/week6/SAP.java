package zhewuzhou.me.week6;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;

import java.util.ArrayList;
import java.util.HashMap;

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
        return 0;
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        return 0;
    }

    // do unit testing of this class
    public static void main(String[] args) {

    }

    private void calculateSAP(int v, int w) {
        checkInput(v);
        checkInput(w);
        BreadthFirstDirectedPaths vPath = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths wPath = new BreadthFirstDirectedPaths(graph, w);
        ArrayList<Integer> ancestors = new ArrayList<>();
        for (int i = 0; i < graph.V(); i++) {
            if (vPath.hasPathTo(i) && wPath.hasPathTo(i)) {
                ancestors.add(i);
            }
        }
        int minSAP = Integer.MAX_VALUE;
        int commonAncestor = -1;
        for (int a : ancestors) {
            int sumDistance = vPath.distTo(a) + wPath.distTo(a);
            if (minSAP > sumDistance) {
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

    private void checkInput(int v) {
        if (v < 0 || v >= graph.V()) {
            throw new IllegalArgumentException("Vertex can not be negative or larger than total number of vertexes");
        }
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
