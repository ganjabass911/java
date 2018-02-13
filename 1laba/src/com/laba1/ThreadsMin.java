/*Основной файл проекта. Здесь вызываются ниеобходимые задачи.
1. Произведние вектора на число.        V_N
2. Скалярное произведение векторов.     V_V
3. Произведение вектора на матрицу.     M_V
4. Произведение матриц.                 M_M
 */

package com.laba1;


import java.util.Scanner;

public class ThreadsMin {
    public static void main(String[] ardgs) {
        while (true) {
            System.out.print("Введите номер задания: ");
            Scanner in = new Scanner(System.in);
            int colThread = in.nextInt();
            switch (colThread) {
                case 1:
                    new V_N().start();
                    break;
                case 2:
                    new V_V().start();
                    break;
                case 3:
                    new M_V().start();
                    break;
                case 4:
                    new M_M().start();
                    break;
            }
        }
    }
}
