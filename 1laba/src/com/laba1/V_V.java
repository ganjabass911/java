package com.laba1;

import java.util.Random;

public class V_V {
    private static final int size = 10000000;
    public static int[]  f1,f2 = new int[size];
    public static int fps=0;

    public static void my_function(int i){
        fps+=f1[i]*f2[i];
    }

    public static void start() {


// Инициализируем генератор
        Random rnd = new Random(System.currentTimeMillis());
        // Получаем случайное число в диапазоне от min до max (включительно)

        for (int i = 0; i < size; i++) {
            f1[i] = ((-size) + rnd.nextInt(size - (-size) + 1));
            f2[i] = ((-size) + rnd.nextInt(size - (-size) + 1));
        }

        for (int j = 0; j < 10; j++) {
            int colThread = j + 1;
//        System.out.print("Write the quantity of threads: ");
//// 1. Инициализация количества потоков
//        Scanner in = new Scanner(System.in);
//        int colThread = in.nextInt();

// 2. Расчет итераций на поток
            int[] n = new int[colThread + 1];
            n[0] = 0;
            n[1] = (int) (size % (colThread + 1));
            for (int i = 2; i < (colThread + 1); i++) {
                n[i] = n[i - 1] + (int) (size % (colThread + 1));
            }

            long timeMillis = System.currentTimeMillis();
// 2,5. инициализация потока с определенным интервалом
            ThreadVV t[] = new ThreadVV[colThread];


// 3. запуск N  потоков с разными интервалами
            for (int i = 0; i < colThread; i++) {
                t[i] = new ThreadVV();
                t[i].setN1(n[i]);
                t[i].setN2(n[i + 1]);
            }

            for (int i = 0; i < colThread; i++) {
                t[i].start();

            }


// 4. Ждем завершения, но тоже не понятно, дождется всех или только одного

            for (int i = 0; i < colThread; i++) {
                try {

                    t[i].join();

                } catch (InterruptedException e) {
                    System.out.println("Error");
                }
            }
            System.currentTimeMillis();

            System.out.println(colThread+" thread(s). Time: " + (System.currentTimeMillis() - timeMillis) + " ms");

        }
    }

    public static class ThreadVV extends Thread {
        private volatile int nk1, nk2;

        public void setN1(int n1) {
            this.nk1 = n1;
        }

        public void setN2(int n2) {
            this.nk2 = n2;
        }

        public void run() {
            for (int i = nk1; i < nk2; i++) {
                my_function(i);

            }

        }

    }
}
