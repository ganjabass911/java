package com.company.PrintNumber;

import com.company.Generator.Generator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintNumbersXML extends PrintNumbers
{
    public String getText(int n, Generator numGen)
    {
        String a ="";
        a = a + "<?xml version=\"1.0\"?>\n<numbers>\n";
        for (int i = 0; i < n; i++)
            a = a + "<n"+i+"> " + numGen.next() + " </n" + i + ">\n";
        a = a + "</numbers>";
        return a;
    }
}
