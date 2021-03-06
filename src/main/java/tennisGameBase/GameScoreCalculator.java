package tennisGameBase;

import tennisGameHome.Player;

public class GameScoreCalculator {
    private static final int[] defaultPoints = new int[]{0, 15, 30, 40};

    /**
     * This method will return result of a game based on given condition
     */
    public String getResultOfTheGame(Player gameWinner, Player gameLooser) {
        if(gameWinner.getScore() == 3 && (gameWinner.getScore() - gameLooser.getScore()) >= 2) {
            gameWinner.setCountSetWins(gameWinner.getCountSetWins() + 1);
            return "game winner -> "+gameWinner.getName();
        }
        if(gameWinner.getScore() >= 3 || gameLooser.getScore() >= 3) return deuce(gameWinner,gameLooser);
        return gameWinner.getName();
    }

    /**
     * This method will handle the deuce condition in a game
     * @param gameWinner
     * @param gameLooser
     * @return
     */
    public String deuce(Player gameWinner, Player gameLooser) {
        if(gameWinner.getScore() == gameLooser.getScore()) return "deuce";
        if(gameWinner.getScore() > gameLooser.getScore() && "Y".equalsIgnoreCase(gameWinner.getAdvantage())) {
            gameWinner.setCountSetWins(gameWinner.getCountSetWins() + 1);
            return "game winner -> "+gameWinner.getName();
        }
        if(gameWinner.getScore() - gameLooser.getScore() == 1 && gameLooser.getScore() == 2) {
            return  gameWinner.getName();
        }
        if(gameWinner.getScore() > gameLooser.getScore() && gameWinner.getAdvantage() == null) {
            gameWinner.setAdvantage("Y");
            gameLooser.setAdvantage(null);
            return "Advantage - "+gameWinner.getName();
        }
        return gameWinner.getName();
    }

    /**
     * This method will display score and point of each game
     * @param playerOne
     * @param playerTwo
     * @param point
     */
    public void displayWinnerResult(Player playerOne, Player playerTwo, String point) {
        if(playerOne.getScore() > 3 || playerTwo.getScore() > 3) {
            System.out.println("Score : " + playerOne.getName() + " : " + defaultPoints[3] + " || " + playerTwo.getName() + " : " + defaultPoints[3]);
        }else {
            System.out.println("Score : " + playerOne.getName() + " : " + defaultPoints[playerOne.getScore()] + " || " + playerTwo.getName() + " : " + defaultPoints[playerTwo.getScore()]);
        }
        System.out.println("Point : "+point);
    }


}
