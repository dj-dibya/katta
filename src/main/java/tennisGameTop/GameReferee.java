package tennisGameTop;

import tennisGameBase.InitiateGame;
import tennisGameHome.Player;

import java.util.Scanner;

public class GameReferee {
    /**
     * Starting of the application
     * This method will drive the Game
     * @param args
     */
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("WelCome to Tennis Match");
        System.out.println("Enter Player One Name");
        String playerOneName = sc.next();
        System.out.println("Enter Player Two Name");
        String playerTwoName = sc.next();

        Player playerOne = new Player(playerOneName,0);
        Player playerTwo = new Player(playerTwoName,0);
        InitiateGame game = new InitiateGame(playerOne,playerTwo);
        game.startGame();
    }
}
