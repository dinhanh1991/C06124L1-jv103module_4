package com.example.music_list.controller;

import com.example.music_list.model.Music;
import com.example.music_list.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
public class SongController {
    @Autowired
    private FileStorageService songService;

    @GetMapping("/songs")
    public String listSongs(Model model) {
        songService.loadSongsFromDirectory();
        model.addAttribute("songs", songService.getAllSongs());
        return "list";
    }
    @GetMapping("/upload")
    public String uploadForm() {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadSong(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng chọn một bài hát để tải lên.");
            return "redirect:/upload";
        }

        try {
            // Lưu bài hát vào thư mục
            String fileName = file.getOriginalFilename();
            File destinationFile = new File("D:/Nhạc/" + fileName);
            file.transferTo(destinationFile);

            // Thêm vào danh sách bài hát
            Music song = new Music();
            song.setName(fileName);
            song.setFilePath(destinationFile.getAbsolutePath());
            song.setArtist("Unknown");
            song.setGenre("Unknown");
            songService.addSong(song);

            redirectAttributes.addFlashAttribute("message", "Tải lên thành công!");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "Có lỗi khi tải lên bài hát.");
        }
        return "redirect:/songs";
    }
}
