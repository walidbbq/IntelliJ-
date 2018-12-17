import org.json.simple.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class ViewController {


    public static void main(String[] args) throws UnsupportedEncodingException, MalformedURLException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Nach welchem Film bzw. nach Welcher Serie möchten Sie suchen?  Bitte" +
                "geben Sie einen Titel ein: ");
        String titel = scn.nextLine();


        APIWork aw = new APIWork();
        JSONObject jo = aw.sucheFilmNachTitel(titel);
        System.out.println(aw.jsonToPojo(jo));


    }
}


