public class Testauto
{
    static private int objcnt = 0;
    public Testauto()
    {
        ++objcnt;
    }
    public void finalize()
    {
        --objcnt;
    }
    public static void main(String[] args)
    {
        Testauto auto1;
        Testauto auto2 = new Testauto();
        Testauto auto3 = new Testauto();
        System.out.println(
                "Anzahl Testauto-Objecte: " + Testauto.objcnt
        );
        auto3=null;
        System.gc();
        System.out.println(
                "Anzahl Testauto-Objecte: " + Testauto.objcnt
        );
    }
}

/*
In dem Script werden 3 Objektreferenzen auf die Klasse Testauto erstellt,
 aber nur 2 davon initialisiert Also entstehen zunächst einmal nur 2 Objekte.
  Das erste System.out.println bestätigt dies.
  Dann wird Auto3 genullt und in der nächsten Zeile der Garbagekollector angestoßen.
   Das nachfolgende System.out.println zeigt, dass nun, nur noch ein Objekt vorhanden ist.


 */