import java.util.List;

public class Film {
    String Filmtitel;
    int Jahr;
//    String Inhalt;
   List<String> Genre;
   List <String> Schauspieler;

    @Override
    public String toString() {
        return "Titel:" + Filmtitel +"\n" +
                "Jahr:" + Jahr + "\n"+
                "Genre:" + Genre + "\n"+
                "Schauspieler:" + Schauspieler
                ;
    }

    Film () {

}

    public Film(String filmtitel, int jahr,  List <String> genre, List <String> schauspieler) {
        Filmtitel = filmtitel;
        Jahr = jahr;
        Genre = genre;
        Schauspieler = schauspieler;
    }
}
