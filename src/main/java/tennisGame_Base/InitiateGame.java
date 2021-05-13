package tennisGame_Base;

public class InitiateGame {
    private String player_one;
    private String player_two;

    public InitiateGame(String player_one, String player_two) {
        this.player_one = player_one;
        this.player_two = player_two;
    }

    public void startGame() {
        System.out.println("Match Started between : "+player_one+" and "+ player_two);
    }
}
