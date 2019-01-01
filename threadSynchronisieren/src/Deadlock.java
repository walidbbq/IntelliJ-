class Gabel {

}


class Besteck {
    private Gabel lenkeGabel;
    private Gabel rechteGabel;


    Besteck(Gabel lenkeGabel, Gabel rechteGabel) {
        this.lenkeGabel = lenkeGabel;
        this.rechteGabel = rechteGabel;
    }


}


class Philosoph {

    String name;
    Besteck bes;


    Philosoph(String name, Besteck bes) {
        this.name = name;
        this.bes = bes;
    }

    public void tagesablauf() {
        while (true) {
            System.out.println("Philosoph " + name + " denkt");
            sleep(10);
            synchronized (bes) {
                System.out.println("Philosoph " + name + " nimmt Besteck auf ");
                sleep(10);
                System.out.println("Philosoph " + name + " isst");
            }
            System.out.println("Philosoph " + name + " legt Besteck ab");
            sleep(10);

        }

    }

    void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }


}


public class Deadlock {


    public static void main(String[] args) {

        Gabel g1 = new Gabel();
        Gabel g2 = new Gabel();
        Gabel g3 = new Gabel();
        Gabel g4 = new Gabel();
        Gabel g5 = new Gabel();

        Besteck b1 = new Besteck(g1, g2);
        Besteck b2 = new Besteck(g2, g3);
        Besteck b3 = new Besteck(g3, g4);
        Besteck b4 = new Besteck(g4, g5);
        Besteck b5 = new Besteck(g5, g1);


        Philosoph p1 = new Philosoph("Theano", b1);
        Philosoph p2 = new Philosoph("Aspasia", b2);
        Philosoph p3 = new Philosoph("Hipparchia", b3);
        Philosoph p4 = new Philosoph("Leontion", b4);
        Philosoph p5 = new Philosoph("Diotima", b5);

        Thread th1 = new Thread((new Runnable() {
            @Override
            public void run() {
                p1.tagesablauf();
            }
        }));

        Thread th2 = new Thread((new Runnable() {
            @Override
            public void run() {
                p2.tagesablauf();
            }
        }));

        Thread th3 = new Thread((new Runnable() {
            @Override
            public void run() {
                p3.tagesablauf();
            }
        }));

        Thread th4 = new Thread((new Runnable() {
            @Override
            public void run() {
                p4.tagesablauf();
            }
        }));

        Thread th5 = new Thread((new Runnable() {
            @Override
            public void run() {
                p5.tagesablauf();
            }
        }));


        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();

    }


}


