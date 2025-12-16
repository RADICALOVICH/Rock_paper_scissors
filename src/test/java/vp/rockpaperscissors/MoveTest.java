package vp.rockpaperscissors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    void rockBeatsScissors() {
        assertTrue(Move.ROCK.beats(Move.SCISSORS));
    }

    @Test
    void paperBeatsRock() {
        assertTrue(Move.PAPER.beats(Move.ROCK));
    }

    @Test
    void scissorsBeatsPaper() {
        assertTrue(Move.SCISSORS.beats(Move.PAPER));
    }

    @Test
    void rockDoesNotBeatPaper() {
        assertFalse(Move.ROCK.beats(Move.PAPER));
    }

    @Test
    void paperDoesNotBeatScissors() {
        assertFalse(Move.PAPER.beats(Move.SCISSORS));
    }

    @Test
    void scissorsDoesNotBeatRock() {
        assertFalse(Move.SCISSORS.beats(Move.ROCK));
    }

    @Test
    void moveDoesNotBeatItself() {
        assertFalse(Move.ROCK.beats(Move.ROCK));
        assertFalse(Move.PAPER.beats(Move.PAPER));
        assertFalse(Move.SCISSORS.beats(Move.SCISSORS));
    }

    @Test
    void getNameReturnsCorrectName() {
        assertEquals("камень", Move.ROCK.getName());
        assertEquals("бумага", Move.PAPER.getName());
        assertEquals("ножницы", Move.SCISSORS.getName());
    }
}

