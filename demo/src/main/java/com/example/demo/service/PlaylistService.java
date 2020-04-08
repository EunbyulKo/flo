package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PlaylistMapper;
import com.example.demo.model.Playlist;

@Service
public class PlaylistService {

	@Autowired
	private PlaylistMapper PlaylistMapper;

	public List<Playlist> getAllPlaylists()  {
		return PlaylistMapper.list();
	}
	
	public List<Playlist> getAllPlaylistsWithSongs()  {
		return PlaylistMapper.listWithSong();
	}
	
}
