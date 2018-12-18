public class Produkt {
    private String upcCode;
    private float preis=0;

    Produkt(String upcCode, float preis) {
        this.upcCode = upcCode;
        this.preis = preis;
    }

    public String getUpcCode() {
        return this.upcCode;
    }

    public float getPreis() {
        return this.preis;
    }


    public boolean equals(Object obj) {
        if (!(obj instanceof Produkt))
            return false;
        Produkt pr = (Produkt) obj;
        if ((pr.upcCode.equals(this.upcCode) && (pr.preis == this.preis)))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "upcCode='" + upcCode + '\'' +
                ", preis=" + preis +
                '}';
    }
}
