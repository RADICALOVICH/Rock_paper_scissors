package vp.rockpaperscissors;

import java.util.Random;

public class Game {
    private final Random random = new Random();
    private int playerWins = 0;
    private int computerWins = 0;
    private int draws = 0;
    private Move lastComputerMove;

    public GameResult playRound(Move playerMove) {
        lastComputerMove = getRandomMove();
        GameResult result = determineResult(playerMove, lastComputerMove);
        updateStats(result);
        return result;
    }

    public Move getLastComputerMove() {
        return lastComputerMove;
    }

    public Move getRandomMove() {
        Move[] moves = Move.values();
        return moves[random.nextInt(moves.length)];
    }

    public GameResult determineResult(Move playerMove, Move computerMove) {
        if (playerMove == computerMove) {
            return GameResult.DRAW;
        } else if (playerMove.beats(computerMove)) {
            return GameResult.WIN;
        } else {
            return GameResult.LOSE;
        }
    }

    private void updateStats(GameResult result) {
        switch (result) {
            case WIN -> playerWins++;
            case LOSE -> computerWins++;
            case DRAW -> draws++;
        }
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getComputerWins() {
        return computerWins;
    }

    public int getDraws() {
        return draws;
    }
}

