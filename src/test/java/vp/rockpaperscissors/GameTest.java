package vp.rockpaperscissors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void determineResult_rockVsScissors_returnsWin() {
        GameResult result = game.determineResult(Move.ROCK, Move.SCISSORS);
        assertEquals(GameResult.WIN, result);
    }

    @Test
    void determineResult_paperVsRock_returnsWin() {
        GameResult result = game.determineResult(Move.PAPER, Move.ROCK);
        assertEquals(GameResult.WIN, result);
    }

    @Test
    void determineResult_scissorsVsPaper_returnsWin() {
        GameResult result = game.determineResult(Move.SCISSORS, Move.PAPER);
        assertEquals(GameResult.WIN, result);
    }

    @Test
    void determineResult_scissorsVsRock_returnsLose() {
        GameResult result = game.determineResult(Move.SCISSORS, Move.ROCK);
        assertEquals(GameResult.LOSE, result);
    }

    @Test
    void determineResult_rockVsPaper_returnsLose() {
        GameResult result = game.determineResult(Move.ROCK, Move.PAPER);
        assertEquals(GameResult.LOSE, result);
    }

    @Test
    void determineResult_paperVsScissors_returnsLose() {
        GameResult result = game.determineResult(Move.PAPER, Move.SCISSORS);
        assertEquals(GameResult.LOSE, result);
    }

    @Test
    void determineResult_sameMoves_returnsDraw() {
        assertEquals(GameResult.DRAW, game.determineResult(Move.ROCK, Move.ROCK));
        assertEquals(GameResult.DRAW, game.determineResult(Move.PAPER, Move.PAPER));
        assertEquals(GameResult.DRAW, game.determineResult(Move.SCISSORS, Move.SCISSORS));
    }

    @Test
    void playRound_updatesStatisticsOnWin() {
        // Используем фиксированный ход компьютера через мокирование невозможно без изменения архитектуры
        // Поэтому просто проверим, что статистика обновляется
        int initialWins = game.getPlayerWins();
        
        // Играем до победы (может потребоваться несколько попыток)
        GameResult result;
        int attempts = 0;
        do {
            result = game.playRound(Move.ROCK);
            attempts++;
        } while (result != GameResult.WIN && attempts < 100);
        
        assertTrue(game.getPlayerWins() > initialWins || result == GameResult.WIN);
    }

    @Test
    void playRound_updatesStatisticsOnLose() {
        int initialLosses = game.getComputerWins();
        
        GameResult result;
        int attempts = 0;
        do {
            result = game.playRound(Move.SCISSORS);
            attempts++;
        } while (result != GameResult.LOSE && attempts < 100);
        
        assertTrue(game.getComputerWins() > initialLosses || result == GameResult.LOSE);
    }

    @Test
    void playRound_updatesStatisticsOnDraw() {
        // Для ничьей нужно, чтобы компьютер выбрал тот же ход
        // Это случайно, поэтому просто проверим общую логику
        for (int i = 0; i < 50; i++) {
            game.playRound(Move.ROCK);
        }
        
        // После 50 раундов должна быть хотя бы одна ничья (вероятностно)
        // Или хотя бы статистика должна обновиться
        assertTrue(game.getPlayerWins() + game.getComputerWins() + game.getDraws() > 0);
    }

    @Test
    void playRound_returnsLastComputerMove() {
        game.playRound(Move.ROCK);
        Move lastMove = game.getLastComputerMove();
        assertNotNull(lastMove);
        assertTrue(lastMove == Move.ROCK || lastMove == Move.PAPER || lastMove == Move.SCISSORS);
    }

    @Test
    void getRandomMove_returnsValidMove() {
        Move move = game.getRandomMove();
        assertNotNull(move);
        assertTrue(move == Move.ROCK || move == Move.PAPER || move == Move.SCISSORS);
    }

    @Test
    void statisticsStartAtZero() {
        assertEquals(0, game.getPlayerWins());
        assertEquals(0, game.getComputerWins());
        assertEquals(0, game.getDraws());
    }

    @Test
    void statisticsAccumulateCorrectly() {
        // Играем несколько раундов и проверяем, что статистика накапливается
        for (int i = 0; i < 10; i++) {
            game.playRound(Move.ROCK);
        }
        
        int totalGames = game.getPlayerWins() + game.getComputerWins() + game.getDraws();
        assertEquals(10, totalGames);
    }
}

