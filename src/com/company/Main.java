package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите путь к файлу:");
        String filePath = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            filePath = reader.readLine();
            reader.close();
            filePath.replace("\\", "\\\\");
        } catch (IOException e) {
            e.printStackTrace();
        }


        WordsContainer wc = WordsContainer.getInstance();

        wc.parseFile(filePath);

        wc.printWordsInContainer();

        wc.printMostPopularWord();

    }
}
