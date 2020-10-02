package guru.springframework;

import java.util.HashMap;

public class Banco {

    private HashMap<Pair, Integer> tasaMap = new HashMap<>();

    Dinero reduce(Expression source, String toMoneda){
        return source.reduce(this, toMoneda);
    }

    public int tasa(String from, String to){
        if(from.equals(to)){
            return 1;
        }

        return tasaMap.get(new Pair(from, to));
    }

    public void addTasa(String from, String to, int tasa){
        tasaMap.put(new Pair(from, to), tasa);
    }
}
