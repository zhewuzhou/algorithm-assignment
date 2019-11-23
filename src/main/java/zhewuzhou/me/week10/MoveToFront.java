package zhewuzhou.me.week10;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {

    private static final int EXTENDED_ASCII = 256;

    // apply move-to-front encoding,
    // reading from standard input and writing to standard output
    public static void encode() {
        char[] seq = new char[EXTENDED_ASCII];
        for (char i = 0; i < EXTENDED_ASCII; i++)
            seq[i] = i;
        while (!BinaryStdIn.isEmpty()) {
            int idx = 0;
            char c = BinaryStdIn.readChar();
            for (; idx < EXTENDED_ASCII; idx++)
                if (seq[idx] == c) break;
            BinaryStdOut.write(idx, 8);
            System.arraycopy(seq, 0, seq, 1, idx);
            seq[0] = c;
        }
        BinaryStdOut.close();
    }

    // apply move-to-front decoding,
    // reading from standard input and writing to standard output
    public static void decode() {
        char[] seq = new char[EXTENDED_ASCII];
        for (char i = 0; i < EXTENDED_ASCII; i++)
            seq[i] = i;
        while (!BinaryStdIn.isEmpty()) {
            int idx = BinaryStdIn.readChar();
            char c = seq[idx];
            BinaryStdOut.write(c);
            System.arraycopy(seq, 0, seq, 1, idx);
            seq[0] = c;
        }
        BinaryStdOut.close();
    }

    // if args[0] is '-', apply move-to-front encoding
    // if args[0] is '+', apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].equals("-")) encode();
        else if (args[0].equals("+")) decode();
    }
}
