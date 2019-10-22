package zhewuzhou.me.week6;

public class Outcast {
    private WordNet wordNet;

    // constructor takes a WordNet object
    public Outcast(WordNet wordnet) {
        this.wordNet = wordnet;
    }

    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns) {
        Long maxDistance = 0L;
        String outcast = null;
        for (String v : nouns) {
            Long distance = 0L;
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

    // see test client below
    public static void main(String[] args) {

    }
}
