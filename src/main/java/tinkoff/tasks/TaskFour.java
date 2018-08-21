package tinkoff.tasks;

import java.util.LinkedList;

/**
 * 4.	Напишите функцию, которая будет из входной строки удалять парные, идущие друг за другом буквы в одну и на выходе
 * вернуть строку, которая не будет иметь парных, идущих друг за другом букв. Пример: aaabccddd => abd, baab => пусто
 */
public class TaskFour {
    public static String foo(String s) {
        LinkedList<Character> list = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (!list.isEmpty() && list.getLast() == s.charAt(i)) {
                list.removeLast();
            }
            else {
                list.add(s.charAt(i));
            }
        }
        String res = "";
        for (Character c : list) {
            res += c;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(foo("aaabccddd"));
        System.out.println(foo("baab"));
    }
}