package tennisGame_Base;

import tennisGame_Home.Player;

public class InitiateGame {
    private Player playerOne;
    private Player playerTwo;

    public InitiateGame(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void startGame() {
        System.out.println("Match Started between : "+ playerOne.getName() +" and "+ playerTwo.getName());
        System.out.println("Score : " + playerOne.getName() + " : " + playerOne.getScore() + " || " + playerTwo.getName() + " : " + playerTwo.getScore());
        ScoreCalculator sc = new ScoreCalculator();
        String resultOfGame;
            do {
                Player randomWinner = getRandomWinner(playerOne, playerTwo);
                if(randomWinner.getName().equalsIgnoreCase(playerOne.getName())) {
                    resultOfGame = sc.getResultOfTheGame(playerOne, playerTwo);
                } else {
                    resultOfGame = sc.getResultOfTheGame(playerTwo, playerOne);
                }
                sc.displayWinnerResult(playerOne,playerTwo,resultOfGame);
            } while(!resultOfGame.contains("winner"));
    }

    public Player getRandomWinner(Player playerOne, Player playerTwo) {
        Player randomWinner = randomPoints() == 0 ? playerOne : playerTwo;
        updateScore(randomWinner);
        return randomWinner;
    }

    public int randomPoints() {
        return 5;
    }

    public void updateScore(Player player) {
        int newScore = player.getScore() + 1;
        player.setScore(newScore);
    }

}
