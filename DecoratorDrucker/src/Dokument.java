public class Dokument {
    private String text;

    Dokument (String text){
        this.text=text;
    }

    public String getText() {
        return  this.text;
    }

    public static void main(String[] args) {

        Dokument dk = new Dokument("HalloDokument!");

        DruckerAbstrakt da = new SwDrucker();
        da.print(dk);

        DruckerAbstrakt da1 = new EchoPrint(da);
        da1.print(dk);


//        DruckerDekorierer dd = new EchoPrint("");

    }

}
