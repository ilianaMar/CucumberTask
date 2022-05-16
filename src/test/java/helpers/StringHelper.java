package helpers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringHelper {
    public int compareWorlds(String  firstString, String secondString, boolean caseSensitive){
        if(caseSensitive){
            return firstString.compareTo(secondString);
        }else {
            return firstString.compareToIgnoreCase(secondString);
        }
    }

    public int countWords(String text){
        if (text == null || text.isEmpty()) { return 0; }
        String[] words = text.split("\\s+");
        List<String> list = Arrays.stream(words).collect(Collectors.toList());
        System.out.println(list);
        return words.length;
    }
}
