package Database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Builder
@Entity
public class HighScore {

    @Id
    private String game;

    private String username;

    private int score;

    public HighScore(String game, String username, int score){
        this.game=game;
        this.username=username;
        this.score=score;
    }
}