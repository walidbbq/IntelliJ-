import java.util.Scanner;


public class ViewController {

    public boolean scannerMethode () {
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println(">> Biite geben Sie den Vornamen des Kunden ein , den Sie suchen: ");
            String vorname = scn.nextLine();
            if (vorname.equals("exit")) {
                return false;
            }
            System.out.println(">> Biite geben Sie den Nachnamen des Kunden ein , den Sie suchen: ");
            String nachname = scn.nextLine();
            if (nachname.equals("exit")) {
                return false;
            }

            System.out.println(vorname + " " + nachname);
            boolean erg = false;
            Kunde k = new Kunde();
            for (Kunde kTemp : KundeWork.kunden) {
                if ((vorname.equals(kTemp.getVorname())) && (nachname.equals(kTemp.getNachname()))) {
                    k = kTemp;
                    erg = true;
                }
            }
            if (erg) {
                System.out.println("Gefungen: ");
                System.out.println(k);
            } else
                System.out.println("Leider nicht gefunden :( ");


        }

    }

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
//        KundeWork.alleKundenAlsSet();
//        System.out.println(KundeWork.kunden);

        ViewController v = new ViewController();

        //Thread 1
        Thread th1 = new Thread( () ->{ KundeWork.alleKundenAlsSet(); v.scannerMethode();
         } );
        th1.start();

        //Thread 2 -Überprüfen ob die KundenListe aktulisiert wird
        Thread th2 = new Thread(() -> {
            while (true) {
                sleep(5000);
                KundeWork.pruefeAufNeueKunden();
//                System.out.println(KundeWork.kunden.size());
            }
        });
        th2.start();



//
//        //Nach einem Kunde suchen
//        Kunde k = new Kunde();
//        k = KundeWork.sucheKundeNachVOrNachname("Hildegard", "von Bingen");
//        System.out.println(k);


    }
}
