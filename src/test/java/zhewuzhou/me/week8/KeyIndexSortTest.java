package zhewuzhou.me.week8;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class KeyIndexSortTest {
    @Test
    public void should_sort_via_key_index() {
        char[] b = {'d', 'a', 'c', 'f', 'f', 'b', 'd', 'b', 'f', 'b', 'e', 'a'};
        int[] a = {3, 0, 2, 5, 5, 1, 3, 1, 5, 1, 4, 0};
        int[] count = new int[7];
        int[] aux = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            count[a[i] + 1]++;
        }

        for (int r = 0; r < 6; r++) {
            count[r + 1] += count[r];
        }

        for (int j = 0; j < a.length; j++) {
            aux[count[a[j]]++] = a[j];
        }

        for (int k = 0; k < a.length; k++) {
            a[k] = aux[k];
        }

        Assert.assertThat(a.length, is(11));
    }
}
