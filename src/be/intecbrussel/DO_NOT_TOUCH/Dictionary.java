package be.intecbrussel.DO_NOT_TOUCH;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class Dictionary {
    private static Queue<String> dictionaryWords = load();

    private static Queue<String> load() {
        Queue<String> words = new ConcurrentLinkedQueue<>();
        File file = new File("resources/Oxford English Dictionary.txt");
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            for (String string : strings) {
                if (!string.isBlank())
                    words.add(string.split(" ")[0]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }

    protected static String getRandomWord() {
        List<String> l = new ArrayList<>(dictionaryWords);
        Collections.shuffle(l);
        String word = l.get(0);
        return word;
    }

    protected static String[] getRandomWords(int amount) {
        String[] words = new String[amount];
        for (int i = 0; i < words.length; i++) {
            words[i] = getRandomWord();
        }
        return words;
    }
}
