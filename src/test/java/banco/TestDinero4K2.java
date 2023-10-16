package banco;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDinero4K2 {
    @Test
    public void sePuedenSumarMontosPositivosDeDineroDeLaMismaMoneda() {
        var unMonto = Dinero.pesos(5);
        var otroMonto = Dinero.pesos(3);

        var resultado = unMonto.mas(otroMonto);

        assertEquals(Dinero.pesos(8), resultado);
    }

    @Test
    public void noSePuedenSumarDosMontosDeDineroConDistintaMoneda() {
        var unMonto = Dinero.pesos(5);
        var otroMonto = Dinero.dolares(3);

        try {
            unMonto.mas(otroMonto);
            fail();
        } catch (Exception error) {
            assertEquals("No se pueden combinar 5 pesos con 3 dólares", error.getMessage());
        }
    }

    @Test
    public void unMontoDeDineroEsIgualAOtroDeLaMismaMonedaYCantidad() {
        var unMonto = Dinero.pesos(10);
        var otroMonto = Dinero.pesos(10);

        assertTrue(unMonto.equals(otroMonto));
    }

    @Test
    public void unMontoDeDineroEsIgualASiMismo() {
        var unMonto = Dinero.pesos(10);

        assertTrue(unMonto.equals(unMonto));
    }

    @Test
    public void sePuedeRestarDosMontosEnUnaMismaMoneda() {
        var dinero1 = Dinero.dolares(5);
        var dinero2 = Dinero.dolares(3);

        var resultado = dinero1.menos(dinero2);

        assertEquals(
                Dinero.dolares(2),
                resultado
        );
    }

    @Test
    public void elSustraendoPuedeSerMenorQueElMinuendoEnUnaOperacionDeResta() {
        var minuendo = Dinero.dolares(5);
        var sustraendo = Dinero.dolares(7);

        var resultado = minuendo.menos(sustraendo);

        assertEquals(
                Dinero.dolares(-2),
                resultado
        );
    }

    @Test
    public void sePuedeConvertirATextoUnMontoPositivoSingular() {
        var monto = Dinero.pesos(1);

        var resultado = monto.toString();

        assertEquals("1 peso", resultado);
    }

    @Test
    public void sePuedeConvertirATextoUnMontoPositivoPlural() {
        var monto = Dinero.pesos(8);

        var resultado = monto.toString();

        assertEquals("8 pesos", resultado);
    }
}
