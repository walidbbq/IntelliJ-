import java.util.Scanner;

public class ViewController {

    static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }


    }

    public static void main(String[] args) {

//
        //Kundeliste aus DB auslesen und zurückliefern
        KundeWork.alleKundenAlsSet();
        System.out.println(KundeWork.kunden);
//
//
//        //Überprüfen ob die KundenListe aktulisiert wird
//        Thread th1 = new Thread(() -> {
//            while (true) {
//                sleep(5000);
//                KundeWork.pruefeAufNeueKunden();
//                System.out.println(KundeWork.kunden);
//            }
//        });
//        th1.start();
//
//        //Nach einem Kunde suchen
//        Kunde k = new Kunde();
//        k = KundeWork.sucheKundeNachVOrNachname("Hildegard", "von Bingen");
//        System.out.println(k);


        //Scanner

        Scanner scn = new Scanner (System.in);
        System.out.println(">> Biite geben Sie den Vornamen des Kunden ein , den Sie suchen: ");
        String vorname = scn.nextLine();
        System.out.println(">> Biite geben Sie den Nachnamen des Kunden ein , den Sie suchen: ");
        String nachname = scn.nextLine();

        System.out.println(vorname + " " + nachname);
        boolean erg =false;
        Kunde k = new Kunde ();
        for (Kunde kTemp :KundeWork.kunden) {
            if  ( (vorname.equals(kTemp.getVorname())) && (nachname.equals(kTemp.getNachname())) ) {
                k = kTemp;
                erg = true;
            }
        }
        if (erg) {
            System.out.println("Gefungen: ");
            System.out.println(k);
        }
        else
            System.out.println("Leider nicht gefünden :( ");



//        try {
//            th1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }
}
