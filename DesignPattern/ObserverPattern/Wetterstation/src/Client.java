public class Client {

    public static void main(String[] args) {
//        Wetterstation wetterstation = new Wetterstation();
//
//        wetterstation.benachrichtigeAlleBeobahcter();
//        wetterstation.temperatur=29;
//        wetterstation.benachrichtigeAlleBeobahcter();

        WetterstattionMitObserverPattern wos = new WetterstattionMitObserverPattern();
        Thermometerob tob = new Thermometerob();
        wos.regestriereBeobachter(tob);

        Anzeigeob aob = new Anzeigeob();
        wos.regestriereBeobachter(aob);

        Benachrichtigungob bob = new Benachrichtigungob();
        wos.regestriereBeobachter(bob);
        wos.deregestriereBeobachter(bob);
//        wos.regestriereBeobachter(tob);

        wos.updateTemp(50);


    }
}
