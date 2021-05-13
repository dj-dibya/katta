import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tennisGame_Base.InitiateGame;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InitiategameTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("should start the game between two given players")
    public void shouldStartTheGame() {
        InitiateGame game = new InitiateGame("P1","P2");
        game.startGame();
        assertEquals("Match Started between : P1 and P2", outputStreamCaptor.toString().trim());
    }
}
