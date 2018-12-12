import java.sql.*;

public class DBJava {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String url = "jdbc:mysql://localhost:3306/test";
        String user= "root";
        String password="";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            System.out.println("Connecttion OK!");

            String sql = "SELECT * FROM kunde WHERE nachname =? " + "And vorname =? ";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1,"Paul");
            prep.setString(2, "Schmitz");

//           Statement stm = conn.createStatement();
//            ResultSet result = prep.executeQuery(sql);
            System.out.println(prep);
            ResultSet result = prep.executeQuery();

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
