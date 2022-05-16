package helpers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringHelper {
    public boolean compareWorlds(String  firstString, String secondString){
        firstString = firstString.toLowerCase();
        secondString = secondString.toLowerCase();
        return firstString.equals(secondString);
    }

    public int countWords(String text){
        if (text == null || text.isEmpty()) { return 0; }
        String[] words = text.split("\\s+");
        List<String> list = Arrays.stream(words).collect(Collectors.toList());
        System.out.println(list);
        return words.length;
    }
}
