import java.util.*;

public class RarestValueFinder {
    public static int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException("Map cannot be empty");
        }

        // Словарь для подсчета количества каждого значения
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Заполняем frequencyMap
        for (int value : map.values()) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        // Поиск наименее частого значения
        int rarestValue = Integer.MAX_VALUE;
        int minFrequency = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int value = entry.getKey();
            int frequency = entry.getValue();

            // Если нашли значение с меньшей частотой, или с той же частотой, но меньшим значением
            if (frequency < minFrequency || (frequency == minFrequency && value < rarestValue)) {
                rarestValue = value;
                minFrequency = frequency;
            }
        }

        return rarestValue;
    }

    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<>();
        students.put("Alyssa", 22);
        students.put("Char", 25);
        students.put("Dan", 25);
        students.put("Jeff", 20);
        students.put("Kasey", 20);
        students.put("Kim", 20);
        students.put("Megran", 25);
        students.put("Ryan", 25);
        students.put("Stef", 22);

        // Вызов метода rarest
        int result = rarest(students);
        System.out.println("Rarest age: " + result); // Ожидается 22
    }
}
