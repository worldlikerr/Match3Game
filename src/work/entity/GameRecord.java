package work.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class GameRecord {
    public int points;
    public int stars;
    public int pass;
    public LocalDate time;
    public static ArrayList<GameRecord> gameRecords;

    public GameRecord(int points, int stars, int pass, LocalDate time) {
        this.points = points;
        this.stars = stars;
        this.pass = pass;
        this.time = time;
        if (gameRecords ==null)
            gameRecords =new ArrayList<>();
    }
    public GameRecord(){
        if (gameRecords ==null)
            gameRecords =new ArrayList<>();
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public static ArrayList<GameRecord> getGameRecords() {
        return gameRecords;
    }

    public static void setGameRecords(ArrayList<GameRecord> gameRecords) {
        GameRecord.gameRecords = gameRecords;
    }
}
