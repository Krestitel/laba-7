import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimesGenerator implements Iterable<Integer> {
    private final int count;

    public PrimesGenerator(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative");
        }
        this.count = count;
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new PrimesIterator();
    }

    private class PrimesIterator implements Iterator<Integer> {
        private int generated = 0;
        private int current = 2;

        @Override
        public boolean hasNext() {
            return generated < count;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more prime numbers");
            }

            while (!isPrime(current)) {
                current++;
            }

            int prime = current;
            current++;
            generated++;
            return prime;
        }
    }
}