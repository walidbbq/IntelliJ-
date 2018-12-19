public abstract class DruckerDekorierer extends DruckerAbstrakt{

    private DruckerAbstrakt drucker;

    protected DruckerAbstrakt getDrucker () {
        return this.drucker;
    }

    protected  void setDrucker (DruckerAbstrakt drucker) {
        this.drucker=drucker;
    }

}


class EchoPrint extends  DruckerDekorierer {

         EchoPrint (DruckerAbstrakt drucker){
            this.setDrucker(drucker);
    }

    @Override
    public boolean print(Dokument txt) {
//             this.getDrucker().print(txt);
                System.out.println(echoPrint());
        return true;
    }

    private String echoPrint () {
             return "Es wird mit EchoPrint ausgedruckt!";
    }
}

class PremiumPrint extends  DruckerDekorierer {

    @Override
    public boolean print(Dokument txt) {
//        this.getDrucker().print(txt);
        System.out.println(premiumPrint());
        return true;
    }

    private String premiumPrint () {
       return "Es wird mit PremiumPrint ausgedruckt!";
    }
}
