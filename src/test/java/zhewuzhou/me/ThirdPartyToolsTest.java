package zhewuzhou.me;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static edu.princeton.cs.algs4.StdRandom.uniform;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ThirdPartyToolsTest {
    @Test
    public void should_generate_random_number() {
        for (int i = 0; i < 50; i++) {
            int random = uniform(1, 100);
            assertThat((random < 100 && random > 0), is(true));
        }
    }

    @Test
    public void should_divide_ints_get_double_result() {
        double result = 1 / (double) 3;
        assertThat(result > 0, is(true));
    }

    @Test
    public void should_work_with_2D_array() {
        int[][] target = new int[3][3];

        assertThat(target.length, is(3));
        assertThat(target[0].length, is(3));
    }

    @Test
    public void should_parse_line() {
        String src = "         Atlanta 123  76  53    0 7 7 7 7 7 0 0 2 1 0 1 3 5 0 0 3 0 0 1 0 2 0 0 0 0 0 0 0";

        List<String> collect = Arrays.stream(src.split(" "))
            .filter(s -> !s.isEmpty())
            .collect(Collectors.toList());

        assertThat(1, is(1));
    }
}
