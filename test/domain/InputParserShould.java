package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InputParserShould {
    @Test
    public void
    parse_input_to_code() {
        assertThat(InputParser.parse("0123"), is(new int[]{0, 1, 2, 3}));
        assertThat(InputParser.parse("4501"), is(new int[]{4, 5, 0, 1}));
    }
}
