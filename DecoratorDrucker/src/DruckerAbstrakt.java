public abstract class DruckerAbstrakt {

    public abstract boolean print(Dokument txt);
}



class SwDrucker extends  DruckerAbstrakt {

    @Override
    public boolean print(Dokument txt) {
        return false;
    }
}


class  FarbDrucker extends  DruckerAbstrakt {

    @Override
    public boolean print(Dokument txt) {
        return false;
    }
}
