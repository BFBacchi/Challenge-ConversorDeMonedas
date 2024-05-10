import com.google.gson.annotations.SerializedName;

public class Moneda {

    // Atributos
    @SerializedName("ARS")
    private double ars;

    @SerializedName("USD")
    private double usd;

    @SerializedName("EUR")
    private double eur;

    @SerializedName("GBP")
    private double gbp;

    @SerializedName("JPY")
    private double jpy;

    @SerializedName("KRW")
    private double krw;

    // Constructor
    public Moneda(double ars, double usd, double eur, double gbp, double jpy, double krw) {
        this.ars = ars;
        this.usd = usd;
        this.eur = eur;
        this.gbp = gbp;
        this.jpy = jpy;
        this.krw = krw;
    }

    // Getters
    public double ars() {
        return ars;
    }

    public double usd() {
        return usd;
    }

    public double eur() {
        return eur;
    }

    public double gbp() {
        return gbp;
    }

    public double jpy() {
        return jpy;
    }

    public double krw() {
        return krw;
    }

    // Método para obtener una nueva instancia de Moneda con las conversiones inversas
    public Moneda invertir() {
        return new Moneda(1 / ars, 1 / usd, 1 / eur, 1 / gbp, 1 / jpy, 1 / krw);
    }
}
