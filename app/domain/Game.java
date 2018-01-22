package domain;

import java.io.Serializable;

public class Game implements Serializable {
    protected Code code;

    public boolean isFinished;

    public Game() {
        this.code = new Code(CodeGenerator.generate());
    }

    public int[] guess(int[] pegs) {
        int[] answer = code.guess(pegs);
        if (isAllPegsAreGuessed(answer))
            isFinished = true;
        return answer;
    }

    private boolean isAllPegsAreGuessed(int[] answer) {
        int nOfWellPlacedPegs = answer[0];
        return nOfWellPlacedPegs == 4;
    }
}
