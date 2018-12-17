import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class APIWork {

    public static void main(String[] args) throws IOException {


        APIWork aw = new APIWork();
//        String erg=aw.sucheFilmNachTitel("Westworld");
        JSONObject jo = new JSONObject();
        jo = aw.sucheFilmNachTitel("Westworld");
        System.out.println(jo);
        Film f = new Film();

        f = aw.jsonToPojo(jo);
        System.out.println(f);
//        Guardians of the Galaxy Vol. 2
    }


    public JSONObject sucheFilmNachTitel(String suchBegriff) throws UnsupportedEncodingException, MalformedURLException {

        String user = "tt3896198";
        String apikey = "88e80093";
        String suBegriff = suchBegriff;
        String subEncode = URLEncoder.encode(suBegriff, "UTF-8");

        String urlString = "http://www.omdbapi.com/?i" + user + "&apikey=" + apikey + "&t=" + subEncode;

        JSONParser jp = new JSONParser();

        URL urlGet = new URL(urlString);

        JSONObject jo = null;

//        "Guardians of the Galaxy Vol. 2"

        try (InputStream is = urlGet.openStream();
             InputStreamReader ir = new InputStreamReader(is, "utf-8")) {
            jo = (JSONObject) jp.parse(ir);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jo;
    }

    public Film jsonToPojo(JSONObject jo) {
//        System.out.println(jo);
        List<String> ge = new ArrayList<>();
        List<String> ss = new ArrayList<>();
//        JSONParser jp = new JSONParser();
//        JSONObject jo2 =jo;
        String erg = jo.toJSONString();
        String title = (String) jo.get("Title");

        String jahr = (String) jo.get("Year");
        String pattern = "\\d+";
        Pattern pat = Pattern.compile(pattern);
        Matcher mat = pat.matcher(jahr);
        String jahr2 = "";
        if (mat.find()) {
            jahr2 = mat.group();
        }

        String genre = (String) jo.get("Genre");
        String pattern2 = "\\s,+";
        String[] x = genre.split(pattern2);
        for (int i = 0; i < x.length; i++) {
            ge.add(x[i]);
        }

        String schauspieler = (String) jo.get("Actors");
        String pattern3 = "\\,";
        String[] y = schauspieler.split(pattern3);
        for (int i = 0; i < y.length; i++) {
            ss.add(y[i]);
        }
//        System.out.println(schauspieler);

        Film f = new Film(title, Integer.parseInt(jahr2), ge, ss);

        return f;
    }


}
