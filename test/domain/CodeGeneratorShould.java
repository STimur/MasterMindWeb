package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CodeGeneratorShould {
    @Test
    public void
    generate_valid_code() {
        assertThat(validate(CodeGenerator.generate()), is(true));
    }

    private boolean validate(int[] code) {
        if (code.length < 4)
            return false;

        for (int i : code)
            if (i < 0 || i > 5)
                return false;

        return true;
    }
}
