package zhewuzhou.me.week4;

import edu.princeton.cs.algs4.Stack;

public class Board {
    private int[][] tiles;
    private int dimension;

    public Board(int[][] blocks) {
        this.dimension = blocks.length;
        this.tiles = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                tiles[i][j] = blocks[i][j];
            }
        }
    } // construct a board from an n-by-n array of blocks

    // (where blocks[i][j] = block in row i, column j)
    public int dimension() {
        return this.dimension;
    } // board dimension n

    public int hamming() {
        int hammingSum = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if ((tiles[i][j] != (i * dimension + j + 1)) && (tiles[i][j] != 0)) {
                    hammingSum++;
                }
            }
        }
        return hammingSum;
    } // number of blocks out of place

    public int manhattan() {
        int manhattanSum = 0;
        int temp;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if ((tiles[i][j] != (i * dimension + j + 1)) && (tiles[i][j] != 0)) {
                    temp = tiles[i][j] % dimension - 1;
                    if (temp < 0) temp += dimension;
                    manhattanSum = manhattanSum + (Math.abs(i - ((tiles[i][j] - 1) / dimension)) + Math
                        .abs(j - temp));
                }
            }
        }
        return manhattanSum;
    } // sum of Manhattan distances between blocks and goal

    public boolean isGoal() {
        return (this.hamming() == 0);
    } // is this board the goal board?

    public Board twin() {
        int[][] twinBoard = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                twinBoard[i][j] = tiles[i][j];
            }
        }
        if ((twinBoard[0][0] != 0) && (twinBoard[0][1] != 0)) {
            exch(twinBoard, 0, 0, 0, 1);
        } else {
            exch(twinBoard, 1, 0, 1, 1);
        }
        return new Board(twinBoard);
    } // a board that is obtained by exchanging any pair of blocks

    public boolean equals(Object y) {
        if (this == y) return true;
        if (y == null) return false;
        if (this.getClass() != y.getClass()) return false;
        Board temp = (Board) y;
        if (this.dimension != temp.dimension) return false;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (this.tiles[i][j] != temp.tiles[i][j]) return false;
            }
        }
        return true;
    } // does this board equal y?

    public Iterable<Board> neighbors() {
        int i0 = 0, j0 = 0;
        int[][] temp = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                temp[i][j] = tiles[i][j];
            }
        }
        Stack<Board> neighbor = new Stack<Board>();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (this.tiles[i][j] == 0) {
                    i0 = i;
                    j0 = j;
                }
            }
        }
        if (i0 != 0) {
            exch(temp, i0, j0, i0 - 1, j0);
            neighbor.push(new Board(temp));
            exch(temp, i0, j0, i0 - 1, j0);
        }
        if (i0 != (dimension - 1)) {
            exch(temp, i0, j0, i0 + 1, j0);
            neighbor.push(new Board(temp));
            exch(temp, i0, j0, i0 + 1, j0);
        }
        if (j0 != 0) {
            exch(temp, i0, j0, i0, j0 - 1);
            neighbor.push(new Board(temp));
            exch(temp, i0, j0, i0, j0 - 1);
        }
        if (j0 != (dimension - 1)) {
            exch(temp, i0, j0, i0, j0 + 1);
            neighbor.push(new Board(temp));
            exch(temp, i0, j0, i0, j0 + 1);
        }
        return neighbor;
    } // all neighboring boards

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(dimension + "\n");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                s.append(String.format("%2d ", tiles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    } // string representation of this board (in the output format specified below)

    private void exch(int[][] forExch, int oi, int oj, int afi, int afj) {
        int temp = forExch[oi][oj];
        forExch[oi][oj] = forExch[afi][afj];
        forExch[afi][afj] = temp;
    }

    public static void main(String[] args) {
    } // unit tests (not graded)
}
