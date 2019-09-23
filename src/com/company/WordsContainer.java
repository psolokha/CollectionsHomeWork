package com.company;

import java.io.*;
import java.util.*;

public class WordsContainer {

    private Map<String, Integer> wordsContainer = new TreeMap<String, Integer>();
    private static WordsContainer instance;

    private WordsContainer(){};

    public static WordsContainer getInstance() {
        if (instance == null) instance = new WordsContainer();
        return instance;
    }

    private void addWordToConatainer(String word) {
        if (wordsContainer.containsKey(word)) wordsContainer.put(word, (wordsContainer.get(word)+1));
        else wordsContainer.put(word,1);
    }

    public void parseFile(String path) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))))) {

            while (fileReader.ready()) {
                StringTokenizer tokenizer = new StringTokenizer(fileReader.readLine(),"*& ,.!?_:;+=-/><'#@!\t\"\\()[]{}%$`");
                while (tokenizer.hasMoreElements()) addWordToConatainer(tokenizer.nextToken().toLowerCase());
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Can not open file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printMostPopularWord() {
        if (wordsContainer.isEmpty()) {
            System.out.println("Container is empty");
            return;
        }

        int tmpNum = 0;
        for (Integer num:wordsContainer.values()) {
            if (num > tmpNum) tmpNum = num;
        }

        for (Map.Entry<String,Integer> entry: wordsContainer.entrySet()) {
            if (entry.getValue() == tmpNum) System.out.println("Most popular word is:\n" + entry.getKey() + ": " + entry.getValue() + " times");
        }

    }

    public void printWordsInContainer() {
        if (wordsContainer.isEmpty()) {
            System.out.println("Container is empty");
            return;
        }
        wordsContainer.forEach((k,v) -> {
            System.out.println(k + ": " + v);
        });

    }
}
