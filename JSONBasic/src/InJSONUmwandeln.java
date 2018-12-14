import org.json.simple.JSONValue;

import java.util.Map;
import java.util.HashMap;

class  Kunde {
    private int kid;
    private String vorname;
    private String nachname;

    public int getKid() {
        return kid;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "kid=" + kid +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                '}';
    }
}

public class InJSONUmwandeln {

    public static void main(String[] args) {

        Kunde k = new Kunde ();
        k.setKid(102);
        k.setVorname("Paul");
        k.setNachname("Auster");

        System.out.println(k);

        Map<String, String> kundeMap = new HashMap<> ();
        kundeMap.put("kid",Integer.toString(k.getKid()));
        kundeMap.put("vorname",k.getVorname());
        kundeMap.put("nachname",k.getNachname());

        System.out.println(kundeMap);

        String jsonString = JSONValue.toJSONString(kundeMap);
        System.out.println(jsonString);

    }
}
