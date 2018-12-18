abstract class Zahlungsmittel {
    public abstract  void artDerZahlungsmittel ();
}



class Zahlungsmittelart {
    static final int Kreditkarte=0;
    static final  int Kontoabbuchung =1;
    static final int Paypal=2;

    Zahlungsmittel getZahulungsmittel (int zm) {
        if (zm==0)
            return  new Kreditkarte();
        if (zm==1)
            return  new Kontoabbuchung();
        if (zm==2)
            return  new Paypal();

        return  null;
    }

}


class Kreditkarte extends  Zahlungsmittel {

    @Override
    public void artDerZahlungsmittel() {
        System.out.println("es Wird mit der Kreditkarte bezahlzt!");
    }
}



class Kontoabbuchung extends  Zahlungsmittel {

    @Override
    public void artDerZahlungsmittel() {
        System.out.println("es Wird mit der Kontoabbuchung bezahlzt!");
    }
}



class  Paypal  extends  Zahlungsmittel {

    @Override
    public void artDerZahlungsmittel() {
        System.out.println("es Wird mit der Paypal bezahlzt!");
    }
}