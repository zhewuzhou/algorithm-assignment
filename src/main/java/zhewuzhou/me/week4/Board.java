package zhewuzhou.me.week4;

import java.util.Arrays;

public class Board {
    private int dimension;
    private int[][] tiles;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        checkTiles(tiles);
    }


    // string representation of this board
    public String toString() {
        return null;
    }

    // board dimension n
    public int dimension() {
        return 0;
    }

    // number of tiles out of place
    public int hamming() {
        return 0;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        return 0;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return false;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        return null;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        return null;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
    }

    private void checkTiles(int[][] tiles) {
        checkNullOrNonSquare(tiles);
        checkContainedTiles(tiles);
        this.dimension = tiles.length;
        this.tiles = tiles;
    }

    private void checkNullOrNonSquare(int[][] tiles) {
        if (tiles == null) {
            throw new IllegalArgumentException();
        }
        if (tiles.length != tiles[0].length) {
            throw new IllegalArgumentException();
        }
    }

    private void checkContainedTiles(int[][] tiles) {
        int dimension = tiles.length;
        int[] sequenceArray = new int[dimension * dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                sequenceArray[i * 3 + j] = tiles[i][j];
            }
        }
        Arrays.sort(sequenceArray);
        for (int i = 0; i < dimension * dimension; i++) {
            if (sequenceArray[i] != i) {
                throw new IllegalArgumentException();
            }
        }
    }
}
