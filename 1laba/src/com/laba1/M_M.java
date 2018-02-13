package com.laba1;

public class M_M {
    private static final int size = 1000;
    private int[][] f1 = new int[size][size];
    private int[][] f2 = new int[size][size];
    private int[][] it_result = new int[size][size];

//выполняем расчет для матрицы результата
    public  void my_function(int inner, int i,int j){
        it_result[inner][i]+=f1[inner][j]*f2[j][i];
    }

    public  int my_random(){
        return  (int) (Math.random()*size)-size ;
    }

    public void start() {
//заполняем матрицы
        for (int i = 0; i < size; i++) {
            for (int j = 0; j<size; j++) {
                f2[i][j] =my_random();
                f1[i][j] = my_random();
            }
        }
//количество потоков
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
            ThreadMM t[] = new ThreadMM[colThread];


// 3. запуск N  потоков с разными интервалами
            for (int i = 0; i < colThread; i++) {
                t[i] = new ThreadMM();
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
//вывод результата времени затраченнного на вполнение задачи  colThread потоками
            System.out.println(colThread+" thread(s). Time: " + (System.currentTimeMillis() - timeMillis) + " ms");

        }
    }
//поток
    private   class ThreadMM extends Thread {
        private volatile int nk1, nk2;

        public void setN1(int n1) {
            this.nk1 = n1;
        }

        public void setN2(int n2) {
            this.nk2 = n2;
        }

        public void run() {
            for (int inner = nk1; inner < nk2; inner++) {
                for (int i = 0; i<size;i++) {
                    for (int j=0; j<size; j++){
                    my_function(inner,i,j);
                    }
                }
            }

        }

    }
}
