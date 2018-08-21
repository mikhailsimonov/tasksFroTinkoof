package tinkoff.tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 3.	Есть файл формата txt в котором две строки => первая строка колонки, вторая значения. Задача –
 * на вход функции подается название колонки и новое значение, напишите функцию, которая будет менять у указанной колонки значение на новое.
 */
public class TaskThree {
    public static void change(String name, String newValue) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input.txt"));
        String columnsLine = scan.nextLine();
        String[] columns = columnsLine.split("\\s");
        String[] values = scan.nextLine().split("\\s");
        scan.close();

        for (int i = 0; i < columns.length; i++) {
            System.out.println(columns[i]);
            if (columns[i].equals(name)) {
                values[i] = newValue;
                break;
            }
        }

        PrintWriter pw = new PrintWriter("output.txt");
        pw.println(columnsLine);
        pw.println(String.join(" ", values));
        pw.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        change("col2", "newval2");
    }
}
