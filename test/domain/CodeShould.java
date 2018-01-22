package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CodeShould {
    private int[] intArray(int... ints) {
        return ints;
    }

    @Test
    public void
    calculate_wellplaced_pegs() {
        assertThat(new Code(intArray(0, 0, 0, 0)).guess(intArray(1, 1, 1, 1)), is(intArray(0, 0)));
        assertThat(new Code(intArray(0, 0, 0, 0)).guess(intArray(0, 1, 1, 1)), is(intArray(1, 0)));
        assertThat(new Code(intArray(0, 0, 0, 0)).guess(intArray(0, 0, 0, 0)), is(intArray(4, 0)));
    }

    @Test
    public void
    calculate_misplaced_pegs() {
        assertThat(new Code(intArray(0, 0, 0, 1)).guess(intArray(2, 2, 2, 0)), is(intArray(0, 1)));
        assertThat(new Code(intArray(1, 1, 1, 0)).guess(intArray(0, 2, 2, 2)), is(intArray(0, 1)));
        assertThat(new Code(intArray(4, 5, 0, 4)).guess(intArray(0, 0, 0, 0)), is(intArray(1, 0)));
        assertThat(new Code(intArray(4, 3, 4, 2)).guess(intArray(2, 2, 1, 1)), is(intArray(0, 1)));
    }
}
