package models;

public class InputParser {
    public static int[] parse(String input) {
        return new int[]{
                input.charAt(0) - '0',
                input.charAt(1) - '0',
                input.charAt(2) - '0',
                input.charAt(3) - '0'
        };
    }
}
