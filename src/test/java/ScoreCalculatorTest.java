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
    public void shouldReturnResultOfTheGame(int playerOneScore, int playerTwoScore, String playerOneName, String playerTwoName, String winner, String expectedPoint) {
        if("playerOne".equalsIgnoreCase(winner)) {
            playerOne.setScore(playerOneScore);
            playerOne.setName(playerOneName);
            playerTwo.setScore(playerTwoScore);
            playerTwo.setName(playerTwoName);
        }else {
            playerOne.setScore(playerTwoScore);
            playerOne.setName(playerTwoName);
            playerTwo.setScore(playerOneScore);
            playerTwo.setName(playerOneName);
        }
        String result = sc.getResultOfTheGame(playerOne,playerTwo);
        assertEquals(expectedPoint,result);
    }
    private static Stream<Arguments> dataProviderForGetResult() {
        return Stream.of(
                Arguments.of(0, 0, null,null,null,null),
                Arguments.of(1, 0, "Roger", "Mahesh", "playerOne", "Roger"),
                Arguments.of(2, 0, "Roger", "Mahesh", "playerOne", "Roger"),
                Arguments.of(3, 0, "Roger", "Mahesh", "playerOne", "winner : Roger"),
                Arguments.of(0, 1, "Roger", "Mahesh", "playerTwo", "Mahesh"),
                Arguments.of(0, 2, "Roger", "Mahesh", "playerTwo", "Mahesh"),
                Arguments.of(0, 3, "Roger", "Mahesh", "playerTwo", "winner : Mahesh")
        );
    }

}
