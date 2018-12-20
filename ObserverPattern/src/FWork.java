import java.util.ArrayList;
import java.util.List;

class Motor {
    private int leistung;
    private String typ;
    private int status;

    void Motor(int leistung, String typ) {
        this.leistung = leistung;
        this.typ = typ;
    }

    public boolean starten() {
        return false;
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

    public int getStatus() {
        return 0;
    }
}


class Fahrzeug {
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

    public boolean anlassen() {
        return false;
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

    public boolean equals(Object obj) {
        if (!(obj instanceof Fahrzeug))
            return false;
        Fahrzeug fr = (Fahrzeug) obj;
        if (fr.id.equals(this.id))
            return true;
        return false;
    }
}


abstract class Abschleppservice {
    private List<Fahrzeug> fahrzeuge = new ArrayList<>();

    public void fahrerLosschickenZU(Fahrzeug fr) {
    }

    public boolean addFahrzeug(Fahrzeug fr) {
        return false;
    }

    public boolean removeFahrzeug(Fahrzeug fr) {
        return false;
    }
}


public class FWork {
}
