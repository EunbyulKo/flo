package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Song;
import com.example.demo.service.SongService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;

@Controller
public class SongController {
	
	private static final String PATH = "song/";
	
	@Autowired
	private SongService songService;
	
	@RequestMapping("/")
	public String printSongTitle(Model model) {
		List<String> titles = new ArrayList<>();
		for(Song song : songService.getAllSongs()) {
			titles.add(song.getTitle());
		}
		
		model.addAttribute("titles", titles);
		
		return PATH + "songTitle";
	}
}
