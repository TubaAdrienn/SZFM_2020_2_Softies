package Controller;

import Database.HighScore;
import Database.HighScoreDao;
import javafx.scene.Scene;
import lombok.extern.log4j.Log4j2;

import javax.persistence.NoResultException;
@Log4j2
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
            //log.error("No result.");
        }

    }

}
