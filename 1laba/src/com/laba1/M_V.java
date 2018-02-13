package com.laba1;

public class M_V {
    private final int size = 10000;
    private int[]   f1 = new int[size];
    private int[]   it_result = new int[size];
    private int[][] f2 = new int[size][size];


    private void my_function(int i,int j){
        it_result[i]+=f1[j]*f2[i][j];
    }

    private int my_random(){
        return  ((int) (Math.random()*size)-size );
    }

    public void start() {
//зополение матрицы и вектора
        for (int i = 0; i < size; i++) {
            f1[i] = my_random();
            for (int j = 0; j<size; j++) {
                f2[i][j] = my_random();
            }
        }
//количесвто потоков от 1 до 10
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
//старт таймера
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
//вывод результата таймера
            System.out.println(colThread+" thread(s). Time: " + (System.currentTimeMillis() - timeMillis) + " ms");

        }
    }

    private class ThreadMV extends Thread {
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
