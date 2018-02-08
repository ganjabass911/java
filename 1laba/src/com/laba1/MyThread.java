package com.laba1;

public class MyThread extends Thread {
    private volatile int n1, n2, x, f[] ;

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
