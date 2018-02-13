package com.laba1;
//Произведние вектора на число.
public class V_N {
    private  final int size = 10600000;
    private   long x=5458;
    private long []  f = new long[size];



    public  void start() {
// Реализация исходного вектора
        for (int i = 0; i < size; i++) {
            f[i] = (int) Math.round((Math.random() * size) - size);
        }
        //выбираем дапозон количества потоков от 1 до 10
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
            //ставим таймер
            long timeMillis = System.currentTimeMillis();
// 2,5. инициализация потока с определенным интервалом
            ThreadVN t[] = new ThreadVN[colThread];


// 3. запуск N  потоков с разными интервалами
            for (int i = 0; i < colThread; i++) {
                t[i] = new ThreadVN();
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

    //сам клас потоков
    private class ThreadVN extends Thread {
        private volatile int n1, n2;
    
        public void setN1(int n1) {
            this.n1 = n1;
        }
    
        public void setN2(int n2) {
            this.n2 = n2;
        }
    
        public void run() {
            for (int i = n1; i < n2; i++) {
                f[i]*=x;
            }
        }
    
    }
}
