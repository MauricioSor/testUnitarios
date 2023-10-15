package banco;

import banco.Dinero;
import org.junit.jupiter.api.Test;

import static banco.Dinero.dolares;
import static banco.Dinero.pesos;
import static org.junit.jupiter.api.Assertions.*;

public class Test01 {
    @Test
    public void test01() {

        assertEquals("5 pesos", pesos(5).toString());
    }
    @Test
    public void restaDeMonedasIguales(){

        Dinero unMonto = Dinero.pesos(10);

        Dinero otroMonto = Dinero.pesos(2);
        Dinero resultado = unMonto.menos(otroMonto);
        assertEquals("8 pesos",resultado.toString());
    }
}
