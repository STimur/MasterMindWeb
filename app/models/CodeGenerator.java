package models;

import java.util.Random;

public class CodeGenerator {
    public static int[] generate() {
        int[] code = new int[4];
        for (int i = 0; i < code.length; i++)
            code[i] = new Random().nextInt(6);
        return code;
    }
}
