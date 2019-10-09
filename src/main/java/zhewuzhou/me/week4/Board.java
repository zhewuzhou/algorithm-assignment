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
        StringBuilder builder = new StringBuilder();
        builder.append(this.dimension);
        builder.append("\n");
        for (int[] line : this.tiles) {
            builder.append(' ');
            for (int tile : line) {
                builder.append(tile);
                builder.append(' ');
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    // board dimension n
    public int dimension() {
        return this.dimension;
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
        if (this == y) {
            return true;
        }

        if (y == null || !(y instanceof Board) || this.dimension != ((Board) y).dimension) {
            return false;
        }

        Board that = (Board) y;
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                if (this.tiles[i][j] != that.tiles[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        return null;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        return null;
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
                sequenceArray[i * dimension + j] = tiles[i][j];
            }
        }
        Arrays.sort(sequenceArray);
        for (int i = 0; i < dimension * dimension; i++) {
            if (sequenceArray[i] != i) {
                throw new IllegalArgumentException();
            }
        }
    }

    // unit testing (not graded)
    public static void main(String[] args) {
    }
}
