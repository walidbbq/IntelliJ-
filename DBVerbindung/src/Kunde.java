import java.sql.*;
import java.util.ArrayList;

public class Kunde {

    int kid;
    private String Vorname;
    private String Nachname;
    private String email;

    Kunde() {
    }

    Kunde(int kid ,String vorname, String nachname, String email) {
        this.kid=kid;
        this.Vorname = vorname;
        this.Nachname = nachname;
        this.email = email;
    }

    int getKID() {
        return this.kid;
    }

    String getVorname() {
        return this.Vorname;
    }

    void setVorname(String Vorname) {
        this.Vorname = Vorname;
    }


    String getNachname() {
        return this.Nachname;
    }

    void setNachname(String Nachname) {
        this.Nachname = Nachname;
    }

    String getEmail() {
        return this.email;
    }

    void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Kunde{" +
                "kid=" + kid +
                ", Vorname='" + Vorname + '\'' +
                ", Nachname='" + Nachname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }



}
