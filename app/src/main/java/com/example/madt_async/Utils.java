package com.example.madt_async;

import java.util.ArrayList;

public class Utils {

    public static String removeExcessiveSpacesFromString(String inputText){
        String[] wordsArray = inputText.split("\\s");
        ArrayList<String> wordsArrayWithoutEmptySpaces = new ArrayList<>();
        for (String word : wordsArray) {
            if(!word.isEmpty()){
                wordsArrayWithoutEmptySpaces.add(word);
            }
        }
        return String.join(" ", wordsArrayWithoutEmptySpaces);
    }
}
