package com.example.mail_setting.controller;

import com.example.mail_setting.model.MailSetting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    private MailSetting mailSettings=new MailSetting();

    public SettingsController() {
        mailSettings.setLanguage("English");
        mailSettings.setPageSize(25);
        mailSettings.setSpamsFilter(false);
        mailSettings.setSignature("Thor\nKing, Asgard");
    }

    @GetMapping
    public String showSettingsForm(Model model) {
        model.addAttribute("mailSettings", mailSettings);
        return "settings";
    }

    @PostMapping
    public String updateSettings(@ModelAttribute MailSetting mailSettings, Model model) {
        this.mailSettings = mailSettings; // Cập nhật cấu hình
        model.addAttribute("message", "Settings updated successfully!");
        return "settings";
    }
}
