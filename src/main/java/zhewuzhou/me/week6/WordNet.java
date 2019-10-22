package zhewuzhou.me.week6;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordNet {
    private static final String DELIMITER_SPACE = " ";
    private static final String DELIMITER_COMMA = ",";
    private Map<String, Integer> nounIdMap = new TreeMap<>();
    private Map<Integer, List<String>> idNounMap = new TreeMap<>();
    private SAP sap;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        parseInputFile(synsets, hypernyms);
    }


    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return nounIdMap.keySet();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        return nounIdMap.containsKey(word);
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        this.checkStringArgument(nounA);
        this.checkStringArgument(nounB);
        return sap.length(nounIdMap.get(nounA), nounIdMap.get(nounB));
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        this.checkStringArgument(nounA);
        this.checkStringArgument(nounB);
        int ancestor = sap.ancestor(nounIdMap.get(nounA), nounIdMap.get(nounB));
        return String.join(DELIMITER_SPACE, idNounMap.get(ancestor));
    }

    // do unit testing of this class
    public static void main(String[] args) {

    }


    private void checkInputFile(String synsets, String hypernyms) {
        if (synsets == null || hypernyms == null) {
            throw new IllegalArgumentException("Input file can not be null");
        }
    }

    private void checkCycle(Digraph net) {
        DirectedCycle cycle = new DirectedCycle(net);
        if (cycle.hasCycle()) {
            throw new IllegalArgumentException("Word Net contains cycle");
        }
    }

    private void checkStringArgument(String input) {
        if (null == input || !this.isNoun(input)) {
            throw new IllegalArgumentException("Input string can not be null or not noun");
        }
    }

    private void parseInputFile(String synsets, String hypernyms) {
        checkInputFile(synsets, hypernyms);
        In syn = new In(synsets);
        In hyper = new In(hypernyms);
        while (syn.exists() && syn.hasNextLine()) {
            String line = syn.readLine();
            String[] columns = splitLine(line, DELIMITER_COMMA);
            if (columns.length > 2) {
                int synId = Integer.parseInt(columns[0]);
                String[] nouns = splitLine(columns[1], DELIMITER_SPACE);
                for (String noun : nouns) {
                    this.nounIdMap.put(noun, synId);
                }
                this.idNounMap.put(synId, Arrays.asList(nouns));
            }
        }
        Digraph net = new Digraph(this.idNounMap.size());
        while (hyper.exists() && hyper.hasNextLine()) {
            String line = hyper.readLine();
            String[] columns = splitLine(line, DELIMITER_COMMA);
            if (columns.length > 0) {
                int root = Integer.parseInt(columns[0]);
                for (String c : columns) {
                    if (!c.equals(columns[0])) {
                        int v = Integer.parseInt(c);
                        net.addEdge(root, v);
                    }
                }
            }
        }
        checkCycle(net);
        this.sap = new SAP(net);
    }

    private String[] splitLine(String line, String delimiter) {
        if (null != line && line.contains(delimiter)) {
            return line.split(delimiter);
        }
        return new String[]{line};
    }
}
