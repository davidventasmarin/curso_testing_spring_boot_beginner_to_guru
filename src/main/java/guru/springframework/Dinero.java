package guru.springframework;

public abstract class Dinero {
    protected int cantidad;
    protected String moneda;

    public Dinero(int cantidad, String moneda) {
        this.cantidad = cantidad;
        this.moneda   = moneda;
    }

    protected String moneda(){
        return moneda;
    }

    public abstract Dinero veces(int multiplicador);

    public static Dinero dollar(int cantidad){
        return new Dollar(cantidad, "USD");
    }

    public static Dinero franco(int cantidad){
        return new Franco(cantidad, "CHF");
    }

    public boolean equals(Object object){
        Dinero dinero = (Dinero) object;

        return cantidad == dinero.cantidad
                && this.getClass().equals(object.getClass());
    }
}
