import java.util.*;

//import MVCBuecher.Model.ModelDB;
public class ControllVM {
    private ModelDB model;
    private ViewK view;
    private List<Buch> alleBuecher;
    private List<Buch> auswahlBuecher;

    ControllVM(ModelDB model, ViewK view) {
        this.model = model;
        this.view = view;
    }

    public void starteProzess() {
        besorgeBuecherAusModel();
        while (true) {
            String antwort = view.frageAntwortKonsole("Bitte geben Sie den Nachnamen des Autors ein, dessen Bücher Sie suchen: ");
            sucheBuecherNachAutor(antwort);
            sortiereBuecherNachJahr();
//            sortiereBuecherNachNVJT();
//            Collections.sort(auswahlBuecher);
            if (auswahlBuecher!=null){
            view.ausgabeKonsole(auswahlBuecher);
            }
            if (antwort.equals("Exit")) {
                return;
            }

        }
    }


    public List<Buch> besorgeBuecherAusModel() {
        alleBuecher = model.zieheVerfuegbareBuecherAusDB();
        return alleBuecher;
    }

    public void sucheBuecherNachAutor(String autor) {
        List<Buch> tempListe = new ArrayList<>();
        for (Buch buch : alleBuecher) {
            if (autor.equals(buch.getNachname())) {
                tempListe.add(buch);
            }
        }
        auswahlBuecher = tempListe;
    }

//    public void sortiereBuecherNachJahr() {
////         Buch temp []= (Buch[]) alleBuecher.toArray();
//        for (int i = 0; i < alleBuecher.size() - 1; i++) {
////            System.out.println(alleBuecher.size());
////            System.out.println("Äußere Schleife"+(alleBuecher.size()-1));
//            for (int j = 0; j < alleBuecher.size() - i - 1; j++) {
////                System.out.println("Innere Schleife: "+ (alleBuecher.size()-i-1));
////                System.out.println((alleBuecher.get(j).getJahr()+ " > "+alleBuecher.get(j + 1).getJahr()));
//                if (alleBuecher.get(j).getJahr() > alleBuecher.get(j + 1).getJahr()) {
//                    Buch tempj = alleBuecher.get(j);
//                    Buch tempj1 = alleBuecher.get(j + 1);
//                    alleBuecher.set(j + 1, tempj);
//                    alleBuecher.set(j, tempj1);
//
//
//                }
//            }
//        }
//            auswahlBuecher = alleBuecher;
//
//    }


    public void sortiereBuecherCompareTo(){

    }



    public void sortiereBuecherNachNVJT() {
        List<Buch> tempListe = auswahlBuecher;
        for (int i = 0; i < tempListe.size(); i++) {
            for (int j = 0; j < tempListe.size(); j++) {
                int sortNachname = tempListe.get(i).getNachname().compareTo(tempListe.get(j).getNachname());
                int sortVorname = tempListe.get(i).getVorname().compareTo(tempListe.get(j).getVorname());
                boolean sortJahr = tempListe.get(i).getJahr() > tempListe.get(j).getJahr();
                int sortTitel = tempListe.get(i).getTitel().compareTo(tempListe.get(j).getTitel());
                if (sortNachname !=0) {
                    Buch tempin = tempListe.get(i);
                    Buch tempjn = tempListe.get(j);
                    tempListe.set(i, tempjn);
                    tempListe.set(j, tempin);
                    if (sortNachname == 0 && sortVorname!=0) {
                        Buch tempiv = tempListe.get(i);
                        Buch tempjv = tempListe.get(j);
                        tempListe.set(i, tempjv);
                        tempListe.set(j, tempiv);
                        if (sortVorname == 0 && sortJahr) {
                            Buch tempij = tempListe.get(i);
                            Buch tempjj = tempListe.get(j);
                            tempListe.set(i, tempjj);
                            tempListe.set(j, tempij);
                            if (!sortJahr && sortTitel!=0) {
                                Buch tempit = tempListe.get(i);
                                Buch tempjt = tempListe.get(j);
                                tempListe.set(i, tempjt);
                                tempListe.set(j, tempit);
                            }
                        }

                    }

                }
            }
        }
        auswahlBuecher = tempListe;
    }

    public void sortiereBuecherNachJahr() {

        List<Buch> tempListe = auswahlBuecher;
        for (int i = 0; i < tempListe.size(); i++) {
            for (int j = 0; j < tempListe.size(); j++) {
                if (tempListe.get(i).getJahr() < tempListe.get(j).getJahr()) {
                    Buch tempi = tempListe.get(i);
                    Buch tempj = tempListe.get(j);
                    tempListe.set(i, tempj);
                    tempListe.set(j, tempi);

                }
            }
        }
        auswahlBuecher = tempListe;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        ViewK vk = new ViewK(scn);
        ModelDB mdb = new ModelDB();
        ControllVM cvm = new ControllVM(mdb, vk);
        cvm.starteProzess();

//        cvm.sortiereBuecherNachNVJT();
//        System.out.println("tetst" + cvm.auswahlBuecher);


//        cvm.sortiereBuecherNachJahr();
//        System.out.println(cvm.auswahlBuecher);


//        System.out.println(cvm.besorgeBuecherAusModel());

    }

}
