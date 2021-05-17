import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tennisGameBase.InitiateGame;
import tennisGameBase.GameScoreCalculator;
import tennisGameHome.Player;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameScoreCalculatorTest {
    Player playerOne;
    Player playerTwo;
    InitiateGame game;
    GameScoreCalculator sc;
    @BeforeEach
    public void setUp() {
        playerOne = new Player("Roger",0);
        playerTwo = new Player("Mahesh",0);
        game = new InitiateGame(playerOne,playerTwo);
        sc = new GameScoreCalculator();
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
                Arguments.of(3, 0, "Roger", "Mahesh", "playerOne", "game winner -> Roger"),
                Arguments.of(3, 1, "Roger", "Mahesh", "playerOne", "game winner -> Roger"),
                Arguments.of(3, 2, "Roger", "Mahesh", "playerOne", "Roger"),
                Arguments.of(0, 1, "Roger", "Mahesh", "playerTwo", "Mahesh"),
                Arguments.of(0, 2, "Roger", "Mahesh", "playerTwo", "Mahesh"),
                Arguments.of(0, 3, "Roger", "Mahesh", "playerTwo", "game winner -> Mahesh"),
                Arguments.of(1, 3, "Roger", "Mahesh", "playerTwo", "game winner -> Mahesh"),
                Arguments.of(2, 3, "Roger", "Mahesh", "playerTwo", "Mahesh")
        );
    }
    //
    @ParameterizedTest
    @DisplayName("should test deuce condition in a game")
    @MethodSource("dataProviderForDeuceCondition")
    public void shouldTestDeuce(int playerOneScore, int playerTwoScore, String playerOneadvantage, String playerTwoadvantage, String expectedPoint) {

        Player p1 = new Player("Roger",playerOneScore);
        p1.setAdvantage(playerOneadvantage);
        Player p2 = new Player("Mahesh",playerTwoScore);
        p2.setAdvantage(playerTwoadvantage);
        String result;
        if(playerTwoScore > playerOneScore) {
            result = sc.deuce(p2, p1);
        } else {
            result = sc.deuce(p1, p2);
        }
        assertEquals(expectedPoint,result);
    }
    private static Stream<Arguments> dataProviderForDeuceCondition() {
        return Stream.of(
                Arguments.of(0, 0, null, null, "deuce"),
                Arguments.of(3, 3, null, null, "deuce"),
                Arguments.of(4, 3, null, null, "Advantage - Roger"),
                Arguments.of(4, 4, null, null, "deuce"),
                Arguments.of(4, 5, null, null, "Advantage - Mahesh"),
                Arguments.of(4, 5, null, "Y", "winner -> Mahesh"),
                Arguments.of(6, 5, "Y", null, "winner -> Roger")
        );
    }


}
