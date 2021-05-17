import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tennisGameBase.InitiateGame;
import tennisGameBase.SetScoreCalculator;
import tennisGameHome.Player;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetScoreCalculatorTest {
    Player playerOne;
    Player playerTwo;
    InitiateGame game;
    SetScoreCalculator sc;
    @BeforeEach
    public void setUp() {
        playerOne = new Player("Roger",0);
        playerTwo = new Player("Mahesh",0);

    }
    @ParameterizedTest
    @DisplayName("should calculate the result of a tennis game set and return result")
    @MethodSource("dataProviderForGetResultOfTheSet")
    public void shouldReturnResultOfTheSet(int playerOneSetCounts, int playerTwoSetCounts, String expectedPoint) {
        playerOne.setCountSetWins(playerOneSetCounts);
        playerTwo.setCountSetWins(playerTwoSetCounts);
        sc = new SetScoreCalculator();
        String result = sc.getResultOfTheSet(playerOne,playerTwo);
        assertEquals(expectedPoint,result);
    }
    private static Stream<Arguments> dataProviderForGetResultOfTheSet() {
        return Stream.of(
                Arguments.of(1, 0,"Roger"),
                Arguments.of(2, 0,"Roger"),
                Arguments.of(3, 0,"Roger"),
                Arguments.of(3, 1,"Roger"),
                Arguments.of(6, 2,"SetWinner => Roger"),
                Arguments.of(0, 1,"Mahesh"),
                Arguments.of(0, 2,"Mahesh"),
                Arguments.of(0, 3,"Mahesh"),
                Arguments.of(1, 3,"Mahesh"),
                Arguments.of(2, 6,"SetWinner => Mahesh")
        );
    }
    //
}
