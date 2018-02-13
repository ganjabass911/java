package com.laba1;

public class M_V {
    private static final int size = 10000;
    public static int[]  f1,it_result = new int[size];
    public static int[][] f2 = new int[size][size];


    public static void my_function(int i,int j){
        it_result[i]+=f1[j]*f2[i][j];
    }

    public static int my_random(){
        int rnd = (int) (Math.random()*size)-size ;
        return rnd;
    }

    public static void start() {

        for (int i = 0; i < size; i++) {
            f1[i] = my_random();
            for (int j = 0; j<size; i++) {
                f2[i][j] =my_random();
            }
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
            ThreadMV t[] = new ThreadMV[colThread];


// 3. запуск N  потоков с разными интервалами
            for (int i = 0; i < colThread; i++) {
                t[i] = new ThreadMV();
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

    public static class ThreadMV extends Thread {
        private volatile int nk1, nk2;

        public void setN1(int n1) {
            this.nk1 = n1;
        }

        public void setN2(int n2) {
            this.nk2 = n2;
        }

        public void run() {
            for (int i = nk1; i < nk2; i++) {
                for (int j = 0; j<size;j++) {
                    my_function(i,j);
                }
            }

        }

    }
}
