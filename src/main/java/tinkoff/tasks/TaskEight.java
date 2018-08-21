package tinkoff.tasks;

/**
 * 8.	Напишите программу, которая выводит на экран числа от 1 до 100. При этом вместо чисел, кратных 3, программа
 * должна выводить слово Fizz, а вместо чисел, кратных 5 — слово Buzz. Если число кратно 15, то программа должна выводить слово FizzBuzz.
 */
public class TaskEight {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                System.out.print("Fizz");
            }
            if (i % 5 == 0) {
                System.out.print("Buzz");
            }
            else if (i % 3 != 0) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
