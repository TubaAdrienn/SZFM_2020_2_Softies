package Database;

import com.sun.marlin.stats.Histogram;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class JPADao<T> {

    protected Class<T> entityClass;

    protected EntityManager entityManager;

    public JPADao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public void update(HighScore hs, int score, String name){
        entityManager.getTransaction().begin();

        hs = entityManager.find(HighScore.class, hs.getGame());
        hs.setScore(score);
        hs.setUsername(name);

        entityManager.getTransaction().commit();
    }

    public List<T> findAll() {
        TypedQuery<T> typedQuery = entityManager.createQuery("FROM " + entityClass.getSimpleName(), entityClass);
        return typedQuery.getResultList();
    }

    public HighScore findScoreByName(String game){
        Query jpqlQuery = getEntityManager().createQuery("SELECT h FROM HighScore h WHERE h.game=:game");
        jpqlQuery.setParameter("game", game);
        return (HighScore) jpqlQuery.getSingleResult();
    }
}
