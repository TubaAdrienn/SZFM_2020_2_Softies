package Database;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class DatabaseXML {

    public static Rules loadRules() throws Exception{
        try {
            JAXBContext context = JAXBContext.newInstance(Rules.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Rules) unmarshaller.unmarshal(DatabaseXML.class.getResourceAsStream("/data/rules.xml"));
        } catch(Exception e) {
            System.out.println("Loading rules unsuccessful");
            throw e;
        }
    }
}