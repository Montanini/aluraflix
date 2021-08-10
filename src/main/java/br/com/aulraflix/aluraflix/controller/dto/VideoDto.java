package br.com.aulraflix.aluraflix.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.aulraflix.aluraflix.modelo.Video;
import lombok.Getter;

@Getter
public class VideoDto {
	
	private Long id;
	private String titulo;
	private String descricao;
	
	public VideoDto(Video video) {
		this.id = video.getId();
		this.titulo = video.getTitulo();
		this.descricao = video.getDescricao();
	}

	public static List<VideoDto> converter(List<Video> videos) {
		return videos.stream().map(VideoDto::new).collect(Collectors.toList());
	}

}
