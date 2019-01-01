public class Buch implements Comparable <Buch> {

    private int bid;
    private String vorname;
    private String nachname;
    private String titel;
    private int jahr;

    Buch () {

    }

    public Buch(int bid, String nachname, String vorname, String titel, int jahr) {
        this.bid = bid;
        this.vorname = vorname;
        this.nachname = nachname;
        this.titel = titel;
        this.jahr = jahr;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }



    @Override
    public String toString() {
        return "Autor: " + vorname +" " + nachname + "\n"+
                "Titel: " + titel + "\n"+
                "Jahr: " + jahr + "\n" ;
    }

    @Override
    public int compareTo(Buch o) {
        int sortieren = this.nachname.compareTo(o.nachname);
        if (sortieren==0){
            sortieren =this.vorname.compareTo(o.vorname);
            if(sortieren==0){
                sortieren=this.jahr - o.jahr;
                if (sortieren==0){
                    sortieren=this.titel.compareTo(o.titel);
                }
            }
        }
        return sortieren;
    }
}
