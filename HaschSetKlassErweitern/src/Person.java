public class Person {

    public static void main(String[] args) {
//
//		Person p1 = new Person("Schickentanz",
//				"Lara", "0121 120 99");
//
//		Person p2 = new Person("Schickentanz",
//				"Lara", "0121 120 99");
//
//		Person p3 = new Person("Schickentanz",
//				"Mara", "0221 121 98");
//
//		System.out.println(p1.equals(p2));
//		System.out.println(p1.hashCode());
//		System.out.println(p2.hashCode());
//
//		System.out.println(p2.equals(p3));
//		System.out.println(p3.hashCode());

    }

    private String vorname;
    private String nachname;
    private String telefonnr;

    public Person() {}

    public Person(String nachname, String vorname) {
        super();
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public Person(String nachname, String vorname, String telefonnr) {
        super();
        this.vorname = vorname;
        this.nachname = nachname;
        this.telefonnr = telefonnr;
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
    public String getTelefonnr() {
        return telefonnr;
    }
    public void setTelefonnr(String telefonnr) {
        this.telefonnr = telefonnr;
    }

    @Override
    public boolean equals(Object obj)  {
        if (obj instanceof Person ) {
            Person p2 = (Person)obj;
            if( this.vorname.equals(p2.vorname) &&
                    this.nachname.equals(p2.nachname)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.vorname.length() +
                this.nachname.length();
    }

    @Override
    public String toString() {
        return vorname + " " + nachname + " " + telefonnr;
    }

}
