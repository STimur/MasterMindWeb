package domain;

import java.util.ArrayList;
import java.util.List;

public class Code {
    private final int[] pegs;

    public Code(int[] pegs) {
        this.pegs = pegs;
    }

    public int[] guess(int[] pegs) {
        int wellPlaced = 0;
        int misplaced = 0;
        List<Integer> positionsToIgnore = new ArrayList();
        for (int i = 0; i < pegs.length; i++) {
            if (this.pegs[i] == pegs[i]) {
                wellPlaced++;
                pegs[i] = -1;
                positionsToIgnore.add(i);
            }
        }
        for (int i = 0; i < pegs.length; i++) {
            if (checkOtherPositionsFor(pegs[i], i, positionsToIgnore))
                misplaced++;
        }
        return new int[]{wellPlaced, misplaced};
    }

    private boolean checkOtherPositionsFor(int peg, int i, List<Integer> positionsToIgnore) {
        for (int j = 0; j < pegs.length; j++) {
            if (j == i)
                continue;
            if (isIgnoredPosition(j, positionsToIgnore))
                continue;
            if (peg == pegs[j]) {
                positionsToIgnore.add(j);
                return true;
            }
        }
        return false;
    }

    private boolean isIgnoredPosition(int i, List<Integer> positionsToIgnore) {
        for (int j : positionsToIgnore)
            if (j == i)
                return true;
        return false;
    }
}
