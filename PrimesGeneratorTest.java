import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimesGeneratorTest {
    public static void main(String[] args) {
        int N = 10;

        PrimesGenerator generator = new PrimesGenerator(N);

        System.out.println("Первые " + N + " простых чисел в прямом порядке:");
        for (int prime : generator) {
            System.out.print(prime + " ");
        }
        System.out.println();

        System.out.println("\nПервые " + N + " простых чисел в обратном порядке:");

        // Для обратного порядка собираем числа в список и переворачиваем
        List<Integer> primesList = new ArrayList<>();
        for (int prime : generator) {
            primesList.add(prime);
        }
        Collections.reverse(primesList);

        for (int prime : primesList) {
            System.out.print(prime + " ");
        }
        System.out.println();
    }
}