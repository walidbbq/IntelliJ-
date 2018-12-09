import java.text.NumberFormat;
import java.util.Locale;

public class Bankkonto {

    private double kontostand;


    Bankkonto(double kontostand) {
        this.kontostand = kontostand;
    }

    public double getKontostand() {
        return this.kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }


    public synchronized void  ueberweisen (double betrag) {
        NumberFormat nf =  NumberFormat.getCurrencyInstance();
        this.setKontostand(this.getKontostand()+betrag);
        System.out.println(",, Betrag über " + betrag + " wurde dem Konto getgeschrieben");
        System.out.println("Neuer Kontostand: " +nf.format(getKontostand()));

    }


    public static void main(String[] args) {
        Bankkonto bk = new Bankkonto (0);


        Thread th1 = new Thread (new Runnable () {

            @Override
            public void run() {
                for (int i =0; i<100; i++) {
                    bk.ueberweisen(10);
                }
            }

        });

        Thread th2 = new Thread (new Runnable () {

            @Override
            public void run() {
                for (int i =0; i<100; i++) {
                    bk.ueberweisen(10);
                }
            }

        });


        Thread th3 = new Thread (new Runnable () {

            @Override
            public void run() {
                for (int i =0; i<100; i++) {
                    bk.ueberweisen(10);
                }
            }

        });

        th1.start();
        th2.start();
        th3.start();

        try {
            th1.join();
            th2.join();
            th3.join();
        }

        catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println(" KS Aus Main: " + bk.getKontostand());



//		bk.setKontostand(500);
//		bk.ueberweisen(1000);
//		System.out.println(bk.getKontostand());
    }


}