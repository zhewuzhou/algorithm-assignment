package zhewuzhou.me.week9;

import edu.princeton.cs.algs4.TST;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.lang.Boolean.TRUE;

public class BoggleSolver {
    private TST<Boolean> tst = new TST<>();

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
        for (String s : dictionary) {
            tst.put(s, TRUE);
        }
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        ArrayList<String> result = new ArrayList<>();
        int rows = board.rows();
        int cols = board.cols();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!isEmptyPrefix("" + board.getLetter(r, c))) {
                    Stack<SimpleEntry<Integer, Integer>> prefix = new Stack<>();
                    prefix.push(new SimpleEntry<>(r, c));
                    boardDFS(r, c, board, result, prefix);
                }
            }
        }
        return result;
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        return 0;
    }

    private void boardDFS(int i, int j, BoggleBoard board, List<String> result, Stack<SimpleEntry<Integer, Integer>> path) {
        for (int ri = -1; ri <= 1; ri++) {
            for (int ci = -1; ci <= 1; ci++) {
                boolean notSamePosition = !(ri == 0 && ci == 0);
                int newRow = i + ri;
                int newCol = j + ci;
                if (notSamePosition &&
                    isValidPosition(newRow, newCol, board) &&
                    !isInPath(path, newRow, newCol)) {
                    String prefix = buildPrefix(path, board);
                    String newPrefix = prefix + (board.getLetter(newRow, newCol));
                    if (tst.get(newPrefix) != null) {
                        result.add(newPrefix);
                        path.push(new SimpleEntry<>(newRow, newCol));
                        boardDFS(newRow, newCol, board, result, path);
                    } else if (!isEmptyPrefix(newPrefix)) {
                        path.push(new SimpleEntry<>(newRow, newCol));
                        boardDFS(newRow, newCol, board, result, path);
                    }
                }
            }
        }
    }

    private boolean isEmptyPrefix(String newPrefix) {
        return tst.keysWithPrefix(newPrefix).spliterator().getExactSizeIfKnown() == 0L;
    }

    private boolean isValidPosition(int r, int c, BoggleBoard board) {
        return (r >= 0 && r < board.rows()) && (c >= 0 && c < board.cols());
    }

    private boolean isInPath(Stack<SimpleEntry<Integer, Integer>> path, int r, int c) {
        return path.stream().anyMatch(s -> s.getKey() == r && s.getValue() == c);
    }

    private String buildPrefix(Stack<SimpleEntry<Integer, Integer>> path, BoggleBoard board) {
        StringBuilder builder = new StringBuilder();
        path.forEach(s -> {
            builder.append(board.getLetter(s.getKey(), s.getValue()));
        });
        return builder.toString();
    }
}
