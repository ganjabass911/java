package com.company;

//все исключения наследуются от класса Exception
//int f() throws Exception{} {...} - обязательно для наследуемых от Exception
//try { f(); } catch ( Exception, e) { log.error; }


//создать новый класс PrintNumbers с наследниками PrintNumbersJson, PrintNumbersXml
//общий метод print (n, NumberGenerator, filename);

import com.company.Generator.*;
import com.company.PrintNumber.*;

import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        FibonacciGenerator genF = new FibonacciGenerator();
        PrimeNumberGenerator genP = new PrimeNumberGenerator();
        PrintNumbersJSON Printer1 = new PrintNumbersJSON();
        PrintNumbersXML Printer2 = new PrintNumbersXML();
        Printer1.print(20, genF, "Generator.json");
        Printer2.print(20, genP,"Generator.xml");

    }
}