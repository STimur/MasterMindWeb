package domain;

import org.junit.Test;

public class InputValidatorShould {
    @Test(expected = InputValidator.ValidationException.class)
    public void
    throw_exception_when_input_length_less_than_four() {
        InputValidator.validate("214");
    }

    @Test(expected = InputValidator.ValidationException.class)
    public void
    throw_exception_when_input_length_more_than_four() {
        InputValidator.validate("12345");
    }

    @Test(expected = InputValidator.ValidationException.class)
    public void
    throw_exception_when_input_contain_letter() {
        InputValidator.validate("a124");
    }

    @Test(expected = InputValidator.ValidationException.class)
    public void
    throw_exception_when_input_contain_digit_out_of_range() {
        InputValidator.validate("6124");
    }
}
