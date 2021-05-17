package tennisGameBase;

import tennisGameHome.Player;

import java.util.Random;

public class InitiateGame {
    private Player playerOne;
    private Player playerTwo;

    public InitiateGame(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    /**
     * This method will start each set  till it gets a winner
     */
    public void startGame() {
        SetScoreCalculator setScoreCalculator = new SetScoreCalculator();
        String result;
        System.out.println("Match Started between : "+ playerOne.getName() +" and "+ playerTwo.getName());
        System.out.println("SetScore : " + playerOne.getName() + " :: " + playerOne.getCountSetWins() + " || " + playerTwo.getName() + " :: " + playerTwo.getCountSetWins());
        do{
            System.out.println("-----------------------------------------------------------");
            playerOne.setScore(0);
            playerOne.setAdvantage(null);
            playerTwo.setScore(0);
            playerTwo.setAdvantage(null);
            gameWinner();
            result = setScoreCalculator.getResultOfTheSet(playerOne,playerTwo);
            System.out.println("-----------------------------------------------------------");
            setScoreCalculator.disPlaySetResult(playerOne,playerTwo,result);
        } while(!result.contains("SetWinner"));
    }
    /**
     * This method will start each game till it gets a winner
     */
    public void gameWinner() {
        System.out.println("Score : " + playerOne.getName() + " : " + playerOne.getScore() + " || " + playerTwo.getName() + " : " + playerTwo.getScore());
        GameScoreCalculator gameScoreCalculator = new GameScoreCalculator();
        String resultOfGame;
        do {
            Player randomWinner = getRandomWinner(playerOne, playerTwo);
            if(randomWinner.getName().equalsIgnoreCase(playerOne.getName())) {
                resultOfGame = gameScoreCalculator.getResultOfTheGame(playerOne, playerTwo);
            } else {
                resultOfGame = gameScoreCalculator.getResultOfTheGame(playerTwo, playerOne);
            }
            gameScoreCalculator.displayWinnerResult(playerOne,playerTwo,resultOfGame);
        } while(!resultOfGame.contains("winner"));
    }
    /**
     * This method will get a random winner each game
     */
    public Player getRandomWinner(Player playerOne, Player playerTwo) {
        Player randomWinner = (randomPoints() == 0) ? playerOne : playerTwo;
        updateScore(randomWinner);
        return randomWinner;
    }
    /**
     * This method will generate random numbers between 0 and 1
     */
    public int randomPoints() {
        return new Random().nextInt(2);
    }
    /**
     * This method increment current score of each random winner
     */
    public void updateScore(Player player) {
        int newScore = player.getScore() + 1;
        player.setScore(newScore);
    }

}
