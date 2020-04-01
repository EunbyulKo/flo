package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Song;

@Mapper
public interface SongMapper {
	@Select("SELECT * FROM SONGS")
	List<Song> list();
}
