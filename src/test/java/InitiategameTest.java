import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tennisGameBase.InitiateGame;
import tennisGameHome.Player;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

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

    @ParameterizedTest
    @DisplayName("should start the game between two given players")
    @MethodSource("dataProviderToStartGame")
    public void shouldStartTheGame(Player p1, Player p2, Player winner) {
        InitiateGame tennisGame = new InitiateGame(p1,p2);
        tennisGame.gameWinner();
    }

    private static Stream<Arguments> dataProviderToStartGame() {
        Player p1 = new Player("Roger",0);
        Player p2 = new Player("Mahesh",0);
        return Stream.of(
                Arguments.of(p1,p2,p1)
        );
    }
    //
    @Test
    @DisplayName("should Return a player object each time player wins randomly")
    public void shouldReturnRandomWinner() {
        Player result = game.getRandomWinner(playerOne,playerTwo);
        Player winner = result.getName().equalsIgnoreCase(playerOne.getName()) ? playerOne : playerTwo;
        assertEquals(winner,result);
    }

    @Test
    @DisplayName("should return random Points 0 or 1")
    public void shouldReturnRandomNumbers() {
        int result = game.randomPoints();
        assertTrue(result == 0 || result == 1);
    }





}
