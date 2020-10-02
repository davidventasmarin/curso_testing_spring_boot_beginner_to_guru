package guru.springframework;

public class Banco {
    Dinero reduce(Expression source, String toMoneda){
        return source.reduce(toMoneda);
    }
}
