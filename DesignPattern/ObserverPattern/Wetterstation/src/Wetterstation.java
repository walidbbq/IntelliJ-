class Thermometer {
    private double temperatur;

    public double getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(double temperatur) {
        this.temperatur = temperatur;
        System.out.println("Thermometer zeigt nun " + this.temperatur +" Grad an");
    }
}

class Anzeige {

    private double temperatur;

    public double getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(double temperatur) {
        this.temperatur = temperatur;
        System.out.println("Anzeige zeigt nun " + this.temperatur +" Grad an");

    }
}

class Benachrichtigung {

    private double temperatur;

    public double getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(double temperatur) {
        this.temperatur = temperatur;
        System.out.println("Benachrichtigugn zeigt nun " + this.temperatur +" Grad an");

    }
}

 class Wetterstation {

    public double temperatur = 20.0;

    public double getTemperatur() {
        return temperatur;
    }

    Thermometer thermometer = new Thermometer();
    Anzeige anzeige = new Anzeige();
    Benachrichtigung benachrichtigung = new Benachrichtigung();


    public void benachrichtigeAlleBeobahcter() {
        double temp = getTemperatur();
        thermometer.setTemperatur(temp);
        anzeige.setTemperatur(temp);
        benachrichtigung.setTemperatur(temp);

        //WIr m�ssen jede einzelne Ausgabe hier einf�gen. Leider k�nnen wir sp�ter zur Laufzeit keine �nderungen
        //mehr machen bspw. wenn die Benachrichtigung wegfalle sollte. Auxh muss uns jeder Empf�nger bekannt sein.
    }

}
