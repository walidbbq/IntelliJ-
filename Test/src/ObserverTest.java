
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObserverTest {

    public static void main(String[] args) {
        // ====
        LichtschrankeP ls = new LichtschrankeP();
        ls.id = 124;
        AutomatischeTuerP at = new AutomatischeTuerP(ls);
        ls.unterbrechen();
    }
}
// Observer Pattern wird durch Interfaces umgesetzt: 

interface Beobachtbar {
    void registriereBeobachter(Beobachter b);
    void deregistriereBeobachter(Beobachter b);
    void benachrichtigeBeobachter();
}

interface Beobachter {
    void aktualisiere(int id);
}

class LichtschrankeP implements Beobachtbar {
    int id;


    private List<Beobachter> liste = new ArrayList<>();

    void unterbrechen() {
        System.out.println("Lichtschranke wird unterbrochen");
        benachrichtigeBeobachter();
    }
    @Override
    public void registriereBeobachter(Beobachter b) {
        liste.add(b);
    }
    @Override
    public void deregistriereBeobachter(Beobachter b) {
        liste.remove(b);
    }
    @Override
    public void benachrichtigeBeobachter() {
         for (Beobachter b : liste) {
            b.aktualisiere(this.id);
        }

    }
}


class AutomatischeTuerP implements Beobachter {

    // AutomatischeTuer muss sich bei Lichtschranke registrieren
    AutomatischeTuerP(Beobachtbar bb) {
//        bb.deregistriereBeobachter(this);
        bb.registriereBeobachter(this);
    }

    void oeffnen() {
        System.out.println("Tür öffnet sich");
    }

    @Override
    public void aktualisiere(int s) {
        System.out.println("Aktualisiere kommt von id=" + s);
            if (s==124)
            this.oeffnen();	// Hier steht die Aktion, die ausgelöst wird,
        // wenn die Lichtschranke unterbrochen wird.
    }

}