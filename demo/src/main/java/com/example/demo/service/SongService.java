package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.SongMapper;
import com.example.demo.model.Song;

@Service
public class SongService {

	@Autowired
	private SongMapper songMapper;

	public List<Song> getAllSongs()  {
		return songMapper.list();
	}
	
}
