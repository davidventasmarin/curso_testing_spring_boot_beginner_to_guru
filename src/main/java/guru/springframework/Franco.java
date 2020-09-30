package guru.springframework;

public class Franco extends Dinero{

    public Franco(int cantidad, String moneda){
        super(cantidad, moneda);
    }

    public Dinero veces(int multiplicador){
        return Dinero.franco(cantidad * multiplicador);
    }
}
