package zhewuzhou.me.week8;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BaseballEliminationTest {

    @Test
    public void should_create_class_via_parse_file() {
        BaseballElimination elimination = new BaseballElimination("baseball/teams29.txt");

        assertThat(elimination.numberOfTeams(), is(29));
        assertThat(elimination.against("Cleveland", "Denver"), is(7));
    }

    @Test
    public void should_find_collections_of_elimination() {
        BaseballElimination elimination = new BaseballElimination("baseball/teams5.txt");

        Iterable<String> eliminations = elimination.certificateOfElimination("Detroit");
        List<String> teams = StreamSupport.stream(eliminations.spliterator(), false)
            .collect(Collectors.toList());

        assertThat(teams.size(), is(4));
    }
}
