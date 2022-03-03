package com.kyleirwin;

import java.util.HashMap;
import java.util.Map;

public class wordleGrid {

    String defaultRow = "|_|_|_|_|_|";
    String allLetters = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
    Map<Integer, String> gridRows = new HashMap<>();

    public Map<Integer, String> defaultGrid() {
        for (int i = 0; i < 6; i++) {
            gridRows.put(i, defaultRow);
        }
        return gridRows;
    }

    public void displayGrid(Map<Integer, String> map) {
        for(Map.Entry<Integer, String> row : map.entrySet()) {
            System.out.println(row.getValue());
        }
    }

}
