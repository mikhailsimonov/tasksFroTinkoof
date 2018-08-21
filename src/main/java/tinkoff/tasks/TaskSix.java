package tinkoff.tasks;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 6.	Есть два List<String>. Первый это эталонные ключи, второй это ключи, которые содержатся в БД. Задача: а) проверить, что в БД нет лишних ключей и вывести все лишние ключи б) проверить, что эталонные ключи содержатся в БД и вывести ключи, которых нет в БД
 *
 */
public class TaskSix {

    public static void check(List<String> a, List<String> b) {
        Set<String> set1 = new HashSet<>(a);
        Set<String> set2 = new HashSet<>(b);

        for (String key : set2) {
            if (!set1.contains(key)) {
                System.out.println("Extra key: " + key);
            }
        }

        for (String key : set1) {
            if (!set2.contains(key)) {
                System.out.println("No key: " + key);
            }
        }
    }

    public static void main(String[] args) {
        List<String> list1 = new LinkedList<>();
        list1.add("qwe");
        list1.add("asd");
        list1.add("zxc");

        List<String> list2 = new LinkedList<>();
        list2.add("qwe");

        List<String> list3 = new LinkedList<>();
        list3.add("qwe");
        list3.add("asd");
        list3.add("zxc");
        list3.add("qaz");
        list3.add("zaq");

        check(list1, list1);
        System.out.println("---");
        check(list1, list2);
        System.out.println("---");
        check(list1, list3);
    }
}