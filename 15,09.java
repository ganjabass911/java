package com.company;
import com.company.numberGenerator.NumberGenerator;
import com.company.fibonachiNumberGenerator.FibonachiNumberGenerator;
import com.company.primeNumberGenerator.PrimeNumberGenerator;

public class Main {

    public static void main(String[] args) {

        int generatorsCount = 2;

        NumberGenerator[] generators = new NumberGenerator[generatorsCount];

        generators[0] = new FibonachiNumberGenerator();
        generators[1] = new PrimeNumberGenerator();

        int n = 10;

        for (int i = 0; i < generatorsCount; ++i){
            for (int j = 0; j < n; ++j){
                System.out.print(String.format("%-3s", String.valueOf(generators[i].next())));
            }
            System.out.println();
        }
    }
}
