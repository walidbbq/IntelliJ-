//import org.json.JSONString;
import com.google.gson.Gson;
import org.json.simple.JSONValue;

import java.util.*;

public class Produkt {

    private List <Produkt> produkte = new ArrayList<>();
    private String name;
    private String marke;
    private Double preis;
    private boolean vorraetig;



    public Produkt() {

    }

    public Produkt(String name, String marke, Double preis, boolean vorraetig) {
        this.name = name;
        this.marke = marke;
        this.preis = preis;
        this.vorraetig = vorraetig;
    }

    public List<Produkt> getProdukte() {
        return produkte;
    }

    public void setProdukte(List<Produkt> produkte) {
        this.produkte = produkte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public boolean getVorraetig() {
        return vorraetig;
    }

    public void setVorraetig(boolean vorraetig) {
        this.vorraetig = vorraetig;
    }

    public static String jsonToString  (Produkt [] produkte ) {
        List<String> lTemp = new ArrayList<>();
        for (Produkt p : produkte) {
            lTemp.add(p.toString());
        }

            String json = JSONValue.toJSONString(lTemp);
            return json;
        }


    @Override
    public String toString() {
        return
                "Name='" + name + '\'' +
                ", Marke='" + marke + '\'' +
                ", Preis=" + preis +
                ", Vorrätig=" + vorraetig
                ;
    }

    public static void main(String[] args) {



//        Produkt.produkte.add(new Produkt())
        Produkt p = new Produkt("Staubsauger","Dyson",230.50,true);
        Map<String,String> hmp = new LinkedHashMap<>();

        Produkt [] parr = {new Produkt("Staubsauger","Dyson",230.50,true),
                            new Produkt("Staubsauger","Dyson",230.50,true),
                            new Produkt("Staubsauger","Dyson",230.50,true)};

        Gson gson = new Gson();
        String str = Produkt.jsonToString(parr);
//        String str = JSONValue.toJSONString(parr);
//        System.out.println(str);
//        System.out.println(str);

        hmp.put("Name",p.getName());
        hmp.put("Marke",p.getMarke());
        hmp.put("Preis",Double.toString(p.getPreis()));
        hmp.put("Vorrätig",Boolean.toString(p.getVorraetig()));
        hmp.put("ZweiteEbene", str);

//        System.out.println(hmp);
        System.out.println( JSONValue.toJSONString(hmp));



    }


}
