package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Playlist;

@Mapper
public interface PlaylistMapper {
	@Select("SELECT * FROM PLAYLISTS")
	List<Playlist> list();
	
	@Select("SELECT * FROM PLAYLISTS")
	@Results({
		@Result(property="songs", javaType=List.class, column="id",
         many=@Many(select="com.example.demo.mapper.SongMapper.findSongsByPlaylistId"))})
	List<Playlist> listWithSong();

}
