package zhewuzhou.me.week6;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WordNetTest {
    private WordNet wordNet = new WordNet("synsets.txt", "hypernyms.txt");

    @Test
    public void should_contain_a_noun() {
        assertThat(wordNet.isNoun("xxxxxxxxxx"), is(false));
        assertThat(wordNet.isNoun("zoological_science"), is(true));
        assertThat(wordNet.isNoun("zoology"), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_null_filepath() {
        new WordNet(null, null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_null_argument_distance() {
        wordNet.distance(null, "zoology zoological_science");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_null_argument_sap() {
        wordNet.sap(null, "zoology zoological_science");
    }

    @Test
    public void should_calculate_distance_for_given_v_w() {
        String nounA = "brucellosis";
        String nounB = "AIDS";
        assertThat(wordNet.distance(nounA, nounB), is(2));
        assertThat(wordNet.sap(nounA, nounB), is("infectious_disease"));

        nounA = "ABO_antibodies";
        nounB = "ABO_blood_group_system";
        assertThat(wordNet.distance(nounA, nounB), is(15));
        assertThat(wordNet.sap(nounA, nounB), is("entity"));
    }

    @Test
    public void should_calculate_coffee_distance() {
        assertThat(wordNet.isNoun("coffee"), is(true));
        assertThat(wordNet.distance("coffee", "coffee"), is(0));
        assertThat(wordNet.distance("coffee", "water"), is(3));
        assertThat(wordNet.distance("coffee", "soda"), is(3));
        assertThat(wordNet.distance("coffee", "bed"), is(9));
        assertThat(wordNet.distance("coffee", "orange_juice"), is(3));
        assertThat(wordNet.distance("coffee", "milk"), is(2));
        assertThat(wordNet.distance("coffee", "apple_juice"), is(3));
        assertThat(wordNet.distance("coffee", "tea"), is(2));
    }
}
