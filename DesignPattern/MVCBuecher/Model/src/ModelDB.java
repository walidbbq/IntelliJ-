import java.sql.*;
import java.util.ArrayList;

public class ModelDB {

    private static Connection conn;


    public Connection holeMeineVerbindung() {
        String url = "jdbc:mysql://localhost:3306/buecherdb";
        String user = "root";
        String password = "";
        Connection con;
        if (conn == null) {
            try {
                con = DriverManager.getConnection(url, user, password);
                conn=con;
                System.out.println("Connected to Database ! ");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }
        System.out.println("Die Verbundung ist schon hergestellt! ");
        return conn;
    }

    public void beendeConnection () {
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public ArrayList <Buch> zieheVerfuegbareBuecherAusDB ()  {
        ArrayList <Buch> buecherListe = new ArrayList<>();
        Buch buch;
        Connection myConn= holeMeineVerbindung();
        boolean p = (!myConn.equals(null));
        System.out.println(p);

        String sql = "SELECT * FROM buch";

        try   {
            Statement stm = myConn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int bid = rs.getInt("bid");
                String nachname = rs.getString("Nachname");
                String vorname= rs.getString("Vorname");
                String titel = rs.getString("Titel");
                int jahr=rs.getInt("Jahr");
                buch = new Buch(bid,nachname,vorname,titel,jahr);
                buecherListe.add(buch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



        return buecherListe;
    }


}
