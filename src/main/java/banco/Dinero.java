package banco;

import java.util.Objects;

import static java.lang.Integer.signum;
import static java.lang.Math.abs;

public class Dinero {
    public static Dinero dolares(double cantidad) {
        return new Dinero(comoCentavos(cantidad), Moneda.DOLAR);
    }

    public static Dinero pesos(double cantidad) {
        return new Dinero(comoCentavos(cantidad), Moneda.PESO);
    }

    private static int comoCentavos(double cantidad) {
        return (int) Math.floor(cantidad * 100);
    }

    private final int cantidadEnCentavos;

    private final Moneda moneda;

    public Dinero(int cantidadEnCentavos, Moneda moneda) {
        this.cantidadEnCentavos = cantidadEnCentavos;
        this.moneda = moneda;
    }

    @Override
    public String toString() {
        return cantidadComoString() + " " + moneda.nombreParaCantidad(cantidadEnCentavos);
    }

    private String cantidadComoString() {
        var parteEntera = abs(cantidadEnCentavos / 100);
        var parteFraccional = abs(cantidadEnCentavos % 100);
        var signo = signum(cantidadEnCentavos) == -1 ? "-" : "";

        if (parteFraccional != 0) {
            return signo + parteEntera + "," + parteFraccional;
        } else {
            return signo + parteEntera;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dinero dinero = (Dinero) o;
        return cantidadEnCentavos == dinero.cantidadEnCentavos && moneda == dinero.moneda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidadEnCentavos, moneda);
    }

    public Dinero mas(Dinero otroMonto) {
        asertarMismaMonedaQue(otroMonto);

        return new Dinero(cantidadEnCentavos + otroMonto.cantidadEnCentavos(), moneda);
    }

    public Dinero menos(Dinero otroMonto) {
        return this.mas(otroMonto.por(-1));
    }

    private void asertarMismaMonedaQue(Dinero otroMonto) {
        if (!otroMonto.tieneMoneda(moneda)) {
            throw new RuntimeException("No se pueden combinar " + this + " con " + otroMonto);
        }
    }

    private int cantidadEnCentavos() {
        return cantidadEnCentavos;
    }

    private boolean tieneMoneda(Moneda unaMoneda) {
        return moneda == unaMoneda;
    }

    public Dinero por(int multiplicador) {
        return new Dinero(multiplicador * cantidadEnCentavos, moneda);
    }
}
