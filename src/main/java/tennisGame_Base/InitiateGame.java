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
            Player randomWinner = getRandomWinner(playerOne, playerTwo);
    }

    public Player getRandomWinner(Player playerOne, Player playerTwo) {

        return playerOne;
    }

    public int randomPoints() {
        return 5;
    }

    public void updateScore(Player player) {
        int newScore = player.getScore() + 1;
        player.setScore(newScore);
    }

}
