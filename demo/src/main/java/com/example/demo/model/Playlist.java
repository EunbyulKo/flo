package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

	private Integer id;
  	
  	private String name;
  	
  	List<Song> songs = new ArrayList<>();

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
}
