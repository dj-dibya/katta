import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tennisGame_Base.InitiateGame;
import tennisGame_Base.ScoreCalculator;
import tennisGame_Home.Player;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreCalculatorTest {
    Player playerOne;
    Player playerTwo;
    InitiateGame game;
    ScoreCalculator sc;
    @BeforeEach
    public void setUp() {
        playerOne = new Player("Roger",0);
        playerTwo = new Player("Mahesh",0);
        game = new InitiateGame(playerOne,playerTwo);
        sc = new ScoreCalculator();
    }
    @ParameterizedTest
    @DisplayName("should calculate the actual result of the game and return result")
    @MethodSource("dataProviderForGetResult")
    public void shouldReturnResultOfTheGame(int playerOneScore, int playerTwoScore, String expectedPoint) {
        playerOne.setScore(playerOneScore);
        playerTwo.setScore(playerTwoScore);
        String result = sc.getResultOfTheGame(playerOne,playerTwo);
        assertEquals(expectedPoint,result);
    }
    private static Stream<Arguments> dataProviderForGetResult() {
        return Stream.of(
                Arguments.of(0, 0, null),
                Arguments.of(1, 0, "player1"),
                Arguments.of(2, 0, "player1"),
                Arguments.of(3, 0, "win player1"),
                Arguments.of(0, 1, "player2"),
                Arguments.of(0, 2, "player2"),
                Arguments.of(0, 3, "player3")
        );
    }

}
