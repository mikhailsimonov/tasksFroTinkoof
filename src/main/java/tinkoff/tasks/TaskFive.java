package tinkoff.tasks;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 5.	Даны две коллекции ObjectA (исходные/справочные данные и проверяемые данные), который содержит поля: int id, String name, String value.
 * Ваша задача проверить эквивалентность всех полей попарно и в случае не совпадения вывести в отчет, а в конце проверки выкинуть ошибку проверки
 *
 */
public class TaskFive {

    public static void check(Collection<ObjectA> c1, Collection<ObjectA> c2) throws Exception {
        Iterator<ObjectA> it1 = c1.iterator();
        Iterator<ObjectA> it2 = c2.iterator();
        if (c1.size() != c2.size()) {
            throw new Exception("Different sizes");
        }
        boolean eq = true;
        while (it1.hasNext()) {
            ObjectA o1 = it1.next();
            ObjectA o2 = it2.next();
            if (!o1.equals(o2)) {
                System.out.println("Diff: '" + o1 + "' and '" + o2 + "'");
                eq = false;
            }
        }
        if (eq) {
            System.out.println("No difference!");
        }
        else {
            throw new Exception("Collections are not equal");
        }
    }

    public static void main(String[] args) {
        Collection<ObjectA> c1 = new LinkedList<>();
        c1.add(new ObjectA(1, "Ivan", "qwerty"));
        c1.add(new ObjectA(2, "Petr", "asdfgh"));
        c1.add(new ObjectA(3, "Boris", "zxcvbn"));

        Collection<ObjectA> c2 = new LinkedList<>();
        c2.add(new ObjectA(1, "Ivan", "qwerty"));
        c2.add(new ObjectA(2, "Petr", "asdfgh"));
        c2.add(new ObjectA(3, "Boris", "zxcvbn"));

        Collection<ObjectA> c3 = new LinkedList<>();
        c3.add(new ObjectA(1, "Иван", "qwerty"));
        c3.add(new ObjectA(2, "Пётр", "asdfgh"));
        c3.add(new ObjectA(3, "Борис", "zxcvbn"));

        try {
            check(c1, c2);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            check(c1, c3);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class ObjectA {
    int id;
    String name;
    String value;
    public ObjectA(int id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }
    public boolean equals(ObjectA o) {
        return id == o.id
                && name.equals(o.name)
                && value.equals(o.value);
    }

    @Override
    public String toString() {
        return id + ". " + name + " (" + value + ")";
    }
}
