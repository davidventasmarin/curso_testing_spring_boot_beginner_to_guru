package guru.springframework;

/*
* Creado el 29/09/2020
* */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    void testMultiplicacionDollar(){
        Dinero cinco = Dinero.dollar(5);
        assertEquals(Dinero.dollar(10), cinco.veces(2));
        assertEquals(Dinero.dollar(15), cinco.veces(3));
    }

    @Test
    void testEqualityDollar(){
        assertEquals(Dinero.dollar(5), Dinero.dollar(5));
        assertNotEquals(Dinero.dollar(5), Dinero.dollar(8));
        assertEquals(Dinero.franco(5), Dinero.franco(5));
        assertNotEquals(Dinero.franco(3), Dinero.dollar(3));
    }

    @Test
    void testMultiplicacionFrancoSuizo(){
        Dinero cinco = Dinero.franco(5);
        assertEquals(Dinero.franco(10), cinco.veces(2));
        assertEquals(Dinero.franco(15), cinco.veces(3));
    }

    @Test
    void testMoneda(){
        assertEquals("USD", Dinero.dollar(1).moneda());
        assertEquals("CHF", Dinero.franco(1).moneda());
    }

}
