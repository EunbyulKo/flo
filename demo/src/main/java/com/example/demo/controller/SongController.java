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
@RequestMapping("/song/*")
public class SongController {
	
	@Autowired
	private SongService songService;
	
	@RequestMapping("/songTitle")
	public String printSongTitle(Model model) {
		List<String> titles = new ArrayList<>();
		for(Song song : songService.getAllSongs()) {
			titles.add(song.getTitle());
		}
		
		model.addAttribute("titles", titles);
		
		return "songTitle";
	}
	
	@RequestMapping("/songAlbumTitle")
	public String printSongAlbumTitle(Model model) {
		List<String> titles = new ArrayList<>();
		for(Song song : songService.getAllSongsWithAlbum()) {
			titles.add(song.getAlbum().getId().toString());
		}
		
		model.addAttribute("titles", titles);
		
		return "songTitle";
	}
}
