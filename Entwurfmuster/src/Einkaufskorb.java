import java.util.ArrayList;
import java.util.List;

public class Einkaufskorb {
    private List <Produkt> produkte= new ArrayList<>();
    private  Zahlungsmittel zm;

    public void fuegeProduktHinzu (Produkt pr) {
        produkte.add(pr);
    }

    public  void nehmeProdukHeraus (Produkt pr) {
        produkte.remove(pr);
    }



    public  float berechneGesamtpreis (int zm) {

        Zahlungsmittelart za =new Zahlungsmittelart();

        System.out.println(za.getZahulungsmittel(zm));

        float pTemp = 0;


        for (Produkt pr : produkte) {
            pTemp += pr.getPreis();
        }
        return pTemp;
    }

    @Override
    public String toString() {
        return "Einkaufskorb{" +
                "produkte=" + produkte +
                '}';
    }

    public static void main(String[] args) {
        Produkt pr = new Produkt("xxx", 19);
        Produkt pr1 = new Produkt("yyy", 45);
        Produkt pr2 = new Produkt("uuu", 56);

        Einkaufskorb ek = new Einkaufskorb();
        ek.fuegeProduktHinzu(pr);
        ek.fuegeProduktHinzu(pr1);
        ek.fuegeProduktHinzu(pr2);

        System.out.println(ek);

        float erg =ek.berechneGesamtpreis(1);
        System.out.println(erg);

        ek.nehmeProdukHeraus(pr1);
        System.out.println(ek);

        float erg2= ek.berechneGesamtpreis(2);
        System.out.println(erg2);
    }


}
