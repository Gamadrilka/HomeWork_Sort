package DZ_Sort;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BubbleSortAndInsertSort {
    static long startTime, endTime;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Бесконечный цикл
        for (; ; ) {
            System.out.println("Введите число каким алгоритмом хотите пользоваться: \n1 - Сортировка пузырьком \n2 - Сортировка выбором \n3 - Выход \n");
            String choice = sc.next();
            if (choice.equals("3")) {
                System.exit(0);
            } else if (choice.equals("1") || choice.equals("2")) {
                //Пузырьковая сортировка - 1
                if (choice.equals("1")) {
                    try {
                        speak();
                        int elements = sc.nextInt();
                        int[] array = randomArray(elements);

                        //Подсчёт времени сортировки
                        startTime = System.currentTimeMillis();
                        bubbleSort(array);
                        endTime = System.currentTimeMillis();
                        System.out.println("Сортировка пузырьком: " + Arrays.toString(array));

                        //Резултат времени
                        setResultTime(startTime, endTime);
                        System.out.println();
                    } catch (InputMismatchException e) {
                        System.out.println("Вы ввели неккоректные символы");
                        break;

                    }
                    // Сортировка выбором - 2
                }else if(choice.equals("2")){
                    try {
                        speak();
                        int elements = sc.nextInt();
                        int [] array = randomArray(elements);

                        //Подсчёт времени сортировки
                        startTime = System.currentTimeMillis();
                        insertSort(array);
                        endTime = System.currentTimeMillis();
                        System.out.println("Сортировка выбором: " + Arrays.toString(array));

                        //Результат веремени
                        setResultTime(startTime, endTime);
                        System.out.println();
                    }catch (InputMismatchException e){
                        System.out.println("Вы ввели неккоректные символы");
                        break;
                    }
                }
                // Если выбор сортировки не совпадает
                }else {
                System.out.println("Такого выбора нет, попробуйте ещё разок");
                System.out.println();
            }
        }
    }
    //Сортировка Пузырьком
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
    //Сортировка выбором
    public static void insertSort(int [] arr){
        for (int i = 1; i<arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while ((j >= 0 && arr[j] > key)) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    //Делаем рандомные элементы
    public static int[] randomArray(int input) {
        Random random = new Random();
        int[] array = new int[input];
        for (int i = 0; i < input; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    //Метод для подсчёта времени
    public static void setResultTime(long starttime, long endtime) {
        long resultTime = endtime - starttime;
        System.out.println("Время выполнения метода = " + resultTime);
    }

    //Метод говорящего))
    public static void speak(){
        System.out.println("Напишите кол-во объема данных, которые Вы бы хотели здесь увидеть: ");
    }
}