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
import java.util.List;

public class APIWork {

    public static void main(String[] args) {


        APIWork aw = new APIWork();
//        String erg=aw.sucheFilmNachTitel("Westworld");
        JSONObject jo = new JSONObject();
        jo=aw.sucheFilmNachTitel("Westworld");
        System.out.println(jo);
//        Guardians of the Galaxy Vol. 2
    }




    public JSONObject sucheFilmNachTitel (String suchBegriff){

        String user="tt3896198";
        String apikey="88e80093";
        String suBegriff=suchBegriff;

//        "Guardians of the Galaxy Vol. 2"

        String subEncode;

        JSONParser jp = new JSONParser();

        String title = null,jahr=null,genre=null,schauspieler=null;

//        title + "\n" + jahr + "\n" + genre + "\n" + schauspieler
        String erg="";
        JSONObject jo=null;

        {
            try {
                subEncode = URLEncoder.encode(suBegriff, "UTF-8");
                String urlString = "http://www.omdbapi.com/?i" + user + "&apikey=" + apikey + "&t=" + subEncode;
                URL urlGet = new URL(urlString);
                InputStream is = urlGet.openStream();
                InputStreamReader ir = new InputStreamReader(is, "utf-8");

                  jo = (JSONObject) jp.parse(ir);
//                   erg = jo.toJSONString();
//                 title = (String) jo.get("Title");
//                 jahr = (String) jo.get("Year");
//                 genre = (String) jo.get("Genre");
//                 schauspieler = (String) jo.get("Director");

//                System.out.println(title + "\n" + jahr + "\n" + genre + "\n" + schauspieler);


            } catch (UnsupportedEncodingException e) {
                //Execption von Encode
                e.printStackTrace();
            } catch (MalformedURLException e) {
                //Exception von URL
                e.printStackTrace();
            } catch (IOException e) {
                //Exception von Openstream
                e.printStackTrace();
            } catch (ParseException e) {
                //Exception von jp.Parse
                e.printStackTrace();
            }
        }

        return jo;
    }

    public  Film jsonToPojo (JSONObject jo) {

        return  new Film();
    }



}
