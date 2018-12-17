import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONBasic {

    public static void main(String[] args) {

        String input = "{\n" +
                "\"vorname\":\"Lena\",\n" +
                "\"nachname\":\"Friedrichs\",\n" +
                "\"geburtsdatum\":\"21.03.1990\",\n" +
                "\"wohnort\":\"Köln\"\n" +
                "}\n" +
                "";

//        System.out.println(input);
        JSONParser parser;
        parser =new JSONParser();
        try {
            JSONObject jsoonObject = (JSONObject) parser.parse(input);
            String vorname = (String)jsoonObject.get("vorname");
            String wohnort = (String) jsoonObject.get("wohnort");

            System.out.printf("%s,%s", vorname,wohnort);
         } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
