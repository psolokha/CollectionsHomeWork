package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите путь к файлу:");
        String filePath = null;
        try {
            filePath = new BufferedReader(new InputStreamReader(System.in)).readLine();
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
