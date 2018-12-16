import org.json.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.*;



public class jsonToHashMap {

    public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
        Map<String, Object> retMap = new HashMap<String, Object>();

        if(json != JSONObject.NULL) {
            retMap = toMap(json);
        }
        return retMap;
    }

    public static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    public static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }

    public static void main(String[] args) {
//        String j = "{\"Title\":\"Guardians of the Galaxy Vol. 2\",\"Year\":\"2017\",\"Rated\":\"PG-13\",\"Released\":\"05 May 2017\",\"Runtime\":\"136 min\",\"Genre\":\"Action, Adventure, Comedy, Sci-Fi\",\"Director\":\"James Gunn\",\"Writer\":\"James Gunn, Dan Abnett (based on the Marvel comics by), Andy Lanning (based on the Marvel comics by), Steve Englehart (Star-Lord created by), Steve Gan (Star-Lord created by), Jim Starlin (Gamora and Drax created by), Stan Lee (Groot created by), Larry Lieber (Groot created by), Jack Kirby (Groot created by), Bill Mantlo (Rocket Raccoon created by), Keith Giffen (Rocket Raccoon created by), Steve Gerber (Howard the Duck created by), Val Mayerik (Howard the Duck created by)\",\"Actors\":\"Chris Pratt, Zoe Saldana, Dave Bautista, Vin Diesel\",\"Plot\":\"The Guardians must fight to keep their newfound family together as they unravel the mystery of Peter Quill's true parentage.\",\"Language\":\"English\",\"Country\":\"USA\",\"Awards\":\"Nominated for 1 Oscar. Another 12 wins & 42 nominations.\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMTg2MzI1MTg3OF5BMl5BanBnXkFtZTgwNTU3NDA2MTI@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.7/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"83%\"},{\"Source\":\"Metacritic\",\"Value\":\"67/100\"}],\"Metascore\":\"67\",\"imdbRating\":\"7.7\",\"imdbVotes\":\"422,969\",\"imdbID\":\"tt3896198\",\"Type\":\"movie\",\"DVD\":\"22 Aug 2017\",\"BoxOffice\":\"$389,804,217\",\"Production\":\"Walt Disney Pictures\",\"Website\":\"https://marvel.com/guardians\",\"Response\":\"True\"}";
            String j = "{ \"data\":\n" +
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
                    "}";
        JSONParser jp = new JSONParser();
        Map<String, Object> retMap = new HashMap<String, Object>();

        try {
            JSONObject jo = (JSONObject) jp.parse(j);
//          JSONArray ja = (JSONArray) joo.get("data");
            System.out.println(jsonToHashMap.jsonToMap(jo));


        } catch (ParseException e ) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


//        JSONObject jo = new JSONObject();
//        try {
////            jsonToHashMap.jsonToMap((JSONObject) jo.get(j));
//            System.out.println(jo.get(j));
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


    }


}
