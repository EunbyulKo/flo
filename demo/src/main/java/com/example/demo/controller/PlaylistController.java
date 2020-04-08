package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Playlist;
import com.example.demo.service.PlaylistService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/playlist/*")
public class PlaylistController {
	
	@Autowired
	private PlaylistService playlistService;
	
	@RequestMapping("/songTitle")
	public String printSongTitle(Model model) {
		List<String> titles = new ArrayList<>();
		for(Playlist playlist : playlistService.getAllPlaylists()) {
			titles.add(playlist.getName());
		}
		
		model.addAttribute("titles", titles);
		
		return "songTitle";
	}
	
	@RequestMapping("/songAlbumTitle")
	public String printSongAlbumTitle(Model model) {
		List<String> titles = new ArrayList<>();
		for(Playlist playlist : playlistService.getAllPlaylistsWithSongs()) {
			titles.add(String.valueOf(playlist.getSongs().size()));
		}
		
		model.addAttribute("titles", titles);
		
		return "songTitle";
	}
}
