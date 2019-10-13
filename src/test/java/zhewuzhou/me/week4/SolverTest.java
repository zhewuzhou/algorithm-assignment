package zhewuzhou.me.week4;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolverTest {
    @Test
    public void should_solve_three_tree_issues() {
        int[][] tiles = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};
        Board initial = new Board(tiles);
        Solver solver = new Solver(initial);

        assertThat(solver.isSolvable(), is(true));
        assertThat(solver.moves(), is(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_detect_unsolvable_board() {
        int[][] tiles = {{1, 2, 3}, {4, 5, 8}, {8, 7, 0}};
        Board initial = new Board(tiles);
        Solver solver = new Solver(initial);
        Board twinBoard = initial.twin();
        Solver twinSolver = new Solver(twinBoard);

        solver.moves();
        solver.solution();
        assertThat(twinSolver.isSolvable(), is(true));
        assertThat(twinSolver.moves(), is(4));
    }

    @Test
    public void should_handle_four_four_tiles() {
        int[][] tiles = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 15, 14, 0}};
        Board initial = new Board(tiles);

        Solver solver = new Solver(initial);
        assertThat(solver.isSolvable(), is(false));
    }
}
