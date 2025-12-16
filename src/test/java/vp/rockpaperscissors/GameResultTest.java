package vp.rockpaperscissors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    void getMessage_returnsCorrectMessage() {
        assertEquals("Вы выиграли!", GameResult.WIN.getMessage());
        assertEquals("Вы проиграли!", GameResult.LOSE.getMessage());
        assertEquals("Ничья!", GameResult.DRAW.getMessage());
    }
}

