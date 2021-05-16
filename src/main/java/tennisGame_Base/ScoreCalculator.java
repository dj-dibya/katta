package tennisGame_Base;

import tennisGame_Home.Player;

public class ScoreCalculator {
    private static final int[] defaultPoints = new int[]{0, 15, 30, 40};

    public String getResultOfTheGame(Player gameWinner, Player gameLooser) {
        if(gameWinner.getScore() == 3 && (gameWinner.getScore() - gameLooser.getScore()) >= 2) return "winner -> "+gameWinner.getName();
        if(gameWinner.getScore() >= 3 && gameLooser.getScore() >= 3) return deuce(gameWinner,gameLooser);
        return gameWinner.getName();
    }

    public String deuce(Player gameWinner, Player gameLooser) {
        if(gameWinner.getScore() == gameLooser.getScore()) return "deuce";
        if(gameWinner.getScore() > gameLooser.getScore() && "Y".equalsIgnoreCase(gameWinner.getAdvantage())) return "winner -> "+gameWinner.getName();
        if(gameWinner.getScore() > gameLooser.getScore() && gameWinner.getAdvantage() == null) {
            gameWinner.setAdvantage("Y");
            gameLooser.setAdvantage(null);
            return "Advantage - "+gameWinner.getName();
        }
        return null;
    }

    public void displayWinnerResult(Player playerOne, Player playerTwo, String point) {
        if(playerOne.getScore() > 3 || playerTwo.getScore() > 3) {
            System.out.println("Score : " + playerOne.getName() + " : " + defaultPoints[3] + " || " + playerTwo.getName() + " : " + defaultPoints[3]);
        }else {
            System.out.println("Score : " + playerOne.getName() + " : " + defaultPoints[playerOne.getScore()] + " || " + playerTwo.getName() + " : " + defaultPoints[playerTwo.getScore()]);
        }
        System.out.println("Point : "+point);
    }


}
