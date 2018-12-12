import java.sql.*;
import java.util.ArrayList;


public class DBVerbindung {


    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/KundenDBA";
        String user = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to database");
        return conn;

    }

    static ArrayList <Kunde> alleKundenAusMySQLAlsListeSpeichern() throws SQLException {
        ArrayList <Kunde> arrk = new ArrayList<Kunde>( );

        String sql = "SELECT * FROM kunde ";
        PreparedStatement prep = DBVerbindung.getConnection().prepareStatement(sql);
        ResultSet result = prep.executeQuery();
        while (result.next()) {
            int kid = result.getInt("kid");
            String vorname = result.getString("vorname");
            String nachname = result.getString("nachname");
            String email = result.getString("email");
            Kunde k = new Kunde(kid,vorname,nachname,email);
            arrk.add(k);
        }
        return arrk;
    }

//    void erstelleVerbindung (String DBName) {
////        KundenDBA
//        String url = "jdbc:mysql://localhost:3306/"+DBName;
//        String user= "root";
//        String password="";
//
//        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {

        ArrayList <Kunde>  arrTab =  new ArrayList <> () ;

        try {
            arrTab=DBVerbindung.alleKundenAusMySQLAlsListeSpeichern();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(arrTab);

        // TODO Auto-generated method stub

//        String url = "jdbc:mysql://localhost:3306/KundenDBA";
//        String user= "root";
//        String password="";
//
//// Update
////        String neueNachname = "Rehfeld-Müller";
////        String alteNachname= "Rehfeld";
////        String sqlUpdate = "UPDATE kunde SET nachname ='" + neueNachname + "' WHERE nachname='" + alteNachname  + "'";
////        System.out.println(sqlUpdate);
//
//        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//
//            System.out.println("Connecttion OK!");
//
//            String sql = "SELECT * FROM kunde WHERE nachname =? or nachname= ? ";
//            PreparedStatement prep = conn.prepareStatement(sql);
//            prep.setString(1,"Müller");
//            prep.setString(2,"Rehfeld-Müller");
//            ResultSet result = prep.executeQuery();
//
////Update
////            Statement stm = conn.createStatement();
////            stm.executeUpdate(sqlUpdate);
////            System.out.println(prep);
//
//
//            while (result.next()){
//                int kid = result.getInt("kid");
//                String vorname = result.getString("vorname");
//                String nachname = result.getString("nachname");
//                String email = result.getString("email");
//
//                System.out.println(kid + " " + vorname + " " + nachname + " " + email);
//            }
//
//        } catch (SQLException sqle)  {
//            sqle.printStackTrace();
//        }
//
    }

}


