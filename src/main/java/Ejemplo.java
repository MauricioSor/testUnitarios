import banco.Dinero;

public class Ejemplo {
    public static void main(String[] args) {
        var unMonto = Dinero.pesos(10.50);
        var otroMonto = Dinero.pesos(5.25);

        var suma = unMonto.mas(otroMonto);

        System.out.println(suma);
    }
}
