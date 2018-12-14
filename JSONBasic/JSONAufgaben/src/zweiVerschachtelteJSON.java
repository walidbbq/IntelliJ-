import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Iterator;

public class zweiVerschachtelteJSON {

    public static void main(String[] args) {

        String input ="{\n" +
                "\"vorname\": \"Lena\",\n" +
                "\"nachname\": \"Mendes\",\n" +
                "\"stadt\": \"Koeln\",\n" +
                "\"freunde\":\n" +
                "[ {\"vorname\":\"Elisabeth\", \"nachname\":\"Schickentanz\"},\n" +
                "{\"vorname\":\"Tina\", \"nachname\":\"Fliedern\"},\n" +
                "{\"vorname\":\"Fabian\", \"nachname\":\"Riegel\"} ]\n" +
                "}";


        JSONParser jp = new JSONParser();

        try {

            JSONObject jo = (JSONObject) jp.parse(input);
//           String Vorname = (String) jo.get("vorname");
//            String Nachname = (String) jo.get("nachname");
//           String Stadt = (String) jo.get("stadt");
//
//           System.out.printf("%s,%s,%s",Vorname,Nachname,Stadt);

            JSONArray ja = (JSONArray) jo.get("freunde");
            Iterator <JSONObject> ijo =  ja.iterator();
           while ( ijo.hasNext()) {
                JSONObject jTemp =ijo.next();
                String vorname = (String) jTemp.get("vorname");
                String nachname = (String) jTemp.get("nachname");
               System.out.printf("%s,%s ,",vorname,nachname);
            }

        }catch (ParseException pe) {
            pe.printStackTrace();
        }
    }
}
