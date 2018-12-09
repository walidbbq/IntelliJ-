
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class rezepteWork {

    public static void main(String[] args) {
        List<Rezepte> rezepte = leseRezepteAusDatei("C:\\Users\\ghani\\IdeaProjects\\IntelliJ-\\Rezepte\\Rezepte.txt");
        System.out.println(rezepte);

    }

    // (1)
    public static List<Rezepte> leseRezepteAusDatei(String pfad) {
        // Einlesen der Datei
        // --> (2)
        List<String> zeile = leseDateiInListe(pfad);
        // --> (3)
        List<Rezepte> rezepte = rezepteAusListeErzeugen(zeile);
        return rezepte;
    }
    // (2)
    public static List<String> leseDateiInListe(String pfad) {
        List<String> zeilen = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(
                new FileReader(pfad))) {
            String zeile = "";
            while( (zeile = br.readLine()) != null ) {
                zeilen.add(zeile);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
        return zeilen;
    }

    // (3)
    public static List<Rezepte> rezepteAusListeErzeugen(List<String> zeilen) {
        List<Rezepte> rezepte = new ArrayList<Rezepte>();
        for (String zeile : zeilen) {

            // --> (4)
            List<String> elemente = elementeAusZeileAuslesenSplit(zeile);
            // Aus List<String> --> Objekt vom Typ Rezept erzeugen

            // --> (5)
            rezepte.add(ausStringListeRezepteErzeugen(elemente));
        }

        return rezepte;
    }

    // (4)
    public static List<String> elementeAusZeileAuslesenSplit(String zeile) {

        List<String> ergebnis = new ArrayList<String>();
        String pattern = "[;:\\?\\,\\.#\\&\\*]+";
        String pattern2 = "\\s";
        String[] elemente = zeile.split(pattern);

        for (String el : elemente) {
            if (el.contains("Zwiebeln")) {
                el = el.trim();
                String[] elInside = el.split(pattern2);
                for (String elIn : elInside) {
                    ergebnis.add(elIn);
                }
            } else {
                el = el.trim();
                ergebnis.add(el);
            }
        }
        // System.out.println(ergebnis);
        return ergebnis;
    }

    // (5)
    public static Rezepte ausStringListeRezepteErzeugen(List<String> elemente) {
        List<String> zutaten = new ArrayList<String>();
        for (int i = 1; i < elemente.size(); i++) {
            zutaten.add(elemente.get(i));
        }
        Rezepte rez = new Rezepte( elemente.get(0), zutaten );
        return rez;
    }


    // Alternative Regex
    public static List<String> elementeAusZeileAuslesen(String zeile) {

        List<String> elemente = new ArrayList<String>();
        String pattern = "\\b[A-ZÃ–Ã„Ãœa-zÃ¼Ã¤Ã¶ÃŸ\\-\\s]+\\b";
        Pattern p = Pattern.compile(pattern);
        Matcher mat = p.matcher(zeile);

        while(mat.find()) {
            elemente.add(mat.group());
            System.out.print( mat.group() + " # ");
        }
        System.out.println();
        return elemente;
    }


}
