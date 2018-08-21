package tinkoff.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.	Написать функцию, которая будет возвращать цифру от 0 до 9, которая будет уникальна для любого треда,
 * обратившегося к этой функции в единицу времени. После выполнения работы тред должен вернуть в массив цифр свою цифру.
 *
 * 2.	Пример: число тредов <= 10 => каждый тред получит любую свободную цифру из массива [0-9]. При количестве тредов
 * > 10 => первые 10 получат любую свободную цифру из массива [0-9], остальные N - 10 тредов должны получить первую свободную цифру
 */
public class TaskFirstAndTwo {

    ArrayList<Thread> threads = new ArrayList<Thread>();
    ArrayList<Integer> integers = new ArrayList<Integer>();
    Map<Thread, Integer> threadIntegerMap = new HashMap<Thread, Integer>();

    private static class MyThread implements Runnable{
        TaskFirstAndTwo first;
        public MyThread(TaskFirstAndTwo first){
            this.first = first;
        }

        public void run() {
            try {
                System.out.println(first.getNumberForThread());
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    first.integers.add(first.getNumberForThread());
                    first.notifyAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public TaskFirstAndTwo(){
        createThread();
        initializeArInt();
        for (Thread t : threads) {
            t.start();
        }
    }

    //метод инициализации массива потоков и массива чисел
    public static void main(String [] args) {
        TaskFirstAndTwo first = new TaskFirstAndTwo();
    }
    //создаем 10 потоков
    public void createThread() {
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new MyThread(this)));
        }
    }

    //наполняем массив чисел
    public void initializeArInt() {
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
    }


    public synchronized Integer getNumberForThread() throws Exception {

        if (!threadIntegerMap.containsKey(Thread.currentThread())) {

            while (integers.isEmpty()) {
                //throw new Exception("all numbers are already in use");
                this.wait();
            }
            threadIntegerMap.put(Thread.currentThread(), integers.remove(0));
            this.notify();
        }
        return threadIntegerMap.get(Thread.currentThread());
    }


}
