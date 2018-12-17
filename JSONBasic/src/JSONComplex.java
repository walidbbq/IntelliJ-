import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Iterator;

public class JSONComplex {

    public static void main(String[] args) {
        String input = "{ \"data\":\n" +
                "[ {\n" +
                "\"vorname\": \"Teresa\",\n" +
                "\"nachname\": \"Mueller\",\n" +
                "\"produkte\": \"Waschmaschine, Haartrockner, Tafelsilber\",\n" +
                "\"freunde\":\n" +
                "[ {\"vorname\":\"Elisabeth\", \"nachname\":\"Schickentanz\"},\n" +
                "{\"vorname\":\"Tina\", \"nachname\":\"Fliedern\"},\n" +
                "{\"vorname\":\"Fabian\", \"nachname\":\"Riegel\"} ]\n" +
                "},\n" +
                "{\n" +
                "\"vorname\": \"Peter\",\n" +
                "\"nachname\": \"Schmitz\",\n" +
                "\"produkte\": \"Rucksack, Fahrrad, Hose\",\n" +
                "\"freunde\":\n" +
                "[ {\"vorname\":\"Sebastian\", \"nachname\":\"Toeller\"},\n" +
                "{\"vorname\":\"Tina\", \"nachname\":\"Fliedern\"} ]\n" +
                "} ]\n" +
                "} "+
                "";

        System.out.println(input);
        JSONParser jp = new JSONParser();
        try {
            JSONObject jobj = (JSONObject) jp.parse(input);
            JSONArray data = (JSONArray) jobj.get("data");
//            String vorname = (String) data.
            Iterator <JSONObject> iter = data.iterator();

            while (iter.hasNext()) {
                JSONObject jsobj =iter.next();
                String vorname = (String) jsobj.get("vorname");
                System.out.println("vorname= " + vorname);

                JSONArray freunde = (JSONArray) jsobj.get("freunde");
                Iterator <JSONObject> itf =freunde.iterator();

                while (itf.hasNext()){
                    JSONObject jsfr = itf.next();
                    String nachname = (String) jsfr.get("nachname");
                    System.out.println("nachname= "+ nachname);
                }

            }

        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }
}
