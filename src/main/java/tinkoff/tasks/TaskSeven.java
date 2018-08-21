package tinkoff.tasks;

import java.util.Map;
import java.util.TreeMap;

/**
 * 7.	Есть строка вида “aaabbcccd”. Задача посчитать количество каждой буквы и вывести. Например: “3a2b3c1d”.

 */
public class TaskSeven {

    public static String foo(String input) {
        Map<Character, Integer> map = new TreeMap<>();
        int len = input.length();
        for (int i = 0; i < len; i++) {
            int count = 1;
            if (map.containsKey(input.charAt(i))) {
                count += map.get(input.charAt(i));
            }
            map.put(input.charAt(i), count);
        }

        String result = "";
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            result += "" + e.getValue() + e.getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(foo("aaabbcccd"));
    }
}
