package tennisGame_Home;

public class Player {
    private String name;
    private int score;
    private String advantage;
    private int countSetWins;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage;
    }

    public int getCountSetWins() {
        return countSetWins;
    }

    public void setCountSetWins(int countSetWins) {
        this.countSetWins = countSetWins;
    }
}
