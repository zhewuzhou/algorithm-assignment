package zhewuzhou.me.week4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class Solver {
    private boolean solvable;
    private int move;
    private Node current;

    private class Node implements Comparable<Node> {
        private int priority;
        private Node parent;
        private Board board;
        private int currentMove;

        public Node(int move, Node parent, Board board) {
            this.currentMove = move;
            this.priority = currentMove + board.manhattan();
            this.parent = parent;
            this.board = board;
        }

        public int compareTo(Node that) {
            return Integer.compare(this.priority, that.priority);
        }
    }

    public Solver(Board initial) {
        if (initial == null) {
            throw new java.lang.IllegalArgumentException();
        }
        Node currentTwin;
        MinPQ<Node> queue = new MinPQ<>(Comparator.comparingInt(o -> o.priority));
        MinPQ<Node> queueTwin = new MinPQ<>(Comparator.comparingInt(o -> o.priority));
        move = 0;
        int moveT = 0;
        this.current = null;
        current = new Node(0, null, initial);
        currentTwin = new Node(0, null, initial.twin());
        while (!(current.board.isGoal() || currentTwin.board.isGoal())) {
            for (Board n : current.board.neighbors()) {
                if (isNewNode(n, current)) {
                    queue.insert(new Node(move + 1, current, n));
                }
            }
            for (Board thisNeighT : currentTwin.board.neighbors()) {
                if (isNewNode(thisNeighT, currentTwin)) {
                    queueTwin.insert(new Node(moveT + 1, currentTwin, thisNeighT));
                }
            }
            current = queue.delMin();
            currentTwin = queueTwin.delMin();
            move = current.currentMove;
            moveT = currentTwin.currentMove;
        }
        if (current.board.isGoal()) {
            solvable = true;
        } else {
            solvable = false;
            move = -1;
        }
    }


    public boolean isSolvable() {
        return solvable;
    }

    public int moves() {
        if (!solvable) return -1;
        return move;
    }

    public Iterable<Board> solution() {
        Stack<Board> theSolution = new Stack<>();
        Node temp;
        if (solvable) {
            temp = current;
        } else {
            return null;
        }
        while (temp != null) {
            theSolution.push(temp.board);
            temp = temp.parent;
        }
        return theSolution;
    } // sequence of boards in a shortest solution; null if unsolvable

    public static void main(String[] args) {
// create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
        Solver solver = new Solver(initial);
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

    private boolean isNewNode(Board n, Node current) {
        return (current.parent == null) || (!n.equals(current.parent.board));
    }
}
