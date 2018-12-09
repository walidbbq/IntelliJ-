
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


class MyHashSet<T> extends HashSet<T> {

    public T get(T suchobjekt) {
        // this --> Objektinstanz, mit der get-Methode aufgerufen wird
        for (T elem : this) {
            if (elem.equals(suchobjekt)) {
                return elem;
            }
        }
        return null;
    }
}

public class AufgabeSucheInSet {

    public static void main(String[] args) {
        //=======

        MyHashSet<Person> hs = new MyHashSet<>();

        hs.add(new Person("Schickentanz","Lara", "0121 120 99"));
        hs.add(new Person ("Rehfeld", "Jan", "0221 408 987"));
        hs.add(new Person ("Zieler", "Sarah", "030 435 667"));
        hs.add(new Person ("Becker", "Paul", "021 44 456"));
        hs.add(new Person ("Heidel", "Tanja", "0151 202365"));

//		String vorname = "Sarah";
//		String nachname = "Zieler";
//
//		Person pers = hs.get(new Person(nachname, vorname));
//		System.out.println("Neue Get Methode / Resultat " + pers);
//
//
//		String telefonnr = sucheNameTelefonnr(hs, vorname, nachname);
//		System.out.println("Telefonnr. " + telefonnr );
//
//
//		telefonnr = sucheNameTelefonnrH(hs, vorname, nachname);
//		System.out.println("MyHashSet / Telefonnr. " + telefonnr );


        sucheTelefonnr(hs);
    }

    public static void sucheTelefonnr(Set<Person> personen) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Wie lautet der Vorname, der Person, die Sie suchen? (q zum beenden)");
            String vorname = sc.nextLine();
            if (vorname.equalsIgnoreCase("q")) {
                break;
            }
            System.out.println("Wie lautet der Nachname?");
            String nachname = sc.nextLine();
            String telefonnr = sucheNameTelefonnr(personen, vorname, nachname);
            if (telefonnr != null) {
                System.out.println("Die Telefonnr. von " + vorname + " "
                        + nachname + " lautet " + telefonnr);
            } else {
                System.out.println("Die Telefonnr. von " + vorname + " "
                        + nachname + " wurde nicht gefunden.");
            }
        }
        sc.close();

    }

    public static String sucheNameTelefonnr(Set<Person> personen, String vorname, String nachname) {

        for(Person p : personen) {
            if (p.getVorname().equals(vorname)) {
                if (p.getNachname().equals(nachname)) {
                    return p.getTelefonnr();
                }
            }
        }
        return null;
    }

    public static String sucheNameTelefonnrH(MyHashSet<Person> personen, String vorname, String nachname) {
        Person pTemp = new Person(nachname, vorname);
        Person p1 = personen.get(pTemp);
        return p1.getTelefonnr();
    }

}
