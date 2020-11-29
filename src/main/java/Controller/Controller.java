package Controller;

import Database.HighScore;
import Database.HighScoreDao;
import javafx.scene.Scene;

import javax.persistence.NoResultException;

public class Controller {

    protected String game;
    protected String name1;
    protected Scene scene;
    protected HighScore score;
    HighScoreDao database = HighScoreDao.getInstance();

    public void initdata(String game, String name1) {
        this.name1 = name1;
        this.game = game;
        try {
            this.score = database.findScoreByName(game);
        } catch (NoResultException e) {
            System.out.println("No result found.");
            score = null;
        }
        System.out.println("Data initalized. Name: " + name1 + ", game: " + game);
    }

}
