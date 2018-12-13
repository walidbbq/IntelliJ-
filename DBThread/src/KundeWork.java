import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class KundeWork {
    static Connection conn;
    static Set<Kunde> kunden;

    public static Connection erstelleVerbindung() {
        String url = "jdbc:mysql://localhost:3306/KundenDBA";
        String user = "root";
        String password = "";
        if (conn == null) {
            Connection con = null;
            try {
                con = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to database");
            } catch (SQLException se) {
                se.printStackTrace();
            }
            conn = con;
        }
        return conn;
    }


    static void alleKundenAlsSet() {
        Set<Kunde> sKTemp = new HashSet<>();

        String sql = "SELECT  * FROM kunde";
        try {
            PreparedStatement prep = erstelleVerbindung().prepareStatement(sql);
            ResultSet rs = prep.executeQuery();

            while (rs.next()) {
                //Kunde Tabelle aus Db auslesen
                int kid = rs.getInt("kid");
                String nachname = rs.getString("nachname");
                String vorname = rs.getString("vorname");
                String email = rs.getString("email");

                //Objekt Kunde erzeugen und ausfüllen
                Kunde kTemp = new Kunde(kid, vorname, nachname, email);

                //Kunde dem Set hinzufügen
                sKTemp.add(kTemp);
            }
            kunden = sKTemp;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static void pruefeAufNeueKunden() {

        Set<Kunde> sKTemp = new HashSet<>();
        boolean verg = false;

        String sql = "SELECT  * FROM kunde";
        try {
            PreparedStatement prep = erstelleVerbindung().prepareStatement(sql);
            ResultSet rs = prep.executeQuery();

            while (rs.next()) {
                //Kunde Tabelle aus Db auslesen
                int kid = rs.getInt("kid");
                String nachname = rs.getString("nachname");
                String vorname = rs.getString("vorname");
                String email = rs.getString("email");

                //Objekt Kunde erzeugen und ausfüllen
                Kunde kTemp = new Kunde(kid, vorname, nachname, email);

                //Kunde dem Set hinzufügen
                sKTemp.add(kTemp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Kunde kunde : kunden) {
          if  (!sKTemp.contains(kunde)) {
              kunden=sKTemp;
              verg=true;

          }

        }

        if (verg)
            System.out.println("die Kundeliste wurde aktualisiert!");
        else
            System.out.println("Die Daten sind up to Date! ");

    }


    static Kunde sucheKundeNachVOrNachname(String vorname, String nachname) {
        for (Kunde kTemp : kunden) {
            if (  (kTemp.getVorname().equals(vorname)) &&
                 (kTemp.getNachname().equals(nachname)) )
                return kTemp;
        }
        return new Kunde();
    }

//    static void pruefeAufNeueKunden() {
////        Set<Kunde> sKTemp = new HashSet<>();
////        boolean verg = false;
////
////        String sql = "SELECT  * FROM kunde";
////        try {
////            PreparedStatement prep = erstelleVerbindung().prepareStatement(sql);
////            ResultSet rs = prep.executeQuery();
////
////            while (rs.next()) {
////                //Kunde Tabelle aus Db auslesen
////                int kid = rs.getInt("kid");
////                String nachname = rs.getString("nachname");
////                String vorname = rs.getString("vorname");
////                String email = rs.getString("email");
////
////                //Objekt Kunde erzeugen und ausfüllen
////                Kunde kTemp = new Kunde(kid, vorname, nachname, email);
////
////                //Objekte vergleichen
////                for (Kunde k : kunden) {
////                    if (!k.equals(kTemp)) {
////                        sKTemp.add(kTemp);
////                        verg = true;
////                    } else {
//////                        System.out.println("Die Daten sind up to Date! ");
////                        verg = false;
////                    }
////
////                }
////
////                //Kunde dem Set hinzufügen
////                if (!verg) {
////                    System.out.println(verg);
////                    kunden = sKTemp;
////                    System.out.println("die Kundeliste wurde aktualisiert!");
////                } else {
////                    System.out.println("Die Daten sind up to Date! ");
////                }
////            }
////
////
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////    }

}
