package com.example.dictionary.model;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private final Map<String,String> dictionary;
    public Dictionary(){
        dictionary = new HashMap<>();
        loadDictionary();
    }
    private void loadDictionary() {
        dictionary.put("hello", "xin chào");
        dictionary.put("book", "quyển sách");
        dictionary.put("computer", "máy tính");
        dictionary.put("apple", "quả táo");
        dictionary.put("car", "xe hơi");
        dictionary.put("dog", "con chó");
        dictionary.put("cat", "con mèo");
    }
    public String translate(String word) {
        return dictionary.get(word.toLowerCase());
    }
    public void addWord(String word, String meaning) {
        dictionary.put(word.toLowerCase(), meaning);
    }
    public void removeWord(String word) {
        dictionary.remove(word.toLowerCase());
    }

}
