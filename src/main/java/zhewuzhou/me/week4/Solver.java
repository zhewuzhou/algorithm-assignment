package zhewuzhou.me.week4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solver {
    private List<Board> moves = new ArrayList<>();
    private HashMap<String, Board> traveledBoard = new HashMap<>();
    private boolean isSolvable = false;

    private class Move implements Comparable<Move> {
        private Board board;
        private int numMoves = 0;

        public Move(Board board) {
            this.board = board;
        }

        public Move(Board board, int batch) {
            this.board = board;
            this.numMoves = batch;
        }

        public int compareTo(Move move) {
            return (this.board.manhattan() - move.board.manhattan()) + (this.numMoves - move.numMoves);
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        traveledBoard.put(initial.toString(), initial);
        solveWithMinPQ(initial);
    }


    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return this.isSolvable;
    }

    // min number of moves to solve initial board
    public int moves() {
        if (this.isSolvable) {
            return this.moves.size() - 1;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // sequence of boards in a shortest solution
    public Iterable<Board> solution() {
        if (this.isSolvable) {
            return this.moves;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // test client (see below)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

    private class BoardNode {
        private Board board;
        private Integer priority;
    }

    private void solveWithMinPQ(Board initial) {
        Move initialMove = new Move(initial, 0);
        MinPQ<Move> normalTry = new MinPQ<>();
        normalTry.insert(initialMove);
        for (int epoch = 1; ; epoch++) {
            if (normalTry.isEmpty()) {
                break;
            }
            Move move = normalTry.delMin();
            moves.add(move.board);
            if (move.board.isGoal()) {
                this.isSolvable = true;
                break;
            }
            addNeighbors(move, epoch, normalTry);
        }
    }

    private void addNeighbors(Move previous, int epoch, MinPQ<Move> normalTry) {
        Iterable<Board> neighbors = previous.board.neighbors();
        for (Board b : neighbors) {
            if (!traveledBoard.containsKey(b.toString())) {
                traveledBoard.put(b.toString(), b);
                Move m = new Move(b, epoch);
                normalTry.insert(m);
            }
        }
    }
}
