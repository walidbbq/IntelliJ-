
import java.util.List;

public class Rezepte {
    String name;
    List<String> zutaten;

    public Rezepte(String name, List<String> zutaten) {
        this.name = name;
        this.zutaten = zutaten;
    }

    @Override
    public String toString() {
        return "Rezept " + name + ", Zutaten = " +
                zutaten + "\n";
    }
}
