package zhewuzhou.me.week9;

import edu.princeton.cs.algs4.TrieST;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import static java.lang.Boolean.TRUE;

public class BoggleSolver {
    private TrieST<Boolean> tst = new TrieST<>();
    private Set<String> validWords = new HashSet<>();

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
        for (String s : dictionary) {
            tst.put(s, TRUE);
        }
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        int rows = board.rows();
        int cols = board.cols();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!isEmptyPrefix("" + board.getLetter(r, c))) {
                    Stack<SimpleEntry<Integer, Integer>> prefix = new Stack<>();
                    prefix.push(new SimpleEntry<>(r, c));
                    boolean[][] visited = new boolean[board.rows()][board.cols()];
                    dfs(r, c, board, "", visited);
                }
            }
        }
        return validWords;
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        return 0;
    }

    public void dfs(int r, int c, BoggleBoard board, String prefix, boolean[][] visited) {
        visited[r][c] = true;
        prefix += board.getLetter(r, c);
        boolean shouldGoingForward = false;
        if (prefix.length() > 2 && tst.contains(prefix)) {
            validWords.add(prefix);
            shouldGoingForward = true;
        } else if (!isEmptyPrefix(prefix)) {
            shouldGoingForward = true;
        }
        if (shouldGoingForward) {
            for (int ri = -1; ri <= 1; ri++) {
                for (int ci = -1; ci <= 1; ci++) {
                    boolean isNeighbour = !(ri == 0 && ci == 0);
                    int newR = r + ri;
                    int newC = c + ci;
                    if (isNeighbour && isValidPosition(newR, newC, board) && !visited[newR][newC]) {
                        dfs(newR, newC, board, prefix, cloneVisited(visited));
                    }
                }
            }
        }
    }

    private boolean[][] cloneVisited(boolean[][] currentVisited) {
        int row = currentVisited.length;
        int col = currentVisited[0].length;
        boolean[][] newVisited = new boolean[row][col];
        for (int r = 0; r < row; r++) {
            System.arraycopy(currentVisited[r], 0, newVisited[r], 0, col);
        }
        return newVisited;
    }

    private boolean isEmptyPrefix(String newPrefix) {
        return tst.keysWithPrefix(newPrefix).spliterator().getExactSizeIfKnown() == 0L;
    }

    private boolean isValidPosition(int r, int c, BoggleBoard board) {
        return (r >= 0 && r < board.rows()) && (c >= 0 && c < board.cols());
    }
}
