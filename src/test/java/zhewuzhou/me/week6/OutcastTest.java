package zhewuzhou.me.week6;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OutcastTest {
    private Outcast outcast = new Outcast(new WordNet("synsets.txt", "hypernyms.txt"));

    @Test
    public void should_calculate_outcast() {
        String nounsA[] = "horse zebra cat bear table".split("\\ ");
        String nounsB[] = "water soda bed orange_juice milk apple_juice tea coffee".split("\\ ");
        String nounsC[] = "apple pear peach banana lime lemon blueberry strawberry mango watermelon potato".split("\\ ");

        assertThat(outcast.outcast(nounsA), is("table"));
        assertThat(outcast.outcast(nounsB), is("bed"));
        assertThat(outcast.outcast(nounsC), is("potato"));
    }
}
