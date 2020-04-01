package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Song;
import com.example.demo.service.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Controller
public class SongController {
	
	@Autowired
	private SongService songService;
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		for(Song song : songService.getAllSongs()) {
			System.out.println(song.getTitle());
		}
		
		return "Happy Coding!";
	}
}
