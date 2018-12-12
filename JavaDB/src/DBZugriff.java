import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
public class DBZugriff {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String url = "jdbc:mysql://localhost:3306/test";
        String user= "root";
        String password="";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            System.out.println("Connecttion OK!");

            String sql = "SELECT * FROM kunde";
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(sql);

            while (result.next()){
                int kid = result.getInt("kid");
                String vorname = result.getString("vorname");
                String nachname = result.getString("nachname");
                System.out.println(kid + " " + vorname + " " + nachname);
            }

        } catch (SQLException sqle)  {
            sqle.printStackTrace();
        }

    }

}
