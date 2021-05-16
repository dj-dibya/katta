package tennisGame_Base;

import tennisGame_Home.Player;

public class ScoreCalculator {
    private static final int[] defaultPoints = new int[]{0, 15, 30, 40};

    public String getResultOfTheGame(Player gameWinner, Player gameLooser) {
        if(gameWinner.getScore() == 3 && gameLooser.getScore() <3) return "winner : "+gameWinner.getName();
        return gameWinner.getName();
    }

    public void displayWinnerResult(Player playerOne, Player playerTwo, String point) {
        System.out.println("Score : " + playerOne.getName() + " : " + defaultPoints[playerOne.getScore()] + " || " + playerTwo.getName() + " : " + defaultPoints[playerTwo.getScore()]);
        System.out.println("Point : "+point);
    }


}
