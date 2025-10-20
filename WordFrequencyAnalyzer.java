import java.util.*;

public class WordFrequencyAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст на английском языке:");
        String text = scanner.nextLine();

        scanner.close();

        // Используем HashMap как требуется в задании
        Map<String, Integer> wordFrequency = new HashMap<>();

        // Разбиваем текст на слова (разделители: пробелы и знаки препинания)
        String[] words = text.split("[\\s\\p{Punct}]+");

        // Подсчитываем частоту каждого слова (РЕГИСТР УЧИТЫВАЕТСЯ)
        for (String word : words) {
            if (!word.isEmpty()) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        // Выводим результаты
        System.out.println("\nРезультат подсчета частоты слов:");
        System.out.println("================================");

        // Простой вывод без сортировки
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println("Слово: '" + entry.getKey() + "' - частота: " + entry.getValue());
        }

        // Статистика
        System.out.println("\nСтатистика:");
        System.out.println("Всего уникальных слов: " + wordFrequency.size());
    }
}