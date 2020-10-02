package guru.springframework;

public class Suma implements Expression{

    Dinero augmend;
    Dinero addmend;

    public Suma(Dinero augmend, Dinero addmend){
        this.augmend  = augmend;
        this.addmend  = addmend;
    }

    public Dinero reduce(String to){
        int cantidad = augmend.cantidad + addmend.cantidad;
        return new Dinero(cantidad, to);
    }
}
