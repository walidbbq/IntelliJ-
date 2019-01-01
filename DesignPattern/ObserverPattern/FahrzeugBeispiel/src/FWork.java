import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface Beobachter {
    void aktualisieren(String str);
}

interface Subjekt {
    void registriereBeobachter(Beobachter beobachter);

    void deregistriereBeobachterr(Beobachter beobachter);

    void beanachrichtigeAlleBeobachter();
}

//===Motor===//

class Motor {
    private int leistung;
    private String typ;
    private int status;

     Motor(int leistung, String typ) {
        this.leistung = leistung;
        this.typ = typ;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "leistung=" + leistung +
                ", typ='" + typ + '\'' +
                ", status=" + status +
                '}';
    }

    public boolean starten() {
        Random rn = new Random();
        int temp = rn.nextInt(6)+1;
                if (temp ==6) {
//                    System.out.println("Motor defekt");
                    return false;
                }
//        System.out.println("Motor wird gestartet");
        this.status = 0;
        return true;
    }

    public int getLeistung() {
        return leistung;
    }

    public void setLeistung(int leistung) {
        this.leistung = leistung;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public boolean anhalten() {
        return false;
    }

//    public int getStatus() {
//        return this.status;
//    }
//    public void setStatus(int s) {this.status=s; };
}

//====Fahrzeug===// Beoabachtbar von Abschleppservice

class Fahrzeug implements Subjekt {
List <Beobachter> listeAlleBeobachter = new ArrayList<>();
    private String id;
    private String marke;
    private String typ;
    private Motor motor;


    Fahrzeug(String id, String marke, String typ, Motor motor) {
        this.id = id;
        this.marke = marke;
        this.typ = typ;
        this.motor = motor;
    }

    @Override
    public String toString() {
        return id;
    }

    public boolean anlassen() {
//        System.out.print("Motor wird gestartet " + this);
        boolean temp = motor.starten();
            if (!temp) {
                //informiere alle Beobachterr darüber
                beanachrichtigeAlleBeobachter();
            }
        return motor.starten();
    }

    public boolean anhalten() {
        return false;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public  String getId (){
        return  this.id;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Fahrzeug))
            return false;
        Fahrzeug fr = (Fahrzeug) obj;
        if (fr.id.equals(this.id))
            return true;
        return false;
    }

    @Override
    public void registriereBeobachter(Beobachter beobachter) {
        listeAlleBeobachter.add(beobachter);

    }

    @Override
    public void deregistriereBeobachterr(Beobachter beobachter) {
        listeAlleBeobachter.remove(beobachter);
    }

    @Override
    public void beanachrichtigeAlleBeobachter() {
        //Nicht nur Abschleppdienst (Beobachter) sondern alle Beobachter informieren!
        for (Beobachter beobachter :listeAlleBeobachter){
            System.out.println("This id Aus benach- Fahrzeug "+this.id);
//            System.out.println("This Beobachter " + beobachter);
            beobachter.aktualisieren(this.id);

        }
    }
}


//===Abschleppservice===// Beobachter

 class Abschleppservice implements Beobachter {
    private List<Fahrzeug> fahrzeuge = new ArrayList<>();



     public void fahrerLosschickenZU(Fahrzeug fr) {

        fahrerSchicken();
    }

    public boolean addFahrzeug(Fahrzeug fr) {
         Beobachter b = this;
        System.out.println(b);
        fr.registriereBeobachter(b); //-> addiere Objectinstanz von typ Beobachter to listeAlleBeobachter
        boolean ok = fahrzeuge.add(fr);         //, die sich in Klasse Fahrzeug befindet.
         return true;
    }

    public boolean removeFahrzeug(Fahrzeug fr) {
        fr.deregistriereBeobachterr(this);
        return fahrzeuge.remove(fr);
    }

//    Abschleppservice (Subjekt s) {
//        s.registriereBeobachter(this);
//    }


    void fahrerSchicken (){
        System.out.println("fahrere Wird vor Ort geschickt");
    }

     @Override
     public void aktualisieren( String str) {
         Fahrzeug suchFahrzeug = new Fahrzeug(str, "", "", new Motor(0, ""));
         for (Fahrzeug fr: fahrzeuge) {
             if (fr.equals(suchFahrzeug)) {
                 System.out.println("Fr " + fr + " suchFarzeug " + suchFahrzeug);
                 fahrerLosschickenZU(fr);
             }
         }
     }

}




//===MAIN METHODE===//
public class FWork {
    public static void main(String[] args) {

        Fahrzeug f1 = new Fahrzeug("f1", "Opel", "Corsa", new Motor(45, "Benzin") );
        Fahrzeug f2 = new Fahrzeug("f2", "Renault", "Megan", new Motor(75, "Benzin") );
        Fahrzeug f3 = new Fahrzeug("f3", "Toyota", "Avensis", new Motor(55, "Benzin") );
        Fahrzeug f4 = new Fahrzeug("f4", "Mercedes", "S", new Motor(75, "Diesel"));

        Abschleppservice as = new Abschleppservice();
        as.addFahrzeug(f1);
        as.addFahrzeug(f2);
        as.addFahrzeug(f3);
        as.addFahrzeug(f4);

        AbDienstInSyrien ass = new AbDienstInSyrien();
        ass.AddPKW(f1);
        ass.AddPKW(f2);
        ass.AddPKW(f3);
        ass.AddPKW(f4);


//        for (int i = 0; i < 10; i++) {

            f1.anlassen();
            f2.anlassen();
            f3.anlassen();
            f4.anlassen();
//        }


    }

    }

