package zhewuzhou.me.week4;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BoardTest {

    @Test
    public void should_to_string_board() {
        Board board = createValidBoard();
        String toString = board.toString();

        assertThat(toString, is(containsString(String.valueOf(board.dimension()))));
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
        createValidBoard();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_sequence_arrays() {
        int[][] invalidArrays = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                invalidArrays[i][j] = i * 3 + j;
            }
        }

        invalidArrays[2][2] = 9;

        new Board(invalidArrays);
    }

    private Board createValidBoard() {
        int[][] validArrays = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                validArrays[i][j] = i * 3 + j;
            }
        }

        return new Board(validArrays);
    }
}
