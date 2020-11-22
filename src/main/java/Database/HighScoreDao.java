package Database;

import javax.persistence.Persistence;

public class HighScoreDao extends JPADao<HighScore> {

    private static HighScoreDao instance;

    private HighScoreDao() {
        super(HighScore.class);
    }

    public static HighScoreDao getInstance() {
        if (instance == null) {
            instance = new HighScoreDao();
            instance.setEntityManager(Persistence.createEntityManagerFactory("test").createEntityManager());
        }
        return instance;
    }
}