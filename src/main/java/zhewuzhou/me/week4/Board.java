package zhewuzhou.me.week4;

import java.util.Arrays;

public class Board {
    private int dimension;
    private int[][] tiles;
    private Board perfectBoard;
    private Integer hamming;
    private Integer manhattan;

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
        if (this.hamming == null) {
            calculateHamming();
        }
        return this.hamming;
    }

    private void calculateHamming() {
        this.hamming = 0;
        Board perfectBoard = this.buildPerfectBoard();
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                if (tiles[i][j] != perfectBoard.tiles[i][j] && tiles[i][j] != 0) {
                    this.hamming++;
                }
            }
        }
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        if (this.manhattan == null) {
            calculateManhattan();
        }
        return this.manhattan;
    }

    private void calculateManhattan() {
        this.manhattan = 0;
        Board perfectBoard = this.buildPerfectBoard();
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                if (tiles[i][j] != perfectBoard.tiles[i][j] && tiles[i][j] != 0) {
                    this.manhattan = this.manhattan + distance(i, j);
                }
            }
        }
    }

    private int distance(int i, int j) {
        int targetRow = ((tiles[i][j] - 1) / this.dimension) - i;
        int targetColumn = (tiles[i][j] - 1) % this.dimension - j;
        int vertical = Math.abs(targetRow);
        int horizontal = Math.abs(targetColumn);
        return vertical + horizontal;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return this.equals(buildPerfectBoard());
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

    private Board buildPerfectBoard() {
        int dimension = this.dimension;
        if (perfectBoard == null) {
            int[][] validArrays = new int[dimension][dimension];
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    if (i == dimension - 1 && j == dimension - 1) {
                        validArrays[i][j] = 0;
                    } else {
                        validArrays[i][j] = i * dimension + j + 1;
                    }
                }
            }
            perfectBoard = new Board(validArrays);
        }
        return perfectBoard;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
    }
}
