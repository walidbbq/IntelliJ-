import java.util.ArrayList;
import java.util.List;

interface  Beobachter {
    public  void aktualisieren (double temp);
}

interface Temperatur {
    public void regestriereBeobachter (Beobachter b);
    public void deregestriereBeobachter (Beobachter b);
    public void benachrichtigeAlleBeobachter();

}



public class WetterstattionMitObserverPattern implements Temperatur {
        private  double temperatur=0;
    List<Beobachter> beobachterList = new ArrayList<Beobachter>();

        public  void updateTemp (double temperatur){
            if (this.temperatur!=temperatur){
                this.temperatur=temperatur;
                  benachrichtigeAlleBeobachter();
            }
    }

    public double getTemperatur () {
            return this.temperatur;
    }

    @Override
    public void regestriereBeobachter(Beobachter b) {
        beobachterList.add(b);
    }

    @Override
    public void deregestriereBeobachter(Beobachter b) {
        beobachterList.remove(b);
    }

    @Override
    public void benachrichtigeAlleBeobachter() {
//            boolean ok = (beobachterList.isEmpty());
//        System.out.println(ok);
//        System.out.println(getTemperatur());
        for (Beobachter temp : beobachterList){
                temp.aktualisieren(getTemperatur());

        }
    }
}


class Thermometerob implements Beobachter {
    private double temperatur;

//    WetterstattionMitObserverPattern wos;

//    Thermometerob (Temperatur br) {
//        Beobachter b = this;
//        br.regestriereBeobachter(b);
//    }

    double getTemperatur () {
        return this.temperatur;
    }


    @Override
    public void aktualisieren(double temp) {
        this.temperatur=temp;
        System.out.println(this.temperatur);
    }
}

class Anzeigeob implements Beobachter{
    private double temperatur;

//    WetterstattionMitObserverPattern wos;

//    Anzeigeob (Temperatur br) {
//        Beobachter b = this;
//        br.regestriereBeobachter(b);
//    }

    double getTemperatur () {
        return this.temperatur;
    }


    @Override
    public void aktualisieren(double temp) {
        this.temperatur=temp;
        System.out.println(this.temperatur);
    }
}

class Benachrichtigungob implements Beobachter{

    private double temperatur;

//    WetterstattionMitObserverPattern wos;

//    Benachrichtigungob (Temperatur br) {
//        Beobachter b = this;
//        br.regestriereBeobachter(b);
//    }

    double getTemperatur () {
        return this.temperatur;
    }


    @Override
    public void aktualisieren(double temp) {
        this.temperatur=temp;
        System.out.println(this.temperatur);
    }

}