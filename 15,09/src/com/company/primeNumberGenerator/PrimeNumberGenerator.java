package com.company.primeNumberGenerator;

import com.company.numberGenerator.NumberGenerator;

public class PrimeNumberGenerator extends NumberGenerator{
    private int currentNumber = 1;

    public int next(){
        currentNumber++;
        while (true){
            if (isPrime(currentNumber)){
                return currentNumber;
            }
            else{
                currentNumber++;
            }
        }
    }

    private boolean isPrime(int num){
        for (int i = 2; i < num / 2 + 1; ++i){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
