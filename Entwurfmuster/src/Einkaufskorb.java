import java.util.ArrayList;
import java.util.List;

public class Einkaufskorb {
    private List<Produkt> produkte = new ArrayList<>();
    private int produkteAnzahl;
    private Zahlungsmittel zm;


    Einkaufskorb () {}

    Einkaufskorb (List <Produkt> produkte ){
        this.produkte=produkte;
        this.produkteAnzahl=this.produkte.size();
        }


    public void fuegeProduktHinzu(Produkt pr) {
        produkte.add(pr);
    }
    public void nehmeProdukHeraus(Produkt pr) {
        produkte.remove(pr);
    }
    public float berechneGesamtpreis() {
        this.produkteAnzahl=produkte.size();
        float pTemp = 0;
        for (Produkt pr : produkte) {
            pTemp += pr.getPreis();
        }
        return pTemp;
    }

    public int getProdukteAnzahl() {
        return produkteAnzahl;
    }


    public Zahlungsmittel setZahlunsmittelart(int zm) {
        Zahlungsmittelart zma = new Zahlungsmittelart();
        this.zm = zma.getZahulungsmittel(zm);
        return this.zm;
    }

    public Zahlungsmittel getZahlunsmittelart() {
        return zm;
    }

    @Override
    public String toString() {
        return "\nEinkaufskorb:"
                +"\n"+produkte +
                ",\nprodukteAnzahl=" + produkteAnzahl
                +"\n"+zm
                ;
    }

    public static void main(String[] args) {
//        Produkt pr = new Produkt("xxx", 19);
//        Produkt pr1 = new Produkt("yyy", 45);
//        Produkt pr2 = new Produkt("uuu", 56);
//
//        Einkaufskorb ek = new Einkaufskorb();
//        ek.fuegeProduktHinzu(pr);
//        ek.fuegeProduktHinzu(pr1);
//        ek.fuegeProduktHinzu(pr2);
//
//
//        ek.setZahlunsmittelart(Zahlungsmittelart.Kontoabbuchung);
//        ek.berechneGesamtpreis();
//        ek.getProdukteAnzahl();
//        System.out.println(ek);

        //2 mit Konstruktor instanzieren
        List <Produkt> ekg = new ArrayList<>();
        ekg.add(new Produkt("Staubsauger",66));
        ekg.add (new Produkt("Ventalator", 15));
        ekg.add (new Produkt("Herd",55));
        ekg.add(new Produkt("Fernsehen",500));

        Einkaufskorb ek1 = new Einkaufskorb(ekg);
        System.out.println(ek1);
        ek1.setZahlunsmittelart(Zahlungsmittelart.Kreditkarte);
        System.out.println(ek1);
        System.out.println(ek1.berechneGesamtpreis());
        ek1.nehmeProdukHeraus(ekg.get(0));
        System.out.println(ek1);
        System.out.println(ek1.berechneGesamtpreis());
        System.out.println(ek1.getProdukteAnzahl());


//        System.out.println(ek);
//        float erg = ek.berechneGesamtpreis();
//        System.out.println(erg);
//
//        ek.setZahlunsmittelart(Zahlungsmittelart.Paypal);
//        System.out.println(ek.getZahlunsmittelart());
//
//
//        ek.nehmeProdukHeraus(pr1);
//        System.out.println(ek);
//
//        float erg2 = ek.berechneGesamtpreis();
//        System.out.println(erg2);
    }


}
