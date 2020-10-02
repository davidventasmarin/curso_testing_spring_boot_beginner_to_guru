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

        Dinero cincoF = Dinero.franco(5);
        assertEquals(Dinero.franco(10), cincoF.veces(2));
    }

    @Test
    void testEqualityDollar(){
        assertEquals(Dinero.dollar(5), Dinero.dollar(5));
        assertNotEquals(Dinero.dollar(5), Dinero.dollar(8));
        assertEquals(Dinero.franco(5), Dinero.franco(5));
        assertNotEquals(Dinero.franco(3), Dinero.dollar(3));
    }

    @Test
    void testMoneda(){
        assertEquals("USD", Dinero.dollar(1).moneda());
        assertEquals("CHF", Dinero.franco(1).moneda());
    }

    @Test
    void testSimpleSuma(){
        Dinero cinco    = Dinero.dollar(5);
        Expression suma = cinco.plus(cinco);
        Banco banco     = new Banco();
        Dinero reduce   = banco.reduce(suma, "USD");
        assertEquals(Dinero.dollar(10), reduce);

    }

    @Test
    void testPlusReturnsSum(){
        Dinero cinco         = Dinero.dollar(5);
        Expression resultado = cinco.plus(cinco);
        Suma sum             = (Suma) resultado;
        assertEquals(cinco, sum.augmend);
        assertEquals(cinco, sum.addmend);
    }

    @Test
    void testReduceSum(){
        Expression suma = new Suma(Dinero.dollar(3), Dinero.dollar(4));
        Banco banco     = new Banco();
        Dinero resultado= banco.reduce(suma, "USD");
        assertEquals(Dinero.dollar(7), resultado);
    }

    @Test
    void testReduceDinero(){
        Banco banco      = new Banco();
        Dinero resultado = banco.reduce(Dinero.dollar(1), "USD");
        assertEquals(Dinero.dollar(1), resultado);
    }

    @Test
    void testReduceDineroDiferenteMoneda(){
        Banco banco = new Banco();
        banco.addTasa("CHF", "USD", 2);
        Dinero resultado = banco.reduce(Dinero.franco(2), "USD");
        assertEquals(Dinero.dollar(1), resultado);
    }

    @Test
    void testIdentificarTarifa(){
        assertEquals(1, new Banco().tasa("USD", "USD"));
        assertEquals(1, new Banco().tasa("CHF", "CHF"));
    }

}
