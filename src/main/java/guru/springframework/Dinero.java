package guru.springframework;

public class Dinero implements Expression {
    protected int cantidad;
    protected String moneda;

    public Dinero(int cantidad, String moneda) {
        this.cantidad = cantidad;
        this.moneda   = moneda;
    }

    protected String moneda(){
        return moneda;
    }

    public static Dinero dollar(int cantidad){
        return new Dinero(cantidad, "USD");
    }

    public static Dinero franco(int cantidad){
        return new Dinero(cantidad, "CHF");
    }

    public boolean equals(Object object){
        Dinero dinero = (Dinero) object;
        return cantidad == dinero.cantidad
                && this.moneda == dinero.moneda;
    }

    @Override
    public Dinero reduce(Banco banco, String to){
        return new Dinero(cantidad / banco.tasa(this.moneda, to), to);
    }

    @Override
    public String toString() {
        return "Dinero{"+"cantidad=" + cantidad + ", moneda='" + moneda
                + '\'' + '}';
    }

    public Dinero veces(int multiplicador){
        return new Dinero(cantidad * multiplicador, this.moneda);
    }

    public Expression plus(Dinero addend){
        return new Suma(this, addend);
    }
}
