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

    private Board createValidBoard(int dimension) {

        return new Board(calculateTiles(dimension));
    }

    private int[][] calculateTiles(int dimension) {
        int[][] validArrays = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                validArrays[i][j] = i * dimension + j;
            }
        }
        return validArrays;
    }
}
