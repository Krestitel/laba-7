import java.util.*;

public class HumanTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создаем коллекцию HashSet
        Set<Human> s = new HashSet<>();

        System.out.println("Введите данные для 3-х человек:");

        // Ввод данных от пользователя для 3 человек
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nЧеловек " + i + ":");
            System.out.print("Имя: ");
            String firstName = scanner.nextLine();

            System.out.print("Фамилия: ");
            String lastName = scanner.nextLine();

            System.out.print("Возраст: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            s.add(new Human(firstName, lastName, age));
        }

        scanner.close();

        // a) Вывод коллекции HashSet
        System.out.println("\n=== a) Коллекция HashSet ===");
        for (Human human : s) {
            System.out.println(human);
        }

        // b) Коллекция LinkedHashSet на основе существующей коллекции s
        Set<Human> linkedHashSet = new LinkedHashSet<>(s);
        System.out.println("\n=== b) Коллекция LinkedHashSet ===");
        for (Human human : linkedHashSet) {
            System.out.println(human);
        }

        // c) Коллекция TreeSet на основе существующей коллекции s
        Set<Human> treeSet = new TreeSet<>(s);
        System.out.println("\n=== c) Коллекция TreeSet (сортировка по Comparable) ===");
        for (Human human : treeSet) {
            System.out.println(human);
        }

        // d) Пустая коллекция TreeSet с компаратором HumanComparatorByLName
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLName());
        treeSetByLastName.addAll(s);
        System.out.println("\n=== d) TreeSet с компаратором по фамилии ===");
        for (Human human : treeSetByLastName) {
            System.out.println(human);
        }

        // e) Пустая коллекция TreeSet с анонимным компаратором по возрасту
        Set<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return h1.getAge() - h2.getAge();
            }
        });
        treeSetByAge.addAll(s);
        System.out.println("\n=== e) TreeSet с анонимным компаратором по возрасту ===");
        for (Human human : treeSetByAge) {
            System.out.println(human);
        }
    }
}