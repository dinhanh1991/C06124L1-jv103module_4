package com.example.dictionary.controller;

import com.example.dictionary.model.Dictionary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
public class DictionaryController {
    private final Dictionary dictionary;

    public DictionaryController() {
        this.dictionary = new Dictionary();
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/translate")
    public String translate(@RequestParam("word") String word, Model model) {
        String meaning = dictionary.translate(word);
        if (meaning != null) {
            model.addAttribute("word", word);
            model.addAttribute("meaning", meaning);
        } else {
            model.addAttribute("error", "Không tìm thấy từ '" + word + "'");
        }
        return "result";
    }

    @PostMapping("/add-word")
    public String addWord(@RequestParam("word") String word,
                          @RequestParam("meaning") String meaning,
                          Model model) {
        dictionary.addWord(word, meaning);
        model.addAttribute("successMessage", "Thêm từ '" + word + "' thành công!");
        return "result";
    }

    @PostMapping("/remove-word")
    public String removeWord(@RequestParam("word") String word,
                             Model model) {
        if (dictionary.translate(word) != null) {
            dictionary.removeWord(word);
            model.addAttribute("successMessage", "Xóa từ '" + word + "' thành công!");
        } else {
            model.addAttribute("error", "Không tìm thấy từ '" + word + "' trong từ điển!");
        }
        return "result";
    }

    private void setResponseEncoding(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
    }
}