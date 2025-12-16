package vp.rockpaperscissors;

public enum Move {
    ROCK("камень"),
    PAPER("бумага"),
    SCISSORS("ножницы");

    private final String name;

    Move(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean beats(Move other) {
        return (this == ROCK && other == SCISSORS) ||
               (this == PAPER && other == ROCK) ||
               (this == SCISSORS && other == PAPER);
    }
}

