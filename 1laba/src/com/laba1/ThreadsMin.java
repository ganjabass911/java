package com.laba1;

import java.util.Random;
import java.util.Scanner;
import com.laba1.MyThread;


public class ThreadsMin {
  public static int x;
  public static int[]  f = new int[10000000];


  public static void main(String[] args) {
      x = 5;

      for (int i = 0; i < 10000000; i++) {
          f[i] = (int) Math.round((Math.random() * 30) - 15);
      }
      while (true) {

          System.out.print("Write the quantity of threads: ");
// 1. Инициализация количества потоков
          Scanner in = new Scanner(System.in);
          int iteration = in.nextInt();

// 2. Расчет итераций на поток
          int[] n = new int[iteration + 1];
          n[0] = 0;
          n[1] = (int) (10000000 % (iteration + 1));
          for (int i = 2; i < (iteration + 1); i++) {
              n[i] = n[i - 1] + (int) (10000000 % (iteration + 1));
          }

          long timeMillis = System.currentTimeMillis();
// 2,5. инициализация потока с определенным интервалом
          MyThread t[] = new MyThread[iteration];


// 3. запуск N  потоков с разными интервалами
          for (int i = 0; i < iteration; i++) {
              t[i] = new MyThread();
              t[i].setF(f);
              t[i].setN1(n[i]);
              t[i].setN2(n[i + 1]);
              t[i].setX(x);
              t[i].start();
          }

// 4. Ждем завершения, но тоже не понятно, дождется всех или только одного

          for (int i = 0; i < iteration; i++) {
              try {
                  t[i].join();

              } catch (InterruptedException e) {
                  System.out.println("Error");
              }
          }
          System.currentTimeMillis();

          System.out.println("It's Work. Time: " + (System.currentTimeMillis() - timeMillis) + " ms");
      }
  }
}
