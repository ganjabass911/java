package com.company.PrintNumber;

import com.company.Generator.Generator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public abstract class PrintNumbers
{
    public void print(int n, Generator numGen, String filename){
        try ( PrintStream a = new PrintStream(new FileOutputStream("out/production/files/"+filename)))
        {
            a.print(getText(n, numGen));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    };
    protected abstract String getText(int n, Generator numGen);
}
