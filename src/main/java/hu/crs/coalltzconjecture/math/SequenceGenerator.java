package hu.crs.coalltzconjecture.math;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SequenceGenerator {

    public Sequence sequence(int seed) {
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();

        int x = seed;
        int y = seed;
        xs.add(x);
        ys.add(y);

        do {
            x++;
            y = result(y);

            xs.add(x);
            ys.add(y);
        } while (y != 1);

        return new Sequence(xs, ys);
    }

    private boolean even(int integer) {
        return (integer % 2) == 0;
    }

    private int result(int integer) {
        if (even(integer)) {
            return integer / 2;
        } else {
            return 3 * integer + 1;
        }
    }

    public List<Sequence> sequences(List<Integer> integers) {
        return integers.stream()
                .map(this::sequence)
                .collect(Collectors.toList());
    }
}
