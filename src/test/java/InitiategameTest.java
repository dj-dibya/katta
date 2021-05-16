import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import tennisGame_Base.InitiateGame;
import tennisGame_Home.Player;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InitiategameTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    Player playerOne;
    Player playerTwo;
    InitiateGame game;
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        playerOne = new Player("Roger",0);
        playerTwo = new Player("Mahesh",0);
        game = new InitiateGame(playerOne,playerTwo);
    }

    @Test
    @DisplayName("should start the game between two given players")
    public void shouldStartTheGame() {
        game.startGame();
        assertEquals("Match Started between : Roger and Mahesh\r\nScore : Roger : 0 || Mahesh : 0", outputStreamCaptor.toString().trim());
    }

    @ParameterizedTest
    @DisplayName("should Return a player object each time player wins randomly")
    @ValueSource(ints = {0,1})
    public void shouldReturnRandomWinner(int randomPoint) {
        Mockito.when(game.randomPoints()).thenReturn(randomPoint);
        Player result = game.getRandomWinner(playerOne,playerTwo);
        Player winner = randomPoint == 0 ? playerOne : playerTwo;
        assertEquals(winner,result);
    }

    @Test
    @DisplayName("should return random Points 0 or 1")
    public void shouldReturnRandomNumbers() {
        int result = game.randomPoints();
        assertTrue(result == 0 || result == 1);
    }





}
