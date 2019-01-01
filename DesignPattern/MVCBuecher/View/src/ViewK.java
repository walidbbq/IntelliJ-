import java.util.List;
import java.util.Scanner;

public class ViewK {

    private Scanner scn;

    ViewK (Scanner scn){
        this.scn=scn;
    }

        public void ausgabeKonsole(List<Buch> liste) {
            int i =1;
                for (Buch buch: liste) {
                    System.out.println("=====\nTreffer:" + i);
                    System.out.println(buch);
                    i++;
                }
        }

        public String frageAntwortKonsole (String str) {
            System.out.println(str);
            String antwort = scn.nextLine();
            return antwort;
    }
}
