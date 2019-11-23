package zhewuzhou.me.week10;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {

    private static final int EXTENDED_ASCII = 256;

    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    public static void transform() {
        String s = BinaryStdIn.readString();
        CircularSuffixArray csa = new CircularSuffixArray(s);
        int N = s.length(), index;
        char[] t = new char[N];
        for (int i = 0; i < N; i++) {
            index = csa.index(i);
            if (index == 0) {
                BinaryStdOut.write(i);
                t[i] = s.charAt(N-1);
            } else t[i] = s.charAt(index-1);
        }
        BinaryStdOut.write(new String(t));
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform, reading from
    // standard input and writing to standard output
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        char[] t = BinaryStdIn.readString().toCharArray();
        int N = t.length;
        int[] next = new int[N], count = new int[EXTENDED_ASCII+1];
        for (int i = 0; i < N; i++)
            count[t[i]+1]++;
        for (int i = 0; i < EXTENDED_ASCII; i++)
            count[i+1] += count[i];
        // The trickiest part
        for (int i = 0; i < N; i++)
            next[count[t[i]]++] = i;

        int nx = next[first];
        for (int i = 0; i < N; i++) {
            BinaryStdOut.write(t[nx]);
            nx = next[nx];
        }
        BinaryStdOut.close();
    }

    // if args[0] is '-', apply Burrows-Wheeler transform
    // if args[0] is '+', apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if (args[0].equals("-")) transform();
        else if (args[0].equals("+")) inverseTransform();
    }
}
