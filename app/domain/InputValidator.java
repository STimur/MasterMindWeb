package domain;

public class InputValidator {
    public static void validate(String input) {
        if (input.length() != 4)
            throw new ValidationException();

        for (char c : input.toCharArray())
            if (c - '0' < 0 || c - '0' > 5)
                throw new ValidationException();
    }

    public static class ValidationException extends RuntimeException {
    }
}
