package zhewuzhou.me.week7;

import edu.princeton.cs.algs4.Picture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class SeamCarverTest {

    private static final String SEAM_3_X_4_PNG = "seam/3x4.png";
    private static final String SEAM_6_X_5_PNG = "seam/6x5.png";

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{{"seam/12x10.png", new int[]{6, 7, 7, 6, 6, 7, 7, 7, 8, 7}}});
    }

    @Parameter(0)
    public String imagePath;
    @Parameter(1)
    public int[] seam;

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_given_null_constructor() {
        new SeamCarver(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_given_invalid_row_negative() {
        SeamCarver seamCarver = createFromFile(SEAM_3_X_4_PNG);

        seamCarver.energy(0, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_given_invalid_row_out_of_range() {
        SeamCarver seamCarver = createFromFile(SEAM_3_X_4_PNG);

        seamCarver.energy(0, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_given_invalid_column_negative() {
        SeamCarver seamCarver = createFromFile(SEAM_3_X_4_PNG);

        seamCarver.energy(-1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_given_invalid_column_out_of_range() {
        SeamCarver seamCarver = createFromFile(SEAM_3_X_4_PNG);

        seamCarver.energy(3, 0);
    }

    @Test
    public void should_calculate_energy_for_valid_coordinate() {
        SeamCarver seamCarver = createFromFile(SEAM_3_X_4_PNG);

        assertThat(seamCarver.energy(1, 2), is(Math.sqrt(52024)));
        assertThat(seamCarver.energy(1, 2), is(Math.sqrt(52024)));
        assertThat(seamCarver.energy(1, 1), is(Math.sqrt(52225)));
        assertThat(seamCarver.energy(0, 0), is(1000D));
        assertThat(seamCarver.energy(2, 3), is(1000D));
    }

    @Test
    public void should_find_vertical_seam() {
        SeamCarver seamCarver = createFromFile(SEAM_6_X_5_PNG);

        assertThat(seamCarver.energy(3, 0), is(1000D));
        assertThat(seamCarver.energy(4, 1), is(closeTo(107.89, 0.01)));
        assertThat(seamCarver.energy(3, 1), is(closeTo(234.09, 0.01)));
        assertThat(seamCarver.energy(3, 2), is(closeTo(133.07, 0.01)));
        assertThat(seamCarver.energy(2, 3), is(closeTo(174.01, 0.01)));
        assertThat(seamCarver.energy(2, 4), is(1000D));
        int[] verticalSeam = {3, 4, 3, 2, 1};
        assertThat(seamCarver.findVerticalSeam(), is(verticalSeam));
    }

    @Test
    public void should_run_with_more_cases() {
        SeamCarver seamCarver = createFromFile(this.imagePath);

        assertThat(seamCarver.findVerticalSeam(), is(this.seam));
    }

    private SeamCarver createFromFile(String fileName) {
        File file = new File(Objects.requireNonNull(this.getClass()
            .getClassLoader()
            .getResource(fileName))
            .getFile());
        Picture picture = new Picture(file);
        return new SeamCarver(picture);
    }
}
