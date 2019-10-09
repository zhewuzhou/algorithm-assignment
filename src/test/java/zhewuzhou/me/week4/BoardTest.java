package zhewuzhou.me.week4;

import org.junit.Test;

import java.util.ArrayList;

import static java.lang.String.valueOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BoardTest {
    @Test
    public void should_not_equals_given_dimension_diff() {
        Board threeDimensionBoard = createValidBoard(3);
        Board fourDimensionBoard = createValidBoard(4);

        assertThat(threeDimensionBoard.equals(fourDimensionBoard), is(false));
    }

    @Test
    public void should_not_equals_given_different_object() {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        Board threeDimensionBoard = createValidBoard(3);

        assertThat(threeDimensionBoard.equals(integers), is(false));
    }

    @Test
    public void should_not_equals_given_null() {
        Board threeDimensionBoard = createValidBoard(3);

        assertThat(threeDimensionBoard.equals(null), is(false));
    }

    @Test
    public void should_not_equals_given_same_board() {
        Board board = createValidBoard(3);
        Board anotherBoard = createValidBoard(3);

        assertThat(board.equals(anotherBoard), is(true));
    }

    @Test
    public void should_equals_given_same_board_diff_tiles() {
        Board board = createValidBoard(3);
        Board anotherBoard = createValidBoard(3);

        assertThat(board.equals(anotherBoard), is(true));
    }

    @Test
    public void should_equals_given_itself() {
        Board threeDimensionBoard = createValidBoard(3);

        assertThat(threeDimensionBoard.equals(threeDimensionBoard), is(true));
    }

    @Test
    public void should_not_equals_given_diff_tiles() {
        Board board = createValidBoard(3);
        int[][] tiles = calculateTiles(3);
        int temp = tiles[1][1];
        tiles[1][1] = tiles[0][0];
        tiles[0][0] = temp;
        Board anotherBoard = new Board(tiles);

        assertThat(board.equals(anotherBoard), is(false));
    }

    @Test
    public void should_to_string_board() {
        Board board = createValidBoard(3);
        String toString = board.toString();

        assertThat(toString, is(containsString(valueOf(board.dimension()))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_create_board_with_null() {
        new Board(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_non_square_arrays() {
        int[][] invalidArrays = new int[3][4];

        new Board(invalidArrays);
    }

    @Test
    public void should_not_throw_exception_when_sequence_arrays() {
        createValidBoard(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_sequence_arrays() {
        int[][] invalidArrays = calculateTiles(3);

        invalidArrays[2][2] = 9;

        new Board(invalidArrays);
    }

    @Test
    public void should_be_goal() {
        assertThat(createValidBoard(10).isGoal(), is(true));
    }

    @Test
    public void should_not_be_goal() {
        int[][] tiles = calculateTiles(10);
        int temp = tiles[0][0];
        tiles[0][0] = tiles[9][9];
        tiles[9][9] = temp;
        Board board = new Board(tiles);

        assertThat(board.isGoal(), is(false));
    }

    @Test
    public void should_calculate_hamming() {
        assertThat(createValidBoard(10).hamming(), is(0));

        int[][] tiles = calculateTiles(10);
        int temp = tiles[0][0];
        tiles[0][0] = tiles[9][9];
        tiles[9][9] = temp;
        Board board = new Board(tiles);

        assertThat(board.hamming(), is(1));
    }

    @Test
    public void should_calculate_manhattan() {
        assertThat(createValidBoard(10).manhattan(), is(0));

        int[][] tiles = calculateTiles(10);
        int temp = tiles[0][0];
        tiles[0][0] = tiles[9][9];
        tiles[9][9] = temp;
        Board board = new Board(tiles);

        assertThat(board.manhattan(), is(18));
    }

    @Test
    public void should_calculate_manhattan_hamming_for_more_cases() {
        int[][] tilesV1 = {{1, 0, 3}, {4, 2, 5}, {7, 8, 6}};
        Board board = new Board(tilesV1);
        assertThat(board.manhattan(), is(3));
        assertThat(board.hamming(), is(3));

        int[][] tilesV2 = {{4, 1, 3}, {0, 2, 5}, {7, 8, 6}};
        board = new Board(tilesV2);
        assertThat(board.manhattan(), is(5));
        assertThat(board.hamming(), is(5));

        int[][] tilesV3 = {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
        board = new Board(tilesV3);
        assertThat(board.manhattan(), is(10));
        assertThat(board.hamming(), is(5));

    }

    private Board createValidBoard(int dimension) {

        return new Board(calculateTiles(dimension));
    }

    private int[][] calculateTiles(int dimension) {
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
        return validArrays;
    }
}
