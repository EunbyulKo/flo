package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Song;

@Mapper
public interface SongMapper {
	@Select("SELECT * FROM SONGS")
	List<Song> list();
	
	@Select("SELECT *, ALBUMS.title AS album_title FROM SONGS INNER JOIN ALBUMS ON SONGS.album_id=ALBUMS.id")
	@Results({
		  @Result(column="album_id", property="album.id"),
		  @Result(column="album_title", property="album.title")
		})
	List<Song> listWithAlbum();
}
