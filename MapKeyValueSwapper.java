import java.util.*;

public class MapKeyValueSwapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создаем исходную Map для демонстрации
        Map<String, Integer> originalMap = new HashMap<>();

        System.out.println("Введите данные для Map (для завершения введите 'exit'):");
        System.out.println("Формат: ключ значение (например: Anna 25)");

        while (true) {
            System.out.print("Введите пару ключ-значение: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length == 2) {
                try {
                    String key = parts[0];
                    Integer value = Integer.parseInt(parts[1]);
                    originalMap.put(key, value);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: значение должно быть числом!");
                }
            } else {
                System.out.println("Ошибка: введите ключ и значение через пробел!");
            }
        }

        scanner.close();

        // Выводим исходную Map
        System.out.println("\nИсходная Map:");
        System.out.println(originalMap);

        // Вызываем метод для обмена ключей и значений
        Map<Integer, Collection<String>> swappedMap = swapKeysAndValues(originalMap);

        // Выводим результат
        System.out.println("\nMap после обмена ключей и значений:");
        System.out.println(swappedMap);

        // Красивый вывод
        System.out.println("\nДетальный вывод:");
        for (Map.Entry<Integer, Collection<String>> entry : swappedMap.entrySet()) {
            System.out.println("Значение " + entry.getKey() + " -> Ключи: " + entry.getValue());
        }
    }

    /**
     * Метод для обмена ключей и значений в Map
     * @param originalMap исходная Map
     * @return новая Map, где ключи и значения поменяны местами
     */
    public static <K, V> Map<V, Collection<K>> swapKeysAndValues(Map<K, V> originalMap) {
        Map<V, Collection<K>> swappedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            K originalKey = entry.getKey();
            V originalValue = entry.getValue();

            // Если значение уже есть в новой Map, добавляем ключ в коллекцию
            if (swappedMap.containsKey(originalValue)) {
                swappedMap.get(originalValue).add(originalKey);
            } else {
                // Если значения еще нет, создаем новую коллекцию
                Collection<K> keys = new ArrayList<>();
                keys.add(originalKey);
                swappedMap.put(originalValue, keys);
            }
        }

        return swappedMap;
    }
}