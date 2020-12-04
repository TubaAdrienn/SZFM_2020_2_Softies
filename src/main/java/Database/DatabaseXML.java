package Database;


import lombok.extern.log4j.Log4j2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
@Log4j2
public class DatabaseXML {

    public static Rules loadRules() throws Exception{
        try {
            JAXBContext context = JAXBContext.newInstance(Rules.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Rules) unmarshaller.unmarshal(DatabaseXML.class.getResourceAsStream("/data/rules.xml"));
        } catch(Exception e) {
            log.error("Loading rules unsuccessful");
            throw e;
        }
    }
}