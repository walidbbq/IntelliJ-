class Roboter2 {
    private Kiste kRob2;


    Roboter2(Kiste kRob2) {
        this.kRob2 = kRob2;
    }

    void befuellenKiste() {

//            System.out.println(kRob2.gefuellt);
        while (true) {

            synchronized (kRob2) {
            if (kRob2.gefuellt) {
                String[] ladung = {"Lampe", "Regal", "Sofa", "Tisch", "Stuhl"};

                    for (String string : ladung) {
                        kRob2.kiste1.add(string);
                        System.out.println("Kiste beladen mit: " + string);
                        try {
                            Thread.sleep(800);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("Kiste vollständig beladen");
                    kRob2.gefuellt=false;



                }

                kRob2.notify();
            }
        }

    }
}
//}