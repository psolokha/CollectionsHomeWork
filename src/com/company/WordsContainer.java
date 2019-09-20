package com.company;

import java.io.*;
import java.util.*;

public class WordsContainer {

    Map<String, Integer> wordsContainer = new TreeMap<String, Integer>();
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
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
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

    public String printMostPopularWord() {
        String sTmp = "";
        Integer iTmp = 0;
        Iterator<Map.Entry<String, Integer>> iterator = wordsContainer.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> tmp = iterator.next();
            if (tmp.getValue() > iTmp) {
                sTmp = tmp.getKey();
                iTmp = tmp.getValue();
            }
        }
        System.out.println("\nThe most popular word is: " + sTmp + "\nNumber of entries: " + iTmp);
        return sTmp;
    }

    public void printWordsInContainer() {
        wordsContainer.forEach((k,v) -> {
            System.out.println(k + ": " + v);
        });
    }
}
