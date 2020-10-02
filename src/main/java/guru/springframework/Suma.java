package guru.springframework;

public class Suma implements Expression{

    Dinero augmend;
    Dinero addmend;

    public Suma(Dinero augmend, Dinero addmend){
        this.augmend  = augmend;
        this.addmend  = addmend;
    }

    @Override
    public Dinero reduce(Banco banco, String to){
        int cantidad = augmend.cantidad + addmend.cantidad;
        return new Dinero(cantidad, to);
    }
}
