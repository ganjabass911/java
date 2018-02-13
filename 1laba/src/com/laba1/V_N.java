package com.laba1;

public class V_N {
    public static int x;
    public static int[]  f = new int[10000000];



    public static void start() {
        x = 5;

        for (int i = 0; i < 10000000; i++) {
            f[i] = (int) Math.round((Math.random() * 30) - 15);

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
            n[1] = (int) (10000000 % (colThread + 1));
            for (int i = 2; i < (colThread + 1); i++) {
                n[i] = n[i - 1] + (int) (10000000 % (colThread + 1));
            }

            long timeMillis = System.currentTimeMillis();
// 2,5. инициализация потока с определенным интервалом
            ThreadVN t[] = new ThreadVN[colThread];


// 3. запуск N  потоков с разными интервалами
            for (int i = 0; i < colThread; i++) {
                t[i] = new ThreadVN();
                t[i].setN1(n[i]);
                t[i].setN2(n[i + 1]);
                t[i].setF(f);
                t[i].setX(x);
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
    public static class ThreadVN extends Thread {
        private volatile int n1, n2, x, f[];
    
        public void setN1(int n1) {
            this.n1 = n1;
        }
    
        public void setN2(int n2) {
            this.n2 = n2;
        }
    
        public void setX(int x) {
            this.x = x;
        }
    
        public void setF(int[] f) {
            this.f = f;
        }
    
        public void run() {
            for (int i = n1; i < n2; i++) {
                this.f[i]*=this.x;
            }
        }
    
    }
}
