package tennisGameTop;

import tennisGameBase.InitiateGame;
import tennisGameHome.Player;

public class GameReferee {
    /**
     * Starting of the application
     * This method will drive the Game
     * @param args
     */
    public static void main(String [] args) {
        Player playerOne = new Player("Roger",0);
        Player playerTwo = new Player("Novak",0);
        InitiateGame game = new InitiateGame(playerOne,playerTwo);
        game.startGame();
    }
}
