package com.company.Generator;

public class PrimeNumberGenerator extends Generator
{
    public int x=2;

    public int next()
    {
        boolean b = true;

        while (b)
        {
            for (int i = 1; i < x; ++i)
            {
                if (x % i == 0)
                {
                    b = false;
                    break;
                }
            }
            x++;
        }
        return x;
    }
}
