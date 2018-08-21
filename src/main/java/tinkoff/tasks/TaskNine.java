package tinkoff.tasks;

/**
 * 9.	Для 15 выводим FizzBuzz, а не FizzBuzzFizzBuzz.
 */

public class TaskNine {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                System.out.print("Fizz");
            }
            if (i % 5 == 0) {
                System.out.print("Buzz");
                if (i == 15) {
                    System.out.print("FizzBuzz");
                }
            }
            else if (i % 3 != 0) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
