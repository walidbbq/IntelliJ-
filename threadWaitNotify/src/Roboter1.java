import java.util.ArrayList;


public class Roboter1 {

    private Kiste kRob1;


    Roboter1(Kiste kRob1) {
        this.kRob1 = kRob1;
    }

    void insRegalLaden() {
        String item;
        while (true) {
            if (kRob1.gefuellt) {
                synchronized (kRob1) {
                    try {
                        kRob1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } else {

                synchronized (kRob1) {
                    for (int i = 0; i < kRob1.kiste1.size(); ) {
                        item = kRob1.kiste1.remove(i);
                        System.out.println(item + " wird ins Regal geladen: ");

                        try {
                            Thread.sleep(800);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.println(kRob1.kiste1);
                    System.out.println("Inhalt der Kiste vollständig im Regal verstaut");
                    kRob1.gefuellt = true;
                }



            }



        }
    }

    public static void main(String[] args) {
        Kiste k1 = new Kiste();
        Roboter2 r2 = new Roboter2(k1);
        Roboter1 r1 = new Roboter1(k1);

        Thread th1 = new Thread(() -> r2.befuellenKiste());

        Thread th2 = new Thread(() -> r1.insRegalLaden());

        th1.start();
        th2.start();
    }
}


