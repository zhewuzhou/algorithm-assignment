package zhewuzhou.me.week9;

import edu.princeton.cs.algs4.In;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class BoggleSolverTest {
    private static BoggleSolver solver;

    @BeforeClass
    public static void createSolver() {
        In dictionary = new In("boggle/dictionary-algs4.txt");
        ArrayList<String> words = new ArrayList<>();
        while (dictionary.exists() && dictionary.hasNextLine()) {
            words.add(dictionary.readLine());
        }
        solver = new BoggleSolver(words.stream().toArray(String[]::new));
    }

    @Test
    public void shouldRunNormalBoard() {
        BoggleBoard board = new BoggleBoard("boggle/board4x4.txt");
        Iterable<String> iterableResult = solver.getAllValidWords(board);

        List<String> result = stream(iterableResult.spliterator(), false).collect(toList());

        assertThat(result.size(), is(not(0)));
    }

    @Test
    public void shouldRunDfsCorrectly() {
        BoggleBoard board = new BoggleBoard("boggle/board4x4.txt");
        boolean[][] visited = new boolean[4][4];
        solver.dfs(0, 0, board, "", visited);


        assertThat(0, is(0));
    }
}
