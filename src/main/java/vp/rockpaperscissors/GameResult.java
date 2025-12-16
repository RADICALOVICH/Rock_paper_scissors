package vp.rockpaperscissors;

public enum GameResult {
    WIN("Вы выиграли!"),
    LOSE("Вы проиграли!"),
    DRAW("Ничья!");

    private final String message;

    GameResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

