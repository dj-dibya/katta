package tennisGameBase;

import tennisGameHome.Player;

import static tennisGameBase.TennisConstants.SET_WINNER;

public class SetScoreCalculator {
    private int playerOneWins;
    private int playerTwoWins;

    /**
     * This method will return result of a set
     * @param playerOne
     * @param playerTwo
     * @return
     */
    public String getResultOfTheSet(Player playerOne, Player playerTwo) {
        this.playerOneWins = playerOne.getCountSetWins();
        this.playerTwoWins = playerTwo.getCountSetWins();
        if(playerOneWins >= 6 || playerTwoWins >= 6)  return setWinner(playerOne,playerTwo);
        Player defaultWinner = (playerOneWins > playerTwoWins) ? playerOne : playerTwo;
        return defaultWinner.getName();
    }

    /**
     * This method will handle win/ tie condition in a set
     * @param playerOne
     * @param playerTwo
     * @return
     */
    private String setWinner(Player playerOne, Player playerTwo) {
        if(playerOneWins >= 6 && (playerOneWins - playerTwoWins) >= 2) return SET_WINNER+playerOne.getName();
        if(playerTwoWins >= 6 && (playerTwoWins - playerOneWins) >= 2) return SET_WINNER+playerTwo.getName();
        if(playerOneWins == 7 && (playerTwoWins >=5 && playerTwoWins <7)) return SET_WINNER+playerOne.getName();
        if(playerTwoWins == 7 && (playerOneWins >=5 && playerOneWins <7)) return SET_WINNER+playerTwo.getName();
        return "";
    }

    /**
     * This method will show result of each set
     * @param playerOne
     * @param playerTwo
     * @param result
     */
    public void disPlaySetResult(Player playerOne, Player playerTwo, String result) {
        System.out.println("SetScore :> " + playerOne.getName() + " :: " + playerOne.getCountSetWins() + " || " + playerTwo.getName() + " :: " + playerTwo.getCountSetWins());
        System.out.println("Set : "+result);
    }
}
