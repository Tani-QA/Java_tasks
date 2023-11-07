package org.example;
//найти минимальный ненулевой элемент обратной диагонали без учета элемента пересечения
import java.util.Scanner;
import java.util.Random;
import java.lang.*;

public class Main {
    public static void main(String[] args) {

        //запрашиваем число на вход >3
        int n;
        Scanner scan = new Scanner(System.in);
        do
        {
            System.out.print("Введите число N, где N >= 3 и N - нечётное число): ");
            n = scan.nextInt();
        } while(n<3 || n % 2 == 0);
        scan.close();

        //создаем 2хмерный массив размерности N*N
        float[][] array = new float[n][n];

        //заполняем массив случайными дробными числами 0.0-0.99 (1 не включается)
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = random.nextFloat();
            }
        }

        //выводим полученный массив в консоль ++
        printMassiv(array, n);

        //находим элемент пересечения через функцию ++ (необязательно)
        int rows = array.length;
        int cols = array[0].length;
        float diagonalElement = findDiagonalElement(array, rows, cols);
        System.out.println("Элемент пересечения по диагонали: " + String.format("%.2f",diagonalElement));

        //находим минимальный ненулевой элемент обратной диагонали++
        findMinElementPobochDiagonal(array, rows, cols);
    }

    //вызов методов

    //выводим полученный массив в консоль++
    public static void printMassiv(float[][] array, int n) {
        System.out.println("Полученный массив: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%.2f",array[i][j]) + "  ");
            }
            System.out.println();
        }
    }

    //находим минимальный ненулевой элемент побочной диагонали++
    public static void findMinElementPobochDiagonal(float[][] array,int rows,int cols) {
        float minElDiagPoboch = array[array.length - 1][0]; //принимаем минимальный - нижний из 1-го столбца
        for (int i = 1; i < array.length; i++) { // начинаем проход со 2-го столбца
            float next = array[array.length - 1 - i][i];
            if ((i != array.length - 1 - i)&&(next != 0.00f)) { // пропускаем элемент на пересечении и нулевой
                if (minElDiagPoboch > next) {
                    minElDiagPoboch = next;
                }
            }
        }
        System.out.println("Минимальный элемент обратной диагонали: " +String.format("%.2f",minElDiagPoboch));
    }

    //находим элемент пересечения (не обязательно)
    public static float findDiagonalElement(float[][] array,int rows,int cols) {
        // Проверяем, что массив является квадратным
        if (rows != cols) {
            throw new IllegalArgumentException("Массив не квадратный");
        }
        float elDiag=array[rows / 2][cols / 2];
        return elDiag;
    }

}