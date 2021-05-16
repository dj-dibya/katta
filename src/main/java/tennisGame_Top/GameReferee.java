package tennisGame_Top;

import tennisGame_Base.InitiateGame;
import tennisGame_Home.Player;

public class GameReferee {
    public static void main(String [] args) {
        Player playerOne = new Player("Roger",0);
        Player playerTwo = new Player("Novak",0);
        InitiateGame game = new InitiateGame(playerOne,playerTwo);
        game.startGame();
    }
}
