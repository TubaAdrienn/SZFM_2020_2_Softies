package Database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
import java.util.NoSuchElementException;

@XmlRootElement(name="rules")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rules {

    private List<Rule> data;

    public void setData(List<Rule> data) {
        this.data = data;
    }

    public Rule getRuleByName(String gameToGet) throws NoSuchElementException {
        Rule rule = data.stream().filter(game -> game.getGame().equals(gameToGet)).findAny().get();
        return rule;
    }
}
