package com.company;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String [] args){
        String path = "D:\\1.txt";// расположение тхт файла

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = null;

            Map<String,Integer> result = new HashMap<>(); //ключ - слово, значение - кол-во вхождений
            List<String> words = new ArrayList<>(); //здесь будут лежать все слова

            while((line=reader.readLine())!=null){//запись всех слов
                List<String> wordsLine = Arrays.asList(line.split(" "));
                words.addAll(wordsLine);
            }

            for(String current: words){//счет найденных слов
                if (!result.containsKey(current)){
                    result.put(current,1);
                }else{
                    result.put(current,result.get(current)+1);
                }
            }
            for(String key: result.keySet()){//вывод
                System.out.println(key + " " + result.get(key));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
