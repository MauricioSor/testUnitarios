package banco;

public class Moneda {
    public static final Moneda PESO = new Moneda("peso", "pesos");
    public static final Moneda DOLAR = new Moneda("dólar", "dólares");

    private final String singular;
    private final String plural;

    public Moneda(String singular, String plural) {
        this.singular = singular;
        this.plural = plural;
    }

    public String nombreParaCantidad(int centavos) {
        return centavos == 100 ? singular : plural;
    }
}
