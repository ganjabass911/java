package com.company.Generator;

public class FibonacciGenerator extends Generator
{
    public int x0=0;
    public int x1=1;


    public int next()
    {
        x = x1+x0;
        x0=x1;
        x1=x;
        return x;
    }
}
