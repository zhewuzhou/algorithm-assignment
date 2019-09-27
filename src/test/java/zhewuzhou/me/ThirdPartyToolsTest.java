package zhewuzhou.me;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

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
}
