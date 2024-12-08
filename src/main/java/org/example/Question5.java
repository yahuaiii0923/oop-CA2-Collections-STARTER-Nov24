package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  Name:Siew Ya Huai
 *  Class Group:SD2b
 */
public class Question5 {    //Java Identifier Count (Map)

    public static void readFile(String fileName) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File(fileName));
        Map<String, Integer> identifierCountMap = new TreeMap<>();
        Map<String, List<String>> identifierLineMap = new TreeMap<>();

        int lineNum = 1;
        // read each line
        while(fileReader.hasNextLine()) {
            String code = fileReader.nextLine();
            String[] words = code.split("[^A-Za-z0-9_]+");

            for (String word : words) {
                // ignore whitespace
                if (word.isEmpty()) {
                    continue;
                }

                // if word is not in identifierCountMap, insert word with a value of 1
                // if word is already in the map, add 1 to the current value of word
                identifierCountMap.merge(word, 1, Integer::sum);

                // if word is not in identifierLineMap, insert word and new ArrayList (to fill with lines of code)
                identifierLineMap.computeIfAbsent(word, k -> new ArrayList<>());
                identifierLineMap.get(word).add(lineNum + ". " + code);
            }
            lineNum++;
        }
        System.out.println("Identifiers found: ");
        for (String identifier : identifierCountMap.keySet()) {
            System.out.println(identifier + "\t" + identifierCountMap.get(identifier));
            for (String line : identifierLineMap.get(identifier)) {
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/main/java/org/example/Question2.java");
    }
}