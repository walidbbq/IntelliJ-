class Gabel {

}

class Philosoph {

    String name;
    Gabel linkeGabel;
    Gabel rechteGabel;


    Philosoph (String name, Gabel linkeGabel, Gabel rechteGabel) {
        this.name=name;
        this.linkeGabel=linkeGabel;
        this.rechteGabel=rechteGabel;
    }

    public void tagesablauf () {
        while (true) {
            System.out.println("Philosoph " + this.name + " denkt");
            thread();
            synchronized (this.linkeGabel) {
                System.out.println("Philosoph " + this.name + " nimmt liknke Gabel auf ");
                thread();
                synchronized (this.rechteGabel) {
                    System.out.println("Philosoph " + this.name + " nimmt rechte Gabel auf");
                    thread();
                    System.out.println("Philosoph " + this.name + " isst");
                    thread();
                }
                System.out.println("Philosoph " + this.name + " legt rechte Gabel ab");
                thread();
            }
            System.out.println("Philosoph " + this.name + " legt liknke Gabel ab");
            thread();



        }

    }

    public void thread () {
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ie ) {
                    ie.printStackTrace();
                }

            }


        }


public class Deadlock {


    public static void main(String[] args) {

        Gabel g1 = new Gabel();
        Gabel g2 = new Gabel();
        Gabel g3 = new Gabel();
        Gabel g4 = new Gabel ();
        Gabel g5 = new Gabel ();


        Philosoph p1 = new Philosoph("Theano", g1,g2 );
        Philosoph p2 = new Philosoph("Aspasia", g2,g3 );
        Philosoph p3 = new Philosoph("Hipparchia", g3,g4 );
        Philosoph p4 = new Philosoph("Leontion", g4,g5 );
        Philosoph p5 = new Philosoph("Diotima", g5,g1 );

        Thread th1 = new Thread( (new Runnable() {
            @Override
            public void run() {
                p1.tagesablauf();
            }
        }));

        Thread th2 = new Thread( (new Runnable() {
            @Override
            public void run() {
                p2.tagesablauf();
            }
        }));

        Thread th3 = new Thread( (new Runnable() {
            @Override
            public void run() {
                p3.tagesablauf();
            }
        }));

        Thread th4= new Thread( (new Runnable() {
            @Override
            public void run() {
                p4.tagesablauf();
            }
        }));

        Thread th5 = new Thread( (new Runnable() {
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


