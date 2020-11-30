package Controller;

import Database.HighScore;
import Database.HighScoreDao;
import javafx.scene.Scene;

import javax.persistence.NoResultException;

public class Controller {

    protected String game;
    protected String name1;
    protected HighScore score = new HighScore(game,name1,0);;
    HighScoreDao database = HighScoreDao.getInstance();

    public void initdata(String game, String name1) {
        this.name1 = name1;
        this.game = game;
        try {
            this.score = database.findScoreByName(game);
        } catch (NoResultException e) {
            score=null;
            System.out.println("No result found.");
        }
        System.out.println("Data initalized. Name: " + name1 + ", game: " + game);
    }

}
