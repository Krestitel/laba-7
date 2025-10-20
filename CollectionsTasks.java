import java.util.*;

public class CollectionsTasks {
    public static void main(String[] args) {
        // a) Создайте массив из N чисел
        int n = 10;
        Integer[] array = {5, 2, 8, 2, 1, 9, 5, 3, 7, 1}; // массив с дубликатами для демонстрации

        System.out.println("a) Исходный массив: " + Arrays.toString(array));

        // b) На основе массива создайте список List
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("b) Список из массива: " + list);

        // c) Отсортируйте список в натуральном порядке
        List<Integer> forSorting = new ArrayList<>(list);
        Collections.sort(forSorting);
        System.out.println("c) Список в натуральном порядке: " + forSorting);

        // d) Отсортируйте список в обратном порядке
        List<Integer> forReverse = new ArrayList<>(list);
        Collections.sort(forReverse, Collections.reverseOrder());
        System.out.println("d) Список в обратном порядке: " + forReverse);

        // e) Перемешайте список
        List<Integer> forShuffle = new ArrayList<>(list);
        Collections.shuffle(forShuffle);
        System.out.println("e) Перемешанный список: " + forShuffle);

        // f) Выполните циклический сдвиг на 1 элемент
        List<Integer> forRotate = new ArrayList<>(list);
        Collections.rotate(forRotate, 1);
        System.out.println("f) Список после циклического сдвига на 1: " + forRotate);

        // g) Оставьте в списке только уникальные элементы
        List<Integer> forUnique = new ArrayList<>(list);
        Set<Integer> uniqueSet = new HashSet<>(forUnique);
        forUnique.clear();
        forUnique.addAll(uniqueSet);
        System.out.println("g) Список с уникальными элементами: " + forUnique);

        // h) Оставьте в списке только дублирующиеся элементы
        List<Integer> forDuplicates = new ArrayList<>(list);
        Set<Integer> temp = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (Integer num : list) {
            if (!temp.add(num)) {
                duplicates.add(num);
            }
        }
        forDuplicates.clear();
        forDuplicates.addAll(duplicates);
        System.out.println("h) Список с дублирующимися элементами: " + forDuplicates);

        // i) Из списка получите массив
        Integer[] resultArray = list.toArray(new Integer[0]);
        System.out.println("i) Массив из списка: " + Arrays.toString(resultArray));
    }
}