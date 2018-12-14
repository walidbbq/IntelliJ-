import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class einsDatenAuslesen {


    public static void main(String[] args) {
        String input ="{\n" +
                "\"ip\": \"88.131.21.121\",\n" +
                "\"hostname\": \"mue-88-131-40-121.dsl.tropolys.de\",\n" +
                "\"city\": \"Dortmund\",\n" +
                "\"region\": \"North Rhine-Westphalia\",\n" +
                "\"country\": \"DE\",\n" +
                "\"loc\": \"51.5161,7.4683\",\n" +
                "\"postal\": \"44289\"\n" +
                "}";


        JSONParser jp = new JSONParser();

        try {

            JSONObject jo = (JSONObject) jp.parse(input);
            String hostname = (String) jo.get("hostname");
            String city = (String) jo.get("city");
            String postal = (String) jo.get("postal");
            System.out.printf("%s,%s,%s",hostname,city,postal);


        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }


}
