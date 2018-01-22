package domain;

class GameMock extends Game {
    public GameMock() {
        code = new Code(new int[]{1, 2, 3, 4});
    }

    public GameMock(int[] pegs) {
        code = new Code(pegs);
    }
}
