package guru.springframework;

import java.util.Objects;

/**
 * @author medlinetec on 02/10/2020.
 * @project Curso_testing_spring_boot_beginner_to_guru
 */
public class Pair {
    private final String from;
    private final String to;

    public Pair(String from, String to){
        this.from = from;
        this.to   = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(from, pair.from) &&
                Objects.equals(to, pair.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
