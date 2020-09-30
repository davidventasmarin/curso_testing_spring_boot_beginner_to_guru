package guru.springframework;

public class Dollar extends Dinero{

    public Dollar(int cantidad, String moneda){
        super(cantidad, moneda);
    }

    public Dinero veces(int multiplicador){
        return Dinero.dollar(cantidad * multiplicador);
    }
}
