package com.company.PrintNumber;

import com.company.Generator.Generator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintNumbersJSON extends PrintNumbers
{
    public String getText(int n, Generator numGen)
    {
        String a = "";
        a = a + "{ \n \"NUMBERS\": \n { \n";
        for (int i = 0; i < n; i++)
            if (i < n-1)
                a = a+ "\"n"+i+"\":"+numGen.next()+",\n";
            else a = a+ "\"n"+i+"\":"+numGen.next()+"\n";
        a = a+ "}\n}";
        return a;
    }
}
