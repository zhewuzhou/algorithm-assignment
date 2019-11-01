package zhewuzhou.me.week8;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BaseballEliminationTest {

    @Test
    public void should_create_class_via_parse_file() {
        BaseballElimination elimination = new BaseballElimination("baseball/teams29.txt");

        assertThat(elimination.numberOfTeams(), is(29));
        assertThat(elimination.against("Cleveland", "Denver"), is(7));
    }

}
