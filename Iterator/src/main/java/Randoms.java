import java.util.*;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    private int min;
    private int max;
    private List<Integer> number = new ArrayList<>();

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void addNumber() {
        random = new Random();
        number.add(random.nextInt(min, max + 1));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int next = 0;

            @Override
            public boolean hasNext() {
                addNumber();
                return true;
            }

            @Override
            public Integer next() {
                if (next < number.size()) {
                    int num = number.get(next);
                    next++;
                    return num;
                }
                return -1;
            }
        };
    }
}