package zhewuzhou.me.week6;

public class Outcast {
    private final WordNet wordNet;

    // constructor takes a WordNet object
    public Outcast(WordNet wordnet) {
        this.wordNet = wordnet;
    }

    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns) {
        int maxDistance = 0;
        String outcast = null;
        for (String v : nouns) {
            int distance = 0;
            for (String w : nouns) {
                distance = distance + wordNet.distance(v, w);
            }
            if (maxDistance < distance) {
                maxDistance = distance;
                outcast = v;
            }
        }
        return outcast;
    }
}
