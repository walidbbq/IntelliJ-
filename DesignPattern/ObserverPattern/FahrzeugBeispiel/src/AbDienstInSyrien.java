import java.util.ArrayList;
import java.util.List;

public class AbDienstInSyrien implements Beobachter {
    List<Fahrzeug> pkws = new ArrayList<>();

    public  void AutoZerst�ren (Fahrzeug f) {
        System.out.println("Auto wird gleich zerst�rt!");
    }

    public boolean AddPKW (Fahrzeug f){
        pkws.add(f);
        f.registriereBeobachter(this);
        return true;
    }

    @Override
    public void aktualisieren(String info) {

        Fahrzeug frinfo = new Fahrzeug (info,"","",new Motor(0,""));
        for (Fahrzeug pkw: pkws){
            if (frinfo.equals(pkw)) {
                AutoZerst�ren(pkw);
            }

        }
    }
}
