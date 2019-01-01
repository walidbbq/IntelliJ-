import java.util.Date;

public class Batchweise {

    public static void main(String[] args) {

        try ( Connection con =DBVerbindung.getConnection()) {

            con.setAutoCommit(false);

            String sqlInsert = "Insert into kunde (vorname,nachname,email ) " +
                    "values (?,?,?)";


            PreparedStatement prep = con.prepareStatement(sqlInsert);
            Long lo1 = new Date().getTime();
            for (int i = 0 ; i<1000 ; i++) {
                String vorname = "Verena";
                String nachname = "Vetter";
                String email = "vetter@email";
                prep.setString(1, vorname + i);
                prep.setString(2, nachname + i);
                prep.setString(3, email + i + ".com");
                prep.addBatch();
            }
            Long lo2 = new Date().getTime();
            prep.executeBatch();
            con.commit();

            Long lo3 = lo2- lo1;
            System.out.println(lo3);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
