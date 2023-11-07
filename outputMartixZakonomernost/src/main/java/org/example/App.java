package org.example;
/* 1. Запросить у пользователя число N (где N число больше или равное 2)
   2. Вывести на экран матрицу размера NxN, заполненную согласно закономерности:
1 1
2 2

1 0 1
0 0 0
3 0 3

1 0 0 1
0 2 2 0
0 3 3 0
4 0 0 4
 */
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        //запрашиваем число на вход >=2
        int n;
        Scanner scanner = new Scanner(System.in);
        do
        {
            System.out.print("Введите число N, где N больше или равно 2: ");
            n = scanner.nextInt();
        } while(n<2);
        scanner.close();

        //печать массива
        printMatrix(n);
    }

    //вызов метода
    public static void printMatrix(int n)
    {
        int value;
        for(int str=0; str<n; str++) //перебор строки
        {
            for(int column=0; column<n; column++) //перебор столбца
            {
                //если строка первая и послденяя, или столбец непервый и неполсдений (когда значения разные true false = true)
                if((str==0 || str==n-1)^(column>0 && column<n-1))
                    value=str+1; //значение элемента массива a равно y+1
                else
                    value=0; //значение элемента массива a равно 0
                //если размерность нечетная + столбец или строка середины пересечения
                if((n%2!=0)&&(column==n/2 || str==n/2))
                    value=0; //значение элемента массива a равно 0
                System.out.printf("%3d", value);
            }
            System.out.println();
        }
    }
}
