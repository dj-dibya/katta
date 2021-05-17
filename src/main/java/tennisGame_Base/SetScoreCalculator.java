package tennisGame_Base;

import tennisGame_Home.Player;

public class SetScoreCalculator {
    private int playerOneWins;
    private int playerTwoWins;

    public String getResultOfTheSet(Player playerOne, Player playerTwo) {
        this.playerOneWins = playerOne.getCountSetWins();
        this.playerTwoWins = playerTwo.getCountSetWins();
        if(playerOneWins >= 6 || playerTwoWins >= 6)  return setWinner(playerOne,playerTwo);
        Player defaultWinner = (playerOneWins > playerTwoWins) ? playerOne : playerTwo;
        return defaultWinner.getName();
    }

    private String setWinner(Player playerOne, Player playerTwo) {
        if(playerOneWins >= 6 && (playerOneWins - playerTwoWins) >= 2) return "SetWinner => "+playerOne.getName();
        if(playerTwoWins >= 6 && (playerTwoWins - playerOneWins) >= 2) return "SetWinner => "+playerTwo.getName();
        if(playerOneWins == 7 && (playerTwoWins >=5 && playerTwoWins <7)) return "SetWinner => "+playerOne.getName();
        if(playerTwoWins == 7 && (playerOneWins >=5 && playerOneWins <7)) return "SetWinner => "+playerTwo.getName();
        return "";
    }


    public void disPlaySetResult(Player playerOne, Player playerTwo, String result) {
        System.out.println("SetScore :> " + playerOne.getName() + " :: " + playerOne.getCountSetWins() + " || " + playerTwo.getName() + " :: " + playerTwo.getCountSetWins());
        System.out.println("Set : "+result);
    }
}
