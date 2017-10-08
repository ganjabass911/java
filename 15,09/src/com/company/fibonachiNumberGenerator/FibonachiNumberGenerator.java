package com.company.fibonachiNumberGenerator;

import com.company.numberGenerator.NumberGenerator;

public class FibonachiNumberGenerator extends NumberGenerator {
    private int prevNumber = 1;
    private int currentNumber = 0;

    public int next(){
        currentNumber += prevNumber;
        prevNumber = currentNumber - prevNumber;
        return currentNumber;
    }
}
